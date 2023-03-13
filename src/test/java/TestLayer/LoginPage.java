package TestLayer;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;

public class LoginPage extends BaseClass {

	@Test(groups = { "LoginPage" })
	public void loginFunctionality() {
		BaseClass.initialization();

		driver.findElement(By.name("username")).sendKeys("Admin");

		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();

	}

}
