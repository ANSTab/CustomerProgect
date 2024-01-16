package pages;

import com.microsoft.playwright.Page;

public class BookPage extends HomePage {
    private Page page;

    public BookPage(Page page) {
        super(page);
        this.page = page;
    }

    private String titleLabel = "//*[@class='editionAbout']//*[@class='work-title']";

    public String getTitleBook() {
        return page.locator(titleLabel).innerText();
    }


    @Override
    protected void waitUntilLoaded() {
        page.waitForSelector("//*[@class='editionAbout']//*[@class='nav-bar work-menu']").isVisible();
    }
}
