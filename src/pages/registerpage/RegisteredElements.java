package pages.registerpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Admin on 3/20/2018.
 */
public class RegisteredElements {
    WebDriver driver;


    public RegisteredElements(WebDriver driver)
    {
        this.driver =  driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//button[text()='REGISTER NOW ']")
    WebElement registerbutton;

   @FindBy(xpath = "//form[@name='htmlForm.registerForm']/div[2]/input[@id='companyName']")
    WebElement companyname;

    @FindBy(xpath = "//form[@name='htmlForm.registerForm']/div[3]/input[@id='emailId']")
    WebElement emailid;

    @FindBy(xpath = ".//*[@id='#']/footer/div")
    WebElement verifyemail;

     public void buttonregistered()
    {
        registerbutton.click();
    }
    public void namecompany()
    {
        companyname.sendKeys("jai  ho");
    }
    public void enteremailid()
    {
   emailid.sendKeys("nitintajane3@gmail.com");
    }
    public void buttonverifyemail()
    {
        verifyemail.click();
    }


}
