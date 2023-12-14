package ui_tests.home_page_and_login_validation;

import enums.Language;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tools.TranslateHelper;

import java.util.stream.Stream;

import static enums.Language.*;

public class VerifyChangingLanguageTest extends PrepareTestDataForLogin {

    private static Stream<Arguments> dateProvider() {
        return Stream.of(
                Arguments.of(UK),
                Arguments.of(DE),
                Arguments.of(ZH)
        );
    }

    @SneakyThrows
    @ParameterizedTest
    @MethodSource("dateProvider")
    public void verifyChangingLanguage(Language language) {
        String text = "Login";
        currentTestName = String.format("verifyChangingLanguage_%s", language.getLabel());
        homePage.changeLanguageOfSite(language);
        String translatedWord = TranslateHelper.translateTextToAnotherLanguage(text, EN.getLabel(), language.getLabel());

        Assertions.assertEquals(homePage.getTextFromLoginButton(), translatedWord,
                String.format(SHOULD_BE_EQUAL, homePage.getTextFromLoginButton(), translatedWord));
    }

    @AfterEach
    private void afterMethodActions() {
        if (("verifyChangingLanguage_zh".equals(currentTestName))) {
            homePage.changeLanguageOfSite(EN);
        }
    }
}
