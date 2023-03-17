package ru.h2odim;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private final WebDriver driver;
    private final By searchString = By.xpath("//input[@class='gLFyf']");
    private final By searchButton = By.xpath("(//input[@class='gNO89b'])[1]");
    private final By firstString = By.xpath("//*[contains(text(),'Разработка и интеграция цифровых сервисов')]");
    private final By menu = By.xpath("(//a[@href='#popup:tildoshnaya'])[1]/div/div");
    private final By contactsButton = By.xpath("(//a[@href='/contacts'])[1]");
    private final By officeAddress = By.xpath("/html/body/div[1]/div[2]/div/div/div[24]/div");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание поисковой строки")
    public void waitForSearchString() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(searchString));
    }

    @Step("Ожидание кнопки Поиск")
    public void waitForSearchButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(searchButton));
    }

    @Step("Клик по кнопке Поиск")
    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    @Step("Ввод в поисковую строку")
    public void setSearchString(String val) {
        driver.findElement(searchString).sendKeys(val);
    }

    @Step("Ожидание первой строки списка")
    public void waitFirstString() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(firstString));
    }

    @Step("Клик по первой строке")
    public void clickFirstString() {
        driver.findElement(firstString).click();
    }

    @Step("Ожидание бутерброда меню")
    public void waitForMenu() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(menu));
    }

    @Step("Клик по бутерброду меню")
    public void clickMenu() {
        driver.findElement(menu).click();
    }

    @Step("Ожидание кнопки Контакты")
    public void waitForContactButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(contactsButton));
    }

    @Step("Клик по кнопке Контакты")
    public void clickContactButton() {
        driver.findElement(contactsButton).click();
    }

    @Step("Ожидание адреса")
    public void waitForOfficeAddress() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(officeAddress));
    }

    @Step("Получение текста")
    public String getOfficeAddressTest() {
        return driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[24]/div")).getText();
    }
}
