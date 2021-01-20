package com.nextBaseCRM.tests.jamila;

import com.nextBaseCRM.Utilities.AutomationTest;
import com.nextBaseCRM.Utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;


public class UserStory1  {
    public static void main(String[] args) throws InterruptedException {
        // setup driver http://login2.nextbasecrm.com
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://login2.nextbasecrm.com/");

        // enter user name Username:helpdesk45@cybertekschool.com    tagName[attribute='value']
        // verify each users can login
        ArrayList<String> validEmails=new ArrayList<>(Arrays.asList(
                "helpdesk45@cybertekschool.com",
                "helpdesk46@cybertekschool.com",
                "hr45@cybertekschool.com",
                "hr46@cybertekschool.com",
                "marketing45@cybertekschool.com",
                "marketing46@cybertekschool.com"));
        // We have a same user password for each user "UserUser"
        String passWord= "UserUser";
        // check each one by one with for each loop
        for (String each : validEmails) {
            driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(each);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");
            Thread.sleep(2000);

            // verify the user can click the remember me bottom
            driver.findElement(By.cssSelector("input[@id='USER_REMEMBER']")).click();
            Thread.sleep(2000);
            // verify the user can click login
            //driver.findElement(By.cssSelector(".login-btn")).click();
            driver.findElement(By.xpath("//*[@value='Log In']")).click();
            Thread.sleep(2000);

        }

        // verify login successful
        String expectedTitle="";
        String actualTitle=driver.getTitle();

        if(expectedTitle.equals(actualTitle)) {
            System.out.println("Title verification is PASSED!");

        } else {
            System.out.println("Title verification is FAILED!!!");
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("actualTitle = " + actualTitle);
        }
        driver.close();
    }
}