package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import enums.Language;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tools.WebElementUtils;
import user.User;


import static com.codeborne.selenide.Selenide.$x;


public class HomePage extends BasePage {
    private final SelenideElement profileIcon = $x("//*[@class='account__icon']");
    private final SelenideElement loginButton = $x("//*[@class='hide-me']");
    private final SelenideElement signInButton = $x("//*[@class='btn primary']");
    private final SelenideElement translateIcon = $x("//*[@class='translate-icon']");
    private final SelenideElement languageSection = $x("//*[@class='language-dropdown-component']");
    private final SelenideElement donationBanner = Selenide.$(By.id("donato"));

    public MyBooksPage loginAsUserAndOpenProfilePage() {
        openLoginPage()
                .setCredentialsAndOpenProfilePage(User.getEmail(), User.getPassword());
        return new MyBooksPage();
    }

    public LoginPage openLoginPage() {
        logger.info("Open Login Page");
        WebElementUtils.shouldBeVisible(loginButton).click();
        return new LoginPage();
    }


    public ProfilePage openProfilePage() {
        logger.info("Open Profile page");
        WebElementUtils.shouldBeVisible(profileIcon).click();
        return new ProfilePage();
    }

    public HomePage changeLanguageOfSite(Language language) {
        WebElementUtils.shouldBeVisible(translateIcon).click();
        Selenide.$(languageSection).findElement(By.xpath(String.format(".//*[@lang='%s']", language.getLabel()))).click();
        waitUntilLoaded();
        return this;
    }

    public String getTextFromLoginButton() {
        logger.info("Get text from 'Login' button");
        return WebElementUtils.shouldBeVisible(loginButton).getText();
    }

    public String getTextFromSignInButton() {
        logger.info("Get text from 'Sign In' button");
        return WebElementUtils.shouldBeVisible(signInButton).getText();
    }

    public static void switchToFrameByElement(WebDriver driver, WebElement frameElement) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", frameElement);
        driver.switchTo().frame(frameElement);
    }

    public static void switchToMainFrame(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.parent.document.getElementsByTagName('frame')[0].contentWindow.focus();");
        driver.switchTo().defaultContent();
    }

//    @Override
//    protected void waitUntilLoaded() {
//        logger.info("Wait when header Banner will be visible");
//        if (donationBanner.isDisplayed()) {
//            Selenide.switchTo().frame(donationBanner);
//            Selenide.$(By.xpath("//*[@id='banner-close-image-white']")).shouldBe(Condition.visible).click();
//            Selenide.switchTo().defaultContent();
//        }
//
//    }

}
