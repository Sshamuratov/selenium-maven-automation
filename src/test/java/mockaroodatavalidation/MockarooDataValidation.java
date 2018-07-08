package mockaroodatavalidation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MockarooDataValidation {
	WebDriver driver;
	JavascriptExecutor js;
	BufferedReader bread;
	
	

	@BeforeClass
	public void classSetup() throws FileNotFoundException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		bread  = new BufferedReader(new FileReader("C:\\Users\\bzikb\\Downloads\\MOCK_DATA.CSV"));

		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void mainTest() throws InterruptedException, IOException {
		driver.get("https://mockaroo.com/");

		String expected = "Mockaroo - Random Data Generator and API Mocking Tool | JSON / CSV / SQL / Excel";
		String actual = driver.getTitle();
		assertEquals(actual, expected);
		assertTrue(driver.findElement(By.xpath("//div[@class='brand']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='tagline']")).isDisplayed());
		removeXfields();
		assertTrue(driver.findElement(By.xpath("//div[@class='column column-header column-name']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='column column-header column-type']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[@class='column column-header column-options']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//a[.='Add another field']")).isEnabled());

		String numberOfRows = "1000";
		String actualNumberOfRows = driver.findElement(By.xpath("//input[@id='num_rows']")).getAttribute("value");
		assertEquals(actualNumberOfRows, numberOfRows);

		String expected2 = "CSV";
		String actual2 = driver.findElement(By.xpath("//select[@id='schema_file_format']/option[1]")).getText();
		assertEquals(actual2, expected2);

		String expected3 = "Unix (LF)";
		String actual3 = driver.findElement(By.xpath("//select[@id='schema_line_ending']/option[1]")).getText();
		assertEquals(actual3, expected3);
		assertTrue(driver.findElement(By.xpath("//input[@id='schema_include_header']")).isSelected());

		assertFalse(driver.findElement(By.xpath("//input[@id='schema_bom']")).isSelected());

		System.out.println("Searching for city");

		driver.findElement(By.xpath("//a[@class='btn btn-default add-column-btn add_nested_fields']")).click();

		driver.findElement(By.xpath("(//input[@placeholder='enter name...'])[7]")).sendKeys("city");

		driver.findElement(By.xpath("//*[@id=\"fields\"]/div[7]/div[3]/input[3]")).click();

		assertTrue(driver.findElement(By.xpath("//*[@id=\"type_dialog_wrap\"]")).isDisplayed());
		driver.findElement(By.xpath("//*[@id=\"type_search_field\"]")).sendKeys("city");
		driver.findElement(By.xpath("//*[@id=\"type_list\"]/div/div[1]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[@class='btn btn-default add-column-btn add_nested_fields']")).click();
		driver.findElement(By.xpath("(//input[@placeholder='enter name...'])[8]")).sendKeys("country");
		driver.findElement(By.xpath("//*[@id=\"fields\"]/div[8]/div[3]/input[3]")).click();
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.xpath("//*[@id=\"type_dialog_wrap\"]")).isDisplayed());
		driver.findElement(By.xpath("//*[@id=\"type_search_field\"]")).sendKeys("country");
		driver.findElement(By.xpath("//*[@id=\"type_list\"]/div[1]/div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

		String city = ""
				+ driver.findElement(By.xpath("(//input[@placeholder='enter name...'])[7]")).getAttribute("value");
		String country = ""
				+ driver.findElement(By.xpath("(//input[@placeholder='enter name...'])[8]")).getAttribute("value");
		String cityAndCountry = city + "," + country;

		assertEquals(bread.readLine(), cityAndCountry);

		assertEquals(brCount(), 1000);

		System.out.println(addingCities().get(5));
		System.out.println(addingCountries().get(5));

	}

	public void removeXfields() {
		for (int i = 1; i <= 6; i++) {
			driver.findElement(By.xpath("//*[@id=\"fields\"]/div[" + i + "]/div[5]/a")).click();
		}

	}

	public int brCount() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\bzikb\\Downloads\\MOCK_DATA.CSV"));

		int count = 0;

		while (br.readLine() != null) {
			count++;
		}
		return count;

	}

	public ArrayList<String> addingCities() throws IOException {
		BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\bzikb\\Downloads\\MOCK_DATA.CSV"));

		ArrayList<String> cityList = new ArrayList<>();

		String cities = "";

		while ((cities = br2.readLine()) != null) {
			
			cityList.add(cities.substring(0, cities.indexOf(",")));
		}
		return cityList;

	}
	
	public ArrayList<String> addingCountries() throws IOException {
		BufferedReader br3 = new BufferedReader(new FileReader("C:\\Users\\bzikb\\Downloads\\MOCK_DATA.CSV"));

		ArrayList<String> countryList = new ArrayList<>();

		String countries = "";

		while ((countries = br3.readLine()) != null) {
			
			countryList.add(countries.substring(countries.indexOf(",")+1));
		}
		return countryList;

	}

}
