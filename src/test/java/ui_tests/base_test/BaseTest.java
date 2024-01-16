package ui_tests.base_test;

import com.microsoft.playwright.Page;
import factory.PlaywrightFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;
import pages.HomePage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    PlaywrightFactory pf;
    private static Page page;
    protected static HomePage homePage;
    protected Properties prop;
    protected static SoftAssertions softAssertions = new SoftAssertions();
//    private static Playwright playwright;
//    private static Browser browser;

    @ParameterizedTest
    @ValueSource(strings = {"chrome"})
    public void setup(String browserName) {
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        if (browserName != null) {
            prop.setProperty("browser", browserName);
            pf.save_prop();
        }

        page = pf.initBrowser(prop);
        homePage = new HomePage(page);
    }

    @AfterAll
    public void tearDown() {
        page.context().browser().close();
    }

    /**  works without PlaywrightFactory*/
//    public void setup(){
//        playwright = Playwright.create();
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
//        page = browser.newPage(new Browser.NewPageOptions().setViewportSize(1800, 1080));
//        page.navigate(new PropertyReadHelper().readFromPropertyFile("url"));
//        homePage = new HomePage(page);
//    }

//    @AfterAll
//    public void tearDown() {
//        browser.close();
//        playwright.close();
//    }


/** Selenide */
//    public static void setUp() {
//        WebDriverManager.chromedriver().setup();
//        Configuration.browser = "chrome";
//        Configuration.webdriverLogsEnabled = true;
//        Configuration.browserSize = "1920x1080";
//        Configuration.headless = false;
//    }
//
//    @BeforeAll
//    public static void init() {
//        setUp();
//    }
//
//    @AfterAll
//    public static void tearDown(){
//        Selenide.closeWebDriver();
//    }
}
