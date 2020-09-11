//PACKAGE
package com.tokiyo.project.UTIL;
//*****************************************************

//IMPORTED PACKGES
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import h.cell;
//*********************************************************************

//EXCEL DATA READER CLASS
public class ReadFromDataProvider 
{

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static String [][] getTableArray(String FilePath, String SheetName) throws Exception 
	{   
		String[][] tabArray = null;
		try {
				FileInputStream ExcelFile = new FileInputStream(FilePath);
				// Access the required test data sheet
				ExcelWBook = new XSSFWorkbook(ExcelFile);
				ExcelWSheet = ExcelWBook.getSheet(SheetName);

				int startRow = 1;
				int startCol = 1;

				int ci=0,cj=0;

				int totalRows = ExcelWSheet.getLastRowNum();
				// you can write a function as well to get Column count
				Row r1 = ExcelWSheet.getRow(1);
				int totalCols =r1.getLastCellNum();
	 
				tabArray=new String[totalRows][totalCols];

				ci=0;
				for (int i=startRow;i<=totalRows;i++, ci++) 
				{        
					cj=0;
					System.out.println("****************************************");
					for (int j=startCol;j<totalCols;j++, cj++)
					{
						tabArray[ci][cj]=getCellData(i,j);
						System.out.println(tabArray[ci][cj]);  
					}

				}
	   
	    

			}

			catch (FileNotFoundException e)
			{
				System.out.println("Could not read the Excel sheet");
				e.printStackTrace();
			}

			catch (IOException e)
			{
				System.out.println("Could not read the Excel sheet");
				e.printStackTrace();

			}

	return(tabArray);

	}


	public static String getCellData(int RowNum, int ColNum) throws Exception 
	{

	try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			int dataType = Cell.getCellType();
			//System.out.println("dataType--"+dataType);
			if  (dataType == 3) 
			{
			return "";
			}else{
					//Cell.setCellValue(str);
					String CellData = Cell.getStringCellValue();
					return CellData;
				 }
		}catch (Exception e)
		 {
			System.out.println(e.getMessage());
			throw (e);
		 }
	

	}

}


