package TestLayer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;

public class AdminPage extends BaseClass {

	@Test(priority = 1, groups = "AdminPage", dependsOnGroups = { "PIMPage" })
	public void verifyUserIsOnAdminPage() {
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		String a = driver.findElement(By.xpath("(//span[@class='oxd-topbar-header-breadcrumb']/h6)[1]")).getText();
		Assert.assertEquals(a, "Admin");
	}

	@Test(priority = 2, groups = "AdminPage", dependsOnGroups = { "PIMPage" })
	public void addNewUserInAdminPage() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();

		driver.findElement(By.xpath("(//div[text()='-- Select --'])[1]")).click();

		List<WebElement> ls = driver.findElements(By.xpath("//div[@role='listbox']/*"));

		for (WebElement abc : ls) {
			String a = abc.getText();
			System.out.println(a);

			if (a.equals("Admin")) {
				abc.click();
				break;
			}
		}

		System.out.println(ls.size());

		driver.findElement(By.xpath("(//label[text()='Employee Name']/following::div/input)[1]"))
				.sendKeys("Rajesh Patil");

		// driver.findElement(By.xpath("//label[text()='Status']/following::div[4]")).click();
		driver.findElement(By.xpath("//div[text()='-- Select --']")).click();

		Thread.sleep(5000);
		List<WebElement> ls1 = driver.findElements(By.xpath("//div[@role='listbox']/*"));

		for (WebElement abc : ls1) {
			String a = abc.getText();
			System.out.println(a);
			if (a.equals("Enabled")) {
				abc.click();
				break;
			}
		}

		driver.findElement(By.xpath("(//label[text()='Employee Name']/following::div/input)[2]"))
				.sendKeys("Rajesh123@gmail.com");

		driver.findElement(By.xpath("(//label[text()='Employee Name']/following::div/input)[3]"))
				.sendKeys("Rajesh123@gmail.com");

		driver.findElement(By.xpath("(//label[text()='Employee Name']/following::div/input)[4]"))
				.sendKeys("Rajesh123@gmail.com");

	}

}
