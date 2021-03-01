package Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;

public class HW7 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("C:\\Users\\Katerina\\IdeaProjects\\QA\\src\\main\\resources\\windows.html");
        try {
            execConfirm(webDriver, true);

            execConfirm(webDriver, false);
            execConfirm(webDriver, false);

            execConfirm(webDriver, true);

            execConfirm(webDriver, false);

            execConfirm(webDriver, true);

            execConfirm(webDriver, false);
            execConfirm(webDriver, false);

            HashMap<String, String> confirmationResult = getConfirmations(webDriver);

            HW7.test("3", confirmationResult.get("pluses"));
            HW7.test("5", confirmationResult.get("minuses"));

            WebElement actionsHtmlFrameElement = webDriver.findElement(By.cssSelector("iframe[src='actions.html']"));
            WebDriver actionsHtmlFrame = webDriver.switchTo().frame(actionsHtmlFrameElement);
            List<WebElement> optionsList = actionsHtmlFrame.findElements(By.cssSelector("#selectable > li"));

            for (int i = 0; i < optionsList.size(); i++) {
                WebElement option = optionsList.get(i);
                option.click();
                String actualText = HW7.getSelectResult(actionsHtmlFrame);
                String expectedText = "#" + option.getText() + "(" + option.getAttribute("data-value") + ")";
                HW7.test(expectedText, actualText);
            }

            webDriver.switchTo().defaultContent();


            String[] PROMPT_WORDS = {"x1", "x2", "y1", "y2"};

            execPrompt(webDriver, false, PROMPT_WORDS[0]);

            for (int i = 0; i < PROMPT_WORDS.length; i++) {
                execPrompt(webDriver, true, PROMPT_WORDS[i]);
            }

            execPrompt(webDriver, false, PROMPT_WORDS[1]);
            execPrompt(webDriver, false, PROMPT_WORDS[0]);

            List<WebElement> promptResult = getPromptsResult(webDriver);

            String[] EXPECTED_WORDS = {"null", "x1", "x2", "y1", "y2", "null", "null"};

            for (int i = 0; i < promptResult.size(); i++) {
                test(EXPECTED_WORDS[i], promptResult.get(i).getText());
            }

            WebElement innerHtmlFrameElement = webDriver.findElement(By.cssSelector("iframe[src='inner.html']"));

            WebDriver innerHtmlFrame = webDriver.switchTo().frame(innerHtmlFrameElement);

            WebElement innerHtmlFrameHeader = innerHtmlFrame.findElement(By.cssSelector("h1"));

            test("Inner html", innerHtmlFrameHeader.getText());


            webDriver.switchTo().defaultContent();
        } catch (NoSuchElementException e) {
            System.out.println(e + "Элемент не найден");
        }

        webDriver.quit();
    }

    public static void execPrompt(WebDriver webDriver, Boolean shouldAccept, String text) {
        WebElement button = webDriver.findElement(By.cssSelector("#prompt > button"));
        button.click();

        WebDriver.TargetLocator targetLocator = webDriver.switchTo();
        Alert prompt = targetLocator.alert();

        prompt.sendKeys(text);

        // If shouldAccept == null, then "null" string will be added to result
        handleBrowserAlert(prompt, shouldAccept);
    }

    public static void handleBrowserAlert(Alert windowEl, Boolean shouldAccept) {
        if (shouldAccept) {
            windowEl.accept();
        } else {
            windowEl.dismiss();
        }
    }

    public static void execConfirm(WebDriver webDriver, Boolean shouldAccept) {
        WebElement button = webDriver.findElement(By.cssSelector("#confirm > button"));
        button.click();

        WebDriver.TargetLocator targetLocator = webDriver.switchTo();
        Alert confirm = targetLocator.alert();

        handleBrowserAlert(confirm, shouldAccept);
    }

    public static List<WebElement> getPromptsResult(WebDriver webDriver) {
        WebElement promptList = webDriver.findElement(By.cssSelector("#prompt"));

        List<WebElement> spanList = promptList.findElements(By.cssSelector("span"));

        return spanList;
    }

    public static String getSelectResult(WebDriver frame) {
        WebElement spanResult = frame.findElement(By.cssSelector("#select-result"));

        return spanResult.getText();
    }


        public static HashMap<String, String> getConfirmations (WebDriver webDriver){
            WebElement confirmationList = webDriver.findElement(By.cssSelector("#confirm"));
            HashMap<String, String> result = new HashMap<>();

            int plusesCount = 0;
            int minusesCount = 0;

            List<WebElement> spanList = confirmationList.findElements(By.cssSelector("span"));

            for (int i = 0; i < spanList.size(); i++) {
                if (spanList.get(i).getText().equals("+")) {
                    plusesCount++;
                } else {
                    minusesCount++;
                }
            }

            result.put("pluses", String.valueOf(plusesCount));
            result.put("minuses", String.valueOf(minusesCount));

            return result;
        }

        public static void test (String expectedText, String actualText){
            if (expectedText.equals(actualText)) {
                System.out.println("Pass");
            } else {
                System.out.println("Error");
            }
        }


    }

