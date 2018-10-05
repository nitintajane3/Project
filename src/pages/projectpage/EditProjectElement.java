
package pages.projectpage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class EditProjectElement
{
    WebDriver driver;
    ResourceBundle proertiflename = ResourceBundle.getBundle("tamplo5");
    private String today;

    public EditProjectElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='navbarList']/li[7]/ul/li[1]")
    WebElement listofproject;

    @FindBy(xpath = "//div[@class='projectsPageContainer']/div[1]/div")
    List<WebElement> listofrecentproject;

    @FindBy(xpath = "//div[@class='projectsPageContainer']/div[2]/div")
    List<WebElement> listofallproject;

    @FindBy(xpath = "//div[@class='projectsPageContainer']/div/div[1]/div[1]/h2/span")
    WebElement isrecentpresent;

    @FindBy(xpath = "//div[@class='projectsPageContainer']/div[2]/div[1]/div[1]/h2/span")
    WebElement isallviewpresent;

    @FindBy(xpath = "//section[@class='projectInfoContentSection ng-scope']/div[1]/div[1]/div[1]/div[1]/h5/span")
    WebElement outsideclick;

    @FindBy(xpath = "//div[@class='projectInfoContentHeaderBookmarks']/ul/li[1]/span[2]/a/span[2]")
    WebElement clickstrtdateicon;

    @FindBy(xpath = "//div[@class='moment-picker-container month-view open']/div/table/tbody/tr")
    List<WebElement> totalrows;

    @FindBy(xpath = "//div[@class='projectInfoContentHeaderBookmarks']/ul/li[2]/span[2]/a/span[2]")
    WebElement clickenddateicon;

    @FindBy(xpath = "//div[@class='moment-picker-container month-view open']/table/thead/tr/th[3][@ng-click='view.next.set()']")
    WebElement clickclendrnextbutton;

    @FindBy(xpath = "//div[@class='projectInfoContentHeaderBookmarks']/ul/li[3]/tamplo-icon-select/span")
    WebElement clickstatusicon;

    @FindBy(xpath = "//div[@class='projectInfoContentHeaderBookmarks']/ul//a/span[3]")
    WebElement clickuploadfileicon;

    @FindBy(xpath = "//div[@class='zeroStateContainer']/p/a")
    WebElement clickchoicefileoption;

    @FindBy(xpath = "//div[@class='projectInfoContentHeaderBookmarks']/ul/li[3]/tamplo-icon-select/span/div/ul/li[2]/a")
    WebElement selectinprogressststaus;


    @FindBy(xpath = "//section[@class='tamplo-messageDialogContentSection']/form/div/input")
    WebElement inputsendfile;

    @FindBy(xpath = "//div[@class='tamplo-dialogLayout dialogAddMemberFollower ng-scope']/header/div/button")
    WebElement closeduploadwindow;

    @FindBy(xpath = "//div[@class='tamplo-messageDialogLayout ng-scope']/footer/button[1][@ng-click='createAttachment()']")
    WebElement btnuploadsuccess;

    @FindBy(xpath = "//section[@class='tamplo-dialogContentSection']/div[2]/button")
    WebElement uploadfilesecondtime;

    @FindBy(xpath = "//div[@class='userSection ng-scope']/div[1]/h5")
    WebElement labelprojectmanager;

    @FindBy(xpath = "//div[@class='userSection ng-scope']/div[2]/h5")
    WebElement labelprojectmember;

    @FindBy(xpath = "//div[@class='swal-modal']/div[2][text()='Duplicate project name.']")
    WebElement projectduplicatealert;

    public void projctDplicteAlert()
    {
        projectduplicatealert.isDisplayed();
    }

    public int activeManagerPjectCnt()
    {
        int actualmanagercnt= 00;
        String getmanagerlabel =  labelprojectmanager.getText();
        int managerlbellength = getmanagerlabel.length();

        if(managerlbellength==18)
        {
            //System.out.println("No any manager exist in this  department");
            actualmanagercnt = 00;
        }
        else
        {
            String lasttwochar = getmanagerlabel.substring(getmanagerlabel.length()-2);
            String ingnore = lasttwochar.replaceAll("-","").trim();
            actualmanagercnt = Integer.parseInt(String.valueOf(ingnore));
        }return actualmanagercnt;
    }

    public int activeMemberProjctCont()
    {
        int actualmembercnt = 00;
        String getmemberlabel =  labelprojectmember.getText();
        int memberlbellength = getmemberlabel.length();
        if(memberlbellength==17)
        {
            //System.out.println("No any manager exist in this  department");
            actualmembercnt = 00;
        }else
        {
            String memberlastchar = getmemberlabel.substring(getmemberlabel.length()-2);
            String memberigonre = memberlastchar.replaceAll("-","").trim();
            actualmembercnt = Integer.parseInt(String.valueOf(memberigonre));
        }return actualmembercnt;
    }


    public void clkUploadfileBtn()

    {
        JavascriptExecutor executor23 = (JavascriptExecutor) driver;

        executor23.executeScript("arguments[0].click();", clickuploadfileicon);

    }

    public void uploadInputFile()
    {
        JavascriptExecutor executor2 = (JavascriptExecutor)driver;
        try {
        executor2.executeScript("arguments[0].click();", clickchoicefileoption);
        }catch (Exception filebutonnotfound)
        {
            executor2.executeScript("arguments[0].click();", uploadfilesecondtime);
        }
        inputsendfile.sendKeys("D:\\Downloads\\meetig time not display correct.png");
        executor2.executeScript("arguments[0].click();", btnuploadsuccess);
        executor2.executeScript("arguments[0].click();", closeduploadwindow);

     }

    public void outSideClick() throws InterruptedException {
      Thread.sleep(1000);
        clickstrtdateicon.click();
    }

    public void selctInprogsPjectStatus()
    {
        selectinprogressststaus.click();
    }

   public void updateProjctName()
   {
       AddProjectElement addprojectpageelmnt = new AddProjectElement(driver);
       WebDriverWait wait =  new WebDriverWait(driver,10);
       wait.until(ExpectedConditions.elementToBeClickable(addprojectpageelmnt.textfieldprojectname ));
       addprojectpageelmnt.textfieldprojectname.clear();
       addprojectpageelmnt.textfieldprojectname.sendKeys(proertiflename.getString("updateprojectname"));

   }

   public void clkStatusIcon()
   {
       JavascriptExecutor execut = (JavascriptExecutor)driver;
       execut.executeScript("arguments[0].click();", clickstatusicon);
       //clickstatusicon.click();
   }

    public String clkProjectName() throws InterruptedException {

        String returnprojectname = null;

        try
        {
            Thread.sleep(1000);

            isrecentpresent.isDisplayed();

            int recentcount = listofrecentproject.size();

            for (int i = 2; i <= recentcount; i++)
            {
                WebElement nameread = driver.findElement(By.xpath("//div[@class='projectsPageContainer']/div[1]/div["+i+"]/header/h3/a"));

                String getdptname = nameread.getText();

                System.out.println("get deparmtent name  from recent view" + getdptname);

                if (proertiflename.getString("projectname").equals(getdptname))
                {
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//div[@class='projectsPageContainer']/div[1]/div["+i+"]/header/div[1]/span[2]")).click();
                    System.out.println("successfully click on all view of this  department" + getdptname);
                    returnprojectname = getdptname;
                    break;
                }
            }
           // returnprojectname = "No project found";
            //driver.findElement(By.xpath("//div[@id='drop-down-project-action-120262-2399']/ul/li[1]/a")).click();
            driver.findElement(By.xpath("//h3[@title='" + returnprojectname + "']/preceding-sibling::div[@class='itemOverflush']/span[2]/div/ul/li[1]/a[text()='EDIT']")).isDisplayed();
        }catch (Exception retu)
        {
            try
            {
                Thread.sleep(1000);

                isallviewpresent.isDisplayed();

                int allcunt = listofallproject.size();

                for (int j = 2; j <= allcunt; j++)
                {
                    WebElement allnameread = driver.findElement(By.xpath("//div[@class='projectsPageContainer']/div[2]/div["+j+"]/header/h3/a"));

                    String getallprojctname = allnameread.getText();

                    System.out.println("get deparmtent name  from recent view" + getallprojctname);

                    if (proertiflename.getString("projectname").equals(getallprojctname))
                    {
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//div[@class='projectsPageContainer']/div[2]/div["+j+"]/header/div/span[2]")).click();
                        System.out.println("successfully click on all view of this  department" + getallprojctname);
                        returnprojectname = getallprojctname;
                        break;
                    }

                }

            }catch (Exception testmail)
            {
                System.out.println("Project name not found");
                returnprojectname = "No project found";
            }

        }


return  returnprojectname;
    }

    public void selectStarteDate() throws InterruptedException
    {
        today=getCurrentDay();
        System.out.println("today date is ="+today);
        clickstrtdateicon.click();

        System.out.println("date click  on successfully");
        int getrows = totalrows.size();
        System.out.println("number of rows"+getrows);
        try {
            for (int i = 1; i <= getrows; i++) {
                for (int j = 1; j <= 7; j++) {
                    Thread.sleep(300);
                    WebElement actualnuumber = driver.findElement(By.xpath("//div[@class='moment-picker-container month-view open']/div/table/tbody/tr[" + i + "]/td[" + j + "]"));
                    String actualdate = actualnuumber.getText();
                    if (actualdate.equals(today)) {
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

    public void selectEndeDate() throws InterruptedException
    {
        today=getCurrentDay();
        System.out.println("today date is ="+today);
        clickenddateicon.click();

        clickclendrnextbutton.click();

        System.out.println("date click  on successfully");
        int getrows = totalrows.size();
        System.out.println("number of rows"+getrows);

        try {
            for (int i = 1; i <= getrows; i++) {
                for (int j = 1; j <= 7; j++) {
                    Thread.sleep(300);
                    WebElement actualnuumber = driver.findElement(By.xpath("//div[@class='moment-picker-container month-view open']/div/table/tbody/tr[" + i + "]/td[" + j + "]"));
                    String actualdate = actualnuumber.getText();
                    if (actualdate.equals(today)) {
                        actualnuumber.click();
                        System.out.println("click on actual date");
                        break;
                    }
                }
            }
        }catch (Exception exeptin)
        {
            System.out.println("not found end date");
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

}