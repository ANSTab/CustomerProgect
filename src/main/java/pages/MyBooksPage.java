package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import tools.WebElementUtils;

import static com.codeborne.selenide.Selenide.$x;

public class MyBooksPage extends LoginPage {

    public static final String MY_BOOKS_HEADER = "My Books";
    private final SelenideElement myBooksHeader = $x("//*[contains(@class,'account-settings-menu')]//following-sibling::*//*[@class='details-title']");
    private final SelenideElement myBooksMenu = $x("//*[@class='mybooks-menu']");


    public boolean isMyBooksHeaderShown() {
        logger.info("Is 'My Books' header shown");
        return WebElementUtils.shouldBeVisible(myBooksHeader).isDisplayed();
    }

    public boolean isMyBooksHeaderContainsProfileName(String profileName) {
        logger.info(String.format("Is My Books Header Contains '%s' Profile Name", profileName));
        return Selenide.$(By.xpath(String.format("//*[@class='section-header' and text()='%s']", profileName.toLowerCase())))
                .shouldBe(Condition.visible)
                .isDisplayed();
    }

    public String getTextFromMyBooksHeader() {
        logger.info("Get Text From My Books Header");
        return WebElementUtils.shouldBeVisible(myBooksHeader).getText();
    }

}
