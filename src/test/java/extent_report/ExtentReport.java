package extent_report;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	

	ExtentHtmlReporter  HTMLreport;
	ExtentReports extent;
	
	WebDriver driver = utilities.driverfactory.open("chrome");
	WebDriverWait wait2 = new WebDriverWait(driver, 10);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String siteURL = driver.getCurrentUrl();
	String siteTitle = driver.getTitle();
	
	SoftAssert SA = new SoftAssert();

	
	@BeforeSuite
	public void setup() {
		
		HTMLreport = new ExtentHtmlReporter("Report.html");
		extent = new ExtentReports();
		extent.attachReporter(HTMLreport);
		HTMLreport.config().setTheme(Theme.STANDARD);
		
		System.out.println("Initializing Test: Checklist #1 --> 3");
	}
	
	@BeforeMethod
	public void firststep() {
		String MeganCoreyShopURL = "http://vpw.45f.myftpupload.com/shop/";
		driver.manage().window().maximize();
		driver.get(MeganCoreyShopURL);	
		System.out.println("Running Test: Template Review");
	}
	
	
	@Test
	public void Test_Checklist_03() throws IOException {
		
		ExtentTest test = extent.createTest("TR: Checklist 3","Megan Corey URLs.");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//*[@id=\"top\"]")).sendKeys(Keys.ESCAPE);
		
		if(siteURL == siteURL.toLowerCase()) {
			test.log(Status.PASS, "PASSED: URL in Lower Case    |    " + driver.getTitle());
		}else if(siteURL == siteURL.toUpperCase()) {
			test.log(Status.FAIL, "FAILED: URL not in Lower Case    |    " + driver.getTitle() + "     |     " + driver.getCurrentUrl());
		}
			
		WebElement product_1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/main/div/ul/li[1]/div/a/div[2]/div[2]/div/h2"));
		
		js.executeScript("arguments[0].scrollIntoView();",product_1);
		js.executeScript("arguments[0].click();",product_1);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		if(siteURL == siteURL.toLowerCase()) {
			test.log(Status.PASS, "PASSED: URL in Lower Case    |    " + driver.getTitle());
		}else if(siteURL == siteURL.toUpperCase()) {
			test.log(Status.FAIL, "FAILED: URL not in Lower Case    |    " + driver.getTitle() + "     |     " + driver.getCurrentUrl());
		}
		
		driver.navigate().to("http://vpw.45f.myftpupload.com/cart/");;
		
		if(siteURL == siteURL.toLowerCase()) {
			test.log(Status.PASS, "PASSED: URL in Lower Case    |    " + driver.getTitle());
		}else if(siteURL == siteURL.toUpperCase()) {
			test.log(Status.FAIL, "FAILED: URL not in Lower Case    |    " + driver.getTitle() + "     |     " + driver.getCurrentUrl());
		}
		
		driver.navigate().to("http://vpw.45f.myftpupload.com/checkout/");

		if(siteURL == siteURL.toLowerCase()) {
			test.log(Status.PASS, "PASSED: URL in Lower Case    |    " + driver.getTitle());
		}else if(siteURL == siteURL.toUpperCase()) {
			test.log(Status.FAIL, "FAILED: URL not in Lower Case    |    " + driver.getTitle() + "     |     " + driver.getCurrentUrl());
		}
		
	}
	
	@Test
	public void Test_Checklist_19() {
		ExtentTest test = extent.createTest("TR: Checklist 19","Favicon test.");
		
		driver.navigate().to("http://vpw.45f.myftpupload.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//*[@id=\"top\"]")).sendKeys(Keys.ESCAPE);
		String PageSource = driver.getPageSource();
		
		if(PageSource.contains("apple-touch-icon-precomposed") || PageSource.contains("favicon")) {
			test.log(Status.PASS, "PASSED: Favicon is present.    |    " + driver.getTitle());
		}else{
			test.log(Status.FAIL, "FAILED: Favicon is not present    |    " + driver.getTitle() + "     |     " + driver.getCurrentUrl());
		}
	}
	
	@Test
	public void Test_Checklist_20() throws IOException {
		ExtentTest test = extent.createTest("TR: Checklist 20","Meta tag test.");
		
		driver.navigate().to("http://vpw.45f.myftpupload.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//*[@id=\"top\"]")).sendKeys(Keys.ESCAPE);
		
		String metaTag = driver.getPageSource();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		if(metaTag.contains("format-detection") && metaTag.contains("telephone") && metaTag.contains("no")) {
			test.log(Status.PASS, "PASSED: Phone number auto-detection is disabled.    |    " + driver.getTitle());
		}else{		
			String temp = utilities.utility.getScreenshot(driver);
			test.log(Status.FAIL,"YO DO NOTE PASS THIS TEST", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
	}
	
	@AfterSuite
	public void end() {
		
		extent.flush();
		
		System.out.println("===============================================");
		System.out.println("||        End of Test: Template Review       ||");
		System.out.println("===============================================");
		driver.close();
		driver.quit();	}
	
}
