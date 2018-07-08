package practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsExamples {

  WebDriver driver;

  @BeforeMethod
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
  }

  @Test
  public void doubleClickTest() {
    driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");

    WebElement slides = driver.findElement(By.id("slide_header"));
    WebElement puff = driver.findElement(By.id("puff_content"));
    WebElement fold = driver.findElement(By.id("fold_content"));
    WebElement scale = driver.findElement(By.id("scale_content"));
    
    
    Actions action = new Actions(driver);
    
    
    action.doubleClick(puff);
    action.perform();
    action.doubleClick(slides);
    action.perform();
    action.doubleClick(fold);
    action.perform();
    action.doubleClick(scale);
    action.perform();
    
    
  }

}