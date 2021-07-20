package pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseClass {
	
	WebDriver driver;

	
	public BaseClass() {
		System.setProperty("webdriver.chrome.driver", "c:\\Users\\The_Kraken\\IdeaProjects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		this.driver = driver;
		driver.manage().window().maximize();
		
	}
	
	@Before
	public void pageSetup(){
		driver.manage().window().maximize();
		
	}
	
	@After
	public void close()  {
		driver.close();
	}
}
