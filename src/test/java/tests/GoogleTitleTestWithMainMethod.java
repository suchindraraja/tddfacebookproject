package tests;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTitleTestWithMainMethod 
{
	public static void main(String[] args) throws Exception
	{
		//Enter a word to search
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word to search");
		String word=sc.nextLine();
		sc.close();
		//Launch browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site and maximize
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.findElement(By.name("q")).sendKeys(word,Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
		//Get the title and validate
		String title=driver.getTitle();
		if(title.contains(word))
		{
			System.out.println("Title test passed");
		}
		else
		{
			System.out.println("Title test failed");
		}
		//Close site
		driver.close();
	}
}
