package com.softserve.edu.JavaPart2HW.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class TestSamples3 {
    @FindBy(css = "body > app-root > app-main > div > div.main-content.app-container > app-ubs > app-header > header > div.container-fluid > div > div > div > ul > a")
    private WebElement signInButton;

    @FindBy(css = ".container h1")
    private WebElement welcomeText;

    @FindBy(css = ".container h2")
    private WebElement signInDetailsText;

    @FindBy(css = "form.sign-in-form label[for='email']")
    private WebElement emailLabel;

    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(css = "button.ubsStyle[type='submit']")
    private WebElement signInSubmitButton;
    @FindBy(css = ".mat-simple-snackbar > span")
    private WebElement result;

    @FindBy(css = "#header_user-wrp > li")
    private WebElement successSignInUserTitle;

    @FindBy(css = ".alert-general-error")
    private WebElement errorMessage;
    @FindBy(css = "#mat-dialog-1 > app-auth-modal > div > div > div.right-side > div > app-sign-in > div > div:nth-child(1) > form > div.alert-general-error.ng-star-inserted")
    private WebElement errorPassword;

    @FindBy(css = "#pass-err-msg > app-error > div")
    private WebElement errorPasswordFormat;
    @FindBy(xpath = "//*[@id='email-err-msg']/app-error/div")
    private WebElement errorEmail;

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.greencity.social/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @BeforeEach
    public void initPageElements() {
        PageFactory.initElements(driver, this);
    }

    @Test
    public void verifyTitle() {
        Assertions.assertEquals("GreenCity", driver.getTitle());
    }

    @ParameterizedTest
    @CsvSource({
            "paneken468@azduan.com, Test123@, TestUser"
    })
    public void signInValidCredentials(String email, String password, String expectedUserName) {
        signInButton.click();
        assertThat(welcomeText.getText(), is("Welcome back!"));
        assertThat(signInDetailsText.getText(), is("Please enter your details to sign in."));
        assertThat(emailLabel.getText(), is("Email"));
        emailInput.sendKeys(email);
        assertThat(emailInput.getAttribute("value"), is(email));
        passwordInput.sendKeys(password);
        assertThat(passwordInput.getAttribute("value"), is(password));
        signInSubmitButton.click();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(3));
        assertThat(successSignInUserTitle.getText(), is(expectedUserName));
    }

    @ParameterizedTest
    @CsvSource({
            "samplestesgreencity.com, uT346^^^erw, Please check if the email is written correctly"
    })
    public void signInInvalidEmail(String email, String password, String message) {
        signInButton.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        assertThat(errorEmail.getText(), is(message));
    }

    @ParameterizedTest
    @CsvSource({
            "samplestest@greencity.com, ...., Password must be at least 8 characters long without spaces"
    })
    public void signInInvalidPassword(String email, String password, String message) {
        signInButton.click();
        passwordInput.sendKeys(password);
        emailInput.sendKeys(email);
        assertThat(errorPasswordFormat.getText(), is(message));
    }

    @ParameterizedTest
    @CsvSource({
            "samplestest@greencity.com, weakpassword, Bad email or password"
    })
    public void signInWithInvalidCredsExpectErrorMessage(String email, String password, String message) {
        signInButton.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInSubmitButton.click();
        assertThat(errorPassword.getText(), is(message));
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}