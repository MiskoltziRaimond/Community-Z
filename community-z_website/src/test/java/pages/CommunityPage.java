package pages;


import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;


public class CommunityPage extends BaseClass {
	
	WebDriver driver;
	//The Xpath location for the search field
	By searchBox = By.xpath("//*[@id=\"agenda_filters\"]/div/div/div[1]/div/div/div[1]/div/input");
	//The xpath location for the Accept Cookies button
	By acceptBtn = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
	//The xpath location for the Reject Cookies button
	By rejectCookies = By.xpath("//*[@id=\"onetrust-reject-all-handler\"]");
	//The cssSelector for the search field and dropdown list under the Location Button
	By filterLocation = By.cssSelector(".show .evnt-filter-menu-items-wrapper [data-group]:nth-child(1)");
	//The Id for the Location button
	By location = By.id("filter_location");
	//Searching for the locations by the given cssSelector
	By searchLocation = By.cssSelector(".dropdown.show .evnt-search");
	//The xpath for the Hungarian value
	By selectedCheckBox = By.xpath("//label[contains(text(),'gary')]");
	
	public CommunityPage () {
		this.driver = super.driver;
	}
	
	public void navigateToSite() {
		driver.get("https://community-z.com/communities");
	}
	
	public void searchElement(String text) {
		driver.findElement(searchBox).sendKeys(text);
	}
	
	public String FilteringLocations(String Country) {
		
		WebDriverWait wait = new WebDriverWait(driver,15);
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable((By)location));
		webElement.click();
		
		webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchLocation));
		webElement.sendKeys(Country);
		
		webElement = wait.until(ExpectedConditions.elementToBeClickable((By)filterLocation));
		return webElement.getText();
		
//		webElement = wait.until(ExpectedConditions.elementToBeClickable((By)selectedCheckBox));
//		webElement.click();
		
	}
	
	//Validation for the search result
	@SuppressWarnings("deprecation")
	public void validateResult() {
		String searchElem = "Training";
		//Collect all the results for after the word placed in the search field
		List<WebElement> results = driver.findElements(searchBox);
		for (int i = 0; i < results.size(); i++) {
			Assert.assertEquals(results.get(i).getText().contains(searchElem), "Search result validation failed at instance [ + i + ].");
		}
		
	}
	//Method for accepting the Cookies pop-up at the bottom page 
	public void acceptCookies() {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable((By)acceptBtn));
		webElement.click();
		
		//Search for an accepted cookie
		Set<Cookie> ck = driver.manage().getCookies();
		System.out.println(ck.toString());
		Cookie ckList = driver.manage().getCookieNamed("OptanonAlertBoxClosed");
		ckList.getDomain();
		ckList.getExpiry();
		ckList.getName();
	}
	
	//Reject the Cookie pop-up
	public void rejectCookies() {
		WebDriverWait wait = new WebDriverWait(driver,15);
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable((By)rejectCookies));
		webElement.click();
	}
	
}
