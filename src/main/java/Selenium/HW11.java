package Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HW11 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        webDriver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        Actions action = new Actions(webDriver);
        WebElement rightClickMe = webDriver.findElement(By.cssSelector("body > div > section > div > div > div > p > span"));
        action.contextClick(rightClickMe).perform();

        WebElement element = webDriver.findElement(By.cssSelector("body > ul > li.context-menu-item.context-menu-icon.context-menu-icon-quit"));
        element.click();

        WebDriver.TargetLocator targetLocator = webDriver.switchTo();
        Alert alert = targetLocator.alert();

        if (alert.getText().equals("clicked: quit")){
            System.out.println("Message text = " + alert.getText());
            Thread.sleep(1000);
            alert.accept();
        }else {
            System.out.println("error");
        }
        webDriver.close();
    }
}
