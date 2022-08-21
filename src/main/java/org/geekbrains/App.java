package org.geekbrains;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;


public class App 
{
    public static void main( String[] args ){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        testButtons(driver);
        testWebTables(driver);
        testDatePicker(driver);
        testAccordion(driver);

        driver.quit();
    }

    public static void testButtons(WebDriver driver){
        Actions action = new Actions(driver);

        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickBtn = driver.findElement(By.cssSelector("button[id='doubleClickBtn']"));
        WebElement rightClickBtn = driver.findElement(By.cssSelector("button[id='rightClickBtn']"));
        WebElement dynamicClickBtn = driver.findElement(By.xpath(".//div[3]/button"));

        action.doubleClick(doubleClickBtn).perform();
        action.contextClick(rightClickBtn).perform();
        dynamicClickBtn.click();
    }

    public static void testWebTables(WebDriver driver){
        driver.get("https://demoqa.com/webtables");

        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys("Vitally");
        driver.findElement(By.id("lastName")).sendKeys("Dmitriev");
        driver.findElement(By.id("userEmail")).sendKeys("test@test.ru");
        driver.findElement(By.id("age")).sendKeys("24");
        driver.findElement(By.id("salary")).sendKeys("54000");
        driver.findElement(By.id("department")).sendKeys("QA");
        driver.findElement(By.id("submit")).click();
    }

    public static void testDatePicker(WebDriver driver){
        driver.get("https://demoqa.com/date-picker");

        driver.findElement(By.id("datePickerMonthYearInput")).click();
        WebElement selectElement = driver.findElement(By.cssSelector("select[class='react-datepicker__month-select']"));
        Select selectObject = new Select(selectElement);
        selectObject.selectByValue("5");
        selectElement = driver.findElement(By.cssSelector("select[class='react-datepicker__year-select']"));
        selectObject = new Select(selectElement);
        selectObject.selectByValue("2011");
        driver.findElement(By.xpath(".//div[4]/div[3]")).click();

    }

    public static void testAccordion(WebDriver driver){
        driver.get("https://demoqa.com/accordian");

        driver.findElement(By.cssSelector("div[id='section1Heading']")).click();
        driver.findElement(By.cssSelector("div[id='section2Heading']")).click();
        driver.findElement(By.cssSelector("div[id='section3Heading']")).click();
    }
}

