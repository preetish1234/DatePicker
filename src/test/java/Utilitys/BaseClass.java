package Utilitys;





import java.io.File;

import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class BaseClass 
{
protected static ExtentReports report;
protected static ExtentTest logger;

@BeforeSuite
	

public static ExtentReports setup() {
	 try {
		     ExtentReports report;      
			// String Path = System.getProperty("user.dir")+"./ScreenShots/"+util.getCurrentDateTime()+"1.html" ;
			 
	report = new ExtentReports(System.getProperty("user.dir")+"./HtmlReport/"+util.getCurrentDateTime()+"MyOwnReport.html" , true);
			 report.addSystemInfo("HostName","Preetish")
			  .addSystemInfo("Envirment", "QA")
			  .addSystemInfo("UserName", "Preetish Kumar Mahato");
			 report.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
		             
			 return report;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	return null;
}
}