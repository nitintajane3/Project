package pages.dayplanpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.plaf.TableHeaderUI;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class DyplnMveActionElement
{
    WebDriver driver;
    private String today;
    public String disablecount;
    private String date = "28";
    private int critcalmove=1;
    private int importntmove=1;
    private int lessimportntmove=1;
    ResourceBundle proptiesdeprtment = ResourceBundle.getBundle("Departmentame");
    ResourceBundle propertyfile = ResourceBundle.getBundle("actiondetails");

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


public int dueActionCountImportnt(int i,int j)

   {
       //i=1,2,3 and j=11,12,17
       //int 1 and 11 critical
       //int 2 and 12 important
       //int 3 and 17 less important

       WebElement actionscountbefore = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div["+i+"]/div[1]/h2"));
       String wholestringname = actionscountbefore.getText();
       System.out.println("get text from "+wholestringname+ "length of action "+wholestringname.length());
       String last2 = (wholestringname.substring(wholestringname.length()-3));

       String removeingspace = last2.replaceAll("-","").trim();

       //System.out.println("after apply replaceall="+removeingspace+"lengthofstrong="+removeingspace.length());
      // System.out.println("it will print last two  character="+last2+"length of charvter");
       //char beforemvingcoount = wholestringname.charAt(j);

      // System.out.println("beofee moving char"+beforemvingcoount);
      int var1 =Integer.parseInt(String.valueOf(removeingspace));
      // int var11 = Character.getNumericValue(beforemvingcoount);
       System.out.println("due actio  count after ="+var1);
       return var1;

   }

    public int dayPlanActionCount(int k,int l)

    {
        //k=1,2,3 and l=11,12,17
        //int 1 and 11 critical
        //int 2 and 12 important
        //int 3 and 17 less important

        WebElement dayplanaction = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer ng-scope']/div/div["+k+"]/div[1]/h2"));
        String dayplanstring = dayplanaction.getText();
        //char dayplanactionnum = dayplanstring.charAt(l);

        String dayplanactiondeault = (dayplanstring.substring(dayplanstring.length()-3));

        String removeingspace2 = dayplanactiondeault.replaceAll("-","").trim();

        //int convertnumberw = Character.getNumericValue(dayplanactionnum);

        int convertnumber =Integer.parseInt(String.valueOf(removeingspace2));

        System.out.println("due actio  count after ="+convertnumber);
        return convertnumber;
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

    public void dayPlanSelectNextDate() throws InterruptedException {
        datechangeicon.click();
        nextmonthdate.click();
        today=getCurrentDay();
        System.out.println("today date is ="+today);
        int getrows = countrow.size();
        System.out.println("number of rows"+getrows);

        try
        {
        for(int i=1;i<=getrows;i++)
        {
              for(int j=1;j<=7;j++)
                {
                    Thread.sleep(300);

                    System.out.println("actual i value " + i + "actual j value" + j);


                    try
                    {
                        WebElement disabledate = driver.findElement(By.xpath("//div[@class='moment-picker-container month-view open']/div/table/tbody/tr[1]/td["+j+"][@class='ng-binding ng-scope disabled']"));
                        disablecount = disabledate.getText();
                        boolean checkeement = disabledate.isEnabled();
                        System.out.println("disable date"+disablecount);
                    }catch (Exception e){System.out.println("does not found any disable  date");}


                    WebElement actualnuumber = driver.findElement(By.xpath("//div[@class='moment-picker-container month-view open']/div/table/tbody/tr[" + i + "]/td[" + j + "]"));
                    String actualdate = actualnuumber.getText();
                    System.out.println("actual date" + actualdate);
                    if (actualdate.equals(today))
                    {
                        //if(disablecount.equals())
                        actualnuumber.click();
                        System.out.println("click on actual date");

                    }

                }

        }
        }catch (Exception e)
        {
            System.out.println("Date does  not found");
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
        actiontitleonpopup.sendKeys(propertyfile.getString("actiontitle4"));
    }

    public void selectduedate() throws InterruptedException
    {
        today=getCurrentDay();
        System.out.println("today date is ="+today);
        duedate.click();

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
                    break;
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

    public void selectProjectOvervw() throws InterruptedException {
        /*JavascriptExecutor excecuteactionproject = (JavascriptExecutor)driver;

        excecuteactionproject.executeScript("arguments[0].click();",selectprojectbtn );*/

        projecticon.click();

        List<WebElement> count = driver.findElements(By.xpath("//div[@class='dropdown-content upside right ng-scope show']/ul/li"));

        int assgineecount = count.size();

        System.out.println("list of projects"+assgineecount);

        String  expectedassgine=proptiesdeprtment.getString("projectname");

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
        System.out.println("today date is ="+today);
        int getrows = countrow.size();
        System.out.println("number of rows"+getrows);

        try
        {
            for(int i=1;i<=getrows;i++)
            {
                for(int j=1;j<=7;j++)
                {
                    Thread.sleep(300);
                    System.out.println("actual i value " + i + "actual j value" + j);
                    WebElement actualnuumber = driver.findElement(By.xpath("//div[@class='moment-picker-container month-view open']/div/table/tbody/tr[" + i + "]/td[" + j + "]"));
                    String actualdate = actualnuumber.getText();
                    System.out.println("actual date" + actualdate);
                    if (actualdate.equals(today))
                    {
                        actualnuumber.click();
                        System.out.println("click on actual date");

                    }

                }

            }
        }catch (Exception e)
        {
            System.out.println("Date does  not found");
        }

    }

}
