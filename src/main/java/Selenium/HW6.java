package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW6 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("C:\\Users\\Katerina\\IdeaProjects\\QA\\src\\main\\resources\\select_hw.html");
        Select auto = new Select(webDriver.findElement(By.id("auto")));
        WebElement output = webDriver.findElement(By.id("out1"));
        List<WebElement> options = auto.getOptions();
        for (int i = 1; i < 4; i++) {
            WebElement webElement = options.get(i);
            auto.selectByIndex(i);
            HW6.test(output.getText(), webElement.getText());
            auto.selectByIndex(0);
            auto.selectByValue(webElement.getText().toLowerCase());
            HW6.test(output.getText(), webElement.getText());
            auto.selectByIndex(0);
            auto.selectByVisibleText(webElement.getText());
            HW6.test(output.getText(), webElement.getText());

        }

    }

    public static void test(String selectedValue, String optionValue){
        if (selectedValue.equals("value:" + optionValue.toLowerCase())) {
            System.out.println("pass");
        }else {
            System.out.println("error");
        }
    }

}

