package pageObjectClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RediffForgetPasswordPage {
	WebDriver driver;
	//locators
	By btn_next=By.xpath("//input[@name='next']");
	//constructor
	public RediffForgetPasswordPage(WebDriver driver) {
		this.driver=driver;
	}
	//action methods
	public void clickNextButton() {
		driver.findElement(btn_next).click();
	}
	public void alerttext_ForgotPassword() {
		Alert alert=driver.switchTo().alert();
		   String act_text=	alert.getText();
		   String expt_text1="Please enter your email ID";
		   alert.accept();
	        if(expt_text1.equals(act_text))  System.out.println("Alert text of Frogot Password window-Test-2 Passed");
	    	else System.out.println("Alert text of Frogot Password window-Test-2 Failed");
	        driver.navigate().back();
		}
}
