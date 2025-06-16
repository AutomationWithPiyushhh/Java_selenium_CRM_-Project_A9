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

		FileInputStream fis = new FileInputStream("C:\\Users\\User\\git\\ProjectA9\\VtigerCRM_FW_A9\\src\\test\\resources\\testScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		
		String value = wb.getSheet("org").getRow(6).getCell(0).getStringCellValue();

		System.out.println(value + (int) (Math.random()*9999));
		
//		Sheet sh = wb.getSheet("org");

//		Row row = sh.getRow(0);
		
//		Cell cell = row.getCell(0);


	}

}
