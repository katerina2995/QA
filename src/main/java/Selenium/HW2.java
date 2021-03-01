package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class HW2 {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        String url = "https://itstep.dp.ua/about-academy/";
        System.out.println("Start test");
        webDriver.get(url);
        Thread.sleep(1000);
        System.out.println();
        System.out.println(webDriver.getTitle());
        if(url.equals(webDriver.getCurrentUrl())){
            System.out.println("Pass");
        }else {
            System.out.println("Error");
        }
        System.out.println("End test");
    }
}
