package com.cybertek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

public class Batch8 {
	public static void main(String[] args) {
		
		
//		Faker faker = new Faker();
//		
//		String creditCard = faker.chuckNorris().fact();
//		
//		System.out.println(creditCard);
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bzikb\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://dice.com");
		
		String expected = "https://www.dice.com/";
		String actual = driver.getCurrentUrl();
		
		
		
		
		
		
		
	}
	
	

}
