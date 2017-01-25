package com.DatePicker.example;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;





public class DataPicker {
	
	
WebDriver driver;
	
	@org.testng.annotations.Test		
	public void chrome_Test(){
	
	
	 
		
			try {
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				
				capabilities.setCapability(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,System.setProperty("webdriver.chrome.driver", 
						"C:\\Users\\preetish\\Desktop\\chromedriver.exe"));
				driver= new ChromeDriver(capabilities);
				
				driver.manage().window().maximize();
				driver.get("https://www.redbus.in/");
				
				
				driver.findElement(By.xpath("//*[contains(text(),'Onward Date')]")).click();
				
				List<WebElement> list=	driver.findElements(By.xpath("//*[contains(text(),'Jan 2017')]//following::*[contains(text(),'26')]"));
				
				int count=list.size();
					System.out.println("total element "+count);
					
					
					for(int i=0;i<count;i++){
						WebElement ele = list.get(i);
						int x=ele.getLocation().getX();
						
						if (x!=0){
							ele.click();
						
							break;
						}
					}
				
				driver.findElement(By.xpath("//*[contains(text(),'Return Date')]")).click();	
				
List<WebElement> list1=	driver.findElements(By.xpath(".//*[@id='rb-calendar_return_cal']//following::*[contains(text(),'26')]"));
				
				int count1=list1.size();
					System.out.println("total element "+count1);
					
					
					for(int i=0;i<count1;i++){
						WebElement ele = list1.get(i);
						int x=ele.getLocation().getX();
						
						if (x!=0){
							ele.click();
						
							break;
						}
					}
					
	driver.findElement(By.xpath(".//button[@id='search_btn']|*[contains(text(),'Search Buses')]")).click();				
					
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	
	
	}
	}
