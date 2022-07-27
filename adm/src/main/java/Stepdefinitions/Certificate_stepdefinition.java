package Stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Baseclass.Base_class;
import Pagefactory.Certificate_objects;
import Pagefactory.StudentLoginObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Certificate_stepdefinition extends Base_class {
		
		public static String student_username,student_password,otp;
		
		public static String[][] username_and_password() throws IOException{
		excel_username_extraction();
		excel_password_extraction();
		info=new String[username.size()][2];
		for(int i=0;i<username.size();i++) {
			info [i][0]=(String) username.get(i);
		    info[i][1]=(String) password.get(i);
			
	  }
		return info;                                
	}
		
	@DataProvider(name="username_and_password")
	public String[][] data_provider() throws IOException{
		   String[][] dp=username_and_password();
		   return dp;
		}   


	@Test(priority=1, dataProvider="username_and_password")
	@Given("user launches student login url and login with valid username and password and enters correct otp number")
	public void user_launches_student_login_url_and_login_with_valid_username_and_password_and_enters_correct_otp_number(String uname,String pword) throws InterruptedException, IOException {
		openBrowser_student();
		
		PageFactory.initElements(driver, Certificate_objects.class);
		excel_username_extraction();
	    student_username=uname;    //(String) username.get(index);
	    
	    StudentLoginObjects.studentid.sendKeys(student_username);
	    
	    excel_password_extraction();
	    student_password=pword;        //(String) password.get(index);
	    
	    StudentLoginObjects.password.sendKeys(student_password);
	    
	    StudentLoginObjects.log_in.click();
	    
	    WebDriverWait wait=explicit_wait();
	    otp=wait.until(ExpectedConditions.visibilityOf(StudentLoginObjects.otp_read)).getText();
	    //System.out.print("otp"+otp);
	    
	    StudentLoginObjects.otp_write.sendKeys(otp);
	    
	    StudentLoginObjects.submit.click();
	    
	    before_screenshot(student_username);
	//	Report_generation.test.log(Status.INFO, "took screenshot of the current dashboard of student profile");
		
	//	WebDriverWait wait=explicit_wait();
		wait.until(ExpectedConditions.elementToBeClickable(Certificate_objects.co_curricular)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(Certificate_objects.cerfificate)).click();
		
		certificate_properties();
		wait.until(ExpectedConditions.visibilityOf(Certificate_objects.title)).sendKeys(properties.getProperty("title"));
		
		wait.until(ExpectedConditions.visibilityOf(Certificate_objects.issuing)).sendKeys(properties.getProperty("issuing"));
		
		wait.until(ExpectedConditions.visibilityOf(Certificate_objects.board_name)).sendKeys(properties.getProperty("board_name"));
		
		wait.until(ExpectedConditions.visibilityOf(Certificate_objects.scope)).click();
		Select select=select_class(Certificate_objects.scope);
		select.selectByVisibleText(properties.getProperty("scope"));
		
		wait.until(ExpectedConditions.visibilityOf(Certificate_objects.year)).click();
		Thread.sleep(1000);
		scroll();
		
		wait.until(ExpectedConditions.visibilityOf(Certificate_objects.select_year)).click();
		Thread.sleep(1000);
		Select select_year=select_class(Certificate_objects.select_year);
		select_year.selectByVisibleText(properties.getProperty("year"));
		
		wait.until(ExpectedConditions.visibilityOf(Certificate_objects.select_month)).click();
		Thread.sleep(1000);
		Select select_month=select_class(Certificate_objects.select_month);
		select_month.selectByVisibleText(properties.getProperty("month"));
		
		wait.until(ExpectedConditions.visibilityOf(Certificate_objects.select_date)).click();
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(Certificate_objects.submit)).click();
		
	//	Report_generation.test.log(Status.INFO, "certificate got added in the corresponding student profile and waiting for admin approval");

	    
	//    Report_generation.test.log(Status.INFO, "logged into student access");
	    
	    Thread.sleep(2000);
	    
	    driver.close();
	 
	  	}

	

}
