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

public class ReadallDatas {
	public static void allDatas() throws IOException{
		File f=new File("C:\\Users\\KUZHALI\\eclipse-workspace\\Maven_Project\\Datadriven xcel\\multi.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);
		int rowcount = sheetAt.getPhysicalNumberOfRows();
		for(int i=0;i<rowcount;i++)
		{
			Row row = sheetAt.getRow(i);
			int cellcount=row.getPhysicalNumberOfCells();
			for(int j=0;j<cellcount;j++) {
				Cell cell = row.getCell(j);
				CellType type = cell.getCellType();
				if(type.equals(CellType.STRING))
				{
					
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
				}
				else if(type.equals(CellType.NUMERIC))
				{
					
					double numericCellValue = cell.getNumericCellValue();
					int newvalue=(int)numericCellValue;
					System.out.println(newvalue);
				
				}
			}
			
		}
	}
	public static void main(String[] args) throws IOException {

		allDatas();
	}
		
		
	


		
		
		
		
		
	}

