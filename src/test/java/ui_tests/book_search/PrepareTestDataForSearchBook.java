package ui_tests.book_search;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.MyBooksPage;
import ui_tests.base_test.BaseTest;
import user.User;

public class PrepareTestDataForSearchBook extends BaseTest {
    protected MyBooksPage myBooksPage;
    protected static final String SHOULD_BE_EQUAL = "'%s' should be equal '%s'";
}
