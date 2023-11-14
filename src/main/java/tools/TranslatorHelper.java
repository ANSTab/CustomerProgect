package tools;

import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetector;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;
import opennlp.tools.util.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static enums.Language.*;


public class TranslatorHelper {

    public static List<enums.Language> languageList = Arrays.asList(CS, DE, EN, ES, FR, HR, IT, PT, TE, UK, ZH);

    public static String definitionOfLanguage(String text) throws IOException {
        // Завантажте модель для визначення мови
        InputStream modelIn = Files.newInputStream(Paths.get("/Users/oleksii/MyProject/MyProject v2/translater/langdetect-183.bin"));
        LanguageDetectorModel model = new LanguageDetectorModel(modelIn);
        LanguageDetector languageDetector = new LanguageDetectorME(model);

        // Визначте мову тексту
        Language bestLanguage = languageDetector.predictLanguage(text);
        return bestLanguage.getLang();

    }

    public static String getCountryLanguageByText(String someText) throws IOException {
        String translatorCode = definitionOfLanguage(someText);
        return languageList.stream()
                .filter(x -> translatorCode.contains(x.getLabel()))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(String.format("There are no '%s' code in Language enum", translatorCode)))
                .getName();
    }
}
