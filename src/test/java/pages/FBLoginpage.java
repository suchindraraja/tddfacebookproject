package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FBLoginpage
{
	public RemoteWebDriver driver;
	
	@FindBy(how=How.NAME,using="email")
	public WebElement emailaddress;
	
	@FindBy(how=How.NAME,using="pass")
	public WebElement pass;
	
	@FindBy(how=How.NAME,using="login")
	public WebElement loginbtn;
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),\"email address or phone number that you've entered doesn't match\")]")
	public WebElement blank_and_nondomain_email_address_err;
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),\"email address that you've entered doesn't match\")]")
	public WebElement invalid_email_address_err;
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),\"password that you've entered is incorrect\")]")
	public WebElement blank_and_invalid_pass;
	
	public FBLoginpage(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void emailAddressFill(String x)
	{
		emailaddress.sendKeys(x);
	}
	
	public void passFill(String x)
	{
		pass.sendKeys(x);
	}
	
	public void loginbtnClick()
	{
		loginbtn.click();
	}
}
