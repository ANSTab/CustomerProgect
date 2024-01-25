package ui_tests.book_search;

import ApiObject.Book;
import ApiObject.Work;
import dataProvider.BookDataProvider;
import dataProvider.WorkDataProvider;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BookPage;

import java.util.List;

public class VerifySearchBookTest extends PrepareTestDataForSearchBook {
    private Book bookData;
    private String bookKey;
    private BookPage bookPage;
    private String bookTitle;

    @Test
    public void sfsdfsdf() {
        prepareTestData();
        bookPage = homePage
                .loginAsUserAndOpenProfilePage()
                .doSearch(bookKey);

        Assertions.assertEquals(bookTitle, bookPage.getTitleBook());
    }

    @Step
    private void prepareTestData() {
        List<Work> books = WorkDataProvider.getWorksList();
        String key = books.get(0).getKey();
        bookData = BookDataProvider.getBookInfoByKey(key);
        bookKey = bookData.getKey();
        bookTitle = bookData.getTitle();
    }
}
