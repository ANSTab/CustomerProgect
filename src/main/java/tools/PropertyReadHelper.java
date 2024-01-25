package tools;

import io.qameta.allure.Step;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReadHelper {

    @Step("Read From Property File by '{0}' key")
    public String readFromPropertyFile(String propertiesKey) {
        Properties properties = new Properties();

        try {
            FileInputStream fileInput = new FileInputStream(Constants.FILE_PATH);
            properties.load(fileInput);
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(propertiesKey);
    }
}