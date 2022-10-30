package testpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import fb.LoginPage;
import fb.MessengerPage;
import fb.RoomsPage;

public class VerifyReturnToMessengerPage {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","E:\\AKSHAY\\VELOCITY\\AUTOMATION\\SELENIUM SERVER\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginPage login=new LoginPage(driver);
				
		login.Messenger();
		
		MessengerPage messenger=new MessengerPage(driver);
		
		messenger.Rooms();
		
		RoomsPage rooms=new RoomsPage(driver);
		
		rooms.Returntomessenger();
		
		driver.quit();
	
	}

}
