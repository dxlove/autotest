package com.duxu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test5 {

	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver",
				"E:/Users/Administrator/workspace/autotest/driver/chromedriver_x64.exe");
		WebDriver webDriver = new ChromeDriver();
		webDriver
				.get("http://list.jd.com/9987-653-655-0-0-0-0-0-0-0-1-1-1-1-1-72-4137-33.html");
		webDriver.manage().window().maximize(); // 全屏
		WebElement webElement = webDriver.findElement(By
				.xpath("//div[@id='plist']"));

		System.out.println(webElement.getAttribute("outerHTML"));

		WebElement li = webElement.findElement(By.xpath("//li[1]"));

		String name = li.findElement(
				By.xpath("//li[1]//div[@class='p-name']/a")).getText();
		System.out.println("商品名:" + name);

		String price = li.findElement(
				By.xpath("//li[1]//div[@class='p-price']/strong")).getText();
		System.out.println("价格:" + price);

		String eva = li
				.findElement(
						By.xpath("//li[1]//div[@class='p-commit']/strong/a[@target='_blank']"))
				.getText();
		System.out.println("评价:" + eva);

		webDriver.close();
	}
}
