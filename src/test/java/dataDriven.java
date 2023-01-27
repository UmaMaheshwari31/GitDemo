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

public class dataDriven {
	public static void main(String[] args) throws IOException {
		
		
	}
	
	public ArrayList<String> getData(String testcaseName) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\demodata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//file input stream argumet
		
		int sheets = workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
			
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();
				Iterator<Cell> cells = firstrow.cellIterator();
				int k=0;
				int column = 0;
				while(cells.hasNext()){
					Cell value = cells.next();
					if(value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						
					column= k;	
					
						
					}
					k++;
				}
				System.out.println("column number is " + column);
				// to scan the entire column
				
				while(rows.hasNext()) {
					Row r= rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						// grab all cell on the specific row
						Iterator<Cell> cellvalues = r.cellIterator();
						while(cellvalues.hasNext()){
							Cell c = cellvalues.next();
							if(c.getCellType()==CellType.STRING) {
								a.add(c.getStringCellValue());	
							}
							else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));	
							}
						
						}
						System.out.println("Git demo sccessful after adding into th Git Hub");
						System.out.println("Branch");
					}
				}
								
			}
		}
		return a;
		
	}
	
}



