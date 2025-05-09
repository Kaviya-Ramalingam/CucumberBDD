package dsalgo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelReader {

	private static final Logger logger = LoggerFactory.getLogger(ExcelReader.class);
	FileInputStream fis;// File input stream to read the Excel file
	public String path;// file path to excel sheet
	XSSFWorkbook workbook; // Workbook and Sheet objects from Apache POI
	XSSFSheet sheet;

	// Constructor that receives the Excel file path
	public ExcelReader(String path) {
		this.path = path;
	}

	public ArrayList<String> getData(String sheetName, String TestcaseName) throws IOException {
		// Open the Excel file
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();

		// List to store values from the matched row
		ArrayList<String> data = new ArrayList<String>();
		logger.debug("Number of sheets in workbook: {}", sheets);

		// Iterate through all sheets in the workbook
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) { // Check if the current sheet matches the
																		// requested sheet name
				logger.info("Reading data from sheet: {}", sheetName);
				sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next(); // First row is expected to be the header row
				Iterator<Cell> cells = firstRow.iterator();
				int k = 0; // counter to track column index
				int column = 0; // Will store the index of "testCaseId" column

				// Iterate through header cells to find the "testCaseId" column
				while (cells.hasNext()) {
					Cell value = cells.next();

					if (value.getStringCellValue().equalsIgnoreCase("testCaseId")) {
						column = k;
						logger.debug("'testCaseId' column found at index {}", column);
					}
					k++;
				}
				// Look through remaining rows for the given test case ID
				while (rows.hasNext()) {
					Row r = rows.next();
					// Check if this row contains the matching testCaseId
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(TestcaseName)) {
						logger.debug("Found matching test case ID: {}", TestcaseName);
						// Read all cells in the matched row
						Iterator<Cell> ce = r.cellIterator();
						while (ce.hasNext()) {
							Cell c = ce.next();
							if (c.getCellType() == CellType.STRING) {
								data.add(c.getStringCellValue());
							} else {
								data.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					} else {
						logger.warn("Test case ID '{}' not found in row {}", TestcaseName, r.getRowNum());
					}
				}
			}
		}

		logger.info("Data for TestCaseID: " + TestcaseName);
		for (String value : data) {
			System.out.println(value);
		}
		return data;

	}

}
