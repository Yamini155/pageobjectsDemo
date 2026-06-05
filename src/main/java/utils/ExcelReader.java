package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static Object [] getExcelData(String sheetName, String methodName) throws IOException {
		FileInputStream file = new FileInputStream("src\\test\\resources\\LoginTest.xlsx");
		   
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		List<String> dataList = new ArrayList<>();
		Object [] data = null;
		for(int i=1;i<rowCount;i++) {
			Row row =sheet.getRow(i);
			if(row==null) {
				continue;
			}
			
			Cell methodCell =row.getCell(0);
			if(methodCell==null) {
				continue;
			}
			String currentMethodName =methodCell.toString();
			if(currentMethodName.equalsIgnoreCase(methodName)) {
				for(int j=1;j<colCount;j++) {
					Cell cell = row.getCell(j);
					if(cell==null) {
						dataList.add("");
						
				}else {
					dataList.add(cell.toString());
				}
					
					
			}
			
		}

			workbook.close();
			file.close();
			
			if(dataList.size()>0) {
				data = new Object[dataList.size()];
				for(int k=0;k<dataList.size();k++) {
					data[k] = dataList.get(k);
				}
			}
			
		}
		
		
		
		
		return data; 
		}

}
