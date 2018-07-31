package pages.loginpage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Admin on 3/20/2018.
 */
public class LoginPageElements {
    public WebDriver  driver;
    String classname = "logintest";


    @FindBy(xpath = "//button[text()='LOG IN'][@class='btn small btn-secondary ng-binding']")
    WebElement signinbutton;

    @FindBy(xpath = "//*[@id='emailIdLoginPage']")
    WebElement username;

    @FindBy(xpath = "//*[@id='pass']")
    WebElement password;

    @FindBy(xpath = "//button[@id='submitButton']")
    WebElement loginbutton;

    @FindBy(xpath = "//button[@class='btn btn-primary btnStretched ng-binding']")
    WebElement loginbuttonenable;

    @FindBy(xpath = "//button[@class='btn btn-primary btnStretched ng-binding disabled']")
    WebElement loginbuttondisable;

    @FindBy(xpath = "//div[@class='error ng-scope']/label")
    WebElement failtologin;


public void loginbtnclick()
    {
    signinbutton.click();
    }
    public void usernameenter(String usernmae)
    {
        username.sendKeys(usernmae);
    }
    public void passwordenter(String passwords)
    {
        password.sendKeys(passwords);
    }
    public void loginbutton()

       {
          // loginbutton.click();


               try {
                   loginbuttonenable.click();
               }catch (NoSuchElementException e)
                   {
                   System.exit(1);
                    }


    }



    public String lblfailtologin()
    {
     String getfailsms = failtologin.getText();
     System.out.println("System give error message as " +getfailsms);
     return getfailsms;
    }








    public LoginPageElements(WebDriver driver)
    {
        this.driver =  driver;
        PageFactory.initElements(driver,this);

    }
}
