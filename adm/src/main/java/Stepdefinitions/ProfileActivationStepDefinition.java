package Stepdefinitions;

import java.io.IOException;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.pageObjects.Account_activation_objects;

import Baseclass.Base_class;
import Baseclass.ProfileActivationBaseClass;
import Pagefactory.Certificate_objects;
import Pagefactory.ProfileActivationObjects;
import Pagefactory.StudentLoginObjects;
import io.cucumber.java.en.Given;

public class ProfileActivationStepDefinition extends ProfileActivationBaseClass{
		
		public static String student_username,student_password,otp;
		
/*		public static String[][] username_and_password() throws IOException{
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
		}   */
	
	public void stuentLogin(String string1,String string2) throws IOException {
		PageFactory.initElements(driver, StudentLoginObjects.class);
		
	//	excel_username_extraction();
	    student_username=string1;    
	    
	    StudentLoginObjects.studentid.sendKeys(student_username);
	    
	//    excel_password_extraction();
	    student_password=string2;        
	    
	    StudentLoginObjects.password.sendKeys(student_password);
	    
	    StudentLoginObjects.log_in.click();
	    
	    WebDriverWait wait=explicit_wait();
	    otp=wait.until(ExpectedConditions.visibilityOf(StudentLoginObjects.otp_read)).getText();
	    
	    StudentLoginObjects.otp_write.sendKeys(otp);
	    
	    StudentLoginObjects.submit.click();
	}
	
	public void activateProfile() throws InterruptedException {
		PageFactory.initElements(driver, ProfileActivationObjects.class);
		
		String current_window=driver.getWindowHandle();
		
    	WebDriverWait wait=explicit_wait();
    //	wait.until(ExpectedConditions.visibilityOf(ProfileActivationObjects.activate_account)).getText();
		
		scroll();
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.elementToBeClickable(ProfileActivationObjects.pay_now)).click();
		
		driver.switchTo().frame(0);
		scroll();
		
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(ProfileActivationObjects.payment)).click();
		
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(ProfileActivationObjects.icici)).click();
		
		wait.until(ExpectedConditions.visibilityOf(ProfileActivationObjects.pay)).click();
		
		Thread.sleep(2000);
		Set<String> windows=driver.getWindowHandles();
	   
		for(String new_window:windows) {
		if(!windows.equals(current_window)) {
		driver.switchTo().window(new_window);
		}
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(ProfileActivationObjects.success)).click();
		
		Thread.sleep(1000);
		driver.switchTo().window(current_window);
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);		
	}

	@Test//(dataProvider="username_and_password")
	@Given("each student logs into student login with valid {string} and {string} does payment to activate their profile")
	public void each_student_logs_into_student_login_and_does_payment_to_activate_their_profile(String uname,String pword) throws IOException, InterruptedException {
		
		openBrowser_student();
		stuentLogin(uname,pword);
		try {
		activateProfile();
		screenshot("successfully registered "+uname);
		System.out.println(uname+" profile activated successfully");
	//	driver.close();
		}
		catch(Exception e){
			screenshot("already registered "+uname);
		//	driver.close();
		//	System.out.println("oops!!!"+uname+" profile already activated");
			Assert.fail("oops!!! "+uname+" profile already activated");
		}
	}
}
