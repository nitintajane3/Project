package pages.projectpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.ResourceBundle;

public class AddProjectElement {


    WebDriver driver;

    ResourceBundle properties = ResourceBundle.getBundle("Departmentame");

    public AddProjectElement(WebDriver driver)
    {
       this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@href='#!/project/createProject']/button[@class='btn small btn-primary ng-binding']")
    WebElement firsttimeprojectcreate;

    @FindBy(xpath = "//a[@href='#!/project/createProject']/button[@class='icon large icon-ic-add']")
    WebElement projectcreatesecond;

    @FindBy(xpath = "//label[@class='navbarItemLabel ng-binding']")
    WebElement depaartmentnamelabel;

    @FindBy(xpath = "//a[@class='dropbtn option ng-binding ng-scope'][text()='SELECT DEPARTMENT']")
    WebElement departmentdropdown;

    @FindBy(xpath = "//div[@class='dropdown-content ng-scope show']/ul/li")
    WebElement departmentlist;

   @FindBy(xpath = "//a[@class='dropbtn option ng-binding ng-scope']/span")
    WebElement dptdropdownicon;

   @FindBy(xpath = "//input[@name='projectName'][@placeholder='GIVE YOUR PROJECT A NAME']")
   WebElement textfieldprojectname;

   @FindBy(xpath = "//div[@class='projectsPageContainer zeroState ng-scope']")
   WebElement emptyspace;

   @FindBy(xpath = "//button[text()='OK']")
   WebElement duplicatealertokbutton;

   @FindBy(xpath = "//button[text()='ADD PROJECT MANAGER']")
   WebElement buttonprojectmanager;

   @FindBy(xpath = "//input[@id='userQuery'][@placeholder='ADD PEOPLE']")
   WebElement addpeople;

   @FindBy(xpath = "//button[@class='btn verysmall btn-primary ng-binding ng-scope'][text()='Save']")
   WebElement savebutton;

   @FindBy(xpath = "//button[text()='ADD PROJECT MEMBER']")
   WebElement buttonprojectmember;

    public void createproject() throws InterruptedException {
        try {

            projectcreatesecond.isDisplayed();
            projectcreatesecond.click();

        }catch (Exception e3)
        {

            firsttimeprojectcreate.isDisplayed();
            firsttimeprojectcreate.click();

        }


    }

    public void clickdropdowndpticon()
    {
        dptdropdownicon.click();
    }

    public void selectdptname() throws InterruptedException
    {
        try
        {
            depaartmentnamelabel.isDisplayed();


        }catch (Exception e)
        {
            departmentdropdown.click();
            List<WebElement> countdpt = driver.findElements(By.xpath("//div[@class='dropdown-content ng-scope show']/ul/li"));
            String  expectdptname=properties.getString("name");
            int actualcountdpt = countdpt.size();
            System.out.println(actualcountdpt);
            for(int i=1;i<=actualcountdpt;i++)
            {
                Thread.sleep(200);
                try {
                    WebElement getnamedept = driver.findElement(By.xpath("//div[@class='dropdown-content ng-scope show']/ul/li[" + i + "]"));
                    String actualdptname = getnamedept.getText();


                    System.out.println("Department name is =" + actualdptname);


                if (actualdptname.equals(expectdptname))
                {
                    driver.findElement(By.xpath("//div[@class='dropdown-content ng-scope show']/ul/li[" + i + "]/a")).click();

                }
                }catch (Exception e1)
                {
                    System.out.println("condition not match");
                }

            }






        }
    }

    public void enterprojectname()
    {
        textfieldprojectname.sendKeys(properties.getString("projectname"));
    }

    public void clickemptyspace()
    {
        emptyspace.click();
    }

    public void clickOKbuttonduplicate()
    {
        duplicatealertokbutton.click();
    }

    public void clickaddprojectmanager()
    {
        buttonprojectmanager.click();
    }

    public void entertextAddpeople()
    {
        addpeople.sendKeys(properties.getString("email2"));
    }

    public void clicksavebutton()
    {
        savebutton.click();
    }

    public void clickbuttonprojectmember()
    {
        buttonprojectmember.click();
    }

    public void entertextaddpeople2()
    {
        addpeople.sendKeys(properties.getString("email3"));
    }


}
