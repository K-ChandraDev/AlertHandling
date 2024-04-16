package testObjectClass;

import org.openqa.selenium.WebDriver;

import driverSetupPack.DriverSetUp;
import pageObjectClasses.RediffForgetPasswordPage;
import pageObjectClasses.RediffLoginPage;
import pageObjectClasses.RediffTabHandles;

public class RediffTest {
	public static WebDriver driver;	
	public static String browser="Chrome";
	public static DriverSetUp driversetup;
	public static RediffLoginPage rediffLoginPage;
	public static RediffTabHandles rediffTabHandles;
	public static RediffForgetPasswordPage rediffForgetPasswordPage;
	public static void driverconfig(String browser)
    {
	 	//Instantiate driver 
    	driver=DriverSetUp.driverInstantiate(browser);   
    }
	
	public void testLoginPage() {
		 rediffLoginPage=new RediffLoginPage(driver);
		 rediffLoginPage.clickLogin();
		 rediffLoginPage.alerttext_LoginWin();
		 rediffLoginPage.clickForgotPasswrod(); 
	}
	public void forgotPasswordPage() throws InterruptedException {
		rediffForgetPasswordPage=new RediffForgetPasswordPage(driver);
		rediffForgetPasswordPage.clickNextButton();
		
		rediffForgetPasswordPage.alerttext_ForgotPassword();
	}
	public void tabhandles() {
		rediffTabHandles=new RediffTabHandles(driver);
		rediffTabHandles.mainTabHandle();
		//click Privacy_policy link in login page
		rediffLoginPage.clickPrivacyPolicy();
		//Getting Window handles of both pages
		rediffTabHandles.checkNewTab(rediffTabHandles.windowHandles());
		//closing privacy_policy tab
		DriverSetUp.driverTearDown();
		//navigating tab to main tab
		rediffTabHandles.navigateTabBack();
		DriverSetUp.driverTearDown();
	}
	
	
   public static void main(String []args) throws InterruptedException {
	    RediffTest.driverconfig(browser);
	    RediffTest rediffTest=new RediffTest();
		rediffTest.testLoginPage();
		rediffTest.forgotPasswordPage();
		rediffTest.tabhandles();
	   
   }
}
