package tests;

import java.util.Scanner;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTitleTestWithAnnotations2 
{
	//Declare global objects/properties
	String word;
	RemoteWebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void launchSite()
	{
		//Enter a word to search
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word to search");
		word=sc.nextLine();
		sc.close();
		//Launch browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//Launch site and maximize
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
	}
	
	@Test(priority=1)
	public void titleTest()
	{
		driver.findElement(By.name("q")).sendKeys(word,Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
		//Get the title and validate
		String title=driver.getTitle();
		if(title.contains(word))
		{
			Reporter.log("Title test passed");
			Assert.assertTrue(true);
		}
		else
		{
			Reporter.log("Title test failed");
			Assert.assertTrue(false);
		}
	}
	
	@AfterMethod
	public void closeSite()
	{
		//Close site
		driver.close();	
	}
}
