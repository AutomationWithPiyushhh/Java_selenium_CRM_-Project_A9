package extra;

import java.io.FileInputStream;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;

public class GetMultipleDataFromODS {
	public static void main(String[] args) throws Exception {
		// Load the ODS file from disk
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\tds.ods");
		SpreadsheetDocument ods = SpreadsheetDocument.loadDocument(fis);

		// Get the sheet by name (or you could use getSheetByIndex(0))
		Table sheet = ods.getSheetByName("Sheet1");

		// Determine how many rows are present
		int rowCount = sheet.getRowCount();

		// Loop through each row and read the first two cells
		for (int i = 0; i < rowCount; i++) {
			Row row = sheet.getRowByIndex(i);

			Cell firstCell = row.getCellByIndex(0);
			Cell secondCell = row.getCellByIndex(1);

			String first = firstCell.getStringValue();
			String second = secondCell.getStringValue();

			System.out.println(first + " | " + second);
		}

		fis.close();
		ods.close();
	}
}
