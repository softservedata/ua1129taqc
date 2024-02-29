package com.softserve.edu09seleniu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTestTest {

    private static final String BASE_URL = "https://www.greencity.social/#/greenCity";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static WebDriver driver;

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
    public void checkLogin() throws InterruptedException {
        //
        //driver.findElement(By.cssSelector(".header_sign-in-link")).click();
        driver.findElement(By.cssSelector("img.ubs-header-sing-in-img.ubs-header-sing-in-img-greencity")).click();
        Thread.sleep(2000); // For Presentation
        //
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("tyv09754@zslsz.com");
        Thread.sleep(2000); // For Presentation
        //
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Qwerty_1");
        Thread.sleep(2000); // For Presentation
        //
        driver.findElement(By.cssSelector(".greenStyle")).click();
        Thread.sleep(2000); // For Presentation
        //
        String loginName = driver.findElement(By.cssSelector(".body-2")).getText();
        Assertions.assertEquals("QwertyY", loginName);
        Thread.sleep(2000); // For Presentation
        //
        driver.findElement(By.cssSelector(".body-2")).click();
        //driver.findElement(By.cssSelector(".drop-down-item:nth-child(2) > a")).click();
        driver.findElement(By.cssSelector("li[aria-label='sign-out'] > a")).click();
        Thread.sleep(2000); // For Presentation
        //
        driver.findElement(By.cssSelector(".header_sign-in-link"));
    }
}
