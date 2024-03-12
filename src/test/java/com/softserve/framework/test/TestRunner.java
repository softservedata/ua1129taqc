package com.softserve.framework.test;

import com.softserve.framework.library.GuestOperation;
import com.softserve.framework.library.LogginedOperation;
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

public abstract class TestRunner {
    private static final String BASE_URL = "https://www.greencity.social/#/ubs";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long SCRIPT_TIMEOUT_WAIT_SECONDS = 100L;
    private static final Long PAGE_LOAD_TIMEOUT_WAIT_SECONDS = 180L;
    private static final long ONE_SECOND_DELAY = 1000;
    private static final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
    private static WebDriver driver;
    protected static GuestOperation guestOperation;
    protected static LogginedOperation logginedOperation;
    protected boolean isTestSuccessful = true;

    protected void presentationSleep() {
        presentationSleep(1);
    }

    protected void presentationSleep(int seconds) {
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

    private static void setupChromeBrowser() {
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
    }

    @BeforeAll
    public static void setup() {
        setupChromeBrowser();
        //
        guestOperation = new GuestOperation(driver);
        logginedOperation = new LogginedOperation(driver);
        //
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
        System.out.println("\t@AfterEach executed, getDisplayName = " + testInfo.getDisplayName());
        System.out.println("\t@AfterEach executed, getTestMethod = " + testInfo.getTestMethod());
        //
        if (!isTestSuccessful) {
            takeScreenShot(testInfo.getDisplayName());
            takePageSource(testInfo.getDisplayName());
        }
        // TODO
        // Close Session
    }

}
