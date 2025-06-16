package extra;

import java.io.FileInputStream;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;

public class GetDataFromODS{
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\tds.ods");
		
        SpreadsheetDocument ods = SpreadsheetDocument.loadDocument(fis);

        // Get the first sheet (by index or by name)
        Table sheet = ods.getSheetByName("Org");
        Row row = sheet.getRowByIndex(4);
        Cell cell = row.getCellByIndex(0);
        
        String data = cell.getStringValue();

        System.out.println(data + (int)(Math.random() * 999));

	}
}
