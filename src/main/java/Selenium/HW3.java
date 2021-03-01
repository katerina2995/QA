package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

public class HW3 {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        String url = "file:///C:/Users/Katerina/AppData/Local/Temp/Rar$EXa592.20688/Lesson2%20hw/automation-practice-table.html";
        System.out.println("Start test");
        webDriver.get(url);
        List<WebElement> tdList = webDriver.findElements(By.tagName("td"));
        System.out.println("td count = " + tdList.size());
        for(WebElement td : tdList) {
            System.out.println("text = " + td.getText());
            System.out.println("tagName = " + td.getTagName());
            System.out.println("display = " + td.isDisplayed());
            System.out.println("==========================");
        }
        webDriver.findElement(By.linkText("details")).click();
        webDriver.quit();
        System.out.println("End test");

    }
}