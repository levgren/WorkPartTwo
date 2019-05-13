import com.automation.remarks.video.annotations.Video;
import helper.BaseTest;
import org.junit.Test;

public class TestCasesSelenide extends BaseTest {

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
