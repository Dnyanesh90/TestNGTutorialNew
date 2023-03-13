package TestLayer;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;

public class HomePage extends BaseClass {

	@Test(groups = { "HomePage" }, dependsOnGroups = { "LoginPage" })
	public void validateHomePageTitle() {
		String a = driver.getTitle();
		Assert.assertEquals(a, "OrangeHRM");
	}

	@Test(priority = 1, groups = { "HomePage" }, dependsOnGroups = { "LoginPage" })
	public void validateHomePageUrl() {
		String b = driver.getCurrentUrl();
		// boolean c = b.contains("orangehrm");
		// Assert.assertEquals(c, true);
		Assert.assertEquals(b.contains("orangehrm"), true);
	}

	@Test(priority = 2, groups = { "HomePage" }, dependsOnGroups = { "LoginPage" })
	public void validateHomePageLogo() {
		boolean d = driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed();

		Assert.assertEquals(d, true);
		// Assert.assertTrue(d);
	}

}
