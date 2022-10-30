package testpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import fb.LoginPage;
import fb.MessengerPage;
import fb.RoomsPage;

public class Test1 {
	
	private WebDriver driver;
	private LoginPage login;
	private MessengerPage messenger;
	private RoomsPage rooms;
	@Parameters("browser")
	@BeforeTest
	public void launchbrowser1(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\AKSHAY\\VELOCITY\\AUTOMATION\\SELENIUM SERVER\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		
		if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\AKSHAY\\VELOCITY\\AUTOMATION\\SELENIUM SERVER\\geckodriver.exe");
			
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void createPOMobject1()
	{
		login=new LoginPage(driver);
		
		messenger=new MessengerPage(driver);
		
		rooms=new RoomsPage(driver);
	}
	
	@BeforeMethod
	public void gotoRoomsPage1()
	{
		driver.get("https://www.facebook.com/");
				
		login.Messenger();
				
		messenger.Rooms();
	}
	@Test 
	public void returntomessenger1()
	{		
		rooms.Returntomessenger();
		
		String URL=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		Assert.assertEquals(URL, "https://www.messenger.com/");
		
		Assert.assertEquals(title, "Messenger");
	}
	
	@Test 
	public void visittohelpcenter1()
	{		
		rooms.Visitohelpcenter();
		
		String URL=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		Assert.assertEquals(URL, "https://www.messenger.com/help");
		
		Assert.assertEquals(title, "Messenger Help Centre");
	}
	
	@AfterMethod
	public void status1()
	{
		System.out.println("succesfully run");
	}
	
	@AfterClass
	public void removeobjects1()
	{
		login=null;
		messenger=null;
		rooms=null;		
	}
	
	@AfterTest
	public void closebrowser1()
	{
		driver.close();
		driver=null;
		System.gc();		
	}

}


