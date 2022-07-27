package Baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfileActivationBaseClass {
	
    public static Properties properties=null;
	public static WebDriver driver;
/*	public static int row_no;
	public static File file=null;
	public static FileInputStream input=null;
	public static XSSFWorkbook workbook=null;
	public static XSSFSheet sheet=null;
	public static List username=new ArrayList();
	public static List password=new ArrayList();
	public static String info[][]=null;   */
	
	    public static WebDriverWait explicit_wait() {
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait;
	     }
			
		public static void scroll() {
			JavascriptExecutor executor=(JavascriptExecutor)driver;
			executor.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
		}
		
		public static Properties loadProperties() throws IOException {
			FileInputStream input=new FileInputStream("C:\\Users\\Lavanya\\eclipse-workspace\\adm\\src\\main\\java\\Baseclass\\profileActivation.properties");
			properties=new Properties();
			properties.load(input);
			return properties;
		}

		public static void openBrowser_student() throws IOException {	
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lavanya\\chromedriver\\chromedriver\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://maplogik.com/index.php/student/login");
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		}
		
	/*	public static void excel_username_extraction() throws IOException {
			loadProperties();
			
			file=new File(properties.getProperty("fileLocation"));
			input=new FileInputStream(file);
			workbook=new XSSFWorkbook(input);
			sheet=workbook.getSheetAt(0);
			row_no=sheet.getLastRowNum();
			System.out.println(row_no);
			int column_no=sheet.getRow(0).getLastCellNum();
			List checker=new ArrayList();
			DataFormatter data=new DataFormatter();
			for(int i=0;i<=column_no;i++) {
				Cell cell_value=sheet.getRow(0).getCell(i);
				String cell_data=data.formatCellValue(cell_value);
				checker.add(cell_data);
			}
			
			int user_index=checker.indexOf("student_id");
			for(int i=1;i<=row_no;i++) {
			Cell cell_value=sheet.getRow(i).getCell(user_index);
			String student_id=data.formatCellValue(cell_value);
			username.add(student_id);
		//	System.out.println(student_id);
			}
		}
		
		public static void excel_password_extraction() throws IOException {
			loadProperties();
	
			file=new File(properties.getProperty("fileLocation"));
			input=new FileInputStream(file);
			workbook=new XSSFWorkbook(input);
			sheet=workbook.getSheetAt(0);
			row_no=sheet.getLastRowNum();
		//	System.out.println(row_no);
			int column_no=sheet.getRow(0).getLastCellNum();
			List checker=new ArrayList();
			DataFormatter data=new DataFormatter();
			for(int i=0;i<=column_no;i++) {
				Cell cell_value=sheet.getRow(0).getCell(i);
				String cell_data=data.formatCellValue(cell_value);
				checker.add(cell_data);
			}
			
			int user_index=checker.indexOf("student_mobile");
			for(int i=1;i<=row_no;i++) {
			Cell cell_value=sheet.getRow(i).getCell(user_index);
			String student_mobile=data.formatCellValue(cell_value);
			password.add(student_mobile);
		//	System.out.println(student_mobile);
			}
		}       */

		public static void screenshot(String string) throws IOException,InterruptedException {
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			File source=screenshot.getScreenshotAs(OutputType.FILE);
			File destination=new File("D:\\MapLogiK\\new scenario\\screenshots\\"+string+".png");
			FileHandler.copy(source,destination);
			Thread.sleep(2000);
		}

}
