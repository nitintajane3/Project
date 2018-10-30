package pages.actionspage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.personaltaskpage.AddPersonalTkElement;
import utilities.GetActionCount;

import java.util.List;
import java.util.ResourceBundle;

public class AddActionslistViewElement

{

    WebDriver driver;
    ResourceBundle propertiestamplo5 = ResourceBundle.getBundle("tamplo5");
    ResourceBundle propertyfile = ResourceBundle.getBundle("actiondetails");


    public AddActionslistViewElement(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ul[@class='iconlist inline views withState']/li[3]/a/span[text()='LIST VIEW']")
    WebElement listview;

    @FindBy(xpath = "//ul[@class='iconlist inline views withState']/li[2]/a/span[text()='OVERVIEW']")
    WebElement overview;

    @FindBy(xpath = "//ul[@class='iconlist inline views withState']/li[1]/a/span[text()='CALENDAR VIEW']")
    WebElement calendarview;

    @FindBy(xpath = "//div[@class='actiontool']/span[1]/tamplo-icon-select")        //common action assignee element
    WebElement actionproject;

    @FindBy(xpath = "//div[@class='actiontool']/span[2]/tamplo-icon-select")
    WebElement  actionassignee;

    @FindBy(xpath = "//div[@class='dropdown-content ng-scope show']/ul/li")
    List<WebElement> listofproject;

    @FindBy(xpath = "//div[@class='dropdown-content upside right ng-scope show']/ul/li")
    List<WebElement> listofprojectlessimportant;

    @FindBy(xpath = "//div[@class='dropdown-content ng-scope show']/ul/li")
    List<WebElement>  actionlistofassginee;

    @FindBy(xpath = "//div[@class='dropdown-content upside right ng-scope show']/ul/li")
    List<WebElement>  actionlistofassgineelessimportant;

    @FindBy(xpath = "//input[@type='text'][@placeholder='Enter action name here...']") //common action title element
    WebElement actionntitlename;

    @FindBy(xpath = "//div[@class='projectActionsWidgetFooter ng-scope']/button[text()='Cancel']")
    WebElement cancelbutton;

    @FindBy(xpath = "//div[@class='swal-footer']/div/button[text()='OK']")
    WebElement okbutton;


    public int getCountCritical() throws InterruptedException
    {
        AddPersonalTkElement addperosnaltaskelement = new AddPersonalTkElement(driver);
        int gettextcritical = GetActionCount.Count(addperosnaltaskelement.criicallable);
        return gettextcritical;
    }

    public int getCountImportant() throws InterruptedException
    {
        AddPersonalTkElement addperosnaltaskelement = new AddPersonalTkElement(driver);
        int gettextimportant = GetActionCount.Count(addperosnaltaskelement.impotyntlabel);
        return gettextimportant;
    }

    public int getCountLessImportant() throws InterruptedException
    {
        AddPersonalTkElement addperosnaltaskelement = new AddPersonalTkElement(driver);
        int gettextlessimportant = GetActionCount.Count(addperosnaltaskelement.lessimportntlabel);
        return gettextlessimportant;
    }

    public void btnCancel()
    {
        cancelbutton.click();
    }

    public void btnOk()
    {
        okbutton.click();
    }

    public void linkListView()
    {
        JavascriptExecutor executorlistview = (JavascriptExecutor)driver;
        executorlistview.executeScript("arguments[0].click();", listview);
        //listview.click();
    }

    public void linkOverView()
    {
        JavascriptExecutor executoroverview = (JavascriptExecutor)driver;
        executoroverview.executeScript("arguments[0].click();", overview);
        overview.click();
    }

    public void linkCalendarView()
    {
        calendarview.click();
    }

    public void enterActiontitle()
    {
        actionntitlename.sendKeys(propertyfile.getString("actiontitle2"));
    }

    public void selectproject()
    {
        JavascriptExecutor excecuteactionproject = (JavascriptExecutor)driver;
        excecuteactionproject.executeScript("arguments[0].click();", actionproject);
        int assgineecount = listofproject.size();
        String  expectedassgine=propertiestamplo5.getString("projectname");

        for(int i=1;i<=assgineecount;i++)
        {

            try
            {
            WebElement assignelement = driver.findElement(By.xpath("//div[@class='dropdown-content ng-scope show']/ul/li[" + i + "]/a"));
            String atalassginename = assignelement.getText();
            if (atalassginename.equals(expectedassgine))
            {
                assignelement.click();
                break;
            }
            }catch (Exception r)
            {
                System.out.println("condition not match");
            }
        }
    }


    public void selectprojectlessimportant()
    {
        JavascriptExecutor excecuteactionproject = (JavascriptExecutor)driver;
        excecuteactionproject.executeScript("arguments[0].click();", actionproject);
        int assgineecount = listofprojectlessimportant.size();
        String  expectedassgine=propertiestamplo5.getString("projectname");

        for(int i=1;i<=assgineecount;i++)
        {

            try
            {
                WebElement assignelement = driver.findElement(By.xpath("//div[@class='dropdown-content upside right ng-scope show']/ul/li[" + i + "]/a"));
                String atalassginename = assignelement.getText();
                if (atalassginename.equals(expectedassgine))
                {
                    assignelement.click();
                    break;
                }
            }catch (Exception r)
            {
                System.out.println("condition not match");
            }
        }
    }

    public void selectactionassigneename() throws InterruptedException {

        JavascriptExecutor excecuteactionassiggnee = (JavascriptExecutor) driver;
        excecuteactionassiggnee.executeScript("arguments[0].click();", actionassignee);
        int assgineecount = actionlistofassginee.size();
        String expectedassgine = propertyfile.getString("assginee1");
        for (int i = 1; i <= assgineecount; i++)
        {
            try {
                Thread.sleep(200);
                WebElement assignelement = driver.findElement(By.xpath("//div[@class='dropdown-content ng-scope show']/ul/li[" + i + "]/a"));
                String atalassginename = assignelement.getText();
                //System.out.println("assginee name ="+atalassginename);
                if (atalassginename.equals(expectedassgine))
                {
                    assignelement.click();
                    break;
                }
            } catch (Exception r) {
                System.out.println("condition not match");
            }

        }


    }

    public void selectactionassigneenamelessimportant() throws InterruptedException {

        JavascriptExecutor excecuteactionassiggnee = (JavascriptExecutor) driver;
        excecuteactionassiggnee.executeScript("arguments[0].click();", actionassignee);
        int assgineecount = actionlistofassgineelessimportant.size();
        String expectedassgine = propertyfile.getString("assginee1");
        for (int i = 1; i <= assgineecount; i++)
        {
            try {
                Thread.sleep(200);
                WebElement assignelement = driver.findElement(By.xpath("//div[@class='dropdown-content upside right ng-scope show']/ul/li[" + i + "]/a"));
                String atalassginename = assignelement.getText();
                //System.out.println("assginee name ="+atalassginename);
                if (atalassginename.equals(expectedassgine))
                {
                    assignelement.click();
                    break;
                }
            } catch (Exception r) {
                System.out.println("condition not match");
            }

        }


    }


}
