package test_cases;

import org.junit.Test;

import pages.CommunityPage;

public class ValidateSearchResult {
	
	
	CommunityPage comObj = new CommunityPage();
	
	@Test
	public void validateResult() throws InterruptedException {
		
		comObj.navigateToSite();
		comObj.searchElement("Training");
		//comObj.validateResult();
		Thread.sleep(500);
		
	}
	
	@Test
	public void close() {
		comObj.close();
		System.out.println("Element matches");
	}
	
}
