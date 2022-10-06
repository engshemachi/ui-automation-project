package fileReaderManager;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadFromFiles {

    public static Properties getAllProperties(String fileName) {
        Properties fileProperties = null;

        try {
            FileReader fileReader = new FileReader("src/main/resources/propertiesFiles/" + fileName);
            fileProperties = new Properties();
            fileProperties.load(fileReader);
        } catch (IOException ioException) {
            System.out.println("There is io exception happened");
        }
        return fileProperties;

    }

    public static String getPropertyByKey(String fileName, String propertyKey) {
        Properties fileProperties = getAllProperties(fileName);
        return fileProperties.getProperty(propertyKey);

    }
}

