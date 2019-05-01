package Tests;

import org.junit.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    private static FileInputStream fileInputStream;
    private static Properties properties;

    protected static  String url;
    protected static  String domain;
    protected static  String searchedWord;

@BeforeClass
    public static void setProperties() {
        try {
            fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        url = properties.getProperty("url");
        searchedWord = properties.getProperty("searchedWord");
        domain = properties.getProperty("domain");
    }
}
