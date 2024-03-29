import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Solution {
    private static ChromeDriver chromeDriver;
    private static FirefoxDriver firefoxDriver;

    @BeforeClass
    public static void beforeAll() {
        chromeDriver = new ChromeDriver();
        firefoxDriver = new FirefoxDriver();
    }

    //1
    @Test
    public void test01_open_websites() {
        chromeDriver.get("https://www.walla.co.il");
        firefoxDriver.get("https://www.ynet.co.il");
    }


    //2
    @Test
    public void test02_google_translate() {
        chromeDriver.get("https://translate.google.com");
        System.out.println(chromeDriver.findElement(By.id("source")));
        System.out.println(chromeDriver.findElement(By.tagName("textarea")));
    }

    //3
    @Test
    public void test03_youtube() {
        firefoxDriver.get("https://www.youtube.com/");
        System.out.println(firefoxDriver.findElement(By.id("search-icon-legacy")));
    }

    //4
    @Test
    public void test04_seleniumHQ() {
        firefoxDriver.get("http://www.seleniumhq.org/");
        WebElement searchElement = firefoxDriver.findElement(By.name("search"));
        System.out.println(searchElement);
        searchElement.sendKeys("selenium");
    }

    //5
    @Test
    public void test05_amazon() {
        chromeDriver.get("http://www.amazon.com/");
        String amazonTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        Assert.assertEquals(chromeDriver.getTitle(), amazonTitle);
        chromeDriver.findElement(By.id("twotabsearchtextbox")).sendKeys("Leather shoes");
    }

    //6
    @Test
    public void test06_translate() {
        chromeDriver.get("https://translate.google.com");
        chromeDriver.findElement(By.id("source")).sendKeys("שלום");
    }

    //7
    @Test
    public void test07_find_song() {
        chromeDriver.get("https://www.youtube.com");
        chromeDriver.findElement(By.id("search")).sendKeys("November rain");
        chromeDriver.findElement(By.id("search-icon-legacy")).click();
    }

    //8
    @Test
    public void test9_facebook() {
        chromeDriver.get("https://www.facebook.com");
        chromeDriver.findElement(By.id("email")).sendKeys("admin");
        chromeDriver.findElement(By.id("pass")).sendKeys("admin");
    }


    @AfterClass
    public void afterAll() {
        chromeDriver.quit();
        firefoxDriver.quit();
    }
}
