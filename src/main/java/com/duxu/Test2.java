package com.duxu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver(); // 建一个浏览器
		driver.get("http://www.baidu.com/"); // 打开一个网站
		
		driver.manage().window().maximize(); // 全屏
		
		WebElement sinput = driver.findElement(By.id("kw"));
		sinput.sendKeys("自动化测试");
		
		WebElement sbtn = driver.findElement(By.id("su"));
		sbtn.click();
		
		driver.quit();
	}

}
