package com.GmailTestChrome;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;


import Utilitys.util;

public class ChromeTest {
	
	WebDriver driver;
	
	@org.testng.annotations.Test		
	public void chrome_Test(){
	
	
	try {
		
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			
		    capabilities.setCapability(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,System.setProperty("webdriver.chrome.driver", 
		    		"C:\\Users\\preetish\\Desktop\\chromedriver.exe"));
			driver= new ChromeDriver(capabilities);
			
			driver.get("https://www.google.co.in/");
			System.out.println("open browser");

			driver.findElement(By.partialLinkText("Gmail")).click();
			System.out.println("Ciick on Gmail Link");


			util.isElementPresnt(driver, "div[gh='cm']", 50);


			driver.findElement(By.cssSelector("div[gh='cm']")).click();
			WebElement element = driver.findElement(By.cssSelector("div[gh='cm']"));
			         JavascriptExecutor executor = (JavascriptExecutor)driver;
			         executor.executeScript("arguments[0].click();", element);
			   System.out.println("click on compose");      
			         
			         
			util.isElementPresnt(driver, "//input[@class='wA']//following::*[@id=':ov']", 50);
			   driver.findElement(By.xpath("//input[@class='wA']//following::*[@id=':ov']")).sendKeys("preetish");


			   
			Robot robot = new Robot();
			
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);

			// hidden element to find
		List<WebElement> list=	driver.findElements(By.id(":pi"));
		
		int count=list.size();
			System.out.println("total element "+count);
			
			
			for(int i=0;i<count;i++){
				WebElement ele = list.get(i);
				int x=ele.getLocation().getX();
				
				if (x!=0){
					ele.click();
					ele.sendKeys("i hve done it");
					break;
				}
			}
				} catch (Exception e) {
					
				e.printStackTrace();
				}
			
	}
	

}
