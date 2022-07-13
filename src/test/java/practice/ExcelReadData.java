package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReadData {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("../SDET7_SAI/SDET7.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
//		Cell val = sheet.getRow(2).getCell(2);
//		System.out.println(val);
		int lastrow = sheet.getLastRowNum();
//		System.out.println(lastrow);
		for(int i=1;i<lastrow;i++)
		{
		Cell c=sheet.getRow(i).getCell(2);
		System.out.println(c);
		}
		
	}
}
