package com.softserve.edu12js;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScrolleTest {
    private static final String BASE_URL = "https://selenium.dev/downloads/";
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

    private void takeScreenShot(String testname)  {
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

    //@Test
    public void checkScroll() throws Exception {
        //
        WebElement linkProject = driver.findElement(By.cssSelector("a[href='https://www.perfecto.io/']"));
        presentationSleep(4); // For Presentation Only
        //
        /*
        // Scrolling by Action class
        Actions action = new Actions(driver);
        action.moveToElement(linkProject).perform();
        presentationSleep(); // For Presentation Only
        */
        //
        // Scrolling by JavaScript injection
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkProject);
        presentationSleep(4); // For Presentation ONLY
        //
        ((JavascriptExecutor)driver).executeScript("alert('Hello, click OK')");
        presentationSleep(4); // For Presentation ONLY
        //
        driver.switchTo().alert().accept();
        presentationSleep(); // For Presentation ONLY
        //
        Assertions.assertTrue(true);
        //
        isTestSuccessful = true;
    }

    @Test
    public void checkFindElements() throws Exception {
        //
        WebElement linkProject = driver.findElement(By.cssSelector("a[href='https://www.perfecto.io/']"));
        presentationSleep(4); // For Presentation Only
        //
        scrollToWebElement(linkProject);
        presentationSleep(4); // For Presentation Only
        //
        //WebElement browserstack = driver.findElement(By.cssSelector("a[href*='www.browserstack.com']"));
        //
        // For Explicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        //
        //WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        //
//        Wait<WebDriver> webDriverWait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofMillis(50))
//                .ignoring(NullPointerException.class)
//                .ignoring(TimeoutException.class);
        //
        //WebElement browserstack = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='www.browserstack.com']")));
        //
        // Find by JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement browserstack = (WebElement) (js.executeScript("return document.querySelector(\"a[href*='http://www.browserstack.com']\");"));
        //
        // For Implicit Wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        //
        //
        System.out.println("browserstack.isDisplayed() = " + browserstack.isDisplayed());
        System.out.println("browserstack.isEnabled() = " + browserstack.isEnabled());
        System.out.println("browserstack.isSelected() = " + browserstack.isSelected());
        presentationSleep(4); // For Presentation Only
        //
        // Click by Selenium
        //browserstack.click();
        //
        // Click by JavaSript
        js.executeScript("arguments[0].click();", browserstack);
        //
        //Assertions.assertTrue(false);
    }
}
