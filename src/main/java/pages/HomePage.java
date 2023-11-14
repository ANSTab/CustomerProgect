package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import enums.Language;
import org.openqa.selenium.By;
import tools.WebElementUtils;
import user.User;


import static com.codeborne.selenide.Selenide.$x;


public class HomePage extends BasePage {
    private final SelenideElement profileIcon = $x("//*[@class='account__icon']");
    private final SelenideElement loginButton = $x("//*[@class='hide-me']//*[text()='Log In']");
    private final SelenideElement translateIcon = $x("//*[@class='translate-icon']");
    private final SelenideElement languageSection = $x("//*[@class='language-dropdown-component']");

    public MyBooksPage loginAsUserAndOpenProfilePage() {
        openLibrary()
                .openLoginPage()
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

}
