import com.example.JSUtils;
import exrcesises.class11.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Solution {
    private static WebDriver driver;

    @BeforeClass
    public static void beforeAll() {
        driver = DriverSingleton.getDriverInstance();
        driver.get("https://dgotlieb.github.io/Navigation/Navigation.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //1
    @Test
    public void Test01_iFrame() {
        WebElement iFrameElement = driver.findElement(By.cssSelector("iframe[src='newFrame.html']"));
        driver.switchTo().frame(iFrameElement);
        System.out.println("IFrame text is: " + driver.findElement(By.id("iframe_container")).getText());
        driver.switchTo().defaultContent();
        Assert.assertEquals("Navigation", driver.findElement(By.id("title")).getText());
    }

	//2 in file Report.java


    //3
    @Test
    public void test02_XML() {
        driver.navigate().to(getData("URL"));
    }

    private static String getData (String keyName) {
        // todo change path to the XML file
        File configXmlFile = new File("C:\\Users\\...\\class12\\config.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            assert dBuilder != null;
            doc = dBuilder.parse(configXmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
    

    
    //4
    @Test
    public void Test10_alert() {
        driver.navigate().to("https://dgotlieb.github.io/Navigation/Navigation.html");
        driver.findElement(By.id("MyAlert")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test
    public void Test11_prompt() {
        driver.findElement(By.id("MyPrompt")).click();
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("Daniel");
        prompt.accept();
        String output = "Daniel";
        assertEquals(output, driver.findElement(By.id("output")).getText());
    }

    @Test
    public void Test12_confirmBox() {
        driver.findElement(By.id("MyConfirm")).click();
        Alert confirmbox = driver.switchTo().alert();
        confirmbox.accept();
        String output = "Confirmed";
        assertEquals(output, driver.findElement(By.id("output")).getText());
        driver.findElement(By.id("MyConfirm")).click();
        confirmbox.dismiss();
        output = "canceled";
        assertEquals(output, driver.findElement(By.id("output")).getText());
    }

    @AfterClass
    public void afterAll() {
        driver.quit();
    }
}
