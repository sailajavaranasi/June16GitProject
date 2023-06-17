package excelOperation;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelDataByName 
{

	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\ravi\\Desktop\\testdata1.xlsx");
		FileOutputStream fos = null;
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("login");
		XSSFRow row = sheet.getRow(0);
		
		int cellNum = 0;
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals("Result"))
				cellNum = i;
		}
		
		row = sheet.getRow(2);
		XSSFCell cell = row.getCell(cellNum);
		cell.setCellValue("Failed");
		
		fos = new FileOutputStream("C:\\Users\\ravi\\Desktop\\testdata1.xlsx");
		wb.write(fos);
		
		wb.close();
		fos.close();
	}

}
