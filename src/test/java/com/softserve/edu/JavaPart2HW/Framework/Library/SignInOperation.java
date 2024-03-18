package com.softserve.edu.JavaPart2HW.Framework.Library;

import com.softserve.edu.JavaPart2HW.Framework.Data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SignInOperation {

    private WebDriver driver;
    private String EmailCssId = "email";
    private String PasswordCssId = "password";
    private String SignInCssSelector = "body > app-root > app-main > div > div.main-content.app-container > app-ubs > app-header > header > div.container-fluid > div > div > div > ul > a";
    private String SubmitButtonCssSelector = "button.ubsStyle[type='submit']";
    public SignInOperation(WebDriver webDriver)
    {
        driver = webDriver;
    }

    public void SignIn(User user)
    {
        OpenSignInMenu();
        SubmitEmail(user.getEmail());
        SubmitPassword(user.getPassword());
        ClickSignInSubmit();
    }

    public void OpenSignInView()
    {
        driver.get("https://www.greencity.social/#/greenCity");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        OpenSignInMenu();
    }

    public void SubmitEmail(String email)
    {
        var emailInput = driver.findElement(By.id(EmailCssId));
        emailInput.sendKeys(email);
    }

    public WebElement GetEmailInput()
    {
        return driver.findElement(By.id(EmailCssId));
    }

    public void SubmitPassword(String password)
    {
        var passwordInput = driver.findElement(By.id(PasswordCssId));
        passwordInput.sendKeys(password);
    }

    public WebElement GetPasswordInput()
    {
        return driver.findElement(By.id(PasswordCssId));
    }

    public void ClickSignInSubmit(){
        var submitButton = driver.findElement(By.cssSelector(SubmitButtonCssSelector));
        submitButton.click();
    }

    private void OpenSignInMenu(){
        driver.findElement(By.cssSelector(SignInCssSelector)).click();
    }
}
