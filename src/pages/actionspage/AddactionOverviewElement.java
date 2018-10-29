package pages.actionspage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.ResourceBundle;

public class AddactionOverviewElement
{


    WebDriver driver;
    private String today;
    public static JavascriptExecutor scriptexecutoroverview;
    ResourceBundle propertyfile = ResourceBundle.getBundle("actiondetails");
    ResourceBundle tamplofile = ResourceBundle.getBundle("tamplo5");


    public AddactionOverviewElement(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//button[@class='icon icon-ic-remove']")
    WebElement closepopup;

    @FindBy(xpath = "//div[@class='actiontool']/span[2]/tamplo-icon-select")
    WebElement  actionassignee;

    @FindBy(xpath = "//div[@class='dropdown-content upside right ng-scope show']/ul/li")
    List<WebElement>  actionlistofassginee;

    @FindBy(xpath = "//div[@class='actiontool']/span[1]/tamplo-icon-select")        //common action assignee element
    WebElement actionproject;

    @FindBy(xpath = "//div[@class='dropdown-content upside right ng-scope show']/ul/li")
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



    public void selectActionAssigneeOvervw()
    {

        /*JavascriptExecutor excecuteactionassiggnee = (JavascriptExecutor) driver;

        excecuteactionassiggnee.executeScript("arguments[0].click();", selectassginee);*/
          //        selectassginee.click();

        System.out.println("successfully click on assignee icon");

        List<WebElement> assignecount = driver.findElements(By.xpath("//section[@class='tamplo-dialogContentSection']/div[2]/div[1]/ul/li/div[3]/span[2]/tamplo-icon-select/span/div/ul/li"));

        int assgineecount = assignecount.size();
        System.out.println("list of prject"+assgineecount);
        String expectedassgine = tamplofile.getString("assigneename");
        for (int i = 1; i <= assgineecount; i++)
        {

                WebElement assignelement = driver.findElement(By.xpath("//div[@class='dropdown-content upside right ng-scope show']/ul/li[" + i + "]/a"));
                String atalassginename = assignelement.getText();
                System.out.println("assginee name ="+atalassginename);
                if (atalassginename.equals(expectedassgine))
                {
                    System.out.println(atalassginename+"=both are same = "+expectedassgine);
                    assignelement.click();
                    System.out.println("successfully click on user");
                    break;
                }
            }
        }

    public void selectproject()
    {
        JavascriptExecutor excecuteactionproject = (JavascriptExecutor)driver;
        excecuteactionproject.executeScript("arguments[0].click();", actionproject);
        int assgineecount = projectcount.size();
        String  expectedassgine=tamplofile.getString("projectname");

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

    public void selectActionAssigneeName() throws InterruptedException {

        JavascriptExecutor excecuteactionassiggnee = (JavascriptExecutor) driver;
        excecuteactionassiggnee.executeScript("arguments[0].click();", actionassignee);
        int assgineecount = actionlistofassginee.size();
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
