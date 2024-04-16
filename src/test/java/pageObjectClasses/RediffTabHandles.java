package pageObjectClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class RediffTabHandles {
     WebDriver driver;
     String loginWinHandle;
     
     public RediffTabHandles(WebDriver driver){
    	 this.driver=driver;
     }
     public void  mainTabHandle(){
    	 loginWinHandle= driver.getWindowHandle(); 
     }
     
     public List<String> windowHandles(){
    	 Set<String>windowHandles=driver.getWindowHandles();
    	 List<String> listWinHandles=new ArrayList<String>(windowHandles);
    	 
    	 return listWinHandles;
     }
    
     public void checkNewTab(List<String> winHandles) {
    	 for(String h:winHandles) {
         	String title=driver.switchTo().window(h).getTitle();
            if(title.equals("Welcome to rediff.com")) {
         	  System.out.println("Opened in new window-Test-3 passed");
         	  break;
            } 
    	 }
     }
     public void navigateTabBack(){
    	 driver.switchTo().window(loginWinHandle);
     }
     
}