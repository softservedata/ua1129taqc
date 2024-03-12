package com.softserve.framework.library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogginedOperation {
    private WebDriver driver;

    public LogginedOperation(WebDriver driver) {
        this.driver = driver;
    }

    public String getLogginedName() {
        return  driver.findElement(By.cssSelector("li.ubs-user-name")).getText();
    }

    public void chooseMySpace() {
        driver.findElement(By.cssSelector("div#main-content button.primary-global-button.btn")).click();
    }

    public  String getMyHabbitsMenuName() {
        return driver.findElement(By.cssSelector("div[aria-selected='true'] div.mat-tab-label-content")).getText();
    }
}
