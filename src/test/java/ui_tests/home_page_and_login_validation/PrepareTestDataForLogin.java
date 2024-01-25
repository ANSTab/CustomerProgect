package ui_tests.home_page_and_login_validation;

import pages.MyBooksPage;
import ui_tests.base_test.BaseTest;
import user.User;

public class PrepareTestDataForLogin extends BaseTest {
    protected static final String PROFILE_NAME = User.getProfileName();
    protected MyBooksPage myBooksPage;
    protected static final String SHOULD_BE_EQUAL = "'%s' should be equal '%s'";
    protected static final String SHOULD_BE_SHOWN = "'%s' should be shown";
}
