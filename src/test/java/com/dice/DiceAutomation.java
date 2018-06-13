package com.dice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceAutomation {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = "https://dice.com";
		driver.get(url);

		String actualTitle = driver.getTitle();
		String expectedTitle = "Job Search for Technology Professionals | Dice.com";

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Step PASS. Dice homepage successfully loaded");

		} else {
			System.out.println("Step FAIL. Dice homepage did not load successfully");
			throw new RuntimeException("Step FAIL. Dice homepage did not load successfully");
		}

		String keyword = "java developer";

		driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);

		String location = "22102";

		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		driver.findElement(By.id("findTechJobs")).click();

		String count = driver.findElement(By.id("posiCountId")).getText();

		System.out.println(count);

		double countResult = Integer.parseInt(count.replaceAll(",", ""));

		if (countResult > 0) {
			System.out.println("Step PASS: Keyword: " + keyword + "search returned " + 
		countResult + " results in " + location);

		} else {
			System.out.println("Step FAIL: Keyword: " + keyword + " search returned " + 
					countResult + " results in " + location);
		}
		
		
		driver.close();
		
		System.out.println("TEST COMPLETED   " +   LocalDateTime.now());
		
	}
	
	

}
