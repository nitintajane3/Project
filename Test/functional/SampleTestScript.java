package functional;

import com.relevantcodes.extentreports.LogStatus;
import functional.landingpagetest.SelectCompanyTest;
import functional.login.TestcaseLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.dayplanpage.DyplnMveActionElement;
import utilities.Reportsextend;

import java.io.IOException;

import static functional.login.TestcaseLogin.driver;
import static utilities.Reportsextend.test;

public class SampleTestScript {

    DyplnMveActionElement dayplanelements = new DyplnMveActionElement(driver);
    public static Reportsextend extend = new Reportsextend();


    @Test
    public void dayPlanMovectionTest() throws IOException, InterruptedException
    {

        extend.reports("Day Plan Automation Test for Moving Actions");

        TestcaseLogin logintest = new TestcaseLogin();    //login test object created

        logintest.validlogintest();

        test.log(LogStatus.INFO,"User  login successfully");

        SelectCompanyTest selectcompy = new SelectCompanyTest();    // //select company object created

        selectcompy.selectcompanuydropdown();

        test.log(LogStatus.INFO,"Company select successfully");

        DashboardPagElement dashboardpage = new DashboardPagElement(driver);      //dashboard page element object created

        dashboardpage.lnkDayPlan();

        test.log(LogStatus.INFO,"Successefully click on day plan link");

        Thread.sleep(200);

        dayplanelements.clickMyAction();
        Thread.sleep(300);
        /*WebElement critcalactioncount = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[1]/div[1]/h2"));
        String getcritcaltext = critcalactioncount.getText();
        //System.out.println("important action"+getcritcaltext);
        System.out.println("display lenght"+getcritcaltext.length());
        char beforemving = getcritcaltext.charAt(11);
        System.out.println("before moving action from critcal section action count  ="+  beforemving);*/




        WebElement dayplanactioncountcritcal = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer ng-scope']/div/div[1]/div[1]/h2"));
        String dayplansection = dayplanactioncountcritcal.getText();
        char daypplancritical  = dayplansection.charAt(11);
        System.out.println("Day plan critical section count="+daypplancritical);
        dayplanelements.moveCricalAction();
        Thread.sleep(1000);
        String dayplansectionafter = dayplanactioncountcritcal.getText();
        char daypplancriticalafter  = dayplansectionafter.charAt(11);
        System.out.println("After moving  Day plan critical section count="+daypplancriticalafter);






        Thread.sleep(600);
        WebElement dayplanactioncountimportnant = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer ng-scope']/div/div[2]/div[1]/h2"));
        String dayplansectionimportnt = dayplanactioncountimportnant.getText();
        char dayplanimportnt  = dayplansectionimportnt.charAt(12);
        System.out.println("Day plan importantg section count="+dayplanimportnt);
        dayplanelements.moveImportntAction();
        Thread.sleep(1000);
        String dayplansectionimportntafter = dayplanactioncountimportnant.getText();
        char dayplanimportntafter  = dayplansectionimportntafter.charAt(12);
        System.out.println("After moving Day plan importantg section count="+dayplanimportntafter);







        Thread.sleep(600);
        WebElement dayplanactioncountlessimportn = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer ng-scope']/div/div[3]/div[1]/h2"));
        String dayplansectionlessim = dayplanactioncountlessimportn.getText();
        char dayplanlessimnt  = dayplansectionlessim.charAt(17);
        System.out.println("Day plan less important section count="+dayplanlessimnt);
        dayplanelements.moveLessImportntAction();
        Thread.sleep(1000);
        String dayplansectionlessimafter = dayplanactioncountlessimportn.getText();
        char dayplanlessimntafter  = dayplansectionlessimafter.charAt(17);
        System.out.println("After Moving  Day plan less important section count="+dayplanlessimntafter);
        Thread.sleep(600);











        /*WebElement lessimportant = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[3]/div[1]/h2"));

        String lessimportciun = lessimportant.getText();


        char lessss = lessimportciun.charAt(17);

        System.out.println("before moving action fromless important section action count  ="+  lessss);

        //System.out.println("important action"+getcritcaltext);

        System.out.println("display lenght less important"+lessimportciun.length());*/

        //Thread.sleep(100);

        //dayplanelements.moveCricalAction();

        //Thread.sleep(1000);

       /* String aftermovingcount = critcalactioncount.getText();

        char afteremving = aftermovingcount.charAt(11);

        System.out.println("after moving action from critcal section action count  ="+  afteremving);*/




        //Assert.assertNotEquals(beforemving,afteremving ,"Action move successfully and count update ");
       /* if(beforemving!=afteremving)
        {
            System.out.println("Action move successfully and count update ");
        }else {
            System.out.println("Action moved but count not update ");
        }*/



    }

}
