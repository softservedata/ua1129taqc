package com.softserve.edu.seleniumwebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Signin {

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

    @FindBy(css=".mat-simple-snackbar > span")
    private WebElement result;

    @FindBy(css = ".alert-general-error")
    private WebElement errorMessage;

    @FindBy(xpath = "//*[@id='email-err-msg']/app-error/div")
    private WebElement errorEmail;

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void initPageElements() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.greencity.social/");
        PageFactory.initElements(driver, this);
    }

    @AfterEach
    public void tearThis() {
        driver.quit();
    }

    @Test
    public void verifyTitle() {
        Assertions.assertEquals("GreenCity", driver.getTitle());
    }

    @ParameterizedTest
    @CsvSource({
        "c3twd50q@minimail.gq, 123456789Xx@, Vira",
        "keb0tijonok2@10mail.xyz, 123456Yy!, Vira"
    })
    public void signInWithValidCredentials(String email, String password, String userName) {
        signInButton.click();
        assertThat(welcomeText.getText(), is("Welcome back!"));
        assertThat(signInDetailsText.getText(), is("Please enter your details to sign in."));
            assertThat(emailLabel.getText(), is("Email"));
        emailInput.sendKeys(email);
        assertThat(emailInput.getAttribute("value"), is(email));
        passwordInput.sendKeys(password);
        assertThat(passwordInput.getAttribute("value"), is(password));
        signInSubmitButton.click();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));

        String loginName = driver.findElement(By.cssSelector(".body-2")).getText();
        Assertions.assertEquals(userName, loginName);
    }

    @ParameterizedTest
    @CsvSource({
        "c3twd50qaaaaa@minimail.gq, 123456789Xx@aaa, Bad email or password"
    })
    public void signInWithInvalidCredentials(String email, String password, String message)  {
        signInButton.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInSubmitButton.click();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
        final var invalidCredentials = driver.findElement(By.cssSelector("div.alert-general-error.ng-star-inserted"));
        assertThat(invalidCredentials.getText(), is(message));
    }

    @ParameterizedTest
    @CsvSource({
        "c3twd50q.gq, 123456789Xx@, Please check if the email is written correctly"
    })

    public void signInInvalidEmail(String email, String password, String message) {
        signInButton.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
        final var errorPasswordMessage = driver.findElement(By.cssSelector("div.validation-email-error.ng-star-inserted"));
        assertThat(errorPasswordMessage.getText(), is(message));
    }

    @ParameterizedTest
    @MethodSource("signInInvalidPasswordParams")
    public void signInInvalidPassword(String email, String password, String message) {
        signInButton.click();
        passwordInput.sendKeys(password);
        emailInput.sendKeys(email);
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
        final var errorPasswordMessage = driver.findElement(By.cssSelector("div.validation-password-error.ng-star-inserted"));
        assertThat(errorPasswordMessage.getText(), is(message));
    }

    private static Stream<Arguments> signInInvalidPasswordParams() {
        return Stream.of(
            Arguments.of("c3twd50q@minimail.gq", "12", "Password must be at least 8 characters long without spaces and contain at least one uppercase letter (A-Z), one lowercase letter (a-z), a digit (0-9), and a special character (~`!@#$%^&*()+=_-{}[]|:;”’?/<>,.)")
        );
    }
}
