package tools;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParserHelper {

    public static String extractedTranslationFromJson(String jsonResponse) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            if (rootNode.has("responseData")) {
                JsonNode responseDataNode = rootNode.get("responseData");
                if (responseDataNode.has("translatedText")) {
                    return responseDataNode.get("translatedText").asText();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
