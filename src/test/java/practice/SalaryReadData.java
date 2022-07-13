package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalaryReadData {
	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().create();
		
		/*
		 * WebDriverManager.chromedriver().setup(); WebDriver driver=new ChromeDriver();
		 */
	
		FileInputStream fis=new FileInputStream("../SDET7_SAI/SDET7.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		int num = sheet.getLastRowNum();
			Cell sal;
		for(int i=1;i<=num;i++) {
			 sal = sheet.getRow(i).getCell(2);
			int salary = (int)sal.getNumericCellValue();
//			System.out.println(salary);
			if(salary>=15000) {
				Cell name = sheet.getRow(i).getCell(1);
				System.out.println("name:"+name);
			}
			
			}
			
		}
}
