package pages.actionspage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.ResourceBundle;

public class AddActionslistViewElement

{

    WebDriver driver;
    ResourceBundle proptiesdeprtment = ResourceBundle.getBundle("Departmentame");
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

    @FindBy(xpath = "//div[@class='actiontool']/span[1]")        //common action assignee element
    WebElement actionproject;

    @FindBy(xpath = "//div[@class='actiontool']/span[2]")
    WebElement  actionassignee;

    @FindBy(xpath = "//div[@class='dropdown-content ng-scope show']/ul/li")
    List<WebElement> listofproject;

    @FindBy(xpath = "//div[@class='dropdown-content ng-scope show']/ul/li")
    List<WebElement>  actionlistofassginee;

    @FindBy(xpath = "//input[@type='text'][@placeholder='Enter action name here...']") //common action title element
    WebElement actionntitlename;



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
        //actionproject.click();
        int assgineecount = listofproject.size();
        String  expectedassgine=proptiesdeprtment.getString("projectname");
        for(int i=1;i<=assgineecount;i++)
        {
            try {
               Thread.sleep(200);
                WebElement assignelement = driver.findElement(By.xpath("//div[@class='dropdown-content ng-scope show']/ul/li["+i+"]/a"));
                String atalassginename = assignelement.getText();
                //System.out.println("assginee name ="+atalassginename);
                if(atalassginename.equals(expectedassgine))
                {
                    assignelement.click();
                }}catch (Exception r)
            {
                System.out.println("condition not match");
            }

        }
    }

    public void selectactionassigneename() throws InterruptedException {

        JavascriptExecutor excecuteactionassiggnee = (JavascriptExecutor) driver;
        excecuteactionassiggnee.executeScript("arguments[0].click();", actionassignee);
        //actionassignee.click();
        int assgineecount = actionlistofassginee.size();
        String expectedassgine = propertyfile.getString("assginee1");
        for (int i = 1; i <= assgineecount; i++) {
            try {
                Thread.sleep(200);
                WebElement assignelement = driver.findElement(By.xpath("//div[@class='dropdown-content ng-scope show']/ul/li[" + i + "]/a"));
                String atalassginename = assignelement.getText();
                //System.out.println("assginee name ="+atalassginename);
                if (atalassginename.equals(expectedassgine)) {
                    assignelement.click();
                }
            } catch (Exception r) {
                System.out.println("condition not match");
            }

        }


    }


}
