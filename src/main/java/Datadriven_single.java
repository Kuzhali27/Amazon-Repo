import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven_single {
	public static void readParticulardata() throws IOException {
		File f=new File("C:\\Users\\KUZHALI\\eclipse-workspace\\Maven_Project\\Datadriven xcel\\SINGLE DATA DRIVEN.xlsx");
		
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);
		Row row = sheetAt.getRow(1);
		Cell cell = row.getCell(0);
		CellType typeofcellType = cell.getCellType();
		if(typeofcellType.equals(CellType.STRING))
		{
			
			String stringCellValue = cell.getStringCellValue();
			System.out.println(stringCellValue);
		}
		else if(typeofcellType.equals(CellType.NUMERIC))
		{
			
			double numericCellValue = cell.getNumericCellValue();
			int newvalue=(int)numericCellValue;
			System.out.println(newvalue);
		
		}
	}
	public static void main(String[] args) throws IOException {
		readParticulardata();
		
	}

}
