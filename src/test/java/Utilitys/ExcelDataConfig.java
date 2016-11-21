package Utilitys;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
		
	public ExcelDataConfig(String excelPath) throws Exception{
		try {
			File scr = new File(excelPath);
			FileInputStream fis = new FileInputStream(scr);
			wb =new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	



	public String getData(int  SheetNumber,int row,int column )
	{   
		sheet1 = wb.getSheetAt(SheetNumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
	    return data;
	}
	
	
	public int getRowCount(int SheetIndex)
	{

    int row = wb.getSheetAt(SheetIndex).getLastRowNum();
      row = row+1;
      return row; 
	}
}
