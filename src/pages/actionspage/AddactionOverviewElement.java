package pages.actionspage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class AddactionOverviewElement
{


    WebDriver driver;
    private String today;
    public static JavascriptExecutor scriptexecutoroverview;
    ResourceBundle proptiesdeprtment = ResourceBundle.getBundle("Departmentame");
    ResourceBundle propertyfile = ResourceBundle.getBundle("actiondetails");


    public AddactionOverviewElement(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ul[@class='iconlist inline views withState']/li[2]/a/span[text()='OVERVIEW']")
    WebElement overview;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[1]/div[@id='criticalContainer']/div[1]/div[2]/button[text()='ADD AN ACTION']")
    WebElement addactionCriticalthisweek;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[1]/div[@id='criticalContainer']/div[2]/div[2]/button[text()='ADD AN ACTION']")
    WebElement addactionCriticalthismonth;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[1]/div[@id='criticalContainer']/div[3]/div[2]/button[text()='ADD AN ACTION']")
    WebElement addactionCriticalnextmonth;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[2]/div[@id='criticalContainer']/div[1]/div[2]/button[text()='ADD AN ACTION']")
    WebElement addactionImportthisweek;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[2]/div[@id='criticalContainer']/div[2]/div[2]/button[text()='ADD AN ACTION']")
    WebElement addactionImportthismonth;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[2]/div[@id='criticalContainer']/div[3]/div[2]/button[text()='ADD AN ACTION']")
    WebElement addactionImportnextmonth;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[3]/div[@id='criticalContainer']/div[1]/div[2]/button[text()='ADD AN ACTION']")
    WebElement addactionLessImportthisweek;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[3]/div[@id='criticalContainer']/div[2]/div[2]/button[text()='ADD AN ACTION']")
    WebElement addactionLessImportthismonth;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[3]/div[@id='criticalContainer']/div[3]/div[2]/button[text()='ADD AN ACTION']")
    WebElement addactionLessImportnextmonth;

    //section[@class='tamplo-dialogContentSection']/div[2]/div[1]/ul/li/div[1]/span/input[@placeholder='Enter action name here...']
    @FindBy(xpath = "//input[@placeholder='Enter action name here...']")
    WebElement actiontitleonpopup;

    //section[@class='tamplo-dialogContentSection']/div[2]/div[1]/ul/li/div[2]/span/button[@title='DUE DATE']
    @FindBy(xpath = "//span/button[@title='DUE DATE']")
    WebElement actionduedate;

    @FindBy(xpath = "//span[@title='PROJECT']")
    WebElement selectprojectbtn;


    //section[@class='tamplo-dialogContentSection']/div[2]/div[1]/ul/li/div[3]/span[2]/tamplo-icon-select/span[@title='Action assignee']
    @FindBy(xpath = " //span[@title='Action assignee']")
    WebElement selectassginee;


    @FindBy(xpath = "//button[@class='icon icon-ic-remove']")
    WebElement closepopup;

    @FindBy(xpath = "//section[@class='tamplo-dialogContentSection']/div[2]/div[1]/ul/li/div[3]/span/tamplo-icon-select/span/div/ul/li//section[@class='tamplo-dialogContentSection']/div[2]/div[1]/ul/li/div[3]/span/tamplo-icon-select/span/div/ul/li")
     List<WebElement> projectcount;

    @FindBy(xpath = "//div[@class='dropdown-content upside right ng-scope show']/ul/li")
    List<WebElement> listofassginee;

     @FindBy(xpath = "//button[text()='Save']")
     WebElement savebutton;

     @FindBy(xpath = "//button[text()='Cancel']")
     WebElement cancelbutton;

     @FindBy(xpath = "//div[@class='projectActionsWidgetFooter tamplo-footerbar']/div[2]/button")
     WebElement addactionbtn;

    @FindBy(xpath = "//li[@class='projectActionListItem addActionItem']/div[2]/span/div/div/table/tbody/tr")
    List<WebElement> findnorows;

    public void linkOverView()
    {
        JavascriptExecutor executoroverview = (JavascriptExecutor)driver;
        executoroverview.executeScript("arguments[0].click();", overview);
        //overview.click();
    }

    public void btnAdActionCriWek()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();", addactionCriticalthisweek);

    }
    public void btnAdActionCrimonth()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();", addactionCriticalthismonth);

    }
    public void btnAdActionCrinxtmonth()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();", addactionCriticalnextmonth);
    }
    public void btnAdActionImportWek()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();", addactionImportthisweek);
    }
    public void btnAdActionImportmonth()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();", addactionImportthismonth);
    }
    public void btnAdActionImportnxtmonth()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();", addactionImportnextmonth);
    }
    public void btnAdActionLesImportWek()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();", addactionLessImportthisweek);
    }
    public void btnAdActionLesImportmonth()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();", addactionLessImportthismonth);
    }
    public void btnAdActionLesImportnxtmonth()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();", addactionLessImportnextmonth);

    }


    public void enterActiontitle()
    {
        actiontitleonpopup.sendKeys(propertyfile.getString("actiontitle3"));
    }



    public void selectduedate() throws InterruptedException
    {
        today=getCurrentDay();
        System.out.println("today date is ="+today);
        actionduedate.click();

        System.out.println("date click  on successfully");
        int getrows = findnorows.size();
        System.out.println("number of rows"+getrows);
        for(int i=1;i<=getrows;i++)
        {
            for(int j=1;j<=7;j++)
            {
                Thread.sleep(300);
                WebElement actualnuumber = driver.findElement(By.xpath("//li[@class='projectActionListItem addActionItem']/div[2]/span/div/div/table/tbody/tr["+i+"]/td["+j+"]"));
                String actualdate = actualnuumber.getText();
                if(actualdate.equals(today))
                {
                    actualnuumber.click();
                    System.out.println("click on actual date");
                }
            }
        }
    }

    private String getCurrentDay ()
    {
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt +"\n");

        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");

        return todayStr;
    }

    public void selectProjectOvervw()
    {
        /*JavascriptExecutor excecuteactionproject = (JavascriptExecutor)driver;

        excecuteactionproject.executeScript("arguments[0].click();",selectprojectbtn );*/

        selectprojectbtn.click();

        List<WebElement> count = driver.findElements(By.xpath("//div[@class='dropdown-content upside right ng-scope show']/ul/li"));

        int assgineecount = count.size();

        System.out.println("list of projects"+assgineecount);

        String  expectedassgine=proptiesdeprtment.getString("projectname");

        for(int i=1;i<=assgineecount;i++)
        {
            try
            {

                WebElement projectnelement = driver.findElement(By.xpath("//div[@class='dropdown-content upside right ng-scope show']/ul/li["+i+"]/a"));

                String atalprojectname = projectnelement.getText();
                System.out.println("assginee name ="+atalprojectname);
                if(atalprojectname.equals(expectedassgine))
                {
                    System.out.println(expectedassgine+"both assginee name ="+atalprojectname);
                    projectnelement.click();
                    System.out.println("successfully click  on project");

                }
            }catch (Exception r)
            {
                System.out.println(" project select condition not match");
            }

        }
    }

    public void selectActionAssigneeOvervw()
    {

        /*JavascriptExecutor excecuteactionassiggnee = (JavascriptExecutor) driver;

        excecuteactionassiggnee.executeScript("arguments[0].click();", selectassginee);*/
        selectassginee.click();

        System.out.println("successfully click on assignee icon");

        List<WebElement> assignecount = driver.findElements(By.xpath("//section[@class='tamplo-dialogContentSection']/div[2]/div[1]/ul/li/div[3]/span[2]/tamplo-icon-select/span/div/ul/li"));

        int assgineecount = assignecount.size();
        System.out.println("list of prject"+assgineecount);
        String expectedassgine = propertyfile.getString("assginee1");
        for (int i = 1; i <= assgineecount; i++)
        {
            try
            {
                WebElement assignelement = driver.findElement(By.xpath("//div[@class='dropdown-content upside right ng-scope show']/ul/li[" + i + "]/a"));
                String atalassginename = assignelement.getText();
                //System.out.println("assginee name ="+atalassginename);
                if (atalassginename.equals(expectedassgine))
                {
                    System.out.println(atalassginename+"=both are same = "+expectedassgine);
                    assignelement.click();
                    System.out.println("successfully click on user");
                }
            } catch (Exception r)
            {
                System.out.println("condition not match");
            }

        }


    }

    public void btnSave()
    {
        savebutton.click();
    }

    public void btnCancel()
    {
        cancelbutton.click();
    }

    public void btnClosedPopup()
    {
        closepopup.click();
    }

    public void btnAddaction()
    {
        addactionbtn.click();
    }


}
