package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    @FindBy (xpath = "//input[@name='q']")
    private SelenideElement searchInput;

    public SearchResultPage searchNecessaryWord(String searchText){
        searchInput.setValue(searchText).pressEnter();
        Allure.addAttachment("Google MainPage search input", "text: '" + searchText + "' is entered in search input");
        return page(SearchResultPage.class);
    }
}
