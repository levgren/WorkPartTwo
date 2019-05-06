package pageObjects;

import io.qameta.allure.Allure;
import static com.codeborne.selenide.Selenide.title;

public class WebSitePage {

    public WebSitePage verifyTitleContainsWord(String searchRequest){
        if (title().toLowerCase().contains(searchRequest))
            Allure.addAttachment("check of the Title","Title contains: '" + searchRequest + "");
        else
            Allure.addAttachment("check of the Title","There is no '" + searchRequest + "' in the title");
        return this;
    }
}
