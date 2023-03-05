package com.example.ex10;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    static MainPage mainPage;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
        mainPage = new MainPage();
    }

    @BeforeEach
    public void setUp() {
        open("https://www.allrecipes.com/");
    }
    /*
    @Test
    public void testSearch() {
        $(By.id("search-block")).click();
        $(By.id("search-block")).sendKeys("tiramisu");
        $(By.className("searchButton")).click();
        assertTrue($(By.xpath("/html/head/title")).getOwnText().contains("tiramisu"));
    }*/

    @Test
    public void test2() {
        $(By.xpath("/html/body/header/nav/div/div/div[5]/section/div/div[1]/button/span[3]")).click();
        $(By.xpath("/html/body/header/nav/div/div/div[5]/section/div/div[1]/div/div[2]/ul[1]/li[1]/a")).click();
        assertTrue($(By.xpath("/html/head/title")).getOwnText().equals("Sign Up"));
    }

    @Test
    public void testAirFry() {
        $(By.xpath("/html/body/main/article/div/section[4]/a/div[2]/span/span")).click();
        $(By.xpath("/html/body/main/section/div[1]/div[2]/div[2]/ul/li[1]/a/span")).click();
        $(By.xpath("/html/body/main/section/div[3]/section/div[1]/a[1]/div[2]/span/span")).click();
        assertTrue($(By.tagName("body")).text().contains("salt"));
    }

    @Test
    public void test4() throws IOException {
        File f = $(By.tagName("html")).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f, new File("allrecipescom.png"));
    }


    @Test
    public void testSearch() {
        mainPage.search("tiramisu");
        assertTrue($(By.xpath("/html/head/title")).getOwnText().contains("tiramisu"));
    }

    @Test
    public void testSignUP() {
        $(By.xpath("/html/body/header/nav/div/div/div[5]/section/div/div[1]/button/span[3]")).click();
        $(By.xpath("/html/body/header/nav/div/div/div[5]/section/div/div[1]/div/div[2]/ul[1]/li[1]/a")).click();
        assertTrue($(By.xpath("/html/head/title")).getOwnText().equals("Sign Up"));
    }



}
