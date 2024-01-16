package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.impl.ElementHandleImpl;
import enums.BrowseMenuItem;
import enums.Language;
import io.qameta.allure.Step;

import tools.WebElementUtils;
import user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class HomePage extends AbstractPage {
    protected static final Logger logger = LogManager.getLogManager().getLogger("");
    private Page page;

    // 1. String Locators - OR
//    private String search = "input[name='search']";
    private String search = "//input[@aria-label='Search']";
    private String searchIcon = "div#search button";
    private String searchPageHeader = "div#content h1";
    private String loginLink = "a:text('Login')";
    private String myAccountLink = "a[title='My Account']";
    private final String donatiileIcon = "//*[@class='account__icon']";
    private final String signInButton = "//*[@class='btn primary']";
    private final String translateIcon = "//*[@class='translate-icon']";
    private final String languageSection = "//*[@class='language-dropdown-component']";
    private final String browseMenuDropdownButton = "//span[text()='Menu']//following-sibling::img[@class='down-arrow']";
    private final String loginButton = "//*[@class='hide-me']";

    private final String profileIcon = "//*[@class='account__icon']";

    // 2. page constructor:
    public HomePage(Page page) {
        this.page = page;
    }

    // 3. page actions/methods:
    public String getHomePageTitle() {
        String title = page.title();
        System.out.println("page title: " + title);
        return title;
    }

    public String getHomePageURL() {
        String url = page.url();
        System.out.println("page url : " + url);
        return url;
    }

    public BookPage doSearch(String bookData) {
        page.fill(search, bookData);
        page.keyboard().press("Enter");
        return new BookPage(page);
    }

    public LoginPage navigateToLoginPage() {
        page.click(myAccountLink);
        page.click(loginLink);
        return new LoginPage(page);
    }

    public MyBooksPage loginAsUserAndOpenProfilePage() {
        openLoginPage()
                .setCredentialsAndOpenProfilePage(User.getEmail(), User.getPassword());
        return new MyBooksPage(page);
    }

    public LoginPage openLoginPage() {
        logger.info("Open Login Page");
        clickLoginButton();
        return new LoginPage(page);
    }

    public void clickLoginButton() {
        page.click(loginButton);
    }

    @Override
    protected void waitUntilLoaded() {
        logger.info("Wait when header Banner will be visible");
//        if (donationBanner.isDisplayed()) {
//            Selenide.switchTo().frame(donationBanner);
//            Selenide.$(By.xpath("//*[@id='banner-close-image-white']")).shouldBe(Condition.visible).click();
//            Selenide.switchTo().defaultContent();
//        }
    }

    public ProfilePage openProfilePage() {
        logger.info("Open Profile page");
        page.waitForSelector(profileIcon).click();
        return new ProfilePage(page);
    }

    public HomePage openBrowseDropDownMenu() {
        logger.info("Open 'Browse' menu");
        page.waitForSelector(browseMenuDropdownButton).click();
        return this;
    }

    public void openBrowseMenuItem(BrowseMenuItem item) {
        openBrowseDropDownMenu();
        page.waitForSelector(String.format(" //*[contains(text(),'%s')]", item.getName())).click();
    }

    @Step("Get Browse Menu Items List")
    public List<String> getBrowseMenuItemsList() {
        openBrowseDropDownMenu();
        List<ElementHandle> elementHandleList = page.querySelectorAll("//*[@class='dropdown-menu browse-dropdown-menu']//*[contains(@data-ol-link-track,'MainNav')]");
        List<String> list = new ArrayList<>();
        for (ElementHandle e : elementHandleList) {
            if (!e.innerText().equals("")) {
                list.add(e.innerText().trim());
            }
        }

        return list.stream().distinct().collect(Collectors.toList());
    }

    public HomePage changeLanguageOfSite(Language language) {
        page.waitForSelector(translateIcon).click();
        ElementHandle parentElement = page.querySelector(languageSection);
        parentElement.querySelector(String.format("//*[@lang='%s']", language.getLabel())).click();
        waitUntilLoaded();
        return this;
    }

    public String getTextFromLoginButton() {
        logger.info("Get text from 'Login' button");
        return page.waitForSelector(loginButton).innerText();
    }

    public String getTextFromSignInButton() {
        logger.info("Get text from 'Sign In' button");
        return page.waitForSelector(signInButton).innerText();
    }

//    public static void switchToFrameByElement(WebDriver driver, WebElement frameElement) {
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", frameElement);
//        driver.switchTo().frame(frameElement);
//    }
//
//    public static void switchToMainFrame(WebDriver driver) {
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("window.parent.document.getElementsByTagName('frame')[0].contentWindow.focus();");
//        driver.switchTo().defaultContent();
//    }
}
