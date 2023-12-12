package login_validation;

import base_test.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import pages.BasePage;
import pages.HomePage;
import pages.MyBooksPage;
import user.User;

public class PrepareTestDataForLogin extends BaseTest {
    protected static final String PROFILE_NAME = User.getProfileName();
    protected static HomePage homePage;
    protected MyBooksPage myBooksPage;
    protected String currentTestName;
    protected static final String SHOULD_BE_EQUAL = "'%s' should be equal '%s'";

    @BeforeAll
    protected static void beforeActions() {
        homePage = new BasePage()
                .openLibrary();
    }
}
