package functional;


import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.personaltaskpage.OvrViewAddPesnalTaskElement;
import utilities.NewExtendReport;

import java.io.FileInputStream;
import java.io.IOException;

import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.*;
import static utilities.SelectDate.selectChoiceDate;

public class SampleTestScript
{


    // public static Reportsextend extend = new Reportsextend();

    NewExtendReport addpersonaltask3 =  new NewExtendReport();
    static OvrViewAddPesnalTaskElement overviewpersonaltaskelement = new OvrViewAddPesnalTaskElement(driver);
    static OvrViewAddPesnalTaskElement overviewaddtaskelement = new OvrViewAddPesnalTaskElement(driver);

    @BeforeTest
    public void loginTest() throws InterruptedException
    {

        addpersonaltask3.newReport("Add personal task from overview test","add_personal_Task_from_oveview_test_report");
        logger =  extent.createTest("Login Test ");
        LoginTst logintest = new LoginTst();
        logintest.loginTestNew();
        logger.log(Status.PASS, MarkupHelper.createLabel("User login  successfully", ExtentColor.GREEN));
        logger.log(Status.PASS, MarkupHelper.createLabel("Company select successfully", ExtentColor.GREEN));
        extent.flush();
    }
    @Test(priority = 1)
    public void linkPersonalTask() throws InterruptedException {
        logger1 =  extent.createTest("Open personal task  module test");

        DashboardPagElement dashboardpage = new DashboardPagElement(driver);      //dashboard page element object created

        dashboardpage.linkPersonalTask();

        logger1.log(Status.PASS, MarkupHelper.createLabel("Successfully link to personal task", ExtentColor.GREEN));

        overviewaddtaskelement.clkOverView();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[1]/div[@id='criticalContainer']/div[1]/div[2]/button[text()='ADD AN ACTION']")).click();

        Thread.sleep(500);

        selectChoiceDate(2018,"Dec",12,driver);


        extent.flush();
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
        /*@AfterMethod
        public void tearDown(ITestResult result) throws IOException {

            failTestScreenShots sreenshot = new failTestScreenShots();
            sreenshot.failscreenshot(driver,result);


        }*/


    @DataProvider

    public Object[][] membrdata() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("files/projectentrydata.xls");//copy path of Exelsheet here

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream); //create object for workbook

        HSSFSheet worksheet = workbook.getSheet("Member"); // get the proper sheet from exel

        int rowcount = worksheet.getPhysicalNumberOfRows();

        System.out.println("total number of row present = " +rowcount);

        String[][] data = new String[rowcount-1][1];
        for (int i =1; i < rowcount; i++) {
            HSSFRow row = worksheet.getRow(i);

            HSSFCell projectname = row.getCell(0);

            if (projectname == null)
                data[i-1][0] = "";
            else {
                projectname.setCellType(CellType.STRING);// to convert numbers into string we use setCell type
                data[i-1][0] = projectname.getStringCellValue();
            }
        }

        return data;
    }

    }


