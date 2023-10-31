import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class FirstTest {

    @Test
    public void sdfsdfsfsdf() {
        Selenide.open("https://lnzweb.com/ru");
        Selenide.$(By.xpath("//*[@class='header-banner']")).shouldBe(Condition.visible);
        Selenide.$(By.xpath("//*[contains(@class,'icon-profile')]")).shouldBe(Condition.visible).click();
        System.out.println("sdf");
    }
}
