package com.toutorialsninjaProj.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Utilities {


	//final means the value assigned to it it will not change.
	//

	public static final int IMPLICIT_WAIT=10;


	public static String generateTimeStamp()
	{
		Date date = new Date();
	    String timeStamp=date.toString().replace(" ", "_").replace(":", "_");
	    return "Akash"+timeStamp+"@gmail.com";
	}


	public static Object[][] getTestDatafromExcel(String Sheetname) throws IOException {

		File ExcelFile=new File("C://Users//shadows box//eclipse-workspace//toutorialsninjaProj//src//main//java//com//toutorialsProj//qa//testdata//Tutorialsninjaexcel.xlsx");

		FileInputStream fis =new FileInputStream(ExcelFile);

		try (//XSSFWorkbook workbook=null;
		XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			XSSFSheet sheet = workbook.getSheet(Sheetname);

			int rows=sheet.getLastRowNum();
			int columns=sheet.getRow(0).getLastCellNum();

			Object[][] data =new Object[rows][rows];

			for(int i=0; i<rows; i++) {
				XSSFRow row=sheet.getRow(i+1);
				for(int j=0; j<columns; j++) {
					XSSFCell cell=row.getCell(j);

					CellType celltype = cell.getCellType();

				 switch(celltype){

				 case STRING:
					 data [i][j]=cell.getStringCellValue();
					  break;
				 case NUMERIC:
					 data[i][j]=Integer.toString((int)cell.getNumericCellValue());
				     break;
				 case BOOLEAN:
					 data[i][j]=cell.getBooleanCellValue();
					 break;



				 }
				}
			}

			return data;
		}

	}




}