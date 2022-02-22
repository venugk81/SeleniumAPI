package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;

public class ExcelReader {

	//https://www.callicoder.com/java-read-excel-file-apache-poi/
	public static String filePath = "/src/main/resources/data/testdata.xlsx";
	
	static Workbook workbook;
	public static Sheet sheet;
	static Object data[][];
	
	/*
	public ExcelReader() {
		try {
			File f = new File(System.getProperty("user.dir")+ filePath);
			System.out.println(f.getAbsolutePath());
			if(f.exists()) {
				workbook = WorkbookFactory.create(new FileInputStream(f));				
			}
			
			
		}catch(Exception oExp)
		{
			Assert.fail("Failed to read excel data from filepath: "+ filePath);
		}
	}
	*/
	
	
	public static Object[][] readData(String sheetname) {
		try {
			File f = new File(System.getProperty("user.dir")+ filePath);
			System.out.println(f.getAbsolutePath());
			if(f.exists()) {
				workbook = WorkbookFactory.create(new FileInputStream(f));				
			}			
			
		}catch(Exception oExp)
		{
			Assert.fail("Failed to read excel data from filepath: "+ filePath);
		}
		
		try {
			sheet = workbook.getSheet(sheetname);
			int rowCount = sheet.getLastRowNum();
			data = new Object[rowCount][1];
			String[] headers= new String[rowCount];
			
			for(int col=0; col<sheet.getRow(0).getLastCellNum(); col++) {
				headers[col]= sheet.getRow(0).getCell(col).toString();
			}
			
			for(int row=1; row<=rowCount; row++) {
				Map<String, String> map = new LinkedHashMap<String, String>();
				for(int col=0; col< sheet.getRow(row).getLastCellNum(); col++){
//					System.out.println(sheet.getRow(row).getCell(col).toString());
					map.put(headers[col], sheet.getRow(row).getCell(col).toString());
				}
				data[row-1][0] = map;
				
				
			}
			
			workbook.close();
			Map<String, String> m1= (Map<String, String>) data[0][0];
			System.out.println(m1.keySet());
			System.out.println(m1.get("TestName"));
			
			m1= (Map<String, String>) data[1][0];
			System.out.println(m1.keySet());
			System.out.println(m1.get("TestName"));
			
			m1= (Map<String, String>) data[2][0];
			System.out.println(m1.keySet());
			System.out.println(m1.get("TestName"));
			
			System.out.println("Length of the rows in the data obj data.length: "+ data.length);
			System.out.println("==================================");
						
		}catch(Exception oExp) {
			oExp.printStackTrace();
		}
		
		return data;
	}
	
	public static void main(String[] args) {
//		ExcelReader ex = new ExcelReader();
		ExcelReader.readData("RegisterUser");
	}
	
}




/*
TestName	firstname	lastname
Test1	venu	gopi
test2	gopi	venu
test3	gopi3	venu3

RegisterUser



HSSF and XSSF implementations -
Apache POI library consists of two different implementations for all the above interfaces.

HSSF (Horrible SpreadSheet Format): HSSF implementations of POI’s high-level interfaces like HSSFWorkbook, HSSFSheet, HSSFRow and HSSFCell are used to work with excel files of the older binary file format - .xls

XSSF (XML SpreadSheet Format): XSSF implementations are used to work with the newer XML based file format - .xlsx.
*/