package pages.dayplanpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GetActionCount;

import javax.swing.plaf.TableHeaderUI;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class DyplnMveActionElement
{
    WebDriver driver;
    private int today;
    public String disablecount;
    private String date = "28";
    private int critcalmove=1;
    private int importntmove=1;
    private int lessimportntmove=1;
    ResourceBundle proptiesdeprtment = ResourceBundle.getBundle("Departmentame");
    ResourceBundle propertyfile = ResourceBundle.getBundle("actiondetails");
    ResourceBundle tamploprotperties = ResourceBundle.getBundle("tamplo5");

    public DyplnMveActionElement(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//aside/div/div[@class='tabFooter']/div/ul/li[@class='iconlistItem active']/a[@ng-click='showMyActions()']")
    WebElement myactionenble;

    @FindBy(xpath = "//aside/div/div[@class='tabFooter']/div/ul/li[@class='iconlistItem']/a[@ng-click='showMyActions()']")
    WebElement myactionnotenble;

    @FindBy(xpath = "//a[@ng-click='showMyActions()']")
    WebElement myaction;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/ul/li[1]/div[2]/button[@class='icon icon-ic-add']")
    WebElement movecriticalaction;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[2]/div[2]/ul/li[1]/div[2]/button[@class='icon icon-ic-add']")
    WebElement moveimportantaction;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[3]/div[2]/ul/li[1]/div[2]/button[@class='icon icon-ic-add']")
    WebElement movelessimprtntaction;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[1]/div[3]/button[@class='btn btnADD ng-binding']")
    WebElement dueactionaddcritical;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[2]/div[3]/button[@class='btn btnADD ng-binding']")
    WebElement dueactionaddimportant;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[3]/div[3]/button[@class='btn btnADD ng-binding']")
    WebElement dueactionaddlessimportant;

    @FindBy(xpath = "//li[@class='projectActionListItem addActionItem']/div[2]/span[button[@title='DUE DATE']]")
    WebElement duedate;

    @FindBy(xpath = "//input[@placeholder='Enter action name here...']")
    WebElement actiontitleonpopup;

    @FindBy(xpath = "//li[@class='projectActionListItem addActionItem']/div[2]/span/div/div/table/tbody/tr")
    List<WebElement> findnorows;

    @FindBy(xpath = "//li[@class='projectActionListItem addActionItem']/div[3]/span")
    WebElement projecticon;

    @FindBy(xpath = "//a[@class='ng-isolate-scope moment-picker-contents']/span[2]")
    WebElement datechangeicon;

    @FindBy(xpath = "//div[@class='moment-picker-container month-view open']/table/thead/tr/th[3]")
    WebElement nextmonthdate;

    @FindBy(xpath = "//div[@class='moment-picker-container month-view open']/table/thead/tr/th[1]")
    WebElement previousdate;

    @FindBy(xpath = "//div[@class='moment-picker-container month-view open']/div/table/tbody/tr")
    List<WebElement> countrow;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[1]/div[1]/h2")
    WebElement criticalgettxt;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[2]/div[1]/h2")
    WebElement importantgettxt;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div[3]/div[1]/h2")
    WebElement lessimportantgettxt;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer ng-scope']/div/div[1]/div[1]/h2")
    WebElement txtdayplancritical;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer ng-scope']/div/div[2]/div[1]/h2")
    WebElement txtdayplanimportant;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer ng-scope']/div/div[3]/div[1]/h2")
    WebElement txtdayplanlessimportant;




    public int  getCriticalCount() throws InterruptedException
    {
        int counte = GetActionCount.Count(criticalgettxt);
        return counte;
    }

    public int  getDayPlanCriticalCount() throws InterruptedException
    {
        int counte = GetActionCount.Count(txtdayplancritical);
        return counte;
    }

    public int  getImportntCount() throws InterruptedException
    {
        int counte = GetActionCount.Count(importantgettxt);
        return counte;
    }

    public int  getDayPlanImportntCount() throws InterruptedException
    {
        int counte = GetActionCount.Count(txtdayplanimportant);
        return counte;
    }

    public int  getLessImportntCount() throws InterruptedException
    {
        int counte = GetActionCount.Count(lessimportantgettxt);
        return counte;
    }

    public int  getDayPlanLessImportntCount() throws InterruptedException
    {
        int counte = GetActionCount.Count(txtdayplanlessimportant);
        return counte;
    }

    public void clickMyAction() throws InterruptedException {
        Thread.sleep(1000);
        myaction.click();
    }

    public void moveCricalAction()
    {
        for(int i=1;i<=critcalmove;i++)
        {
            try {
                WebElement addcrtcalaction = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[1]/div[2]/ul/li["+i+"]/div[2]/button[@class='icon icon-ic-add']"));
                addcrtcalaction.click();
            }catch (Exception e)
            {

            }

        }
    }

    public void moveImportntAction()
    {
        for(int i=1;i<=importntmove;i++)
        {
            try {
                WebElement addimportantaction = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[2]/div[2]/ul/li["+i+"]/div[2]/button[@class='icon icon-ic-add']"));
                addimportantaction.click();
            }catch (Exception e)
            {

            }

        }
    }

    public void moveLessImportntAction()
    {
        for(int i=1;i<=lessimportntmove;i++)
        {
            try {
                WebElement addlessimprntaction = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[3]/div[2]/ul/li["+i+"]/div[2]/button[@class='icon icon-ic-add']"));
                addlessimprntaction.click();
            }catch (Exception e)
            {
               System.out.println("does  not found any action");
            }

        }
    }

    public void selectNxtMonthCurntDate() throws InterruptedException
    {
        today=getCurrentDay();
        datechangeicon.click();
        nextmonthdate.click();
        int getrows = countrow.size();
        try
        {
            for(int i=1;i<=getrows;i++)
            {
                for(int j=1;j<=7;j++)
                {
                    try
                    {
                        WebElement actualnuumber = driver.findElement(By.xpath("//div[@class='moment-picker-container month-view open']/div/table/tbody/tr[" + i + "]/td[" + j + "][@class='ng-binding ng-scope']"));
                        String actualdate = actualnuumber.getText();
                        if (Integer.valueOf(actualdate).equals(today))
                        {
                            actualnuumber.click();
                            break;
                        }
                    }catch (Exception outp){}
                }
            }
        }catch (Exception expetin)

        {
            System.out.println("not fund start date ");
        }


    }

    public void dueAtionAddCritcal()
    {
       dueactionaddcritical.click();
    }

    public void dueAtionAddImprnt()
    {
        dueactionaddimportant.click();
    }

    public void dueAtionAddLessImprtnt()
    {
        dueactionaddlessimportant.click();
    }

    public void enterActiontitle()
    {
        actiontitleonpopup.sendKeys(tamploprotperties.getString("personaltasktitle"));
    }


    private int getCurrentDay ()
    {
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt +"\n");

        //Integer to String Conversion
        int todayStr = todayInt;
        System.out.println("Today Str: " + todayStr + "\n");

        return todayStr;
    }

    public void selectProjectOvervw() throws InterruptedException {


        projecticon.click();

        List<WebElement> count = driver.findElements(By.xpath("//div[@class='dropdown-content upside right ng-scope show']/ul/li"));

        int assgineecount = count.size();

        System.out.println("list of projects"+assgineecount);

        String  expectedassgine=tamploprotperties.getString("projectname");

        for(int i=1;i<=assgineecount;i++)
        {
                Thread.sleep(200);
                WebElement projectnelement = driver.findElement(By.xpath("//div[@class='dropdown-content upside right ng-scope show']/ul/li["+i+"]/a"));

                String atalprojectname = projectnelement.getText();
                System.out.println("assginee name ="+atalprojectname);
                if(atalprojectname.equals(expectedassgine))
                {
                    System.out.println(expectedassgine+"both assginee name ="+atalprojectname);
                    projectnelement.click();
                    System.out.println("successfully click  on project");
                    break;

                }


        }
    }

    public void dayPlanSelectpastDate() throws InterruptedException {
        datechangeicon.click();
        previousdate.click();
        previousdate.click();
        today=getCurrentDay();
        int getrows = countrow.size();

        try
        {
            for(int i=1;i<=getrows;i++)
            {
                for(int j=1;j<=7;j++)
                {
                    Thread.sleep(300);
                    try {
                        WebElement actualnuumber = driver.findElement(By.xpath("//div[@class='moment-picker-container month-view open']/div/table/tbody/tr[" + i + "]/td[" + j + "][@class='ng-binding ng-scope']"));
                        String actualdate = actualnuumber.getText();
                        if (Integer.valueOf(actualdate).equals(today))
                        {
                            actualnuumber.click();
                            break;
                        }
                    }catch (Exception notmatch){}

                }

            }
        }catch (Exception e)
        {
            System.out.println("Date does  not found");
        }

    }

}
