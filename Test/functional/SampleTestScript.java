package functional;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import functional.landingpagetest.SelectCompanyTest;
import functional.login.TestcaseLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.dayplanpage.DyplnMveActionElement;
import utilities.failTestScreenShots;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import static functional.dayplantest.DayPlanAddactionTest.overviewelement;
import static functional.login.TestcaseLogin.driver;
import static utilities.TakeScreenshot.takeScreenshot;

public class SampleTestScript {

    DyplnMveActionElement dayplanelements = new DyplnMveActionElement(driver);
    // public static Reportsextend extend = new Reportsextend();
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    private String date = "12";
    public String disablecount;
    private String today;
    ExtentTest logger;


    @Test
    public void dayPlanMovectionTest(ITestResult result) throws InterruptedException, IOException {

        htmlReporter = new ExtentHtmlReporter("C:\\Users\\Admin\\IdeaProjects\\Project\\Extent-Reports/report.html");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
        extent.setSystemInfo("Environment", "Automation Testing");
        extent.setSystemInfo("User Name", "Rajkumar SM");

        htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
        htmlReporter.config().setReportName("Name of the Report Comes here");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        logger = extent.createTest("passTest");

        TestcaseLogin logintest = new TestcaseLogin();    //login test object created

        logintest.validlogintest();

        //test.log(LogStatus.INFO,"User  login successfully");

        SelectCompanyTest selectcompy = new SelectCompanyTest();    // //select company object created

        selectcompy.selectcompanuydropdown();


        logger.log(Status.PASS, "Company select" + logger.addScreenCaptureFromPath(takeScreenshot(driver)));
        //test.log(LogStatus.INFO,"Company select successfully");

        DashboardPagElement dashboardpage = new DashboardPagElement(driver);      //dashboard page element object created

        dashboardpage.lnkDayPlan();

        logger.log(Status.PASS, MarkupHelper.createLabel("successfully click  on day plan", ExtentColor.GREEN));

        //test.log(LogStatus.INFO,"Successefully click on day plan link");

       dayplanelements.clickMyAction();
        Thread.sleep(200);
        dayplanelements.dueAtionAddCritcal();
        dayplanelements.enterActiontitle();
        WebElement duedate = driver.findElement(By.xpath("//li[@class='projectActionListItem addActionItem']/div[2]/span[button[@title='DUE DATE']]"));


        // dayplanelements.selectduedate();

        today = getCurrentDay();
        System.out.println("today date is =" + today);
        duedate.click();
        System.out.println("date click  on successfully");
        Thread.sleep(200);
       //driver.findElement(By.xpath("//div[@class='moment-picker-container month-view open']/table/thead/tr/th[3]")).click();
        //System.out.println("successfullyclick on next month ");


        List<WebElement> findnorows = driver.findElements(By.xpath("//li[@class='projectActionListItem addActionItem']/div[2]/span/div/div/table/tbody/tr"));

        int getrows = findnorows.size();
        System.out.println("number of rows" + getrows);
        for (int i = 1; i <= getrows; i++)
        {
            for (int j = 1; j <= 7; j++)
            {
                Thread.sleep(300);
                WebElement actualnuumber = driver.findElement(By.xpath("//li[@class='projectActionListItem addActionItem']/div[2]/span/div/div/table/tbody/tr[" + i + "]/td[" + j + "]"));
                String actualdate = actualnuumber.getText();
                if (actualdate.equals(today))
                {
                  WebElement disabledate = driver.findElement(By.xpath("//div[@class='moment-picker-container month-view open']/div/table/tbody/tr[1]/td["+j+"][@class='ng-binding ng-scope disabled']"));
                    disablecount = disabledate.getText();
                    System.out.println(disablecount);
                    if(disabledate.isSelected())
                    {
                        System.out.println("is enable  run");
                        break;
                    }
                    else
                    {
                        try
                           {
                            actualnuumber.click();
                            System.out.println("click on actual date");
                           }catch (Exception re)
                                 {
                                   System.out.println("not  elemmernt not found for click");
                                 }
                    }
                }
            }
        }


        Thread.sleep(100);

        dayplanelements.selectProjectOvervw();


        Thread.sleep(400);

        overviewelement.selectActionAssigneeOvervw();


        Thread.sleep(400);

        overviewelement.btnSave();


        Thread.sleep(400);

        overviewelement.btnClosedPopup();

        extent.flush();

    }

    private String getCurrentDay()
    {
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt + "\n");

        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");

        return todayStr;
    }

         /*@Test
        public void testts() throws InterruptedException {
            logger = extent.createTest("Fail Test");
            dayplanelements.clickMyAction();
            logger.log(Status.FAIL, MarkupHelper.createLabel("CLick on my action filter", ExtentColor.BLUE));
            dayplanelements.selectProjectOvervw();


        }*/

        /*Thread.sleep(300);
        *//*WebElement critcalactioncount = driver.findElement(By.xpath("//div[@class='projectActionsWidgetContainer']/div/div[1]/div[1]/h2"));
        String getcritcaltext = critcalactioncount.getText();
        //System.out.println("important action"+getcritcaltext);
        System.out.println("display lenght"+getcritcaltext.length());
        char beforemving = getcritcaltext.charAt(11);
        System.out.println("before moving action from critcal section action count  ="+  beforemving);*//*




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





*/





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
        @AfterMethod
        public void tearDown(ITestResult result) throws IOException {

            failTestScreenShots sreenshot = new failTestScreenShots();
            sreenshot.failscreenshot(driver,result);


        }


    }


