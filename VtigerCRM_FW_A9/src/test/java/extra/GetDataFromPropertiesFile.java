package extra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
//		Step 1 :- Getting the java representation object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Basic_Selenium\\VtigerCRM_FW_A9\\src\\test\\resources\\commonData.properties");

//		Step 2 :- By using Properties class of java load all the keys
		Properties pObj = new Properties();
		pObj.load(fis);

//		Step 3 :- By using getProperty() we will get the value
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");

		System.out.println("Browser is : " + BROWSER);
		System.out.println("Url is : " + URL);
		System.out.println("Username is : " + USERNAME);
		System.out.println("Password is : " + PASSWORD);
		
		fis.close();
		
//		Set the properties file data
		
		pObj.setProperty("City", "Noida");
		pObj.setProperty("State", "UP");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\User\\Basic_Selenium\\VtigerCRM_FW_A9\\src\\test\\resources\\commonData.properties");
		pObj.store(fos, "Data added by ATE...");
		fos.close();
	}
}
