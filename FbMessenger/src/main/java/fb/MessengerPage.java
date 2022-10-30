package fb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessengerPage {
	
	@FindBy (xpath="(//a[@class='_4vo5'])[1]")
	private WebElement rooms;
	
	public MessengerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Rooms()
	{
		rooms.click();
	}
	

}
