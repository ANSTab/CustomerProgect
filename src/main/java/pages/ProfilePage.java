package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import tools.WebElementUtils;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage extends HomePage {

    private final SelenideElement profileTitle = $x("//*[@class='account-content']//*[text()='Мій профіль']");

    public boolean isPhoneNumberShown(String number) {
        logger.info("Is Phone Number Shown");
        return Selenide.$(By.xpath(String.format("//*[contains(text(),'%s')]", number))).isDisplayed();
    }

    @Override
    protected void waitUntilLoaded() {
        WebElementUtils.shouldBeVisible(profileTitle);
    }
}