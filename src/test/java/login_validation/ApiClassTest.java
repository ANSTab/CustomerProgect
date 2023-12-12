package login_validation;

import ApiObject.Work;
import dataProvider.BookDataProvider;
import dataProvider.WorkDataProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import tools.RestAssuredUtils;

import java.util.List;

public class ApiClassTest {

    @Test
    public void sdfsf() {
        List<Work> books = WorkDataProvider.getWorksList();
       String key =  books.get(0).getKey();
        BookDataProvider.getBookInfoByKey(key);
    }
}
