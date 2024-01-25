package pages;

import com.microsoft.playwright.Page;
import enums.ActivitiesRelatedToBooks;
import io.qameta.allure.Step;

public class MyBooksPage extends HomePage {
    private Page page;

    public MyBooksPage(Page page) {
        super(page);
        this.page = page;
    }

    private final String booksLabel = "//*[contains(@class,'disguised-select')]//*[text()='Books']";

    @Step("Is My Books Header Contains '{0}' Profile Name")
    public boolean isMyBooksHeaderContainsProfileName(String profileName) {
        logger.info(String.format("Is My Books Header Contains '%s' Profile Name", profileName));
        waitUntilLoaded();
        return page.locator(String.format("//*[@class='section-header' and text()='%s']", profileName.toLowerCase())).isVisible();
    }

    @Step("Is '{0}' Activities Related To Books Shown")
    public boolean isActivitiesRelatedToBooksShown(ActivitiesRelatedToBooks action) {
        logger.info(String.format("Is '%s' Activities Related To Books", action.getName()));
        return page.locator(String.format("//*[@class='details-content']//*[text()='My Loans']", action.getName())).isVisible();
    }

    @Override
    public void waitUntilLoaded() {
        page.waitForSelector("//*[@class='mybooks']").isVisible();
    }
}
