package test_cases;

import org.junit.Test;
import pages.CommunityPage;

public class AcceptCookies {
	
	CommunityPage comObject = new CommunityPage();
	
	@Test
	public void acceptCookies() throws InterruptedException {
		comObject.navigateToSite();
		comObject.acceptCookies();
		Thread.sleep(500);
		
	}
	@Test
	public void close() {
		comObject.close();
		System.out.println("Cookies Accepted");
	}

}
