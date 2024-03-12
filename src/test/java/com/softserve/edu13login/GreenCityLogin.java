package com.softserve.edu13login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class GreenCityLogin {
    private static final String BASE_URL = "https://www.greencity.social/#/ubs";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long SCRIPT_TIMEOUT_WAIT_SECONDS = 100L;
    private static final Long PAGE_LOAD_TIMEOUT_WAIT_SECONDS = 180L;
    private static final long ONE_SECOND_DELAY = 1000;
    private static final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
    private static WebDriver driver;
    private boolean isTestSuccessful = true;

    private void presentationSleep() {
        presentationSleep(1);
    }

    private void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void takeScreenShot(String testname) {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./" + currentTime + "_" + testname + "_screenshot.png"));
        } catch (IOException e) {
            //throw new RuntimeException(e);
        }
    }

    private void takePageSource(String testname) {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        String pageSource = driver.getPageSource();
        byte[] strToBytes = pageSource.getBytes();
        Path path = Paths.get("./" + currentTime + "_" + testname + "_source.html");
        try {
            Files.write(path, strToBytes, StandardOpenOption.CREATE);
        } catch (IOException e) {
            //throw new RuntimeException(e);
        }
    }

    private void scrollToWebElement(WebElement webElement) {
        /*
        // Scrolling by Action class
        Actions action = new Actions(driver);
        action.moveToElement(webElement).perform();
        */
        //
        // Scrolling by JavaScript injection
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        //
        // https://peter.sh/experiments/chromium-command-line-switches/
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //
        //driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)); // 0 by default
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(SCRIPT_TIMEOUT_WAIT_SECONDS));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT_WAIT_SECONDS));
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1295, 687));
        System.out.println("@BeforeAll executed");
    }

    @AfterAll
    public static void tear() {
        if (driver != null) {
            driver.quit(); // close()
        }
        System.out.println("@AfterAll executed");
    }

    @BeforeEach
    public void setupThis() {
        isTestSuccessful = false;
        driver.get(BASE_URL);
        System.out.println("\t@BeforeEach executed");
    }

    @AfterEach
    public void tearThis(TestInfo testInfo) throws InterruptedException {
        Thread.sleep(8000); // For Presentation
        System.out.println("\t@AfterEach executed, name = " + testInfo.getDisplayName());
        //
        if (!isTestSuccessful) {
            takeScreenShot(testInfo.getDisplayName());
            takePageSource(testInfo.getDisplayName());
        }
        // TODO
        // Close Session
    }

    @Test
    public void checkLogin() {
        //
        // Steps TC
        // Click Login Button
        driver.findElement(By.cssSelector("app-ubs .ubs-header-sing-in-img")).click();
        //
        // Fill email input
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("tyv09754@zslsz.com");
        presentationSleep(); // For Presentation ONLY
        //
        // Fill password input
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Qwerty_1");
        presentationSleep(); // For Presentation ONLY
        //
        // Press Button Login
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // get Username
        String actualUserName = driver.findElement(By.cssSelector("li.ubs-user-name")).getText();
        String expectedUserName = "QwertyY";
        presentationSleep(); // For Presentation ONLY
        //
        // Check
        Assertions.assertEquals(expectedUserName, actualUserName);
        presentationSleep(); // For Presentation ONLY
        //
        isTestSuccessful = true;
    }

    @Test
    public void checkMyHabit() {
        //
        // Steps TC
        // Click Login Button
        driver.findElement(By.cssSelector("app-ubs .ubs-header-sing-in-img")).click();
        //
        // Fill email input
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("tyv09754@zslsz.com");
        presentationSleep(); // For Presentation ONLY
        //
        // Fill password input
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Qwerty_1");
        presentationSleep(); // For Presentation ONLY
        //
        // Press Button Login
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // Green City menu Click
        //driver.findElement(By.xpath("//ul[@role='tablist']//a[contains(text(),'Green City')]")).click();
        driver.findElement(By.cssSelector("app-header:nth-child(1) ul[role='tablist'] a[href*='greenCity']")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // Start forming a habit button click
        driver.findElement(By.cssSelector("div#main-content button.primary-global-button.btn")).click();
        presentationSleep(); // For Presentation ONLY
        //
        String actualLabel = driver.findElement(By.cssSelector("div[aria-selected='true'] div.mat-tab-label-content")).getText();
        String expectedLabel = "My habits";
        presentationSleep(); // For Presentation ONLY
        //
        // Check
        Assertions.assertTrue(actualLabel.contains(expectedLabel));
        presentationSleep(); // For Presentation ONLY
        //
        isTestSuccessful = true;
    }
}
