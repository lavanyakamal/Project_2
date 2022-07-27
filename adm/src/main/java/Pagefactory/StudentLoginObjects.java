package Pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentLoginObjects {
	
	@FindBy(id="login-student-id")
	public static WebElement studentid;
	
	@FindBy(id="login-mobile")
	public static WebElement password;
	
	@FindBy(xpath="//*[text()='Log in']")
	public static WebElement log_in;
	
	@FindBy(xpath="//*[@id='test_otp']")
	public static WebElement otp_read;
	
	@FindBy(id="login-otp")
	public static WebElement otp_write;
	
	@FindBy(xpath="//*[text()='Submit']")
	public static WebElement submit;

}
