package webelement;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElements {
	WebDriver driver;

	@BeforeClass
	public void classSetup() throws FileNotFoundException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void myLinks() throws InterruptedException {
		driver.get("https://github.com");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		List<String> Arrlst = new ArrayList<>();
		int numberOfLinks = links.size();
		System.out.println(numberOfLinks);
		for (WebElement webElement : links) {
			if(webElement.getText().isEmpty()) {
				continue;
			}
			Arrlst.add(webElement.getText());
			
		}
		
		System.out.println(Arrlst);
		System.out.println(Arrlst.size());
		
		Thread.sleep(5000);
		
	}
	
	@Test
	public void findAll() {
		driver.get("https://forms.zohopublic.com/murodil/form/SeleniumWebElements/formperma/eCecYgX4WMcmjxvXVq6UdhA2ABXIoqPAxnAF8H8CCJg");
		List<WebElement> inputBoxes = driver.findElements(By.xpath("//input[@type='text']"));
		List<WebElement> dropDownBoxes = driver.findElements(By.tagName("select"));
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		
		assertEquals(inputBoxes.size(),2);
		assertEquals(dropDownBoxes.size(),3);
		assertEquals(checkBoxes.size(),9);
		assertEquals(radioButtons.size(),9);
		assertEquals(buttons.size(),1);
	}

}
