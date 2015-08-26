package com.duxu.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {
	WebDriver driver;

	@Test
	public void f() {
		driver = new FirefoxDriver();
		driver.get("http://www.baidu.com/"); // 打开一个网站

		driver.manage().window().maximize(); // 全屏

		WebElement sinput = driver.findElement(By.id("kw"));
		sinput.sendKeys("自动化测试");

		WebElement sbtn = driver.findElement(By.id("su"));
		sbtn.click();
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
