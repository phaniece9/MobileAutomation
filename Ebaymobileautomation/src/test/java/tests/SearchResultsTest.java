package tests;

import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidKeyCode;

import org.testng.annotations.Test;

import pages.BasePage;
import pages.SearchResultPage;
import com.basesetup.BaseSetup;

public class SearchResultsTest extends BaseSetup {
	BasePage basepage;
	LoginTest loginTest;
	SearchResultPage searchResult;
	
	
	BaseSetup bs;
	Properties obj=new Properties();
	
	@Test
	public void searchAProduct() throws Exception{
		loginTest.login();
		basepage.searchFld.isDisplayed();
		basepage.searchFld.sendKeys(obj.getProperty("tvsearch"));
		
		//moving down
		
		((AndroidDeviceActionShortcuts) bs).pressKeyCode(AndroidKeyCode.ACTION_DOWN);
		Thread.sleep(1000);
		
		((AndroidDeviceActionShortcuts) bs).pressKeyCode(AndroidKeyCode.ENTER);
		//select sort
		searchResult.sortby.click();
		
		bs.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//select filter
		searchResult.filter.click();
		bs.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//select price range
		searchResult.pricerange.click();
		
		bs.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		searchResult.done.click();
		bs.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		searchResult.select.click();
		
		
}
	
	@Test
	public void searchAProductAndPurchase() throws Exception{
		searchAProduct();
		
		searchResult.review.click();
		
		searchResult.buyNowBtn.isDisplayed();
		searchResult.buyNowBtn.click();
		searchResult.proceedToPayBtn.isDisplayed();
		searchResult.proceedToPayBtn.click();
}
	
}
