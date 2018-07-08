package practices;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadWebTables {
	
	
	
	String url = "file:///C:/Users/bzikb/Desktop/HTML/webtable.html";
	WebDriver driver;
	
	
	@BeforeClass
	public void classSetup() throws FileNotFoundException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void readScores() {
		WebElement table = driver.findElement(By.tagName("table"));
		System.out.println(table.getText());
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='worldcup']/tbody/tr"));
		System.out.println(rows.size());
		List<WebElement> headers = driver.findElements(By.xpath("//table/thead/tr/th"));
		System.out.println(headers.size());
		
		


	}
	
	

}
