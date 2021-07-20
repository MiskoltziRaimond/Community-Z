package test_cases;

import org.junit.Test;

import junit.framework.Assert;
import pages.CommunityPage;

@SuppressWarnings("deprecation")
public class LocationFiltering {

	CommunityPage filterLoc = new CommunityPage();
	
	@Test
	public void filterLocation() throws InterruptedException {
		filterLoc.navigateToSite();
		filterLoc.acceptCookies();
		String resultOfSearch = filterLoc.FilteringLocations("Hungary");
		Assert.assertEquals("Hungary", resultOfSearch);
		Thread.sleep(500);
	}
	
	@Test
	public void close(){
		filterLoc.close();
		System.out.println("Tested successfully");
	}
}
