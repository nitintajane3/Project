package functional.landingpagetest;


import functional.login.TestcaseLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class UserProfileTest
{
   public static WebDriver driver;

@Test
    public void test1()
{

    ResourceBundle logine = ResourceBundle.getBundle("loginlocator");
    TestcaseLogin logintest = new TestcaseLogin();
    logintest.validlogintest();
    System.out.println("test ull poi");
    //JavascriptExecutor executor2 = (JavascriptExecutor)driver;
    //driver.findElement(By.cssSelector("button[class='btn small btnDropDown ng-binding']")).click();
    //WebElement element = driver.findElement(By.xpath("//button[@value='Dropdown']"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(logine.getString("userprofilebuttonelement"))));
    //driver.findElement(By.xpath(logine.getString("userprofilebuttonelement"))).click();

}



}
