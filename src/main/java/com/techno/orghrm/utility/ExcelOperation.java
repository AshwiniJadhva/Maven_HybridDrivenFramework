package com.techno.orghrm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.reporters.jq.Main;

import com.techno.orghrm.constant.ConstantPath;
public class ExcelOperation {
	
	
	public static Object[][] getSheetData(String fileName,String sheetName, boolean isHeader) throws IOException {
		File file = new File(ConstantPath.TESTDATA+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);
		int count =0;
		if(isHeader)
			count =1;
		Sheet sheet = wb.getSheet(sheetName);
		int totalRows = sheet.getLastRowNum();
		System.out.println("total rows -> " + totalRows); // 0->3
		//if(isHeader)
		//	totalRows = sheet.getLastRowNum();
		int totalCol = sheet.getRow(0).getLastCellNum();
		System.out.println("total col -> " + totalCol); // 3
		
		Object[][] data = new Object[totalRows][totalCol];
		for(int rowIndex=1;rowIndex<=data.length;rowIndex++) {
			for(int colIndex=0;colIndex<totalCol;colIndex++) {
				try {
					if(CellType.STRING==sheet.getRow(rowIndex).getCell(colIndex).getCellType())
						data[rowIndex-count][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
					else if(CellType.NUMERIC==sheet.getRow(rowIndex).getCell(colIndex).getCellType())
						data[rowIndex-count][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).getNumericCellValue();
					else if(CellType.BOOLEAN==sheet.getRow(rowIndex).getCell(colIndex).getCellType())
						data[rowIndex-count][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
					
				}catch(NullPointerException ne) {
					data[rowIndex-count][colIndex] ="";
				}
				//System.out.print(data[rowIndex-count][colIndex] + " ");
			}
			//System.out.println();
		}
		wb.close();
		return data;
	}
	
	

	 
	 


}
