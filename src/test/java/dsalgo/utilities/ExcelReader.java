package dsalgo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	FileInputStream fis;
	public String path;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public ExcelReader(String path) {
		
		this.path = path;
	}

	public ArrayList<String> getData(String sheetName) throws IOException{
		fis = new FileInputStream(path);
		ArrayList<String>a = new ArrayList<String>();
		workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		
		for(int i=0;i<=sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase(sheetName)){
				sheet=workbook.getSheetAt(i);
			}
			
			Iterator<Row>rows=sheet.iterator();
			Row firstRow = rows.next();
			Iterator<Cell>cells=firstRow.iterator();
			
			while(cells.hasNext()) {
				Cell value = cells.next();
				if(value.getStringCellValue().equalsIgnoreCase("testCaseId"));
			}
		}
		
		
		return null;
		
	}

}
