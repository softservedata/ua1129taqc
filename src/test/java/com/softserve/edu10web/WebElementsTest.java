package com.softserve.edu10web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class WebElementsTest {

    private static final String BASE_URL = "https://demo.opencart.com/index.php";
    private static final long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final long ONE_SECOND_DELAY = 1000;
    private static WebDriver driver;

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
        driver.get(BASE_URL);
        System.out.println("\t@BeforeEach executed");
    }

    @AfterEach
    public void tearThis() throws InterruptedException {
        Thread.sleep(8000); // For Presentation
        System.out.println("\t@AfterEach executed");
        // TODO
        // Close Session
    }

    @Test
    public void checkExistWebElement() throws Exception {
        //
        System.out.println("1. isVisible Login Link = "
                + driver.findElement(By.cssSelector("#top a[href*='route=account/login']")).isDisplayed());
        presentationSleep(); // For Presentation ONLY
        //
        driver.findElement(By.cssSelector("div.nav.float-end a[data-bs-toggle='dropdown']")).click();
        presentationSleep(); // For Presentation ONLY
        //
        System.out.println("2. isVisible Login Link = "
                + driver.findElement(By.cssSelector("#top a[href*='route=account/login']")).isDisplayed());
        presentationSleep(); // For Presentation ONLY
        //
        driver.findElement(By.cssSelector("#top a[href*='route=account/login']")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // /*-
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("hahaha");
        String content = driver.findElement(By.id("input-email")).getAttribute("value");
        System.out.println("***content email = " + content);
        presentationSleep(2); // For Presentation ONLY
        //
        // Refresh some webelements
        driver.navigate().refresh();
        presentationSleep(); // For Presentation ONLY
        //
        driver.findElement(By.id("input-email")).sendKeys("bebebe");
        presentationSleep(); // For Presentation ONLY
        // */
        //
        /*- Architecture ERROR
        WebElement email = driver.findElement(By.id("input-email"));
        //
        email.click();
        email.clear();
        email.sendKeys("hahaha");
        String content = email.getAttribute("value");
        System.out.println("content email = " + content);
        presentationSleep(); // For Presentation ONLY
        //
        // Refresh some webelements
        driver.navigate().refresh();
        presentationSleep(); // For Presentation ONLY
        email.sendKeys("bebebe"); // Runtime Error
        presentationSleep(); // For Presentation ONLY
        */
        //
        // driver.findElement(By.id("input-email")).sendKeys("password");
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys("password");
        content = driver.findElement(By.id("input-password")).getAttribute("value");
        System.out.println("content password = " + content);
        presentationSleep(2); // For Presentation ONLY
        //
    }

    @Test
    public void checkSearch()  {
        List<WebElement> products = driver.findElements(By.cssSelector("div#content div.col"));
        System.out.println("***products.size() = " + products.size());
        presentationSleep(); // For Presentation ONLY
        //
        WebElement iPhoneContainer = products.get(1);
        WebElement iPhonePrice = iPhoneContainer.findElement(By.cssSelector("span.price-new"));
        presentationSleep(); // For Presentation ONLY
        //
        String price = iPhonePrice.getText();
        System.out.println("***price = " + price);
        Assertions.assertTrue(price.contains("123"));
    }

    @Test
    public void checkAllOptions()  {
        driver.findElement(By.linkText("Desktops")).click();
        presentationSleep(); // For Presentation ONLY
        driver.findElement(By.linkText("Show All Desktops")).click();
        presentationSleep(); // For Presentation ONLY
        WebElement select = driver.findElement(By.id("input-sort"));
        presentationSleep(); // For Presentation ONLY
        //
        List<WebElement> allOptions = select.findElements(By.tagName("option"));
        for (WebElement current : allOptions) {
            System.out.println("Option = " + current.getText());
        }
    }

    @Test
    public void checkSelect()  {
        driver.findElement(By.linkText("Desktops")).click();
        presentationSleep(); // For Presentation ONLY
        driver.findElement(By.linkText("Show All Desktops")).click();
        presentationSleep(); // For Presentation ONLY
        WebElement selectWebElement = driver.findElement(By.id("input-sort"));
        presentationSleep(); // For Presentation ONLY
        //
        Select select = new Select(selectWebElement);
        presentationSleep(); // For Presentation ONLY
        select.selectByVisibleText("Rating (Lowest)");
    }
}
