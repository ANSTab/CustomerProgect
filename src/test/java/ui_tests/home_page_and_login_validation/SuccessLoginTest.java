package ui_tests.home_page_and_login_validation;

import enums.ActivitiesRelatedToBooks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SuccessLoginTest extends PrepareTestDataForLogin {

    @Test
    public void verifyUserLoginSuccess() {
        List<ActivitiesRelatedToBooks> activitiesRelatedToBooks = Arrays.asList(ActivitiesRelatedToBooks.values());
        myBooksPage = homePage
                .loginAsUserAndOpenProfilePage();
        Assertions.assertTrue(myBooksPage.isMyBooksHeaderContainsProfileName(PROFILE_NAME), String.format("'%s' should be shown", PROFILE_NAME));
        activitiesRelatedToBooks.forEach(actions ->
                Assertions.assertTrue(myBooksPage.isActivitiesRelatedToBooksShown(actions), String.format("'%s' should be shown", actions)));
        softAssertions.assertAll();
    }
}
