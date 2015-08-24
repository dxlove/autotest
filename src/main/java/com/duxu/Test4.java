package com.duxu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test4 {
	public static void main(String[] args) {
		//WebDriver driver = new FirefoxDriver(); // 建一个浏览器
		System.setProperty("webdriver.chrome.driver", "E:/Users/Administrator/workspace/autotest/driver/chromedriver_x64.exe"); 
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://123.56.119.63:8888/project"); // 打开一个网站
		driver.manage().window().maximize(); // 全屏
		/*
		 * WebElement regLink = driver.findElement(By.linkText("注册"));
		 * regLink.click();
		 */

		WebElement loginName = driver.findElement(By.name("loginName"));
		loginName.sendKeys("dxlove");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("dxlove");

		WebElement submit = driver.findElement(By.id("loginform"));
		submit.submit();
		
		WebElement managerLink = driver.findElement(By.linkText("后台管理"));
		managerLink.click();
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				System.out.println(d.getPageSource());
				return d.findElement(By.linkText("添加产品")).getText()
						.startsWith("添加产品");
			}

		});
		
		WebElement editgoodLink = driver.findElement(By.linkText("添加产品"));
		editgoodLink.click();

		driver.quit();
	}
}
