package suite_run_test;


import junit.framework.TestSuite;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import ui_tests.home_page_and_login_validation.SuccessLoginTest;
import ui_tests.home_page_and_login_validation.VerifyBrowseDropDownMenuTest;
import ui_tests.home_page_and_login_validation.VerifyChangingLanguageTest;

/**
 * Suite - run all package
 */
@Suite
@SelectPackages({"ui_tests"})
public class JUnit5TestSuiteExample extends TestSuite {
}

/**
 * Suite - run some classes
 */
//@Suite
//@SelectClasses({SuccessLoginTest.class, VerifyBrowseDropDownMenuTest.class, VerifyChangingLanguageTest.class})
//public class JUnit5TestSuiteExample {
//}
