package pages.dashboardpage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Admin on 3/20/2018.
 */
public class DashboardPagElement {
    WebDriver driver;

    ResourceBundle properties = ResourceBundle.getBundle("config");
    String  actualcompany=properties.getString("companyname");


    @FindBy(xpath = "//a[text()=' PROJECTS ']")
    WebElement projectlink;

    @FindBy(xpath = "//a[text()=' MEETINGS ']")
    WebElement meetinglink;

    @FindBy(xpath = "//a[text()=' DAY PLAN']")
    WebElement dayplanlink;

    @FindBy(xpath = "//a[text()=' ACTIONS ']")
    WebElement actionlink;

    @FindBy(xpath = "//li[@class='active ng-scope']")
    WebElement dashboardlink;

    @FindBy(xpath = "//*[@id='jq-dropdown-3']/ul/li")
    List<WebElement> cmpcount;

    @FindBy(xpath = "//button[@class='btn btnDropDown username ng-binding']")
    WebElement usernameprofilebutton;

    @FindBy(xpath = "//button[@class='btn btnDropDown username ng-binding ng-scope']")
    WebElement companynamedropdownbox;


   @FindBy(xpath = "//a[@href='../app/#!/departments'][text()=' DEPARTMENTS ']")
   WebElement  departmentlink;

    @FindBy(css="button[class='btn small btnDropDown ng-binding']")
    WebElement usernameprofileiconCSS;

    @FindBy(xpath = "//div[@class='dashboardPageInfoHeaderRight']/span[@class='date ng-binding']")
    WebElement getdate;

    @FindBy(xpath = "//a[text()='PERSONAL TASKS']")
    WebElement personaltasklink;

    public void lnkdepartment()
    {
       departmentlink.click();

    }
    public void lnkprojects()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(projectlink));

       projectlink.click();
    }
    public void lnkmeeting()
    {
        meetinglink.click();
    }

    public void lnkdayplan()
    {
      dayplanlink.click();
    }
    public void lnkaction()
    {
        JavascriptExecutor actionlinkexcecute = (JavascriptExecutor)driver;
        actionlinkexcecute.executeScript("arguments[0].click();", actionlink);
     //actionlink.click();
    }

    public void lnkdashboard()
    {
     dashboardlink.click();
    }
    public String readdate()
    {
       String date = getdate.getText();
       return date;
    }

    public void btnusernmaeprofile()
    {
        usernameprofilebutton.click();

    }
   public void lnkdepartmet()
   {
      departmentlink.click();
   }

    public void dropdowncompany()
    {
        JavascriptExecutor excetuejava = (JavascriptExecutor)driver;
        excetuejava.executeScript("arguments[0].click()",companynamedropdownbox);


    }

    public void selectcompanydropdown() throws InterruptedException {
        String  actualcompany=properties.getString("companyname");
        int activecompnycount = cmpcount.size();
        for(int i=1;i<=activecompnycount;i++)
        {
            Thread.sleep(200);
            try
            {
                WebElement readcompanyname = driver.findElement(By.xpath("//*[@id='jq-dropdown-3']/ul/li[" + i + "]"));
                String getcompanyname = readcompanyname.getText();
                System.out.println("list of company = " + getcompanyname);
                if (getcompanyname.equals(actualcompany))
                {
                    driver.findElement(By.xpath("//*[@id='jq-dropdown-3']/ul/li[" + i + "]/a")).click();
                    System.out.println("click on expected company");
                }
            }catch (Exception e4){System.out.println("condition not match");}
        }
    }

    public DashboardPagElement(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void linkPersonalTask()
    {
        personaltasklink.click();
    }





}
