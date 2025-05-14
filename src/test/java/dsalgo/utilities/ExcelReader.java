package dsalgo.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelReader {

	    private static final Logger logger = LoggerFactory.getLogger(ExcelReader.class);
	    private final String resourceName;

	    public ExcelReader(String resourceName) {
	        this.resourceName = resourceName;
	    }

	    public Map<String, String> getDataAsMap(String sheetName, String testCaseName) throws IOException {
	        Map<String, String> dataMap = new LinkedHashMap<>();
	        DataFormatter formatter = new DataFormatter();

	        try (InputStream path = getClass().getClassLoader().getResourceAsStream(resourceName);
	             XSSFWorkbook workbook = new XSSFWorkbook(path)) {

	            logger.info("Opened workbook for reading: {}", resourceName);

	            XSSFSheet sheet = workbook.getSheet(sheetName);
	            if (sheet == null) {
	                logger.error("Sheet not found: {}", sheetName);
	                throw new IllegalArgumentException("Sheet not found: " + sheetName);
	            }
	            logger.info("Reading from sheet: {}", sheetName);

	            Iterator<Row> rowIterator = sheet.iterator();
	            if (!rowIterator.hasNext()) {
	                logger.error("Sheet is empty: {}", sheetName);
	                throw new IllegalArgumentException("Sheet is empty: " + sheetName);
	            }

	            // Read header row
	            Row headerRow = rowIterator.next();
	            List<String> headers = new ArrayList<>();
	            for (Cell cell : headerRow) {
	                headers.add(formatter.formatCellValue(cell));
	            }
	            logger.debug("Headers found: {}", headers);

	            boolean found = false;
	            while (rowIterator.hasNext()) {
	                Row row = rowIterator.next();
	                Cell testCaseCell = row.getCell(0);

	                if (testCaseCell != null &&
	                    formatter.formatCellValue(testCaseCell).equalsIgnoreCase(testCaseName)) {

	                    logger.info("Found matching test case: {}", testCaseName);

	                    for (int i = 0; i < headers.size(); i++) {
	                        Cell cell = row.getCell(i);
	                        String value = (cell != null) ? formatter.formatCellValue(cell) : "";
	                        dataMap.put(headers.get(i), value);
	                    }
	                    found = true;
	                    break;
	                }
	            }

	            if (!found) {
	                logger.warn("Test case '{}' not found in sheet '{}'", testCaseName, sheetName);
	            } else {
	                logger.info("Data map for test case '{}': {}", testCaseName, dataMap);
	            }
	        }
	        return dataMap;
	    }
	}