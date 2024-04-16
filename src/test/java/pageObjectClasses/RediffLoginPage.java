package pageObjectClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RediffLoginPage {
WebDriver driver;
	
	//constructor
	public RediffLoginPage(WebDriver driver){
		this.driver=driver;
	}
    // locators
	By btn_login=By.xpath("//input[@name='proceed'][@class='signinbtn']");
	By link_forgotPassword=By.xpath("//span[@class='forgotlink']//a"); 
	By link_privacyPolicy=By.xpath("//a[contains(.,'Privacy Policy')]");
	//Action Methods
	
	public void clickLogin() {
		driver.findElement(btn_login).click();
	}
	public void clickForgotPasswrod() {
		driver.findElement(link_forgotPassword).click();;
	}
	public void clickPrivacyPolicy() {
		driver.findElement(link_privacyPolicy).click();
	}
	public void alerttext_LoginWin() {
		Alert alert=driver.switchTo().alert();
		   String act_text=	alert.getText();
		   String expt_text="Please enter a valid user name";
		   alert.accept();
	        if(expt_text.equals(act_text))  System.out.println("Alert text of Login window-Test-1 Passed");
	    	else System.out.println("Alert text of Login window-Test-1 Failed");
		}
	

}
