package application_Test;

import java.sql.SQLException;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.GitHubLogin_Page;




import Utilitys.ExcelDataConfig;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class  CRM{
	
	
	protected ExtentReports report;
	protected static ExtentTest logger;
	Logger log;
	WebDriver driver;
	final String user = "preetish.m004@gmail.com";
	final String pass ="mili21sep";
@BeforeMethod(alwaysRun=true)
public void Logconfig()throws ClassNotFoundException, SQLException
{
PropertyConfigurator.configure("C:\\Preetish/Shipping/log.properties");
}

@BeforeTest(alwaysRun=true)
public void BrowserEngin() throws Exception{

         try {
			
        	report = Utilitys.BaseClass.setup();
            
         
     logger = report.startTest("ApplicationTestCase");

   logger.log(LogStatus.INFO, "Browser started");
   
   
		} catch (Exception e) {
			
			e.printStackTrace();
		}
         
}  
         @Test(dataProvider="LoginData",groups="GitHub-Login",priority=1,alwaysRun=true)
         public void Login_to_gitHub(String user,String pass){
         	
         	try {
         		driver=Utilitys.BrowserFactory.startBrowser("firefox");
         		
         		logger = report.startTest("Github_Login");
         		
         		GitHubLogin_Page login= new GitHubLogin_Page(driver);
         		
         		login.Login_Method(driver, user, pass);
         		logger.log(LogStatus.INFO, "Click in username");
         		logger.log(LogStatus.PASS, "Click in password");
         		logger.log(LogStatus.PASS, "Click to LoginBottom");
         		
        
			logger.log(LogStatus.PASS, "----Login successful-----");
		
				
         	} catch (Exception e) {
         		
 		
         	}
         	
         	}      
         
         
         
         


@AfterMethod(alwaysRun=true)
public void tearDown(ITestResult result){
	
		
	try {
		if (result.getStatus()==ITestResult.FAILURE)
			
		{
		
			String screenshot_path =Utilitys.util.captureScreenShot( driver, result.getName());
            String image= logger.addScreenCapture(screenshot_path);
logger.log(LogStatus.FAIL," invalid credential "+ image +" login Unsuccessful");
		}
			
		report.endTest(logger);
		report.flush();
		driver.quit();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}


@DataProvider (name="LoginData")
public Object[][]passData() throws Exception{
ExcelDataConfig config = new ExcelDataConfig("C:\\Preetish\\Shipping\\src\\test\\java\\TestData\\GithubLogin.xlsx");
int rows = config.getRowCount(0);
Object[][] data = new Object[rows][2];
for(int i=0;i<rows;i++ )
{
	data[i][0] = config.getData(0, i, 0);
	data[i][1] = config.getData(0, i, 1);
}

return data;


	
}
}
