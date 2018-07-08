package com.dice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BuyingPorsche {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver chrome = new ChromeDriver();

		JavascriptExecutor jse = (JavascriptExecutor)chrome;

		chrome.get("https://www.porsche.com/usa/modelstart");
		chrome.manage().window().maximize();
		chrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		chrome.findElement(By.xpath("html/body/div[2]/div[4]/div/div[2]/a[1]/div/div[2]/div/span")).click();

		String basePrice = chrome.findElement(By.xpath("//*[@id=\"m982120\"]/div[1]/div[2]/div[2]")).getText()
				.toString().replaceAll("[^0-9]", "");

		chrome.findElement(By.xpath("//*[@id=\"m982120\"]/div[2]/div/a/span")).click();

		for (String windows : chrome.getWindowHandles()) {
			chrome.switchTo().window(windows);
		}

		String basePrice2 = chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[1]/div[2]")).getText()
				.toString().replaceAll("[^0-9]", "");

		System.out.println(basePrice.substring(0, basePrice.length() - 2) + "\t" + basePrice2);
		if (basePrice.substring(0, basePrice.length() - 2).equals(basePrice2)) {
			System.out.println("Base price equal");
		} else {
			System.out.println("Base price not equal");
		}

		String equipmentPrice = chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText()
				.toString().replaceAll("[^0-9]", "");
		if (equipmentPrice.equals("0")) {
			System.out.println("Equipment price is 0");
		} else {
			System.out.println("Equipment price is not 0");
		}

		String totalPrice = chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]")).getText()
				.toString().replaceAll("[^0-9]", "");

		String deliverPrice = chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[3]/div[2]")).getText()
				.toString().replaceAll("[^0-9]", "");

		int tP = Integer.parseInt(totalPrice);
		int dPANDbP = Integer.parseInt(deliverPrice) + Integer.parseInt(basePrice2);

		if (tP == dPANDbP) {
			System.out.println("Total price is the sum of base price + Delivery, Processing and Handling Fee");
		} else {
			System.out.println("Total price is not the sum of base price + Delivery, Processing and Handling Fee");
		}

		chrome.findElement(By.xpath("//*[@id=\"s_exterieur_x_FJ5\"]/span")).click();

		String miamibluePrice = chrome.findElement(By.xpath("//*[@id=\"s_exterieur_x_FJ5\"]"))
				.getAttribute("data-price").toString().replaceAll("[^0-9]", "");

		equipmentPrice = chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText().toString()
				.replaceAll("[^0-9]", "");
		
		if (miamibluePrice.equals(equipmentPrice)) {
			System.out.println("Price for Equipment is Equal to Miami Blue price");
		} else {
			System.out.println("Price for Equipment is not Equal to Miami Blue price");
		}
		
		chrome.findElement(By.xpath("//*[@id=\"s_exterieur_x_MXRD\"]/span/span")).click();
		
		String wheelPrice = chrome.findElement(By.xpath("//*[@id=\"s_exterieur_x_MXRD\"]")).getAttribute("data-price").toString().replaceAll("[^0-9]", "");
		
		int mbANDwp = Integer.parseInt(miamibluePrice) + Integer.parseInt(wheelPrice);
		int ep2 = Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText().toString().replaceAll("[^0-9]", ""));
		
		if(mbANDwp == ep2) { System.out.println("Price for Equipment is the sum of Miami Blue price + 20\" Carrera Sport Wheels"); }
		else { System.out.println("Price for Equipment is not the sum of Miami Blue price + 20\" Carrera Sport Wheels"); }
		
		int t2 = Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]")).getText().toString().replaceAll("[^0-9]", ""));
		int t2others = Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[1]/div[2]")).getText().toString().replaceAll("[^0-9]", "")) +
				Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText().toString().replaceAll("[^0-9]", "")) +
				Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[3]/div[2]")).getText().toString().replaceAll("[^0-9]", ""));
		if(t2 == t2others) {
			System.out.println("PASS15");
		}else {
			System.out.println("FAIL");
		}
		
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,900)", "");
		chrome.findElement(By.xpath("//*[@id=\"s_interieur_x_PP06\"]")).click();
		
		int pfe16 = Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText().toString().replaceAll("[^0-9]", ""));
		int others16 = Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"seats_73\"]/div[2]/div[1]/div[3]/div")).getText().toString().replaceAll("[^0-9]", "")) + mbANDwp;
		
		if(pfe16 == others16) {
			System.out.println("PASS16");
		}else {
			System.out.println("FAIL");
		}
		
		int others17 = Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[1]/div[2]")).getText().toString().replaceAll("[^0-9]", "")) +
				Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText().toString().replaceAll("[^0-9]", "")) +
				Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[3]/div[2]")).getText().toString().replaceAll("[^0-9]", ""));
		int t17 = Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]")).getText().toString().replaceAll("[^0-9]", ""));
		
		if(t17==others17) {
			System.out.println("PASS17");
		}else {
			System.out.println("FAIL");
		}
		
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,750)", "");
		chrome.findElement(By.xpath("//*[@id=\"IIC_subHdl\"]")).click();
		
		Thread.sleep(3000);
		chrome.findElement(By.xpath("//*[@id=\"vs_table_IIC_x_PEKH_x_c01_PEKH\"]")).click();
		
		int e20others = Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"vs_table_IIC_x_PEKH\"]/div[1]/div[2]/div")).getText().toString().replaceAll("[^0-9]", "")) + others16;
		int e20 = Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText().toString().replaceAll("[^0-9]", ""));
		
		if(e20==e20others) { System.out.println("PASS20"); }
		else { System.out.println("FAIL20"); }
		
		int others21 = e20 + Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[3]/div[2]")).getText().toString().replaceAll("[^0-9]", "")) +
				Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[1]/div[2]")).getText().toString().replaceAll("[^0-9]", ""));
		int t21 = Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]")).getText().toString().replaceAll("[^0-9]", ""));
		
		if(t21 == others21) { System.out.println("PASS21"); }
		else { System.out.println("FAIL21"); }
		
		chrome.findElement(By.xpath("//*[@id=\"IMG_subHdl\"]")).click();
		
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,200)", "");
		chrome.findElement(By.xpath("//*[@id=\"vs_table_IMG_x_M250_x_c11_M250\"]")).click();
		
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,300)", "");
		chrome.findElement(By.xpath("//*[@id=\"vs_table_IMG_x_M450_x_c91_M450\"]")).click();
		
		int e25others = e20others + Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"vs_table_IMG_x_M250\"]/div[1]/div[2]/div")).getText().toString().replaceAll("[^0-9]", ""))
		+ Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"vs_table_IMG_x_M450\"]/div[1]/div[2]/div")).getText().toString().replaceAll("[^0-9]", ""));
		int e25 = Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText().toString().replaceAll("[^0-9]", ""));
				
		if(e25==e25others) { System.out.println("PASS25"); }
		else {System.out.println("FAIL25"); }
		
		int others26 = Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[1]/div[2]")).getText().toString().replaceAll("[^0-9]", ""))
				+ Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[2]/div[2]")).getText().toString().replaceAll("[^0-9]", "")) +
				Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[3]/div[2]")).getText().toString().replaceAll("[^0-9]", ""));
		int t26 = Integer.parseInt(chrome.findElement(By.xpath("//*[@id=\"s_price\"]/div[1]/div[4]/div[2]")).getText().toString().replaceAll("[^0-9]", ""));
		
		if(t26==others26) { System.out.println("PASS26"); }
		else { System.out.println("FAIL26"); }
		
		System.out.println("COMPLETED");
		chrome.quit();

	}

}