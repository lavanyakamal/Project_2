package Pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileActivationObjects {
	
	@FindBy(xpath="//*[text()='Activate your Account']")
	public static WebElement activate_account;
	
	@FindBy(id="rzp-button1")
	public static WebElement pay_now;
	
	@FindBy(xpath="//*[@method='netbanking']")//iframe
	public static WebElement payment;
	
	@FindBy(id="bank-item-ICIC")//iframe
	public static WebElement icici;
	
	@FindBy(xpath="//*[text()='Pay ₹ 100'][2]")//iframe
	public static WebElement pay;
	
	@FindBy(xpath="//*[text()='Success']")//new window
	public static WebElement success;


}
