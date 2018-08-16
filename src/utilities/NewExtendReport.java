package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class NewExtendReport
{
    ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;


    public void newReport(String reportname,String testname)
    {
        htmlReporter = new ExtentHtmlReporter("C:\\Users\\Admin\\IdeaProjects\\Project\\Extent-Reports/Extendreportew.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Tamplo.com");
        extent.setSystemInfo("Environment", "Automation Testing");
        extent.setSystemInfo("Test By", "Nitin Tajane");

        htmlReporter.config().setDocumentTitle("Tamplo automation script");
        htmlReporter.config().setReportName(reportname);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        logger = extent.createTest(testname);


    }
}
