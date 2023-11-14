package tools;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebElement;

public class WebElementUtils {

    public static WebElement shouldBeVisible(WebElement element) {
        return Selenide.$(element).shouldBe(Condition.visible);
    }
}
