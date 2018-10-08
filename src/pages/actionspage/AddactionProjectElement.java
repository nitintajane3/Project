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

public class AddactionProjectElement
{

    WebDriver driver;
    private String today;
    ResourceBundle propertyfile = ResourceBundle.getBundle("actiondetails");

    public AddactionProjectElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='navbarList']/li[7]/ul/li[1]")
    WebElement listofproject;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[1]/div[3]/div[2]/button[text()='ADD AN ACTION']")
    WebElement addcriticalaction;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[2]/div[3]/div[2]/button[text()='ADD AN ACTION']")
    WebElement  addimpotantaction;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[3]/div[3]/div[2]/button[text()='ADD AN ACTION']")
    WebElement  addlessimportntaction;

    @FindBy(xpath = "//input[@type='text'][@placeholder='Enter action name here...']") //common action title element
    WebElement actionntitle;

    @FindBy(xpath = "//button[@title='DUE DATE']")
    WebElement duedate;

    @FindBy(xpath = "//li[@class='projectActionListItem addActionItem']/div[2]/span/div/div/table/tbody")
    WebElement tabletbody;

   @FindBy(xpath = "//li[@class='projectActionListItem addActionItem']/div[2]/span/div/div/table/tbody/tr")
    List<WebElement> findnorows;

    @FindBy(xpath = "//span[@title='Action assignee']")        //common action assignee element
    WebElement actionassignee;

    @FindBy(xpath = "//div[@class='dropdown-content ng-scope show']/ul/li")
    List<WebElement>  listofassginee;

    @FindBy(xpath = "//button[@class='btn verysmall btn-primary ng-binding ng-scope'][text()='Save']")  //commons save button
    WebElement savebutton;

    @FindBy(xpath = "//button[@class='btn verysmall btn-link ng-binding ng-scope'][text()='Cancel']")
    WebElement cancelbuttton;


    public void clickprojectfirst()
    {
        /*JavascriptExecutor listofprojectexcecute = (JavascriptExecutor)driver;
        listofprojectexcecute.executeScript("arguments[0].click();", listofproject);*/
        listofproject.click();
    }

    public void btnaddcriticalaction()
    {
        JavascriptExecutor excecutecritical = (JavascriptExecutor)driver;
        excecutecritical.executeScript("arguments[0].click();", addcriticalaction);
        //addcriticalaction.click();
    }

    public void btnaddimportntaction()
    {
        JavascriptExecutor excecuteimportant = (JavascriptExecutor)driver;
        excecuteimportant.executeScript("arguments[0].click();", addimpotantaction);
        //addimpotantaction.click();
    }

    public void btnaddlessimportantaction()
    {
        JavascriptExecutor excecutelessimportant = (JavascriptExecutor)driver;
        excecutelessimportant.executeScript("arguments[0].click();", addlessimportntaction);
        //addlessimportntaction.click();
    }

    public void enterActiontitle()
    {
        actionntitle.sendKeys(propertyfile.getString("actiontitle"));
    }

    public void clickduedate() throws InterruptedException
    {
        today=getCurrentDay();
        System.out.println("today date is ="+today);
        duedate.click();

        System.out.println("date click  on successfully");
        int getrows = findnorows.size();
        System.out.println("number of rows"+getrows);
        try
        {
        for(int i=1;i<=getrows;i++)
         {
           for(int j=1;j<=7;j++)
            {
              WebElement actualnuumber = driver.findElement(By.xpath("//li[@class='projectActionListItem addActionItem']/div[2]/span/div/div/table/tbody/tr["+i+"]/td["+j+"]"));
              String actualdate = actualnuumber.getText();
              if(actualdate.equals(today))
                  {
                  actualnuumber.click();
                  break;
                  }
            }
         }
       }catch (Exception expetin)

    {
        System.out.println("not fund start date ");
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

    public void selectactionassignee() throws InterruptedException {

        /*JavascriptExecutor excecuteactionassiggnee = (JavascriptExecutor)driver;
        excecuteactionassiggnee.executeScript("arguments[0].click();", actionassignee);*/
        Thread.sleep(200);
        actionassignee.click();
        int assgineecount = listofassginee.size();
        String  expectedassgine=propertyfile.getString("assginee1");
        for(int i=1;i<=assgineecount;i++)
        {
            try {
            Thread.sleep(100);
            WebElement assignelement = driver.findElement(By.xpath("//div[@class='dropdown-content ng-scope show']/ul/li["+i+"]/a"));
            String atalassginename = assignelement.getText();
            System.out.println("atalassginename");

            System.out.println("assginee name ="+atalassginename);
            if(atalassginename.equals(expectedassgine))
            {
                assignelement.click();
                System.out.println("successfully click on assignee"+expectedassgine);
            }}catch (Exception ryuh)
            {
                System.out.println("condition not match");
            }

        }
    }

    public void clicksaveaction()
    {
        JavascriptExecutor excecutesavebtn = (JavascriptExecutor)driver;
        excecutesavebtn.executeScript("arguments[0].click();", savebutton);
        //savebutton.click();
    }

    public void clickcancelaction()
    {
        cancelbuttton.click();
    }

    public void nextmonthduedate() throws InterruptedException {
        today=getCurrentDay();
        System.out.println("today date is ="+today);
        duedate.click();
        Thread.sleep(100);
        driver.findElement(By.xpath("//div[1]/section/section/section/div[2]/section/div/div/div[1]/div[3]/div[1]/ul/li/div[2]/span/div/table/thead/tr/th[3]")).click();
        int getrows = findnorows.size();
        System.out.println("number of rows"+getrows);
        for(int i=1;i<=getrows;i++)
        {
            for(int j=1;j<=7;j++)
            {
                Thread.sleep(200);
                WebElement actualnuumber = driver.findElement(By.xpath("//li[@class='projectActionListItem addActionItem']/div[2]/span/div/div/table/tbody/tr["+i+"]/td["+j+"]"));
                String actualdate = actualnuumber.getText();
                if(actualdate.equals(today))
                {
                    actualnuumber.click();
                    System.out.println("click on actual date");
                }
            }
        }

       /* try
        {
            Thread.sleep(1000);
        }catch (InterruptedException e76)
        {
            e76.printStackTrace();
        }*/

    }
}
