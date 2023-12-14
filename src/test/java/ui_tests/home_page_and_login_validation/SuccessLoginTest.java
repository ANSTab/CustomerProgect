package ui_tests.home_page_and_login_validation;

import enums.BrowseMenuItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pages.MyBooksPage.MY_BOOKS_HEADER;

public class SuccessLoginTest extends PrepareTestDataForLogin {

    @Test
    public void verifyUserLoginSuccess() {
        myBooksPage = homePage
                .loginAsUserAndOpenProfilePage();
        Assertions.assertTrue(myBooksPage.isMyBooksHeaderShown(), String.format("'%s' should be shown", MY_BOOKS_HEADER));
        Assertions.assertTrue(myBooksPage.isMyBooksHeaderContainsProfileName(PROFILE_NAME), String.format("'%s' should be shown", PROFILE_NAME));
    }
}
