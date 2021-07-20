package test_cases;

import org.junit.Test;

import junit.framework.Assert;
import pages.CommunityPage;

@SuppressWarnings("deprecation")
public class LocationFiltering_v2 {

	CommunityPage filterLoc = new CommunityPage();
	
	@Test
	//here we created a negative test to make sure that the filter is working for picklist that aren't presented in the available list
	public void filterLocation() throws InterruptedException {
		filterLoc.navigateToSite();
		filterLoc.acceptCookies();
		String resultOfSearch = filterLoc.FilteringLocations("Italy");
		Assert.assertEquals("Italy", resultOfSearch);
		Thread.sleep(500);
	}
	
	@Test
	public void close(){
		filterLoc.close();
		System.out.println("Tested successfully");
	}
}
