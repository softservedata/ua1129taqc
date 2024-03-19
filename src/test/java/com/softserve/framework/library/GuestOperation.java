package com.softserve.framework.library;

import com.softserve.edu.Applog;
import com.softserve.framework.data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuestOperation {
    private static final Logger logger = LoggerFactory.getLogger(Applog.class); // org.slf4j.LoggerFactory
    private WebDriver driver;

    public GuestOperation(WebDriver driver) {
        this.driver = driver;
    }

    //public void signIn(String email, String password) {
    public void signIn(User user){
        System.out.println("*****Start with user = " + user);
        logger.debug("+++++Start with user = " + user);
        // Click Login Button
        driver.findElement(By.cssSelector("app-ubs .ubs-header-sing-in-img")).click();
        //
        // Fill email input
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        //driver.findElement(By.id("email")).sendKeys("tyv09754@zslsz.com");
        //driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("email")).sendKeys(user.getEmail());
        //
        // Fill password input
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        //driver.findElement(By.id("password")).sendKeys("Qwerty_1");
        //driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("password")).sendKeys(user.getPassword());
        //
        // Press Button Login
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        logger.debug("Done with user = " + user);
    }

    public void greencitySwitch() {
        //driver.findElement(By.cssSelector("app-header:nth-child(1) ul[role='tablist'] a[href*='greenCity']")).click();
        driver.findElement(By.cssSelector("app-ubs ul[role='tablist'] a[href*='greenCity']")).click();
    }
}
