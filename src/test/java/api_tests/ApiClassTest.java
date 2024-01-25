package api_tests;

import ApiObject.Work;
import dataProvider.BookDataProvider;
import dataProvider.WorkDataProvider;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ApiClassTest {

    @Test
    public void sdfsf() {
        List<Work> books = WorkDataProvider.getWorksList();
        String key = books.get(0).getKey();
        BookDataProvider.getBookInfoByKey(key);
    }
}
