package Utilitys;

import java.io.File;
import java.io.FileInputStream;


import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WriteExcel {
	
	
	
	
	public static void write1(int row,int column,String passvalue) throws Exception{
		
		
		
	
			try {
				 File scr = new File("C:\\Preetish\\onlineproject\\src\\test\\java\\excel\\data.xlsx");
				 FileInputStream fis = new FileInputStream(scr);
				 XSSFWorkbook wb = new XSSFWorkbook(fis);
				 XSSFSheet Sheet1 =  wb.getSheetAt(0);
				
				Sheet1.getRow(row).createCell(column).setCellValue(passvalue);
				
				FileOutputStream filout = new FileOutputStream(scr);
				wb.write(filout);
				wb.close();
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		
		
	}

}
