package com.duxu;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Test1 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new FirefoxDriver(); // 建一个浏览器
		driver.get("http://www.heshidai.com/"); // 打开一个网站

		driver.manage().window().maximize(); // 全屏

		WebElement btn = driver.findElement(By.linkText("立即登录")); // 点击页面上面那个 键连
																	// 登陆
		btn.click();

		WebElement inputphone = driver.findElement(By.id("phone")); // 填写用户密码
		inputphone.sendKeys("18665304516");
		WebElement inputpwd = driver.findElement(By.id("pwd"));
		inputpwd.sendKeys("dx123456");

		WebElement loginbtn = driver.findElement(By.id("btn_login_phone")); // 点击登陆
		loginbtn.click();

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				// return d.getTitle().toLowerCase().startsWith("cheese!");
				System.out.println(d.findElement(By.id("home_a")).getText());
				System.out.println(d.getPageSource());
				return d.findElement(By.id("home_a")).getText()
						.startsWith("进入我的账户");
			}

		});

		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(String
				.format("Domain -> name -> value -> expiry -> path"));
		for (Cookie c : cookies)
			System.out.println(String.format("%s -> %s -> %s -> %s -> %s",
					c.getDomain(), c.getName(), c.getValue(), c.getExpiry(),
					c.getPath()));

		WebElement apoint = driver.findElement(By.id("point")); // 点击签到
		apoint.click();

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("alert('ok')");
		 * 
		 * Alert alert = driver.switchTo().alert();
		 * 
		 * System.out.println(alert.getText()); alert.accept();
		 */

		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File("capture/"
				+ getCurrentDateTime() + ".jpg"));

		// driver.close();
		driver.quit();
	}

	public static String getCurrentDateTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");// 设置日期格式
		// System.out.println(df.format(new Date()));
		return df.format(new Date());
	}
}
