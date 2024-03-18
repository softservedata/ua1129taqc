package com.softserve.edu.JavaPart2HW.Selenium;

import com.softserve.edu.JavaPart2HW.Framework.Data.User;
import com.softserve.edu.JavaPart2HW.Framework.Library.SignInOperation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.softserve.edu.JavaPart2HW.Framework.Data.UserRepository;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class TestSamples3 {

    @FindBy(css = ".container h1")
    private WebElement welcomeText;

    @FindBy(css = ".container h2")
    private WebElement signInDetailsText;

    @FindBy(css = "form.sign-in-form label[for='email']")
    private WebElement emailLabel;
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

    public static WebDriver driver;

    private static Stream<Arguments> provideUsers() {
        return Stream.of(
                Arguments.of(UserRepository.GetValidUser())
        );
    }

    private static Stream<Arguments> provideInvalidUsers() {
        return Stream.of(
                Arguments.of(UserRepository.GetInvalidUser())
        );
    }

    private static Stream<Arguments> provideUsersWithIncorrectEmails() {
        return Stream.of(
                Arguments.of(UserRepository.GetInvalidUserWithIncorrectEmail())
        );
    }

    private static Stream<Arguments> provideUsersWithWeekPasswords() {
        return Stream.of(
                Arguments.of(UserRepository.GetInvalidUserWithWeekPassword())
        );
    }

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
    @MethodSource("provideUsers")
    public void signInValidCredentials(User user) {

        var signInOperationHelper = new SignInOperation(driver);
        signInOperationHelper.OpenSignInView();

        assertThat(welcomeText.getText(), is("Welcome back!"));
        assertThat(signInDetailsText.getText(), is("Please enter your details to sign in."));
        assertThat(emailLabel.getText(), is("Email"));

        signInOperationHelper.SubmitEmail(user.getEmail());
        assertThat(signInOperationHelper.GetEmailInput().getAttribute("value"), is(user.getEmail()));

        signInOperationHelper.SubmitPassword(user.getPassword());
        assertThat(signInOperationHelper.GetPasswordInput().getAttribute("value"), is(user.getPassword()));

        signInOperationHelper.ClickSignInSubmit();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(3));
        assertThat(successSignInUserTitle.getText(), is(user.getName()));
    }


    @ParameterizedTest
    @MethodSource("provideUsersWithIncorrectEmails")
    public void signInInvalidEmail(User user) {
        var signInOperationHelper = new SignInOperation(driver);
        signInOperationHelper.OpenSignInView();
        signInOperationHelper.SubmitEmail(user.getEmail());
        signInOperationHelper.SubmitPassword(user.getPassword());

        var expectedErrorMessage = "Please check if the email is written correctly";
        assertThat(errorEmail.getText(), is(expectedErrorMessage));
    }

    @ParameterizedTest
    @MethodSource("provideInvalidUsers")
    public void signInInvalidPassword(User user) {
        var signInOperationHelper = new SignInOperation(driver);
        signInOperationHelper.OpenSignInView();
        signInOperationHelper.SubmitPassword(user.getPassword());
        signInOperationHelper.SubmitEmail(user.getEmail());

        var expectedErrorMessage = "Password must be at least 8 characters long without spaces";
        assertThat(errorPasswordFormat.getText(), is(expectedErrorMessage));
    }

    @ParameterizedTest
    @MethodSource("provideUsersWithWeekPasswords")
    public void signInWithInvalidCredsExpectErrorMessage(User user) {
        var signInOperationHelper = new SignInOperation(driver);
        signInOperationHelper.OpenSignInView();
        signInOperationHelper.SubmitPassword(user.getPassword());
        signInOperationHelper.SubmitEmail(user.getEmail());
        signInOperationHelper.ClickSignInSubmit();

        var expectedErrorMessage = "Bad email or password";
        assertThat(errorPassword.getText(), is(expectedErrorMessage));
    }

    @Test
    public void CheckHabits(){
        driver.findElement(By.cssSelector("body > app-root > app-main > div > div.main-content.app-container > app-ubs > app-header > header > div.container-fluid > div > div > div > ul > a")).click();

        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("paneken468@azduan.com");

        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Test123@");

        driver.findElement(By.cssSelector("button[type='submit']")).click();


        // Green City menu Click
        driver.findElement(By.cssSelector("app-header:nth-child(1) ul[role='tablist'] a[href*='greenCity']")).click();

        // Start forming a habit button click
        driver.findElement(By.cssSelector("div#main-content button.primary-global-button.btn")).click();

        //
        String actualLabel = driver.findElement(By.cssSelector("div[aria-selected='true'] div.mat-tab-label-content")).getText();
        String expectedLabel = "My habits";

        // Check
        Assertions.assertTrue(actualLabel.contains(expectedLabel));

    }

    @Test
    @CsvSource({
            "samplestest@greencity.com, ...."
    })
    public void Login(String email, String password) {
        driver.findElement(By.cssSelector("body > app-root > app-main > div > div.main-content.app-container > app-ubs > app-header > header > div.container-fluid > div > div > div > ul > a")).click();

        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("paneken468@azduan.com");

        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Test123@");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}