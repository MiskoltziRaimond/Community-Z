package test_cases;

import org.junit.Test;
import pages.CommunityPage;

public class RejectCookies {

CommunityPage comObject = new CommunityPage();
	
	@Test
	public void rejectCookie() throws InterruptedException {
		comObject.navigateToSite();
		comObject.rejectCookies();
		Thread.sleep(500);
		
	}
	@Test
	public void close() {
		comObject.close();
		System.out.println("Cookies Rejected");
	}

	
}
