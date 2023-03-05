package com.example.ex10;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement searchTextbox = $(By.name("q"));
    private SelenideElement searchIcon = $(By.className("icon-search"));
    private SelenideElement searchButton = $(By.className("general-search__button"));
    private SelenideElement signUpMenu = $(By.xpath("/html/body/header/nav/div/div/div[5]/section/div/div[1]/button/span[3]"));
    private SelenideElement signUpMenuItem = $(By.xpath("/html/body/header/nav/div/div/div[5]/section/div/div[1]/div/div[2]/ul[1]/li[1]/a"));


    public void search(String query) {
        searchIcon.click();
        searchTextbox.click();
        searchTextbox.sendKeys(query);
        searchButton.click();
    }

    public void openSignUp() {
        signUpMenu.click();
        signUpMenuItem.click();
    }
}
