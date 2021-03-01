package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW5 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        webDriver.navigate().to("http://google.com");
        WebElement q = webDriver.findElement(By.name("q"));
        q.sendKeys("liki24 api");
        q.submit();
        webDriver.findElement(By.cssSelector("#result-stats"));
        String str = "Результатов: примерно 3 350 (0,68 сек.) ";
        if (str.startsWith("Результатов: примерно 3 350")){
            System.out.println("Pass");
        }else {
            System.out.println("Error");
        }
        Thread.sleep(1000);
        webDriver.quit();
        System.out.println("End test");
    }
}
