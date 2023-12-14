package dataProvider;

import ApiObject.Work;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tools.JsonParserHelper;

import java.util.ArrayList;
import java.util.List;

public class WorkDataProvider {

    @Step("Get Works List")
    public static List<Work> getWorksList() {
        RestAssured.baseURI = "https://openlibrary.org/subjects/works.json";
        Response response = RestAssured.get();
        int statusCode = response.getStatusCode();
        System.out.println("Статус-код: " + statusCode);

        return parseJsonToWorks(response.getBody().asString());
    }

    @Step("Parse Json To Works")
    private static List<Work> parseJsonToWorks(String json) {
        List<Work> books = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray worksArray = jsonObject.getJSONArray("works");
            for (int i = 0; i < worksArray.length(); i++) {
                JSONObject bookObject = worksArray.getJSONObject(i);
                Work works = parseWork(bookObject);
                books.add(works);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return books;
    }

    public static Work parseWork(JSONObject workObject) throws JSONException {
        Work works = new Work();
        works.setKey(workObject.getString("key"));
        works.setTitle(workObject.getString("title"));
        works.setEditionCount(workObject.getInt("edition_count"));
        works.setCoverEditionKey(workObject.optString("cover_edition_key", ""));
        return works;
    }
}
