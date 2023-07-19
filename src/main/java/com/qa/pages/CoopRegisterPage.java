package com.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CoopRegisterPage {

    private WebDriver driver;

    //1.Created Constructor

    public CoopRegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //2.Find WebElements

    private By joinMember = By.cssSelector("a[class='coop-btn']");
    private By radioButton = By.cssSelector("#member-has-card-no");
    private By clickNext = By.id("register-check-card-button");
    private By title = By.cssSelector("#member-title");
    private By firstName = By.cssSelector("#member-first-name");
    private By lastName = By.cssSelector("#member-last-name");
    private By day = By.cssSelector("#member-day-of-birth");
    private By month = By.cssSelector("#member-month-of-birth");
    private By year = By.cssSelector("#member-year-of-birth");
    private By postcode = By.cssSelector("#postcode");
    private By findAddress = By.id("find-address-current");
    private By addressBox = By.cssSelector(".current-address-list");
    private By addressPick = By.cssSelector(".current-address-list li:nth-child(3)");
    private By email = By.cssSelector("input[id='member-email']");
    private By confirmEmail = By.cssSelector("input[id='member-confirm-email']");
    private By password = By.cssSelector("input[id='member-password']");
    private By confirmPassword = By.cssSelector("input[id='member-confirm-password']");
    private By contactRadioButton = By.cssSelector("#marketing-opt-in-email");
    private By submitButton = By.id("register-button");

    //3. Creating a Method

    public void joinMemberClick() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        driver.findElement(joinMember).click();

    }

    public void clickOnRadio() {
        driver.findElement(radioButton).click();
        driver.findElement(clickNext).click();
    }

    public void fillDetailsOne(String titleSelection,String nameFirst,String nameLast,String dayPick,String monthPick,String yearPick) {
        Select select = new Select(driver.findElement(title));
        select.selectByVisibleText(titleSelection);
        driver.findElement(firstName).sendKeys(nameFirst);
        driver.findElement(lastName).sendKeys(nameLast);
        driver.findElement(day).sendKeys(dayPick);
        driver.findElement(month).sendKeys(monthPick);
        driver.findElement(year).sendKeys(yearPick);
    }

    public void fillDetailsTwo(String postCode,String emailPerson,String cEmail,String pass,String cPassword) {
        driver.findElement(postcode).sendKeys(postCode);
        driver.findElement(findAddress).click();
        List<WebElement> box = driver.findElements(addressBox);
        driver.findElement(addressPick).click();
        driver.findElement(email).sendKeys(emailPerson);
        driver.findElement(confirmEmail).sendKeys(cEmail);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(cPassword);
        driver.findElement(contactRadioButton).click();
        //driver.findElement(submitButton).click();
    }


}
