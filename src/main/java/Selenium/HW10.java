package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class HW10 {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        String str = "C:\\Users\\Katerina\\IdeaProjects\\QA\\src\\main\\resources\\select.html";
        webDriver.get(str);
        Actions actions = new Actions(webDriver);
        try {
            WebElement cheese = webDriver.findElement(By.cssSelector("#additives option[value='Cheese']"));

            actions.moveToElement(cheese).click().perform();
            HW10.test(findSelectedOption("Cheese",webDriver).getAttribute("value"),cheese.getAttribute("value"));

            WebElement pepperoni = webDriver.findElement(By.cssSelector("#additives option[value='Pepperoni']"));

            actions.keyDown(Keys.CONTROL).moveToElement(pepperoni).click().perform();
            HW10.test(findSelectedOption("Cheese",webDriver).getAttribute("value"),cheese.getAttribute("value"));
            HW10.test(findSelectedOption("Pepperoni",webDriver).getAttribute("value"), pepperoni.getAttribute("value"));

            WebElement mushrooms = webDriver.findElement(By.cssSelector("#additives option[value='Mushrooms']"));
            
            actions.keyDown(Keys.CONTROL).moveToElement(mushrooms).click().perform();
            HW10.test(findSelectedOption("Cheese",webDriver).getAttribute("value"),cheese.getAttribute("value"));
            HW10.test(findSelectedOption("Pepperoni",webDriver).getAttribute("value"), pepperoni.getAttribute("value"));
            HW10.test(findSelectedOption("Mushrooms",webDriver).getAttribute("value"),mushrooms.getAttribute("value"));


        } catch (Exception e) {
            e.printStackTrace();
        }
        webDriver.quit();
    }

    public static void test(String selectedValue, String optionValue) {
        if (optionValue.toLowerCase().equals(selectedValue.toLowerCase())) {
            System.out.println("pass");
        } else {
            System.out.println("error");
        }
    }
    public static WebElement findSelectedOption(String value, WebDriver webDriver){
        return webDriver.findElement(By.cssSelector("#out2 option[value='" + value + "']"));

    }
    }


