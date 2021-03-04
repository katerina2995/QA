package Selenium;

import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;



public class HW12 {
        private WebDriver webDriver;


        @Before
        public void setUp() {
            System.out.println("Before test");
            System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.get("C:\\Users\\Katerina\\IdeaProjects\\QA\\src\\main\\resources\\index.html");
        }
    @Test
    public void testHeaderWebDriverWait(){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 15);
        webDriverWait.until(webDriver1 -> webDriver1.findElement(By.tagName("h1")));
        webDriverWait.until(webDriver1 -> webDriver1.switchTo().alert());
        Alert alert = webDriver.switchTo().alert();
        String expectedText = "Test it";
        String h1 = alert.getText();

        if(expectedText.equals(h1)){
            System.out.println("Текст совпадает = " + h1);
        }
        alert.accept();
        webDriverWait.until(webDriver1 -> webDriver1.findElement(By.cssSelector("body.blue")));
        String h1Color = Color.fromString(webDriver.findElement(By.tagName("h1")).getCssValue("color")).asHex();
        System.out.println("Фон синий и текст " + h1Color);  // #ffff00 - yellow color
    }
    }
