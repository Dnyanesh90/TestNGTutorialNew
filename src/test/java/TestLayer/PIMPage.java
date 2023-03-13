package TestLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;

public class PIMPage extends BaseClass {
	String empid;

	@Test(priority = 1, groups = { "PIMPage" }, dependsOnGroups = { "HomePage" })
	public void validateUserIsOnPIMPage() {
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		String a = driver.getCurrentUrl();
		Assert.assertEquals(a.contains("pim"), true);
	}

	@Test(priority = 2, groups = { "PIMPage" }, dependsOnGroups = { "HomePage" })
	public void addNewUser() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		driver.findElement(By.name("firstName")).sendKeys("Rajesh");
		driver.findElement(By.name("lastName")).sendKeys("Patil");
		empid = driver.findElement(By.xpath("//label[text()='Employee Id']/following::div/input"))
				.getAttribute("value");
		System.out.println(empid);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
	}

	@Test(priority = 3, groups = { "PIMPage" }, dependsOnGroups = { "HomePage" })
	public void addMorePersonalDetails() throws InterruptedException {
		Thread.sleep(4000);

		WebElement wb = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='RP';", wb);

		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]")).sendKeys("1234567890");

		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[6]")).sendKeys("19090990");

		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[7]")).sendKeys("AAAA990");

		// driver.findElement(By.xpath("(//div[@class='oxd-select-text
		// oxd-select-text--active'])[2]")).click();
		Thread.sleep(4000);
		// driver.findElement(By.xpath("//div[text()='Married']")).click();

		WebElement male = driver.findElement(By.xpath("//input[@value='1']"));

		js.executeScript("arguments[0].click();", male);

		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
	}

	@Test(priority = 3, groups = { "PIMPage" }, dependsOnGroups = { "HomePage" })
	public void searchEmployeeUsingEmpId() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();

		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(empid);

		driver.findElement(By.xpath("//button[text()=' Search ']")).click();
		
		Thread.sleep(5000);
	}

	@Test(priority = 4, groups = { "PIMPage" }, dependsOnGroups = { "HomePage" })
	public void deleteEmployeeFunctionality() throws InterruptedException
	{
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']")).click();
		
		//driver.findElement(By.xpath("//button[text()=' Delete Selected ']")).click();
		
		Thread.sleep(8000);
		driver.findElement(By.xpath("//button[text()=' No, Cancel ']")).click();
		
		
	}
	
	
}
