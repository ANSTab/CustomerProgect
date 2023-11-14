package login_validation;

import base_test.BaseTest;
import enums.Language;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.HomePage;
import pages.MyBooksPage;
import tools.TranslatorHelper;
import user.User;

import java.util.stream.Stream;

import static enums.Language.*;
import static pages.MyBooksPage.MY_BOOKS_HEADER;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FirstTest extends BaseTest {

    public static HomePage homePage = new HomePage();
    private String profileName = User.getProfileName();
    private MyBooksPage myBooksPage;
    private String currentTestName;


    private static Stream<Arguments> dateProvider() {
        return Stream.of(
                Arguments.of(UK, UK.getName()),
                Arguments.of(DE, DE.getName()),
                Arguments.of(FR, FR.getName())
        );
    }

    @Test
    @Order(0)
    public void verifyUserLoginSuccess() {
        currentTestName = "verifyUserLoginSuccess";
        myBooksPage = homePage
                .loginAsUserAndOpenProfilePage();
        Assertions.assertTrue(myBooksPage.isMyBooksHeaderShown(), String.format("'%s' should be shown", MY_BOOKS_HEADER));
        Assertions.assertTrue(myBooksPage.isMyBooksHeaderContainsProfileName(profileName), String.format("'%s' should be shown", profileName));
    }

    @SneakyThrows
    @ParameterizedTest
    @MethodSource("dateProvider")
    @Order(1)
    public void verifyChangingLanguage(Language language, String countryLang) {
        currentTestName = String.format("verifyChangingLanguage_%s", language.getLabel());
        homePage.changeLanguageOfSite(language);

        String ukText = myBooksPage.getTextFromMyBooksHeader();
        String lang = TranslatorHelper.getCountryLanguageByText(ukText);
        Assertions.assertEquals(lang, countryLang, String.format("'%s' should be equal '%s'", lang, countryLang));
    }

    @AfterEach
    private void afterMethodActions() {
        if (("verifyChangingLanguage_fr".equals(currentTestName))) {
            homePage.changeLanguageOfSite(EN);
        }
    }
}
