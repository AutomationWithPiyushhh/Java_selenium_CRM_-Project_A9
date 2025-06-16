package extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class GetDataFromPropertiesAndExcel {
    public static void main(String[] args) throws InterruptedException, IOException {

        FileInputStream fis = new FileInputStream("");
        Properties pObj = new Properties();
        pObj.load(fis);

        String BROWSER = pObj.getProperty("bro");
        String URL = pObj.getProperty("url");
        String USERNAME = pObj.getProperty("un");
        String PASSWORD = pObj.getProperty("pwd");

        WebDriver driver = null;

        if (BROWSER.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-autofill");
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-autofill-keyboard-accessory-view[8]");
            driver = new ChromeDriver(options);
        } else if (BROWSER.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (BROWSER.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(URL);

        // Login
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();

        Thread.sleep(3000);

        // Navigate to Create Contact
        driver.findElement(By.linkText("Contacts")).click();
        driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

        WebElement salutationDropdown = driver.findElement(By.name("salutationtype"));
        Actions act = new Actions(driver);
        act.moveToElement(salutationDropdown).perform();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("option[value='Mr.']")).click();

        // Read Excel
        FileInputStream fis1 = new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\CRM_A5\\src\\test\\resources\\GetDataFromExcelFile.xlsx");
        Workbook wb = WorkbookFactory.create(fis1);
        Sheet sh = wb.getSheet("contacts");

        for (int i = 1; i <= sh.getLastRowNum(); i++) {
            Row row = sh.getRow(i);

            String first = row.getCell(0).getStringCellValue();
            String second = row.getCell(1).getStringCellValue();
            String third = row.getCell(2).getStringCellValue();
            String fourth = row.getCell(3).getStringCellValue();
            String fifth = row.getCell(4).getStringCellValue();
            String sixth = row.getCell(5).getStringCellValue();
            String seventh = row.getCell(6).getStringCellValue();
            String eighth = row.getCell(7).getStringCellValue();
            String ninth = row.getCell(8).getStringCellValue();
            String tenth = row.getCell(9).getStringCellValue();
            String eleven = row.getCell(10).getStringCellValue();
            String twelve = row.getCell(11).getStringCellValue();
            String thirteen = row.getCell(12).getStringCellValue();
            String fourteen = row.getCell(13).getStringCellValue();
            String fifteen = row.getCell(14).getStringCellValue();
            String sixteen = row.getCell(15).getStringCellValue();
            String seventeen = row.getCell(16).getStringCellValue();
            String eighteen = row.getCell(17).getStringCellValue();
            String nineteen = row.getCell(18).getStringCellValue();
            String twenty = row.getCell(19).getStringCellValue();
            String twentyone = row.getCell(20).getStringCellValue();
            String twentytwo = row.getCell(21).getStringCellValue();
            String twentythree = row.getCell(22).getStringCellValue();
            String twentyfour = row.getCell(23).getStringCellValue();
            String twentyfive = row.getCell(24).getStringCellValue();
            String twentysix = row.getCell(25).getStringCellValue();

            driver.findElement(By.name("firstname")).sendKeys(first);
            driver.findElement(By.name("lastname")).sendKeys(second);
            driver.findElement(By.id("phone")).sendKeys(third);
            driver.findElement(By.id("mobile")).sendKeys(fourth);

            WebElement leadDropdown = driver.findElement(By.name("leadsource"));
            act.moveToElement(leadDropdown).perform();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("option[value='Direct Mail']")).click();

            driver.findElement(By.id("homephone")).sendKeys(fifth);
            driver.findElement(By.id("title")).sendKeys(sixth);
            driver.findElement(By.id("otherphone")).sendKeys(seventh);
            driver.findElement(By.id("department")).sendKeys(eighth);
            driver.findElement(By.id("fax")).sendKeys(ninth);
            driver.findElement(By.id("email")).sendKeys(tenth);
            driver.findElement(By.id("assistant")).sendKeys(eleven);
            driver.findElement(By.id("assistantphone")).sendKeys(twelve);
            driver.findElement(By.id("secondaryemail")).sendKeys(thirteen);

            driver.findElement(By.name("emailoptout")).click();
            driver.findElement(By.name("donotcall")).click();
            driver.findElement(By.name("reference")).click();
            driver.findElement(By.name("notify_owner")).click();
            driver.findElement(By.name("portal")).click();

            driver.findElement(By.name("mailingstreet")).sendKeys(fourteen);
            driver.findElement(By.id("mailingpobox")).sendKeys(fifteen);
            driver.findElement(By.id("mailingcity")).sendKeys(sixteen);
            driver.findElement(By.id("mailingstate")).sendKeys(seventeen);
            driver.findElement(By.id("mailingzip")).sendKeys(eighteen);
            driver.findElement(By.id("mailingcountry")).sendKeys(nineteen);

            driver.findElement(By.name("otherstreet")).sendKeys(twenty);
            driver.findElement(By.id("otherpobox")).sendKeys(twentyone);
            driver.findElement(By.id("othercity")).sendKeys(twentytwo);
            driver.findElement(By.id("otherstate")).sendKeys(twentythree);
            driver.findElement(By.id("otherzip")).sendKeys(twentyfour);
            driver.findElement(By.id("othercountry")).sendKeys(twentyfive);
            driver.findElement(By.name("description")).sendKeys(twentysix);

            Thread.sleep(2000);

            WebElement saveBtn = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
            act.moveToElement(saveBtn).perform();
            saveBtn.click();

            String actualFirst = driver.findElement(By.id("dtlview_First Name")).getText();
            String actualLast = driver.findElement(By.id("dtlview_Last Name")).getText();

            if (actualFirst.equals(first) && actualLast.equals(second)) {
                System.out.println("Contact Created successfully!!!");
            } else {
                System.out.println("Couldn't create Contact!!!!");
            }

            WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
            act.moveToElement(profile).perform();
            Thread.sleep(2000);
            driver.findElement(By.linkText("Sign Out")).click();
        }

        driver.quit();
    }
}
