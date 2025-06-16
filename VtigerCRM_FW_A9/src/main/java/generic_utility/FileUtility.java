package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	public String getDataFromPropFile(String key) throws IOException {
//		Step 1 :- Getting the java representation object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Basic_Selenium\\VtigerCRM_FW_A9\\src\\test\\resources\\commonData.properties");

//		Step 2 :- By using Properties class of java load all the keys
		Properties pObj = new Properties();
		pObj.load(fis);

//		Step 3 :- By using getProperty() we will get the value
		String VALUE = pObj.getProperty(key);
		return VALUE;
	}
	
	
	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\git\\ProjectA9\\VtigerCRM_FW_A9\\src\\test\\resources\\testScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		
		String value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();

		return value ;
	}
}
