package helper;

import pageObjects.MainPage;
import com.automation.remarks.junit.VideoRule;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class BaseTest {

    protected MainPage mainPage = page(MainPage.class);

    private static FileInputStream fileInputStream;
    private static Properties properties;

    protected static  String url;
    protected static  String domain;
    protected static  String searchedWord;

    @BeforeClass
    public static void setProperties() {
        try {
            fileInputStream = new FileInputStream("config.properties");
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

        searchedWord = properties.getProperty("searchedWord");
        domain = properties.getProperty("domain");
        url = properties.getProperty("url");
    }

    @Rule
    public VideoRule videoRule = new VideoRule();

    @Before
    public void openGoogleSearchPage(){
        open(url);
    }
}
