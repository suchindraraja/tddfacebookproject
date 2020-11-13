package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUtility 
{
	public RemoteWebDriver driver;
	
	public TestUtility()
	{
		driver=null;
	}
	
	//Reusable methods
	//Without cross browser
	public RemoteWebDriver launchChromeBrowser()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
		driver=new ChromeDriver(co);
		return(driver);
	}
	//With cross browser
	public RemoteWebDriver launchBrowser(String bn)
	{
		if(bn.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--disable-notifications");
			driver=new ChromeDriver(co);
		}
		else if(bn.equalsIgnoreCase("firefox"))
		{
			//Add disable notifications code related to firefox
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(bn.equalsIgnoreCase("opera"))
		{
			//Add disable notifications code related to opera
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}
		else if(bn.equalsIgnoreCase("edge"))
		{
			//Add disable notifications code related to edge
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(bn.equalsIgnoreCase("ie"))
		{
			//Add disable notifications code related to ie
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Please enter correct browser name");
			System.exit(0);   //Stop execution forcibly
		}
		return(driver);
	}
	
	public void launchSite(String url)
	{
		//Launch Site and maximize
		driver.get(url);
		//driver.manage().window().maximize();
	}
	
	public Properties accessProperties() throws Exception
	{
		//Calling Properties
		File f1=new File("E:\\Automation\\AutomationNested\\com.pom.facebook\\src\\test\\resources\\properties\\config.properties");
		FileInputStream fi1=new FileInputStream(f1);
		Properties pro=new Properties();
		pro.load(fi1);
		return(pro);
	}
	
	public void closeSite()
	{
		//Close site
		driver.close();
	}
	
	public String screenshot() throws Exception
	{
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt=new Date();
		File src=driver.getScreenshotAs(OutputType.FILE);
		String ssname=sf.format(dt)+".png";
		File dest=new File(ssname);
		FileHandler.copy(src,dest);
		return(dest.getAbsolutePath());
	}
	
	public void headerFormat(Workbook wb,Sheet sh,int nouc)
	{
		//Font settings for Headings
		Font font1=wb.createFont();
		font1.setColor(IndexedColors.BLUE.getIndex());
	    font1.setItalic(true);
	    font1.setBold(true);
	    //Cell Style settings for Headings
		CellStyle cs1=wb.createCellStyle();
		cs1.setFont(font1);
		cs1.setAlignment(HorizontalAlignment.CENTER);
		sh.getRow(0).getCell(nouc).setCellStyle(cs1);
	}
	
	public void passResultFormat(Workbook wb,Sheet sh,int nouc,int i)
	{
		//Font settings for Headings
		Font font1=wb.createFont();
		font1.setColor(IndexedColors.GREEN.getIndex());
	    font1.setItalic(true);
	    font1.setBold(true);
	    //Cell Style settings for Headings
		CellStyle cs1=wb.createCellStyle();
		cs1.setFont(font1);
		cs1.setAlignment(HorizontalAlignment.CENTER);
		sh.getRow(i).getCell(nouc).setCellStyle(cs1);
	}
	
	public void failResultFormat(Workbook wb,Sheet sh,int nouc,int i)
	{
		//Font settings for Headings
		Font font1=wb.createFont();
		font1.setColor(IndexedColors.RED.getIndex());
	    font1.setItalic(true);
	    font1.setBold(true);
	    //Cell Style settings for Headings
		CellStyle cs1=wb.createCellStyle();
		cs1.setFont(font1);
		cs1.setAlignment(HorizontalAlignment.CENTER);
		sh.getRow(i).getCell(nouc).setCellStyle(cs1);
	}
}
