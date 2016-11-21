package Utilitys;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Date;

public class util {
	
	
	WebDriver driver;
	
	public static void Hover(WebDriver driver, WebElement MoveToElement){
		
		    Actions action = new Actions(driver);
		    action.moveToElement(MoveToElement).perform();
	     
	}
	
	public static void HoverAndClick(WebDriver driver,
			WebElement ElementToHover,WebElement elementToClick){
		          Actions action = new Actions(driver);
      action.moveToElement(ElementToHover).click(elementToClick).build()
		            .perform();
	
	}	
	
	public static void DragAndDrop(WebDriver driver,WebElement srcElement,WebElement dstElement)
	{
	               Actions action= new Actions(driver);
	         action.dragAndDrop(srcElement, dstElement).perform();
	}
	
	
	public static void SelectDropDown(WebDriver driver,String xpath ,String value)
	{	
	   WebElement element=driver.findElement(By.xpath(xpath));
		        Select se=new Select(element);
		          se.selectByValue(value);
	}

    	 
		public static void explicitWait(WebDriver driver,String Xpath){
			(new WebDriverWait(driver,30)).until(ExpectedConditions
					.elementToBeClickable(By.xpath(Xpath)));
			
    		 }
		
		
		public static void SwitchWindow(WebDriver driver) {
			for (String windowName : driver.getWindowHandles()) {
			      driver.switchTo().window(windowName);
			}
		}
		
		public static String captureScreenShot(WebDriver driver,String screenshotName){
				try {
				TakesScreenshot ts = (TakesScreenshot)driver;
		
   			    File sources = ts.getScreenshotAs(OutputType.FILE);
		
			    String dest= System.getProperty("user.dir")+"./ScreenShots/"+screenshotName+".png";
		        
			    File destination = new File(dest);
			   
		        FileUtils.copyFile(sources,destination );
			   
			    System.out.println("ScreenShot taken");
			   
			    return dest;   
				   } 
				
				
				catch (Exception e) 
				
				{
			
		System.out.println("Exception while taking screenshot"+e.getMessage());
				
					return e.getMessage();
				}
				
		}
		
public static void highLightElement(WebDriver driver,WebElement element)
{
JavascriptExecutor js=(JavascriptExecutor)driver; 
 
js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
 
try 
{
Thread.sleep(500);
} 
catch (InterruptedException e) {
 
System.out.println(e.getMessage());
} 
 
js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element); 
 
}
		



public static WebElement isElementPresnt(WebDriver driver,String xpath,int time)
{
 
WebElement ele = null;
 
for(int i=0;i<time;i++)
{
try{
ele=driver.findElement(By.xpath(xpath));
break;
}
catch(Exception e)
{
try 

{
Thread.sleep(1000);
} catch (InterruptedException e1) 

{
System.out.println("Waiting for element to appear on DOM");
}

}

}
return ele; 
}

public static String getCurrentDateTime()
 {
	DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	 
	 //get current date time with Date()
	 Date date = new Date();
	 
	 // Now format the date
	 String datenew= dateFormat.format(date);
	 
	 return datenew;
 }

}