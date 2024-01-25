package tools;

import io.qameta.allure.Step;
import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetector;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static enums.Language.*;


public class TranslateHelper {

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

    public static String translateTextToAnotherLanguage(String text, String sourceLang, String targetLang) throws IOException {
        String apiKey = new PropertyReadHelper().readFromPropertyFile("translaterApiKey");
        return translateText(apiKey, text, sourceLang, targetLang);
    }


    @Step ()
    private static String translateText(String apiKey, String text, String sourceLang, String targetLang) throws IOException {
        String url = "https://api.mymemory.translated.net/get?q=" + URLEncoder.encode(text, "UTF-8") +
                "&langpair=" + sourceLang + "|" + targetLang + "&key=" + apiKey;

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return extractedTranslationFromJson(response.toString());
        }
    }

    private static String extractedTranslationFromJson(String jsonResponse) {
        return JsonParserHelper.extractedTranslationFromJson(jsonResponse);

    }
}

