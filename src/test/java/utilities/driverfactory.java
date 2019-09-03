package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverfactory {
	
	public static WebDriver open(String browsertype) {
		
		if(browsertype.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Christian\\Documents\\Projects\\Selenium Test\\Demo Selenium\\Software\\chromedriver.exe");
			return new ChromeDriver();		
		}
		
		else if(browsertype.equalsIgnoreCase("mozilla")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Christian\\Documents\\Projects\\Selenium Test\\Demo Selenium\\Software\\geckodriver.exe");
			return new FirefoxDriver();
		}
		
		else if(browsertype.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver","C:\\Users\\Christian\\Documents\\Projects\\Selenium Test\\Demo Selenium\\Software\\msedgedriver.exe");
			return new EdgeDriver();
		}
		
		return null;		
	}

}
