package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Reportsextend {
    public static ExtentReports extend;
    public static ExtentTest test;

    public void reports(String name)
    {
        extend = new ExtentReports("Extent-Reports/"+name+"report.html", true);
        test = extend.startTest(""+name+"");

    }
}
