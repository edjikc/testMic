package ru.h2odim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setupDriver() {

        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        driver.get("https://google.com/");
    }

    @Test
    public void checkOfficeAddress() {
        mainPage.waitForSearchString();
        mainPage.setSearchString("crtweb.ru");
        mainPage.waitForSearchButton();
        mainPage.clickSearchButton();
        mainPage.waitFirstString();
        mainPage.clickFirstString();
        mainPage.waitForMenu();
        mainPage.clickMenu();
        mainPage.waitForContactButton();
        mainPage.clickContactButton();
        mainPage.waitForOfficeAddress();
        String text = mainPage.getOfficeAddressTest();
        Assert.assertEquals("Тюмень,\nул. Малыгина, 84 к. 1", text);
    }

    @After
    public void quit(){
        driver.quit();
    }


}