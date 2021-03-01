package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW8 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
        try {
            WebElement frameResultElement = webDriver.findElement(By.id("iframeResult"));
            WebDriver frameResult = webDriver.switchTo().frame(frameResultElement).switchTo().frame(0);

            String title = frameResult.findElement(By.cssSelector("title")).getAttribute("innerHTML");

            if (!title.equals("W3Schools Online Web Tutorials")) {
                throw new AssertionError("Invalid iframe title");
            } else {
                System.out.println("Passed");
            }
        } catch (NoSuchElementException e) {
            System.out.println(e + "Элемент не найден");
        }

        webDriver.quit();
    }
}
