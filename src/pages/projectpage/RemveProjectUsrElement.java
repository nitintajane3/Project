package pages.projectpage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.ResourceBundle;

public class RemveProjectUsrElement
{
    WebDriver driver;
    ResourceBundle proertiflename = ResourceBundle.getBundle("tamplo5");

    public RemveProjectUsrElement(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div/div[1]/ul/li/div[2]/span")
    List<WebElement> listofusername;

    @FindBy(xpath = "//div[@class='projectActionsWidgetContainer']/div/div/div[2]/ul/li/div[2]/span")
    List<WebElement> listofactivemembercount;

    @FindBy(xpath = "//div[@class='userSection ng-scope']/div[2]/h5")
    WebElement activemembercount;

    @FindBy(xpath = "//span[@class='userRemove ng-scope']/button[@class='icon icon-ic-remove']")
    WebElement remvebutton;

    @FindBy(xpath = "//div[@class='actiontool ng-scope']/span[1]/tamplo-icon-select/span")
    WebElement usericonbutton;

    @FindBy(xpath = "//div[@class='actiontool ng-scope']/span[1]/tamplo-icon-select/span/div/ul/li/a")
    WebElement usermoveoption;

    @FindBy(xpath = "//div[@class='actiontool ng-scope']/span[1]/tamplo-icon-select/span/div/ul")
    WebElement clkremovebutton;

    @FindBy(xpath = "//div[@class='projectsPageContainer']/div/div[1]/div[1]/h2/span")
    WebElement isrecentpresent;

    @FindBy(xpath = "//div[@class='projectsPageContainer']/div[1]/div")
    List<WebElement> listofrecentproject;

    @FindBy(xpath = "//div[@class='projectsPageContainer']/div[2]/div[1]/div[1]/h2/span")
    WebElement isallviewpresent;

    @FindBy(xpath = "//div[@class='projectsPageContainer']/div[2]/div")
    List<WebElement> listofallproject;

    @FindBy(xpath = "//li[@class='iconlistItem ng-scope']/span[text()='TEAM MEMBERS - ']/following-sibling::a/span[1]")
    WebElement clickonteammember;

    @FindBy(xpath = "//div[@class='userSection ng-scope']/div[1]/ul[@class='projectActionsList']/li/div[4]/button")
    public WebElement manageredtbutton;



    public void clkOnTeamMemberlist()
    {
        JavascriptExecutor excetuejava = (JavascriptExecutor)driver;
        excetuejava.executeScript("arguments[0].click()",clickonteammember);
    }

    public String UserMoveOptionSelct() {

        String optionreadtext = usermoveoption.getText();
        clkremovebutton.click();
        return optionreadtext;
    }

    public void clkUserIconBtn()
    {
        JavascriptExecutor excetuejava = (JavascriptExecutor)driver;
        excetuejava.executeScript("arguments[0].click()",usericonbutton);

    }

    public String memberEditButton() throws InterruptedException {
        int usermembernum = activeMemberDptCont();
        String returnmembername = null;
        if(usermembernum!=0)
        {
            int countmembername =  listofactivemembercount.size();

            for(int i=1;i<=countmembername;i++)
            {
                WebElement getmembername = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div/div[2]/ul/li["+i+"]/div[2]/span"));
                String readmembername = getmembername.getText();
                if(readmembername.equals(proertiflename.getString("removemembername")))
                {
                    Thread.sleep(500);
                    driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div/div[2]/ul/li["+i+"]/div[4]/button")).click();
                    returnmembername = readmembername;
                    break;
                }
                returnmembername = "No User present in Department member level";
            }

        }else
        {
            System.out.println("No User present in Department member level");
            returnmembername = "No User present in Department member level";
        }


        return returnmembername;
    }


    public void remveUserButton()
    {
        remvebutton.click();
    }

    public int activeMemberDptCont()
    {
        int actualmembercnt = 00;
        String memberlabel =  activemembercount.getText();
        int memberlbellength = memberlabel.length();
        if(memberlbellength<=17)
        {
            //System.out.println("No any manager exist in this  department");
            actualmembercnt = 00;
        }else
        {
            String memberlastchar = memberlabel.substring(memberlabel.length()-2);
            String memberigonre = memberlastchar.replaceAll("-","").trim();
            actualmembercnt = Integer.parseInt(String.valueOf(memberigonre));
        }return actualmembercnt;
    }

    public String searchNameAndEditBtn() throws InterruptedException {
        String returnusername = null;
        try {
            int countusername =  listofusername.size();

            for(int i=1;i<=countusername;i++)
            {
                WebElement getusrname = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div/div[1]/ul/li["+i+"]/div[2]/span"));
                String readusername = getusrname.getText();
                if(readusername.equals(proertiflename.getString("removeusername")))
                {
                    Thread.sleep(500);
                    driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div/div[1]/ul/li["+i+"]/div[4]/button")).click();
                    returnusername = readusername  + " This user found in manager level";
                    break;
                }
                returnusername = readusername +" This user found in manager level";
            }
            driver.findElement(By.xpath("//div[@class='actiontool ng-scope']/span[2]/button[@class='icon icon-ic-remove']")).isDisplayed();

        }catch (Exception userlistout)
        {
            int usermembernum = activeMemberDptCont();

            if(usermembernum!=0)
            {
                int countmembername =  listofactivemembercount.size();

                for(int j=1;j<=countmembername;j++)
                {
                    WebElement getmembername = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div/div[2]/ul/li["+j+"]/div[2]/span"));
                    String readmembername = getmembername.getText();
                    if(readmembername.equals(proertiflename.getString("removeusername")))
                    {
                        Thread.sleep(500);
                        driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div/div[2]/ul/li["+j+"]/div[4]/button")).click();
                        returnusername = readmembername  + " This user found in member level";
                        break;
                    }

                    returnusername = readmembername + " This user found in member level";
                }

            }else
            {
                System.out.println("No User present in Department member level");
                returnusername = "Selected user not present in department";
            }
        }

        return returnusername;
    }

    public String clkProjectName() throws InterruptedException {

        String returnprojectname = null;

        try {
            Thread.sleep(1000);

            isrecentpresent.isDisplayed();

            int recentcount = listofrecentproject.size();

            for (int i = 2; i <= recentcount; i++) {
                WebElement nameread = driver.findElement(By.xpath("//div[@class='projectsPageContainer']/div[1]/div[" + i + "]/header/h3/a"));

                String getdptname = nameread.getText();

                System.out.println("get deparmtent name  from recent view" + getdptname);

                if (proertiflename.getString("projectname").equals(getdptname)) {
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//div[@class='projectsPageContainer']/div[1]/div[" + i + "]/header/h3/a")).click();
                    System.out.println("successfully click on all view of this  department" + getdptname);
                    returnprojectname = getdptname;
                    break;
                }
            }
            Thread.sleep(700);
           driver.findElement(By.xpath("//li[@class='iconlistItem ng-scope']/span[text()='TEAM MEMBERS - ']/following-sibling::a/span[1]")).isDisplayed();
            System.out.println("project name is = " + returnprojectname);
        } catch (Exception retu) {

            try {
                Thread.sleep(1000);

                isallviewpresent.isDisplayed();

                int allcunt = listofallproject.size();

                for (int j = 2; j <= allcunt; j++) {
                    WebElement allnameread = driver.findElement(By.xpath("//div[@class='projectsPageContainer']/div[2]/div[" + j + "]/header/h3/a"));

                    String getallprojctname = allnameread.getText();

                    System.out.println("get deparmtent name  from recent view" + getallprojctname);

                    if (proertiflename.getString("projectname").equals(getallprojctname)) {
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//div[@class='projectsPageContainer']/div[2]/div[" + j + "]/header/h3/a")).click();
                        System.out.println("successfully click on all view of this  department" + getallprojctname);
                        returnprojectname = getallprojctname;
                        break;
                    }

                }

            } catch (Exception testmail) {
                System.out.println("Project name not found");
                returnprojectname = "No project found";
            }

        }
            return returnprojectname;
        }

}
