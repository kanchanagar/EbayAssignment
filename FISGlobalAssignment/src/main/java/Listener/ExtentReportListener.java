package Listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListener {
	
	public static ExtentSparkReporter report = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;
	public static ExtentTest logInfo = null;
	
	
	public static ExtentReports setUp() throws Throwable {
		
		String reportLocation1 = System.getProperty("user.dir") + "/Reports/Cucumber_Extent_Report_"
				 + ".html";
		report = new ExtentSparkReporter(reportLocation1);
		report.config().setDocumentTitle("Automation Report");
		report.config().setReportName("Automation Report");
		System.out.println("Extent Report location Initialised");

		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Application", "Ebay");
		extent.setSystemInfo("Machine", "macbook" + "64 Bit");


		System.out.println("System Information set in Extent Report");
		return extent;
	}

}
