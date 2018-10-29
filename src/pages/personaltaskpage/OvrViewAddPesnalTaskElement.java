package pages.personaltaskpage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GetActionCount;

import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class OvrViewAddPesnalTaskElement
{
    WebDriver driver;
    private int today;
    ResourceBundle propertiesfile = ResourceBundle.getBundle("tamplo5");
    public String disablecount;
    public static JavascriptExecutor scriptexecutoroverview;

    public OvrViewAddPesnalTaskElement(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ul[@class='iconlist inline views withState']/li[2]/a/span[text()='OVERVIEW']")
    WebElement overviewclick;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[1]/div[1]/h2/span")
    WebElement countallcritical;

    @FindBy(xpath = "//div[1]/div[@id='criticalContainer']/div[1]/h4/span")
    WebElement countcritcalthisweek;

    @FindBy(xpath = "//div[1]/div[@id='criticalContainer']/div[2]/h4/span")
    WebElement countcriticalthismonth;

    @FindBy(xpath = "//div[1]/div[@id='criticalContainer']/div[3]/h4/span")
    WebElement countcriticalnextmonth;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[2]/div[1]/h2/span")
    WebElement countallmportant;

    @FindBy(xpath = "//div[2]/div[@id='criticalContainer']/div[1]/h4/span")
    WebElement countimportntthisweek;

    @FindBy(xpath = "//div[2]/div[@id='criticalContainer']/div[2]/h4/span")
    WebElement countimportntthismonth;

    @FindBy(xpath = "//div[2]/div[@id='criticalContainer']/div[3]/h4/span")
    WebElement countimportntnextmonth;

    @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[3]/div[1]/h2/span")
    WebElement countallessimportant;

    @FindBy(xpath = "//div[3]/div[@id='criticalContainer']/div[1]/h4/span")
    WebElement countlessimportntthisweek;

    @FindBy(xpath = "//div[3]/div[@id='criticalContainer']/div[2]/h4/span")
    WebElement countlessimportntthismonth;

    @FindBy(xpath = "//div[3]/div[@id='criticalContainer']/div[3]/h4/span")
    WebElement countlessimportntnextmonth;


    @FindBy(xpath = "//div[1]/div[@id='criticalContainer']/div[1]/div[2]/button[text()='ADD AN ACTION']")
    WebElement btnaddcritcalthisweek;

    @FindBy(xpath = "//div[1]/div[@id='criticalContainer']/div[2]/div[2]/button[text()='ADD AN ACTION']")
    WebElement btnaddcriticalthismonth;

    @FindBy(xpath = "//div[1]/div[@id='criticalContainer']/div[3]/div[2]/button[text()='ADD AN ACTION']")
    WebElement btnaddcriticalnextmonth;

    @FindBy(xpath = "//div[2]/div[@id='criticalContainer']/div[1]/div[2]/button[text()='ADD AN ACTION']")
    WebElement btnaddimportntthisweek;

    @FindBy(xpath = "//div[2]/div[@id='criticalContainer']/div[2]/div[2]/button[text()='ADD AN ACTION']")
    WebElement btnaddimportntthismonth;

    @FindBy(xpath = "//div[2]/div[@id='criticalContainer']/div[3]/div[2]/button[text()='ADD AN ACTION']")
    WebElement btnaddimportntnextmonth;

    @FindBy(xpath = "//div[3]/div[@id='criticalContainer']/div[1]/div[2]/button[text()='ADD AN ACTION']")
    WebElement btnaddlessimportntthisweek;

    @FindBy(xpath = "//div[3]/div[@id='criticalContainer']/div[2]/div[2]/button[text()='ADD AN ACTION']")
    WebElement btnaddlessimportntthismonth;

    @FindBy(xpath = "//div[3]/div[@id='criticalContainer']/div[3]/div[2]/button[text()='ADD AN ACTION']")
    WebElement btnaddlessimportntnextmonth;

    @FindBy(xpath = "//div[@class='moment-picker-container month-view open']/table/thead/tr/th[3]")
    public static WebElement nextmonthdate;

    @FindBy(xpath = "//div[@class='ng-scope']/ul/li[1]/div[2]/span/button[@title='DUE DATE']")
    public static WebElement duedate;

    @FindBy(xpath = "//div[@class='moment-picker-container month-view open']/table/thead/tr/th[1]")
    WebElement previousdate;

    @FindBy(xpath = "//li[@class='projectActionListItem addActionItem']/div[2]/span/div/div/table/tbody/tr")
    public static List<WebElement> findnorows;

    @FindBy(xpath = "//input[@placeholder='Enter action name here...']")
    WebElement actiontitle;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement butonsave;

    @FindBy(xpath = "//button[@class='icon icon-ic-remove']")
    WebElement btnclosed;

    public void enterActiontitle()
    {
        actiontitle.sendKeys(propertiesfile.getString("personaltasktitle"));
    }

    public void btnSave()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();",butonsave);
    }

    public void btnClosedPopUp()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();",btnclosed);
    }


    public int getCountAllCritical() throws InterruptedException
    {
        int overallcount = GetActionCount.Count(countallcritical);
        return overallcount;
    }

    public int getCountAllImportant() throws InterruptedException
    {
        int overallcount = GetActionCount.Count(countallmportant);
        return overallcount;
    }

    public int getCountAllessImportant() throws InterruptedException
    {
        int overallcount = GetActionCount.Count(countallessimportant);
        return overallcount;
    }

    public int  getCountCritcalThisWeek() throws InterruptedException
    {
        int count = GetActionCount.Count(countcritcalthisweek);
        return count;
    }

    public int  getCountCritcalThisMonth() throws InterruptedException
    {
        int count = GetActionCount.Count(countcriticalthismonth);
        return count;
    }

    public int  getCountCritcalNextMonth() throws InterruptedException
    {
        int count = GetActionCount.Count(countcriticalnextmonth);
        return count;
    }

    public int  getCountImportntThisWeek() throws InterruptedException
    {
        int count = GetActionCount.Count(countimportntthisweek);
        return count;
    }

    public int  getCountImportntThisMonth() throws InterruptedException
    {
        int count = GetActionCount.Count(countimportntthismonth);
        return count;
    }

    public int  getCountImportntNextMonth() throws InterruptedException
    {
        int count = GetActionCount.Count(countimportntnextmonth);
        return count;
    }

    public int  getCountLessImportntThisWeek() throws InterruptedException
    {
        int count = GetActionCount.Count(countlessimportntthisweek);
        return count;
    }

    public int  getCountLessImportntThisMonth() throws InterruptedException
    {
        int count = GetActionCount.Count(countlessimportntthismonth);
        return count;
    }

    public int  getCountLessImportntNextMonth() throws InterruptedException
    {
        int count = GetActionCount.Count(countlessimportntnextmonth);
        return count;
    }


   public void clkOverView()
    {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1500);");
        overviewclick.click();
    }

    public void addBtnCriticalThisWeek()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();",btnaddcritcalthisweek);
    }

    public void addBtnCriticalThisMonth()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();",btnaddcriticalthismonth);
    }

    public void addBtnCriticalNextMonth()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();",btnaddcriticalnextmonth);
    }


    public void addBtnImportantThisWeek()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();",btnaddimportntthisweek);
    }

    public void addBtnImportantThisMonth()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();",btnaddimportntthismonth);
    }

    public void addBtnImportantNextMonth()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();",btnaddimportntnextmonth);
    }

    public void addBtnLesImportantThisWeek()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();",btnaddlessimportntthisweek);
    }

    public void addBtnLesImportantThisMonth()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();",btnaddlessimportntthismonth);
    }

    public void addBtnLesImportantNextMonth()
    {
        scriptexecutoroverview = (JavascriptExecutor)driver;
        scriptexecutoroverview.executeScript("arguments[0].click();",btnaddlessimportntnextmonth);
    }


    public void selectNxtMonthCurntDate() throws InterruptedException
    {
        today=getCurrentDay();
        //today=30;
        duedate.click();
        nextmonthdate.click();
        int getrows = findnorows.size();
        try
        {
            for(int i=1;i<=getrows;i++)
            {
                for(int j=1;j<=7;j++)
                {
                    try
                    {
                        WebElement actualnuumber = driver.findElement(By.xpath("//li[@class='projectActionListItem addActionItem']/div[2]/span/div/div/table/tbody/tr[" + i + "]/td[" + j + "][@class='ng-binding ng-scope']"));
                        String actualdate = actualnuumber.getText();
                        if (Integer.valueOf(actualdate).equals(today))
                        {
                            actualnuumber.click();
                            break;
                        }
                    }catch (Exception ouuput){}
                }
            }
        }catch (Exception expetin)

        {
            System.out.println("not fund start date ");
        }


    }

    public void selectPrviousMonthCurntDate() throws InterruptedException
    {

            today = getCurrentDay();
            duedate.click();
        try {  //why try catch because some time element will not found
            previousdate.click();
            int getrows = findnorows.size();
            try {
                for (int i = 1; i <= getrows; i++)
                {
                    for (int j = 1; j <= 7; j++)
                    {
                        try
                        {
                        WebElement actualnuumber = driver.findElement(By.xpath("//li[@class='projectActionListItem addActionItem']/div[2]/span/div/div/table/tbody/tr[" + i + "]/td[" + j + "][@class='ng-binding ng-scope']"));
                        String actualdate = actualnuumber.getText();
                        if (Integer.valueOf(actualdate).equals(today))
                        {
                            actualnuumber.click();
                            break;
                        }
                        }catch (Exception notfound){}
                    }
                }
            } catch (Exception expetin)

            {
                System.out.println("not fund start date ");
            }
        }catch (Exception previous)
        {
            System.out.println("does not found back arrow");
        }

    }

    public void selectTodayDate() throws InterruptedException
    {
        today=getCurrentDay();
        duedate.click();
        int getrows = findnorows.size();
        try
        {
            for(int i=1;i<=getrows;i++)
            {
                for(int j=1;j<=7;j++)
                {
                    // below element find only active dates from respective month
                    try {
                        WebElement actualnuumber = driver.findElement(By.xpath("//li[@class='projectActionListItem addActionItem']/div[2]/span/div/div/table/tbody/tr[" + i + "]/td[" + j + "]"));
                        String actualdate = actualnuumber.getText();
                        if (Integer.valueOf(actualdate).equals(today)) {
                            actualnuumber.click();
                            break;
                        }
                    }catch (Exception notfound){}
                }
            }
        }catch (Exception expetin)

        {
            System.out.println("not fund start date ");
        }


    }
    public void selectNextWeekDueDate() throws InterruptedException {
        duedate.click();
       // today=getCurrentDay();
        today=Integer.sum(getCurrentDay(),8);  // in today date we add 8 number if todays is 20 after adding it will  be 28
       // System.out.println("today date is ="+today);
        int getrows = findnorows.size();
        //System.out.println("number of rows"+getrows);

        int  lastedate = currentMonthLastDate();  //found last date of current month like 31. 28 according to month

        try
        {
            for(int i=1;i<=getrows;i++)
            {
                for (int j = 1; j <= 7; j++)
                {
                    Thread.sleep(300);

             //       System.out.println("actual i value " + i + "actual j value" + j);


                    try {

                      // below element find only active dates from respective month
                        WebElement actualnuumber = driver.findElement(By.xpath("//div[@class='moment-picker-container month-view open']/div/table/tbody/tr[" + i + "]/td[" + j + "][@class='ng-binding ng-scope']"));
                        String actualdate = actualnuumber.getText();
               //         System.out.println("actual date" + actualdate);
                        if (Integer.valueOf(actualdate).equals(today))
                        {
                            // if searching value from  calendar and sum of date ()like 28 is same then click
                            actualnuumber.click();
                            break;
                            //          System.out.println("click on actual date");

                        }else
                            {
                                if (today > lastedate)   //if sum of date is greather than last date then go next month
                                {                        //because added 8 value not fitted to current  month that why it take goes to  next month
                                    nextmonthdate.click();
                                    for(int l=1;l<=getrows;l++)
                                    {
                                        for (int k = 1; k <= 7; k++)
                                        {
                                      int differecen = today - lastedate;  //pointer goes to next month this differece find date which we have to click
                                      System.out.println("Integer.compare(today,lastedate) " + differecen );

                                            try
                                            {
                                                //then again searching date in next month
                                                WebElement actualnuumber2 = driver.findElement(By.xpath("//div[@class='moment-picker-container month-view open']/div/table/tbody/tr["+l+"]/td["+k+"][@class='ng-binding ng-scope']"));
                                                String actualdate2 = actualnuumber2.getText();

                                                if (Integer.valueOf(actualdate2).equals(differecen))
                                                   {
                                                       actualnuumber2.click();
                                                             break;
                                                    }else
                                                           {
                                                                 System.out.println("In next month date not found");
                                                           }
                                            }catch (Exception oirtkj)
                                            {
                                                System.out.println("does not match");
                                            }
                                        }
                                    }
                                }else
                                    {
                                        System.out.println("today dtae not greather than actual date");
                                    }

                            }

                    } catch (Exception disablenumberfond) {
                        System.out.println("found disable number");
                    }

                }
            }
        }catch (Exception e)
        {
            System.out.println("Date does  not found");
        }

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

    public int currentMonthLastDate() throws InterruptedException
    {
        duedate.click();

        int lastvalue = 00;

        int getrows = findnorows.size();

        for(int i=1;i<=getrows;i++)
        {
            for (int j = 1; j <= 7; j++)
            {
                try {


                    WebElement allnumber = driver.findElement(By.xpath("//div[@class='moment-picker-container month-view open']/div/table/tbody/tr[" + i + "]/td[" + j + "][@class='ng-binding ng-scope']"));
                    String lastvaluestirng = allnumber.getText();
                    lastvalue = Integer.valueOf(lastvaluestirng);
                    //System.out.println("last  value is = " + lastvalue);
                }catch (Exception outputtest){}

            }
        }
        return lastvalue;
    }

}
