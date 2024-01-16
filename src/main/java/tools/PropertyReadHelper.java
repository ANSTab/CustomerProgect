package tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReadHelper {

    public String readFromPropertyFile(String propertiesKey) {
        String filePath = "/Users/oleksii/MyProject/MyProject v2/src/main/resources/config/config.properties";
        Properties properties = new Properties();

        try {
            FileInputStream fileInput = new FileInputStream(filePath);
            properties.load(fileInput);
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(propertiesKey);
    }
}