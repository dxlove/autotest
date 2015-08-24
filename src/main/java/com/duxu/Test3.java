package com.duxu;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test3 {
	public static void main(String[] args) throws Exception {
		// WebDriver driver = new FirefoxDriver(); // 建一个浏览器
		System.setProperty("webdriver.chrome.driver",
				"E:/Users/Administrator/workspace/autotest/driver/chromedriver.exe");

		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(
						new File(
								"E:/Users/Administrator/workspace/autotest/driver/chromedriver.exe"))
				.usingAnyFreePort().build();
		service.start();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.ppmoney.com/"); // 打开一个网站
		driver.manage().window().maximize(); // 全屏
		WebElement regLink = driver.findElement(By.linkText("立即登录"));
		regLink.click();

		WebElement Phone = driver.findElement(By.name("Phone"));
		Phone.sendKeys("18665304516");
		WebElement Password = driver.findElement(By.id("Password"));
		Password.sendKeys("dx123456");

		WebElement sendRegister = driver.findElement(By.id("sendLogin"));
		sendRegister.click();
		
		Actions builder = new Actions(driver);   
	    builder.moveToElement(driver.findElement(By.partialLinkText("投资理财"))).perform();   

		WebElement test1 = driver.findElement(By.partialLinkText("活期理财"));
		test1.click();
		
		Select selectAge = new Select(driver.findElement(By.id("User_Age")));
	    
		//driver.close();
		service.stop();
	}
}
