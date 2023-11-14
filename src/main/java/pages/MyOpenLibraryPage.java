package pages;

import com.codeborne.selenide.SelenideElement;
import tools.WebElementUtils;

import static com.codeborne.selenide.Selenide.$x;

public class MyOpenLibraryPage extends BasePage {
    private final SelenideElement myOpenLibrarySection = $x("//*[@class='dropdown-menu hamburger-dropdown-menu']");

    @Override
    protected void waitUntilLoaded() {
        WebElementUtils.shouldBeVisible(myOpenLibrarySection);
    }
}