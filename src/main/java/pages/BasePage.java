package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import tools.PropertyReadHelper;
import tools.WebElementUtils;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$x;

public class BasePage extends AbstractPage {

    protected static final Logger logger = LogManager.getLogManager().getLogger("");
    private final SelenideElement headerBannerLabel = $x("//*[@class='header-bar']");

    public HomePage openLibrary() {
        Selenide.open(new PropertyReadHelper().readFromPropertyFile("url"));
        waitUntilLoaded();
        return new HomePage();
    }

    @Override
    protected void waitUntilLoaded() {
        logger.info("Wait when header Banner will be visible");
        WebElementUtils.shouldBeVisible(headerBannerLabel);
    }
}
