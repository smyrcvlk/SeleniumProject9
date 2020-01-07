package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Budget {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://test-basqar.mersys.io");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://test-basqar.mersys.io");
        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();
        driver.findElement(By.cssSelector(".group-items > :nth-child(6)")).click();
        driver.findElement(By.cssSelector(".group-items > :nth-child(6) > .children > :nth-child(1)")).click();
        driver.findElement(By.cssSelector(".group-items > :nth-child(6) > .children > :nth-child(1) .children > :nth-child(1)")).click();
        driver.findElement(By.cssSelector("[data-icon='plus']")).click();

        String descriptionname = "Smyrcvlk";
        driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]")).sendKeys(descriptionname);


        driver.findElement(By.cssSelector("#mat-select-2")).click();

        driver.findElement(By.xpath("//*[@id=\"mat-option-11\"]/span")).click();

        String startdatename = "01/01/2020";
        driver.findElement(By.xpath("//*[@id=\"mat-input-7\"]")).sendKeys(startdatename);


        String enddate = "03/28/2020";
        driver.findElement(By.xpath("//*[@id=\"mat-input-8\"]")).sendKeys(enddate);

        String comment="SUCCESS!";
        driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]")).sendKeys(comment);

        driver.findElement(By.xpath("//div[@class='mat-tab-label mat-ripple ng-star-inserted']")).click();
        driver.findElement(By.xpath("//input[@class='mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-untouched ng-pristine ng-invalid']")).sendKeys("1");
        driver.findElement(By.xpath("//ms-decimal-field//input")).sendKeys("2");
        driver.findElement(By.xpath("//button[@class='mat-raised-button mat-button-base mat-basic ng-star-inserted']")).click();
        WebElement saveIcon = driver.findElement(By.cssSelector("mat-dialog-container [data-icon=\"save\"]"));
        saveIcon.click();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label='Budget Group successfully created']")));
            System.out.println("Creation success!");
        } catch (Exception e) {
            System.out.println("Creation failure!");
        }
        String text = driver.findElement(By.xpath("//td[text()='Smyrcvlk']")).getText();
        if (descriptionname.equals(text)) {
            System.out.println("success");
        }

        String text2 = driver.findElement(By.xpath("//td[text()='01/01/2020']")).getText();
        if (startdatename.equals(text2)) {
            System.out.println("success");
        }
        String text3 = driver.findElement(By.xpath("//td[text()='03/28/2020']")).getText();
        if (enddate.equals(text3)) {
            System.out.println("success");

        }

    }

}







