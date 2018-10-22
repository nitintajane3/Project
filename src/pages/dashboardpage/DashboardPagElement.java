package pages.dashboardpage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Admin on 3/20/2018.
 */
public class DashboardPagElement {
    WebDriver driver;

    ResourceBundle properties = ResourceBundle.getBundle("config");
    String  actualcompany=properties.getString("companyname");
    JavascriptExecutor excetuejava = (JavascriptExecutor)driver;


    @FindBy(xpath = "//div[@class='tamplo-mainBanner-itemRight']/nav/ul/li[5]/a[text()=' PROJECTS ']")
    WebElement projectlink;

    @FindBy(xpath = "//ul[@class='navbarList']/li[6]/span/label/a")
    WebElement lftpanelprojectlink;

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

   @FindBy(xpath = "//a[@class='ng-binding'][text()=' DEPARTMENTS ']")
   WebElement leftpaneldptlink;

    @FindBy(css="button[class='btn small btnDropDown ng-binding']")
    WebElement usernameprofileiconCSS;

    @FindBy(xpath = "//div[@class='dashboardPageInfoHeaderRight']/span[@class='date ng-binding']")
    WebElement getdate;

    @FindBy(xpath = "//a[text()='PERSONAL TASKS']")
    WebElement personaltasklink;

    @FindBy(xpath = "//ul[@class='navbarList']/li[3]/span/label/a")
    WebElement dayplanrghtpnl;

    @FindBy(xpath = "//ul[@class='navbarList']/li[4]/span/label/a")
    WebElement personaltskrightpanel;


    public void lftPanelPjectLnk()
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
        lftpanelprojectlink.click();
    }

    public void lnkDepartment()
    {
        try {
            JavascriptExecutor excetuejava = (JavascriptExecutor)driver;
            excetuejava.executeScript("arguments[0].click()",departmentlink);
            //departmentlink.click();

        }catch (Exception dprt){
            JavascriptExecutor excetuejava = (JavascriptExecutor)driver;
            excetuejava.executeScript("arguments[0].click()",leftpaneldptlink);
            //leftpaneldptlink.click();

        }
            }

            public void leftPanelDeptLink()
            {
                JavascriptExecutor excetuejava = (JavascriptExecutor)driver;
                excetuejava.executeScript("arguments[0].click()",leftpaneldptlink);
            }
    public void lnkprojects()
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
        projectlink.click();
    }
    public void lnkmeeting()
    {
        meetinglink.click();
    }

    /*public void lnkdayplan()
    {
      dayplanlink.click();
    }*/
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
       JavascriptExecutor excetuejava = (JavascriptExecutor)driver;
       excetuejava.executeScript("arguments[0].click()",departmentlink);
       /*JavascriptExecutor js = (JavascriptExecutor)driver;
       js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
       departmentlink.click();*/
   }

    public void dropdowncompany()
    {
        JavascriptExecutor excetuejava = (JavascriptExecutor)driver;
        excetuejava.executeScript("arguments[0].click()",companynamedropdownbox);


    }

    public void lnkDayPlan()
    {
        try
        {
            dayplanlink.click();
        }catch (Exception e)
        {
            dayplanrghtpnl.click();
        }

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

    public void linkPersonalTask() {
        try {
            personaltasklink.click();

        } catch (Exception e)
        {
          personaltskrightpanel.click();
        }

    }





}
