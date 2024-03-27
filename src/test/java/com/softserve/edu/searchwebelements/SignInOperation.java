package com.softserve.edu.searchwebelements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.stream.Stream;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SignInOperation {

    private static final String BASE_URL = "https://www.greencity.social/";
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static JavascriptExecutor js;

    @BeforeAll
    public static void initAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @BeforeEach
    public void initEach() {
        driver.get(BASE_URL);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }

    @AfterAll
    public static void tearAll() {
        driver.quit();
    }

    @Test
    public void verifyTitle() {
        Assertions.assertEquals("GreenCity", driver.getTitle());
    }

    @ParameterizedTest(name = "Should successfully sign in for email={0}, password={1}, username={2}")
    @MethodSource("signInValidCredentialsParams")
    public void signInWithValidCredentials(String email, String password, String userName) {
        WebElement signInButton = (WebElement) js.executeScript("return document.querySelector('body > app-root > app-main > div > div.main-content.app-container > app-ubs > app-header > header > div.container-fluid > div > div > div > ul > a')");
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".container h1")));

        WebElement welcomeText = (WebElement) js.executeScript("return document.querySelector('.container h1')");
        WebElement signInDetailsText = (WebElement) js.executeScript("return document.querySelector(\".container h2\")");
        WebElement emailLabel = (WebElement) js.executeScript("return document.querySelector(\"form.sign-in-form label[for='email']\")");
        WebElement emailInput = (WebElement) js.executeScript("return document.getElementById('email')");
        WebElement passwordInput = (WebElement) js.executeScript("return document.getElementById('password')");
        WebElement signInSubmitButton = (WebElement) js.executeScript("return document.querySelector(\"button.ubsStyle[type='submit']\")");

        assertThat(welcomeText.getText(), is("Welcome back!"));
        assertThat(signInDetailsText.getText(), is("Please enter your details to sign in."));
        assertThat(emailLabel.getText(), is("Email"));
        emailInput.sendKeys(email);
        assertThat(emailInput.getAttribute("value"), is(email));
        passwordInput.sendKeys(password);
        assertThat(passwordInput.getAttribute("value"), is(password));
        signInSubmitButton.click();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        String loginName = driver.findElement(By.cssSelector(".body-2")).getText();
        Assertions.assertEquals(userName, loginName);
        WebElement signOutButton = driver.findElement(By.cssSelector("li[aria-label=\"sign-out\"] > a"));
        js.executeScript("arguments[0].click();", signOutButton);
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    private static Stream<Arguments> signInValidCredentialsParams() {
        return Stream.of(
            Arguments.of("c3twd50q@minimail.gq", "123456789Xx@", "Vira"),
            Arguments.of("keb0tijonok2@10mail.xyz", "123456Yy!", "Vira")
        );
    }

    @DisplayName("Should verify that an error message appears after entering invalid credentials")
    @ParameterizedTest
    @MethodSource("signInInvalidCredentialsParams")
    public void signInWithInvalidCredentials(String email, String password, String message)  {
        driver.findElement(By.cssSelector("body > app-root > app-main > div > div.main-content.app-container > app-ubs > app-header > header > div.container-fluid > div > div > div > ul > a")).click();

        WebElement emailInput = (WebElement) js.executeScript("return document.getElementById('email')");
        WebElement passwordInput = (WebElement) js.executeScript("return document.getElementById('password')");
        WebElement signInSubmitButton = (WebElement) js.executeScript("return document.querySelector(\"button.ubsStyle[type='submit']\")");

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInSubmitButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert-general-error.ng-star-inserted")));
        final var invalidCredentials = driver.findElement(By.cssSelector("div.alert-general-error.ng-star-inserted"));
        assertThat(invalidCredentials.getText(), is(message));
    }

    private static Stream<Arguments> signInInvalidCredentialsParams() {
        return Stream.of(
            Arguments.of("c3twd50q@minimail.gq", "123456789Xx@aaa", "Bad email or password"),
            Arguments.of("keb0tijonok2@10mailaaaa.xyz", "123456Yy!", "Bad email or password")
        );
    }

    @DisplayName("Should verify that an error message appears after entering invalid email")
    @ParameterizedTest
    @MethodSource("signInInvalidEmailParams")
    public void signInInvalidEmail(String email, String password, String message) {
        driver.findElement(By.cssSelector("body > app-root > app-main > div > div.main-content.app-container > app-ubs > app-header > header > div.container-fluid > div > div > div > ul > a")).click();

        WebElement emailInput = (WebElement) js.executeScript("return document.getElementById('email')");
        WebElement passwordInput = (WebElement) js.executeScript("return document.getElementById('password')");

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.validation-email-error.ng-star-inserted")));
        final var errorPasswordMessage = driver.findElement(By.cssSelector("div.validation-email-error.ng-star-inserted"));
        assertThat(errorPasswordMessage.getText(), is(message));
    }

    private static Stream<Arguments> signInInvalidEmailParams() {
        return Stream.of(
            Arguments.of("c3twd50q.gq", "123456789Xx@", "Please check if the email is written correctly"),
            Arguments.of("keb0tijonok2@@@10mail.xyz", "123456Yy!", "Please check if the email is written correctly")
        );
    }

    @DisplayName("Should verify that an error message appears after entering invalid password")
    @ParameterizedTest
    @MethodSource("signInInvalidPasswordParams")
    public void signInInvalidPassword(String email, String password, String message) {
        WebElement signInButton = (WebElement) js.executeScript("return document.querySelector('body > app-root > app-main > div > div.main-content.app-container > app-ubs > app-header > header > div.container-fluid > div > div > div > ul > a')");
        signInButton.click();

        WebElement emailInput = (WebElement) js.executeScript("return document.getElementById('email')");
        WebElement passwordInput = (WebElement) js.executeScript("return document.getElementById('password')");

        passwordInput.sendKeys(password);
        emailInput.sendKeys(email);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.validation-password-error.ng-star-inserted")));
        final var errorPasswordMessage = driver.findElement(By.cssSelector("div.validation-password-error.ng-star-inserted"));
        assertThat(errorPasswordMessage.getText(), is(message));
    }

    private static Stream<Arguments> signInInvalidPasswordParams() {
        return Stream.of(
            Arguments.of("c3twd50q@minimail.gq", "12", "Password have from 8 to 20 characters long without spaces and contain at least one uppercase letter (A-Z), one lowercase letter (a-z), a digit (0-9), and a special character (~`!@#$%^&*()+=_-{}[]|:;”’?/<>,.)"),
            Arguments.of("keb0tijonok2@10mail.xyz", "567!@", "Password have from 8 to 20 characters long without spaces and contain at least one uppercase letter (A-Z), one lowercase letter (a-z), a digit (0-9), and a special character (~`!@#$%^&*()+=_-{}[]|:;”’?/<>,.)")
        );
    }
}
