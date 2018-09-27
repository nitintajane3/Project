package pages.departmentpage;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.ResourceBundle;

 public class DeleteDepartmentElement {
     WebDriver driver;
     ResourceBundle rb = ResourceBundle.getBundle("tamplo5");

     public DeleteDepartmentElement(WebDriver driver) {
         this.driver = driver;
         PageFactory.initElements(driver, this);
     }

     @FindBy(xpath = "//section[@class='tamplo-PageContent']/div[2]/div")
     List<WebElement> recentviewdpt;

     @FindBy(xpath = "//section[@class='tamplo-PageContent']/div[3]/div")
     List<WebElement> allviewdpt;


     @FindBy(xpath = "//section[@class='tamplo-PageContent']/div[2]/div[1]/div/h2/span")
     WebElement recentviewpresent;

     @FindBy(xpath = "//section[@class='tamplo-PageContent']/div[3]/div[1]/div/h2/span")
     WebElement allviewpresent;

     @FindBy(xpath = "//div[@class='projectInfoContentHeaderTitle']/div/span")
     WebElement menuoverflashicon;



     @FindBy(xpath = "//div[@class='dropdown-content show']/ul/li[2]/a")
     WebElement deletedpertmrrnt;

     @FindBy(xpath = "//div[@class='swal-footer']/div[2]/button")
     WebElement deleteconfombtn;

     @FindBy(xpath = "//div[@class='swal-footer']/div[1]/button")
     WebElement deletecancel;

     @FindBy(xpath = "//button[text()='OK']")
     WebElement onbutton;

     @FindBy(xpath = "//h2[@class='headingprojectPriority Critical']/span[@class='headingprojectPriorityTitle ng-binding']")
     WebElement recentviewcount;



     public int recentDptCount() throws InterruptedException {
         Thread.sleep(500);
         String recentviewreadheder = recentviewcount.getText();
         String substringdevde = recentviewreadheder.substring(recentviewreadheder.length()-2);
         String removeingspace = substringdevde.replaceAll("-","").trim();
         int recentcount = Integer.parseInt(String.valueOf(removeingspace));
         System.out.println("list of department count=" + recentcount);
         return recentcount;

     }

     public void okBtn()
     {
         JavascriptExecutor executor = (JavascriptExecutor)driver;
         executor.executeScript("arguments[0].click();", onbutton);
     }

     public void delteConfirmBtn()
     {
         JavascriptExecutor executor = (JavascriptExecutor)driver;
         executor.executeScript("arguments[0].click();", deleteconfombtn);
     }

     public void delteCancelBtn()
     {
         JavascriptExecutor executor = (JavascriptExecutor)driver;
         executor.executeScript("arguments[0].click();", deletecancel);
     }




     public void clickRemoveBtn()
     {
         deletedpertmrrnt.click();
     }


     public void clickMenuOver()
     {
         JavascriptExecutor js = (JavascriptExecutor)driver;
         js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
         menuoverflashicon.click();
     }


     public void clickEditButton()
     {
         int recentcount = recentviewdpt.size();
         int allviewcount = allviewdpt.size();
         System.out.println("recent view department cont  =" + recentcount);
         System.out.println("all view deparmnt count =" + allviewcount);


             if(driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[2]/div[1]/div/h2/span")).isDisplayed())
             {
             for (int i = 2; i <= recentcount; i++)
             {

                 WebElement nameread = driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[2]/div[" + i + "]/header/div/h3/a"));

                 String getdptname = nameread.getText();

                 System.out.println("get deparmtent name  from recent view" + getdptname);

                 if (rb.getString("dptname").equals(getdptname))
                 {
                     driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[2]/div[" + i + "]/header/div/h3/a")).click();
                     System.out.println("successfully click on all view of this  department" + getdptname);
                 }
             }
         } else  {
             System.out.println("not  found  searching dpeartment");
             if (driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[3]/div[1]/div/h2/span")).isDisplayed()) {
                 for (int j = 2; j <= allviewcount; j++) {

                     WebElement nameread2 = driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[3]/div[" + j + "]/header/div/h3/a"));

                     String getdptname1 = nameread2.getText();

                     System.out.println("get deparmtent name  from all view" + getdptname1);

                     if (rb.getString("dptname").equals(getdptname1)) {
                         driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[3]/div[" + j + "]/header/div/h3/a")).click();
                         System.out.println("successfully click on all view of this  department" + getdptname1);
                         break;

                     }
                 }
             } else {
                 System.out.println("not found project");
             }
         }

     }

     public void recentView()
     {


         try
         {
             int recentcount = recentviewdpt.size();
          driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[2]/div[1]/div/h2/span")).isDisplayed();
             for (int i = 2; i <= recentcount; i++)
             {
                 WebElement nameread = driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[2]/div[" + i + "]/header/div/h3/a"));

                 String getdptname = nameread.getText();

                 System.out.println("get deparmtent name  from recent view" + getdptname);

                 if (rb.getString("dptname").equals(getdptname))
                 {
                     driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[2]/div[" + i + "]/header/div/h3/a")).click();
                     System.out.println("successfully click on all view of this  department" + getdptname);
                     break;
                 }
             }
         }catch (Exception retu)
         {
             System.out.println("In recent view department not  found");
         }
     }


     public String dptSelectNdOpenDetails() {


         String getdptname = null;
         try {
             int recentcount = recentviewdpt.size();
             driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[2]/div[1]/div/h2/span")).isDisplayed();
             for (int i = 2; i <= recentcount; i++) {
                 WebElement nameread = driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[2]/div[" + i + "]/header/div/h3/a"));

                 getdptname = nameread.getText();

                 System.out.println("get deparmtent name  from recent view" + getdptname);

                 if (rb.getString("dptname").equals(getdptname)) {
                     driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[2]/div[" + i + "]/header/div/h3/a")).click();
                     System.out.println("successfully click on all view of this  department" + getdptname);
                     break;
                 }
             }
         } catch (Exception retu) {
             System.out.println("In recent view department not  found");
         }
         return getdptname;
     }


     public void allView()
     {

         try {
             driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[3]/div[1]/div/h2/span")).isDisplayed();
             int allviewcount = allviewdpt.size();
             for (int j = 2; j <= allviewcount; j++)
                 {

                     WebElement nameread2 = driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[3]/div[" + j + "]/header/div/h3/a"));

                     String getdptname1 = nameread2.getText();

                     System.out.println("get deparmtent name  from all view" + getdptname1);

                     if (rb.getString("dptname").equals(getdptname1))
                     {
                         driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[3]/div[" + j + "]/header/div/h3/a")).click();
                         System.out.println("successfully click on all view of this  department" + getdptname1);
                         break;

                     }
                 }
             }               catch (Exception resu){ System.out.println("In All view department not  found");
             }

     }
 }



        /*{
            driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[3]/div[1]/div/h2/span")).isDisplayed();

            for (int i = 2; i <= allviewcount; i++)
            {

                WebElement nameread = driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[3]/div[" + i + "]/header/div/h3/a"));

                String getdptname1 = nameread.getText();

                System.out.println("get deparmtent name  from all view"+getdptname1);

                if(rb.getString("dptname").equals(getdptname1))
                {
                    driver.findElement(By.xpath("//section[@class='tamplo-PageContent']/div[3]/div[" + i + "]/header/div/h3/a")).click();
                    System.out.println("successfully click on all view of this  department"+    getdptname1);
                    break;
                }
            }
        }*/




