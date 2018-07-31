package pages.departmentpage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ResourceBundle;

public class AddDepartmetElement {

   WebDriver driver;


    public AddDepartmetElement(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    ResourceBundle rb = ResourceBundle.getBundle("Departmentame");

    @FindBy(xpath = "//a[@href='#!/department/createDepartment']")
    WebElement addDeptbutton;

    @FindBy(xpath = "//textarea[@placeholder='GIVE YOUR DEPARTMENT A NAME']")
      WebElement dprtnametextarea;

    @FindBy(xpath = "//div[@class='userSection']")
    WebElement emptyspace;

    @FindBy(xpath = "html/body/div[1]/section/section/section/div[2]/section/div/div/div[1]/div/div/button")
    WebElement adddprtmanager;

    @FindBy(xpath = "//div[1]/section/section/section/div[2]/section/div/div/div[2]/div/div/button")
    WebElement adddeprtmember;

    @FindBy(xpath = "//*[@id='userQuery']")
    WebElement enteruseremailidintext;

    @FindBy(xpath = "//h5[@class='titleIcon userListTitle ng-binding']/span")
    WebElement clickontextfield;

    @FindBy(xpath = "//div[1]/section/section/section/div[2]/section/div/div/div[2]/h5/span")
    WebElement  emptyclick;

    @FindBy(xpath = "//button[@class='btn verysmall btn-primary ng-binding ng-scope'][text()='Save']")
     WebElement savebutton;

    @FindBy(xpath = "//button[@class='btn verysmall btn-link ng-binding ng-scope'][text()='Cancel']")
    WebElement cancelbutton;

    @FindBy(xpath = "//div[6]/div/div[2]")
    WebElement readpopup;

    @FindBy(xpath = "//div[6]/div")
    WebElement duplicatepopup;

    @FindBy(xpath = "//button[text()='OK']")
    WebElement  duplicateokbutton;


    @FindBy(xpath = "//div[6]/div/div[3]/div[//button[text()='OK']]")
    WebElement closedpopup;

    @FindBy(xpath = "//div[6]/div[1]")
    WebElement emailidduplicate;

    public void setAddDeptbutton()
    {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", addDeptbutton);

    }

    public void setDprtnametextarea()
    {
        dprtnametextarea.sendKeys(rb.getString("name"));
    }

    public void clickemptyspace()
    {
        emptyspace.click();
    }
     public void addbuttodeprtmaager()
   {
       JavascriptExecutor executor2 = (JavascriptExecutor)driver;
       executor2.executeScript("arguments[0].click();", adddprtmanager);

   }
    public void enteremailid()
   {
    enteruseremailidintext.sendKeys(rb.getString("email1"));
    }
    public void enteremailidmember()
    {
        enteruseremailidintext.sendKeys(rb.getString("email2"));
    }

    public void clickemailidfield()
    {
        clickontextfield.click();
    }

    public void clickonsavebutton()
    {
        savebutton.click();
    }
     public void clickoncancelbutton()
     {
         cancelbutton.click();
     }

     public void duplicatepoppresent()
     {
         readpopup.isDisplayed();

     }

     public void popupokbutton()
     {
         closedpopup.click();
     }

     public void duplicatepopupclosed()
     {
         duplicateokbutton.click();
     }
     public void setdeparmentmember()
     {
         adddeprtmember.click();
     }

     public void setemptyclick()
     {
         JavascriptExecutor executor2 = (JavascriptExecutor)driver;
         executor2.executeScript("arguments[0].click();", emptyclick);

     }

     public void popupenteredduplicateemail()
     {
         emailidduplicate.isDisplayed();
     }
}
