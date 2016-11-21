package page;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class GitHubLogin_Page {
	protected ExtentReports report;
	protected static ExtentTest logger;
    WebDriver driver;
	
	
	public GitHubLogin_Page(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='login_field']")
	WebElement username;
	@FindBy(how=How.XPATH,using=".//*[@id='password']")
	WebElement password;
	@FindBy(how=How.XPATH,using=".//*[@id='login']/form/div[4]/input[3]")
	WebElement click;
	
	

public void Login_Method(WebDriver driver , String user , String pass){
	
	try {
		username.click();
		username.sendKeys(user);
		String userid = "preetish.m004@gmail.com";
		Assert.assertEquals("invalid user", userid, user);
   
		
		password.click();
		password.sendKeys(pass);
		String pass1 = "mili21sep";
		Assert.assertEquals("invalid user",pass1,pass);
   
		
		click.click();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
    
}
	
}
