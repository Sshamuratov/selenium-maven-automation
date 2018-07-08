package pomdesign;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AllOrdersPage;
import pages.WebOrdersLoginPage;

public class WebOrderTests {

	WebDriver driver;
	WebOrdersLoginPage loginPage;
	AllOrdersPage allOrdersPage;
	String userId = "Tester";
	String password = "test";

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@BeforeMethod
	public void setUpApplication() {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

	}

	@Test(description = "Verify labels and tab links are displayed")
	public void labelsVerification() {
		assertEquals(driver.getTitle(), "Web Orders Login");

		loginPage = new WebOrdersLoginPage(driver);

//		loginPage.userName.sendKeys(userId);
//		loginPage.password.sendKeys(password);
//		loginPage.loginButton.click();
		loginPage.login(userId, password);
		

		allOrdersPage = new AllOrdersPage(driver);

		assertTrue(allOrdersPage.WebOrdersText.isDisplayed());
		assertTrue(allOrdersPage.listOfAllOrders.isDisplayed());
		assertEquals(allOrdersPage.welcomeMsg.getText().replace(" | Logout", ""), "Welcome, " + userId + "!");
		assertTrue(allOrdersPage.ViewAllOrders.isDisplayed());
		assertTrue(allOrdersPage.viewallproducts.isDisplayed());
		assertTrue(allOrdersPage.orderTab.isDisplayed());

	}

	@AfterMethod
	public void logout() {
		
		allOrdersPage.logout();
	}

}
