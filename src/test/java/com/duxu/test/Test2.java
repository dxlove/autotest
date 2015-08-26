package com.duxu.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {
	WebDriver driver;

	@Test
	public void f() {
		driver = new FirefoxDriver();
		driver.get("http://www.qq.com/"); // 打开一个网站

		driver.manage().window().maximize(); // 全屏

	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
