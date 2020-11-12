package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FBHomepage 
{
	public RemoteWebDriver driver;
	
	@FindBy(how=How.XPATH,using="//*[@aria-label='Account']")
	public WebElement profile_pic;
	
	@FindBy(how=How.XPATH,using="//*[text()='Log Out']")
	public WebElement logout;
	
	public FBHomepage(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void profilePicClick()
	{
		profile_pic.click();
	}
	
	public void logoutClick()
	{
		logout.click();
	}
}
