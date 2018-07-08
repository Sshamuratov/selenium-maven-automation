package com.jobapplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JobApplication {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();

		WebDriver chrome = new ChromeDriver();
		
		chrome.get("https://forms.zohopublic.com/murodil/form/JobApplicationForm/formperma/kOqgtfkv1dMJ4Df6k4_mekBNfNLIconAHvfdIk3CJSQ");
		
		chrome.findElement(By.xpath("//*[@id=\"Name-li\"]/div[1]/div/span[1]/input")).sendKeys("Sanjar");
		
		chrome.findElement(By.xpath("//*[@id=\"Name-li\"]/div[1]/div/span[2]/input")).sendKeys("Shamuratov");
		
		

		Thread.sleep(5000);
		chrome.close();

	}

}
