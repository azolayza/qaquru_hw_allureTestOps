package com.azovcevae.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class GitHubSteps {
    @Step("Open main page GitHubCom")
    public void openMainPage(){
        open("https://github.com/");
    }

    @Step("Search repository {repository}")
    public void searchForRepository(String repository){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("GOTO {repository}")
    public void openRepository(String repository){
        $(linkText(repository)).click();
    }

    @Step("Open tab Issues")
    public void openIssuesTub(){
        attachPageSource();
        $(partialLinkText("Issues")).click();
    }

    @Step("Check issue with {number}")
    public void shouldSeeIssueNumber(int number){
        $(withText("#" + number)).should(Condition.visible);
    }

    @Attachment(value = "Screenshot", type = "text/html", fileExtension =  "html")
    public byte[] attachPageSource(){
        return WebDriverRunner.source().getBytes();
    }

}
