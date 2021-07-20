package test_cases;

import org.junit.After;
import org.junit.Test;
import pages.CommunityPage;

public class HomePageTest  {
	
	CommunityPage searchObject = new CommunityPage();
	
	@Test
	public void searchingElements() throws InterruptedException{
	
		searchObject.navigateToSite();
		searchObject.searchElement("java");
		Thread.sleep(500);
			
	}
	@Test
	public void close() {
		searchObject.close();
		System.out.println("Tested successfully");
	}
	
	//A negative test which covers that only letters can be placed in the searching field
//	@Test
//	public void searchingElements2() throws InterruptedException{
//	
//		searchObject.navigateToSite();
//		searchObject.searchElement("1212@#!");
//		Thread.sleep(500);
//			
//	}
	
//	@Test
//	public void close() {
//		searchObject.close();
//		System.out.println("Test failed");
//	}
}
