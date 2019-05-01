package Tests;

import PageObjects.MainPage;
import com.automation.remarks.junit.VideoRule;
import com.automation.remarks.video.annotations.Video;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class TestCasesSelenide extends BaseTest{

    private MainPage mainPage = page(MainPage.class);

    @Rule
    public VideoRule videoRule = new VideoRule();

    @Before
    public void openGoogleSearchPage(){
        open(url);
    }

    @Test
    @Video
    public void verifyTitle() {
        mainPage.searchNecessaryWord(searchedWord)
                .openFirstLink()
                .verifyTitleContainsWord(searchedWord);
    }

    @Test
    @Video
    public void verifyExpectedDomain(){
        mainPage.searchNecessaryWord(searchedWord)
                .verifyDomainOnSearchResultPage(domain, 5);
    }


}
