package dataProvider;

import ApiObject.Book;
import ApiObject.Work;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

public class BookDataProvider {

    @Step("Get Works List")
    public static Book getBookInfoByKey(String workKey) {
      RestAssured.baseURI =  String.format("https://openlibrary.org/works/%s.json", workKey);
        Response response = RestAssured.get();
        String json = response.asString();
        int statusCode = response.getStatusCode();
        System.out.println("Статус-код: " + statusCode);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, Book.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
