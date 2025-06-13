package extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		Step - 1 -> Get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\git\\ProjectA9\\VtigerCRM_FW_A9\\src\\test\\resources\\testScriptData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);// Create method will not create anything
												  // It will open the workbook in read-mode
	
		Sheet sh = wb.getSheet("org");
		
		Row row = sh.getRow(4);
		
		Cell cell = row.getCell(0);
		
		String data = cell.getStringCellValue();
	
		System.out.println(data + (int)(Math.random() * 999));
	}
	
}
