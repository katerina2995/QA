package Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HW9 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("C:\\Users\\Katerina\\IdeaProjects\\QA\\src\\main\\resources\\windows.html");

        WebElement button = null;
        try {
            String h1 = webDriver.getWindowHandle();
            System.out.println("First handle = " + h1);
            button = webDriver.findElement(By.cssSelector("#button1"));
            button.click();
            Thread.sleep(2000);
            String secondPgeHandle = "";
            for (String windowHandle : webDriver.getWindowHandles()) {
                secondPgeHandle = windowHandle;
                if (!windowHandle.equals(h1)) {
                    break;
                }
            }

            WebDriver window = webDriver.switchTo().window(secondPgeHandle);

            System.out.println("Second page title " + window.getTitle());
            HW9.test("Компьютерная Академия ШАГ Днепр – №1 на рынке IT-образования Украины", window.getTitle());

            WebDriver mainWindow = webDriver.switchTo().window(h1);
            button = mainWindow.findElement(By.cssSelector("#content button"));
            button.click();
            for (String windowHandle : webDriver.getWindowHandles()) {
                System.out.println(windowHandle);
                WebDriver currentWindow = webDriver.switchTo().window(windowHandle);
                currentWindow.close();
            }
        } catch (NoSuchElementException | InterruptedException e) {
            System.out.println("Элемент не найден");

        }

    }
    public static void test (String expectedText, String actualText){
        if (expectedText.equals(actualText)) {
            System.out.println("Pass");
        } else {
            System.out.println("Error");
        }
    }
}

