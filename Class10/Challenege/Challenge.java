import exrcesises.class11.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.JavascriptExecutor;


import static org.testng.Assert.assertEquals;

public class Challenge {
    private static WebDriver driver;

    @BeforeClass
    public static void setUP(){
        driver = DriverSingleton.getDriverInstance();
    }

    @Test
    public void test06_HandlingTabs() {
        driver.get("https://www.google.com");
        String googleTab = driver.getWindowHandle();
        ((JavascriptExecutor)driver).executeScript("window.open('https://www.youtube.com','_blank');");
        String youtubeTab = driver.getWindowHandle();
        ((JavascriptExecutor)driver).executeScript("window.open('https://translate.google.com','_blank');");
        driver.switchTo().window(googleTab);
        driver.switchTo().window(youtubeTab);
    }

    @AfterClass
    public void afterAll() {
        driver.quit();
    }
}
