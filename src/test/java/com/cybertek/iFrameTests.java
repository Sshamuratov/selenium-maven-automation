package com.cybertek;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class iFrameTests extends TestBase {
	
	
	@Test
	public void iFrameTest() {
		driver.get("http://the-internet.herokuapp.com/iframe");
		
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
	
	}
	
	
	
	

}
