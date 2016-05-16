package com.test.gurukul.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadXL {

	public static Object[][] readFile(String path) throws IOException {


		// Path to the excel file
		File datafile = new File(path);

		FileInputStream  fi =new FileInputStream(datafile);

		// We create a workbook which represents the excel file
		XSSFWorkbook book = new XSSFWorkbook(fi);

		XSSFSheet sheet = book.getSheet("Sheet1");
		// No of rows in the sheet
		int rowNum = sheet.getLastRowNum();

		// No of columns in the sheet
		int colNum = sheet.getRow(0).getLastCellNum();

		// A Two dimensional array of Strings which represents the data in the
		// sheet
		String[][] data = new String[rowNum][colNum];

		for (int i = 0; i < rowNum; i++) {
			XSSFRow row = sheet.getRow(i+1);
			
			
			for (int j = 0; j < colNum; j++) {
				// Get the columns or cells for the first row and keep looping
				// for the other rows
				XSSFCell cell = row.getCell(j);

				// Make a call to the method cellToString which actually
				// converts the cell contents to String
				String value = cellToString(cell);
				data[i][j] = value;
                
			}
		}
		return data;

	}

	private static String cellToString(XSSFCell cell) {

		Object result="" ;

		switch (cell.getCellType()) {

		case Cell.CELL_TYPE_NUMERIC:
			result = cell.getNumericCellValue();			
			break;

		case Cell.CELL_TYPE_STRING:
			result = cell.getStringCellValue();			
			break;

		case Cell.CELL_TYPE_BOOLEAN:
			result = cell.getBooleanCellValue();
			break;


		case  Cell.CELL_TYPE_BLANK :
			result=cell.getCellType();

			break;

		case Cell.CELL_TYPE_FORMULA:
			result = cell.getCellFormula();
			break;

		default:
			throw new RuntimeException("Unknown Cell Type");
		}

		return result.toString();
	}

}

