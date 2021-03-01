package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class HW4 {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        System.out.println("Start test");

        webDriver.navigate().to("https://itstep.dp.ua/about-academy/");
        System.out.println(webDriver.getTitle());
        Thread.sleep(1000);

        webDriver.navigate().to("https://itstep.dp.ua/formy-obucheniya/");
        System.out.println(webDriver.getTitle());
        Thread.sleep(1000);

        webDriver.navigate().to("https://itstep.dp.ua/testirovanie-po-qa/");
        System.out.println(webDriver.getTitle());
        Thread.sleep(1000);
        webDriver.quit();
        System.out.println("End test");

        }
    }

