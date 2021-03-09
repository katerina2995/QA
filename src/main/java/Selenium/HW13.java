package Selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class HW13 {
    public static void main(String[] args) {
        System.out.println("Before test");
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
        try {
            WebElement element = webDriver.findElement(By.cssSelector("#save"));
            element.click();
            webDriver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
            webDriver.findElement(By.cssSelector("#loading img[src$=\".gif\"]"));

            webDriver.findElement(By.cssSelector("#loading img:not([src$=\".gif\"])"));

            String src = webDriver.findElement(By.cssSelector("#loading img")).getAttribute("src");
            String text = webDriver.findElement(By.cssSelector("#loading")).getText();
            System.out.println(text);
            System.out.println(src);
        } catch (NoSuchElementException e) {

            System.out.println("Элемент не найден");
        }
    }
}