package pages.departmentpage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.ResourceBundle;

public class DeptUserActiveDeactiveElement
{
    WebDriver  driver;
    ResourceBundle rb = ResourceBundle.getBundle("tamplo5");
  public DeptUserActiveDeactiveElement(WebDriver driver)
  {
      this.driver = driver;
      PageFactory.initElements(driver,this);
  }

  @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[1]/h5")
    WebElement activatemanagercount;

  @FindBy(xpath = "//section[@class='projectInfoContentSection']/div/div/div[2]/h5")
  WebElement activemembercount;

  @FindBy(xpath = "//div[@class='filterActions']/ul/li[2]/a/span[2]")
  WebElement inactiveuser;

  @FindBy(xpath = "//div[@class='filterActions']/ul/li[1]/a/span[2]")
  WebElement activateuser;

  @FindBy(xpath = "//div[@class='userSection']/div[1]/ul/li/div[2]/span")
  List<WebElement> listofusername;

  @FindBy(xpath = "//div[@class='userSection']/div[1]/ul/li/div[4]/button")
  List<WebElement> listofeditbutton;

    @FindBy(xpath = "//div[@class='userSection']/div[2]/ul/li/div[2]/span")
    List<WebElement> listofmembername;

  @FindBy(xpath = "//div[@class='actiontool ng-scope']/span[2]")
  WebElement threedotclick;

  @FindBy(xpath = "//li[@class='projectActionListItem ng-scope']/div[2]/span")
  List<WebElement> listofuserindpt;


  public void filteerActiveUser()
  {
      JavascriptExecutor executor = (JavascriptExecutor)driver;
      executor.executeScript("arguments[0].click();", activateuser);

  }

  public void filterDeactivateUser()
  {
      JavascriptExecutor executor = (JavascriptExecutor)driver;
      executor.executeScript("arguments[0].click();", inactiveuser);
  }

  public int activeManagerDptcnt()
  {
      int actualmanagercnt= 00;
      String managerlabel =  activatemanagercount.getText();
     int managerlbellength = managerlabel.length();

     if(managerlbellength==18)
     {
      //System.out.println("No any manager exist in this  department");
      actualmanagercnt = 00;
            }
     else
         {
         String lasttwochar = managerlabel.substring(managerlabel.length()-2);
         String ingnore = lasttwochar.replaceAll("-","").trim();
         actualmanagercnt = Integer.parseInt(String.valueOf(ingnore));
     }return actualmanagercnt;
  }

