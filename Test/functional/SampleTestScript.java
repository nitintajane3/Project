package functional;


import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import functional.login.LoginTst;
import functional.personaltasktest.OvrViewAddPesnalTaskTest;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.dashboardpage.DashboardPagElement;
import pages.personaltaskpage.OvrViewAddPesnalTaskElement;
import utilities.GetCurrentMonth;
import utilities.GetYear;
import utilities.NewExtendReport;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static functional.login.LoginTst.driver;
import static utilities.NewExtendReport.extent;
import static utilities.NewExtendReport.logger;
import static utilities.NewExtendReport.logger1;

public class SampleTestScript
{


    // public static Reportsextend extend = new Reportsextend();

    private int today;
    private int year;
    private String month;
    NewExtendReport addpersonaltask3 =  new NewExtendReport();
    OvrViewAddPesnalTaskElement overviewpersonaltaskelement = new OvrViewAddPesnalTaskElement(driver);
    OvrViewAddPesnalTaskElement overviewaddtaskelement = new OvrViewAddPesnalTaskElement(driver);

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

        selectChoiceDate(2022,"Dec",12);


        extent.flush();
    }


    public void selectNextWeekDueDate() throws InterruptedException
    {
        overviewpersonaltaskelement.duedate.click();
        // today=getCurrentDay();
        today=Integer.sum(getCurrentDay(),8);  // in today date we add 8 number if todays is 20 after adding it will  be 28
        // System.out.println("today date is ="+today);
        int getrows = overviewpersonaltaskelement.findnorows.size();
        //System.out.println("number of rows"+getrows);

        int  lastedate = currentMonthLastDate();  //found last date of current month like 31. 28 according to month

        try
        {
            for(int i=1;i<=getrows;i++)
            {
                for (int j = 1; j <= 7; j++)
                {
                    Thread.sleep(300);


                    try {

                        // below element find only active dates from respective month
                        WebElement actualnuumber = driver.findElement(By.xpath("//div[@class='moment-picker-container month-view open']/div/table/tbody/tr[" + i + "]/td[" + j + "][@class='ng-binding ng-scope']"));
                        String actualdate = actualnuumber.getText();

                        if (Integer.valueOf(actualdate).equals(today))
                        {
                            // if searching value from  calendar and sum of date ()like 28 is same then click
                            actualnuumber.click();
                            break;
                            //          System.out.println("click on actual date");

                        }else
                        {
                            if (today > lastedate)   //if sum of date is greather than last date then go next month
                            {                        //because added 8 value not fitted to current  month that why it take goes to  next month
                                overviewpersonaltaskelement.nextmonthdate.click();
                                for(int l=1;l<=getrows;l++)
                                {
                                    for (int k = 1; k <= 7; k++)
                                    {
                                        int differecen = today - lastedate;  //pointer goes to next month this differece find date which we have to click
                                        System.out.println("Integer.compare(today,lastedate) " + differecen );

                                        try
                                        {
                                            //then again searching date in next month
                                            WebElement actualnuumber2 = driver.findElement(By.xpath("//div[@class='moment-picker-container month-view open']/div/table/tbody/tr["+l+"]/td["+k+"][@class='ng-binding ng-scope']"));
                                            String actualdate2 = actualnuumber2.getText();

                                            if (Integer.valueOf(actualdate2).equals(differecen))
                                            {
                                                actualnuumber2.click();
                                                break;
                                            }else
                                            {
                                                System.out.println("In next month date not found");
                                            }
                                        }catch (Exception oirtkj)
                                        {
                                            System.out.println("does not match");
                                        }
                                    }
                                }
                            }else
                            {
                                System.out.println("today dtae not greather than actual date");
                            }

                        }

                    } catch (Exception disablenumberfond) {
                        System.out.println("found disable number");
                    }

                }
            }
        }catch (Exception e)
        {
            System.out.println("Date does  not found");
        }
    }

    public void selectChoiceDate(int choiceyear,String choicemonth, int choicedate) throws InterruptedException
    {
        //do not run for current today date it will  continueously execution mode
        overviewpersonaltaskelement.duedate.click();
        String gettextmonth =null;
        today = getCurrentDay();
        month = getCurrentMonth();
        year = getCurrentYear();
        int getrows = overviewpersonaltaskelement.findnorows.size();
       int differenceyear = choiceyear-year ;


      for(int g= 0; g<=differenceyear; g++)
      {
          WebElement gettxtyear = driver.findElement(By.xpath("//div[@class='duedate']/span/div/table/thead/tr/th[2]"));
          int yearnumber  = GetYear.Year(gettxtyear);

          if (yearnumber == choiceyear)
          {
              for (int p = 1; p <= 3; p++)
              {
                  for (int q = 1; q <= 4; q++)
                  {
                      WebElement gettxtyear2 = driver.findElement(By.xpath("//div[@class='duedate']/span/div/table/thead/tr/th[2]"));
                      String headermonth = gettxtyear2.getText();
                      int lengthheader = headermonth.length();
                      if(lengthheader>=6)
                      {
                          WebElement gettxtyear3 = driver.findElement(By.xpath("//div[@class='duedate']/span/div/table/thead/tr/th[2]"));
                          gettextmonth = GetCurrentMonth.Month(gettxtyear3);
                          if(gettextmonth.equals(choicemonth))
                          {

                          }else {
                              for (int a = 1;a<=12;a++)
                              {


                                  driver.findElement(By.xpath("//div[@class='duedate']/span/div/table/thead/tr/th[3]")).click();
                                   String getnexttextmonth = GetCurrentMonth.Month(gettxtyear3);
                                  if(getnexttextmonth.equals(choicemonth))
                                  {
                                      gettextmonth = GetCurrentMonth.Month(gettxtyear3);
                                      break;
                                  }

                              }

                              }
                      }else
                          {
                          WebElement monthttext = driver.findElement(By.xpath("//div[@class='duedate']/span/div/div/table/tbody/tr[" + p + "]/td[" + q + "]"));
                         gettextmonth = monthttext.getText();
                         }
                         if (gettextmonth.equals(choicemonth))
                         {
                             try { driver.findElement(By.xpath("//div[@class='duedate']/span/div/div/table/tbody/tr[" + p + "]/td[" + q + "]")).click();
                             }catch (Exception output){}




                          for (int i = 1; i <= getrows; i++)
                          {
                              for (int j = 1; j <= 7; j++)
                              {
                                  Thread.sleep(300);
                                  try {
                                      // below element find only active dates from respective month
                                      WebElement actualnuumber = driver.findElement(By.xpath("//div[@class='duedate']/span/div/div/table/tbody/tr["+i+"]/td["+j+"]"));
                                      String actualdate = actualnuumber.getText(); // use this above path becauae previous found many date so its fail

                                      if (Integer.valueOf(actualdate).equals(choicedate)) {
                                          // if searching value from  calendar and sum of date ()like 28 is same then click
                                          actualnuumber.click();
                                          break;
                                          //          System.out.println("click on actual date");
                                      }
                                  } catch (Exception output) {
                                  }
                              }// column for end
                          } //rows for loop end
                      }
                  }
              }

          }
          if(year==yearnumber)
          {
              try {


                  driver.findElement(By.xpath("//div[@class='duedate']/span/div/table/thead/tr/th[2]")).click();
                  driver.findElement(By.xpath("//div[@class='duedate']/span/div/table/thead/tr/th[3]")).click();
              }catch (Exception output){}
          } else
              {
                  try {


                      driver.findElement(By.xpath("//div[@class='duedate']/span/div/table/thead/tr/th[3]")).click();
                  }catch (Exception output){}

          }

      }

    }




    public int currentMonthLastDate() throws InterruptedException
    {
        //overviewpersonaltaskelement.duedate.click();

        int lastvalue = 00;

        int getrows = overviewpersonaltaskelement.findnorows.size();

        for(int i=1;i<=getrows;i++)
        {
            for (int j = 1; j <= 7; j++)
            {
                try
                {
                    WebElement allnumber = driver.findElement(By.xpath("//div[@class='moment-picker-container month-view open']/div/table/tbody/tr[" + i + "]/td[" + j + "][@class='ng-binding ng-scope']"));
                    String lastvaluestirng = allnumber.getText();
                    lastvalue = Integer.valueOf(lastvaluestirng);
                    //System.out.println("last  value is = " + lastvalue);
                }catch (Exception outputtest){}

            }
        }
        return lastvalue;
    }

    public int getCurrentYear() throws InterruptedException {
        overviewpersonaltaskelement.duedate.click();

        WebElement getyear = driver.findElement(By.xpath("//div[@class='duedate']/span/div/table/thead/tr/th[2]"));
        int yearnumber = GetYear.Year(getyear);
        System.out.println("current year is = " + yearnumber);
        return yearnumber;
    }

    public String getCurrentMonth() throws InterruptedException
    {
        overviewpersonaltaskelement.duedate.click();
        WebElement getmonth = driver.findElement(By.xpath("//div[@class='duedate']/span/div/table/thead/tr/th[2]"));
        String monthnumber = GetCurrentMonth.Month(getmonth);
        System.out.println("current year is = " + monthnumber);
        return monthnumber;
    }

    private int getCurrentDay()
    {
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt + "\n");

        //Integer to String Conversion
        int todayStr = todayInt;
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