  public int activeMemberDptCont()
  {
      int actualmembercnt = 00;
      String memberlabel =  activemembercount.getText();
      int memberlbellength = memberlabel.length();
      if(memberlbellength==17)
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

    public int deActiveManagerDptcnt()
    {
        int deactiveactualmanagercnt= 00;
        String deactivemanagerlabel =  activatemanagercount.getText();
        int deactivemanagerlbellength = deactivemanagerlabel.length();

        if(deactivemanagerlbellength==18)
        {
            //System.out.println("No any manager exist in this  department");
            deactiveactualmanagercnt = 00;
        }
        else
        {
            String deactivelasttwochar = deactivemanagerlabel.substring(deactivemanagerlabel.length()-2);
            String deactiveingnore = deactivelasttwochar.replaceAll("-","").trim();
            deactiveactualmanagercnt = Integer.parseInt(String.valueOf(deactiveingnore));
        }return deactiveactualmanagercnt;
    }

    public int deActiveMemberDptCont()
    {
        int deactiveactualmembercnt = 00;
        String deactivememberlabel =  activemembercount.getText();
        int dememberlbellength = deactivememberlabel.length();
        if(dememberlbellength==17)
        {
            //System.out.println("No any manager exist in this  department");
            deactiveactualmembercnt = 00;
        }else
        {
            String dememberlastchar = deactivememberlabel.substring(deactivememberlabel.length()-2);
            String dememberigonre = dememberlastchar.replaceAll("-","").trim();
            deactiveactualmembercnt = Integer.parseInt(String.valueOf(dememberigonre));
        }return deactiveactualmembercnt;
    }

    public String managerEditButton() throws InterruptedException {
        int usermanagernum = activeManagerDptcnt();
        String returnusername = null;
        if(usermanagernum!=0)
        {
          int countusername =  listofusername.size();

          for(int i=1;i<=countusername;i++)
          {
            WebElement getusrname = driver.findElement(By.xpath("//div[@class='userSection']/div[1]/ul/li["+i+"]/div[2]/span"));
            String readusername = getusrname.getText();
            if(readusername.equals(rb.getString("removeusername")))
            {
                Thread.sleep(500);
                driver.findElement(By.xpath("//div[@class='userSection']/div[1]/ul/li["+i+"]/div[4]/button")).click();
                returnusername = readusername;
                break;
            }
          }

        }else
        {
            System.out.println("No User present in Department manager level");
            returnusername = "No User present in Department manager level";
        }


       return returnusername;
    }


    public String memberEditButton() throws InterruptedException {
        int usermembernum = activeMemberDptCont();
        String returnmembername = null;
        if(usermembernum!=0)
        {
            int countmembername =  listofmembername.size();

            for(int i=1;i<=countmembername;i++)
            {
                WebElement getmembername = driver.findElement(By.xpath("//div[@class='userSection']/div[2]/ul/li["+i+"]/div[2]/span"));
                String readmembername = getmembername.getText();
                if(readmembername.equals(rb.getString("removemembername")))
                {
                    Thread.sleep(500);
                    driver.findElement(By.xpath("//div[@class='userSection']/div[2]/ul/li["+i+"]/div[4]/button")).click();
                    returnmembername = readmembername;
                    break;
                }
            }

        }else
        {
            System.out.println("No User present in Department member level");
            returnmembername = "No User present in Department member level";
        }


        return returnmembername;
    }

    public void selectRemoveOption()
    {

            WebDriverWait waitest = new WebDriverWait(driver,3);
            waitest.until(ExpectedConditions.elementToBeClickable(threedotclick));
            threedotclick.click();
            driver.findElement(By.xpath("//div[@class='actiontool ng-scope']/span[2]/div/ul/li[1]/a")).click();


    }

    public void removeButton()
    {
        driver.findElement(By.xpath("//div[@class='actiontool ng-scope']/span[2]/div/ul/li[1]/a")).click();
    }

    public void selectDeactivateOption()
    {
        WebDriverWait waitest = new WebDriverWait(driver,3);
        waitest.until(ExpectedConditions.elementToBeClickable(threedotclick));
        threedotclick.click();
        driver.findElement(By.xpath("//div[@class='actiontool ng-scope']/span[2]/div/ul/li[2]/a")).click();
    }


    public String searchNameAndRemve() throws InterruptedException {
        int usermanagernum = activeManagerDptcnt();
        String returnusername = null;
       try {
            int countusername =  listofusername.size();

            for(int i=1;i<=countusername;i++)
            {
                WebElement getusrname = driver.findElement(By.xpath("//div[@class='userSection']/div[1]/ul/li["+i+"]/div[2]/span"));
                String readusername = getusrname.getText();
                if(readusername.equals(rb.getString("removeusername")))
                {
                    Thread.sleep(500);
                    driver.findElement(By.xpath("//div[@class='userSection']/div[1]/ul/li["+i+"]/div[4]/button")).click();
                    returnusername = readusername;
                    break;
                }
            }

            driver.findElement(By.xpath("//div[@class='actiontool ng-scope']/span[2]")).click();


        }catch (Exception userlistout)
        {
            int usermembernum = activeMemberDptCont();

            if(usermembernum!=0)
            {
                int countmembername =  listofmembername.size();

                for(int i=1;i<=countmembername;i++)
                {
                    WebElement getmembername = driver.findElement(By.xpath("//div[@class='userSection']/div[2]/ul/li["+i+"]/div[2]/span"));
                    String readmembername = getmembername.getText();
                    if(readmembername.equals(rb.getString("removeusername")))
                    {
                        Thread.sleep(500);
                        driver.findElement(By.xpath("//div[@class='userSection']/div[2]/ul/li["+i+"]/div[4]/button")).click();
                        returnusername = readmembername;
                        driver.findElement(By.xpath("//div[@class='actiontool ng-scope']/span[2]")).click();
                        break;
                    }
                }

            }else
            {
                System.out.println("No User present in Department member level");
                returnusername = "Selected user not present in department";
            }
        }


        return returnusername;
    }
}
