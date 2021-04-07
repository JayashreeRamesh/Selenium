package week4.homeassignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.snapdeal.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// CLick on Men's Fashion
		WebElement menFash = driver.findElement(By.xpath("//li[@class='navlink lnHeight'][1]"));

		// Mouse Hover action
		Actions builder = new Actions(driver);
		builder.moveToElement(menFash).perform();

		// Go to Sports Shoes

		driver.findElement(By.xpath("//span[text() = 'Sports Shoes']")).click();

		// Get the count of the sports shoes
		String SportShoes = driver.findElement(By.xpath("//span[@class = 'category-count']")).getText();
		int ssCount = Integer.parseInt(SportShoes.replaceAll("\\D", ""));
		System.out.println("Sport Shoes Count:" + ssCount);

		// Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

		// Sort by Low to High

		Thread.sleep(2000);

		driver.findElement(By.className("sort-selected")).click();

		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();

		// Check if the items displayed are sorted correctly
		driver.findElements(By.xpath("//div[@id ='products']"));
		
		
		List<WebElement> prodList = driver.findElements(By.xpath("//span[@class = 'lfloat product-price']"));

		List<String> shoePrice = new ArrayList<String>();

		for (int i = 0; i < prodList.size(); i++) {

			String price = prodList.get(i).getText();

			shoePrice.add(price);

			int intShoePrice = Integer.parseInt(price.replaceAll("\\D", ""));

			System.out.println(intShoePrice);

		}
		
	

		// System.out.println(shoePrice);
		driver.findElement(
				By.xpath("//button[@class = 'view-more-button btn btn-line btn-theme-secondary js-view-more']"))
				.click();

		driver.findElement(By.xpath("//label[@for= 'Brand-Puma']")).click();

		driver.findElement(By.xpath("//div[@class='btn applyFilters lfloat']")).click();

		WebElement pumaShoes = driver.findElement(By.xpath("//img[@title= 'Puma Blue Training Shoes']"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(pumaShoes).perform();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@pogid='634946472715']")).click();

		// Actual Price of the shoes
		String actPrice = driver.findElement(By.xpath("//span[@class = 'strikee ']")).getText();
		int intActPrice = Integer.parseInt(actPrice.replaceAll("\\D", ""));
		System.out.println("Actual Price:" + intActPrice);

		// Discount Price of the shoes
		String disPrice = driver.findElement(By.xpath("//span[@class = 'payBlkBig']")).getText();
		int intDisPrice = Integer.parseInt(disPrice.replaceAll("\\D", ""));
		System.out.println("Discount Price:" + intDisPrice);

		// Discount Percent of the shoes
		String disPercent = driver.findElement(By.xpath("//span[@class = 'percent-desc ']")).getText();
		int intdisPercent = Integer.parseInt(disPercent.replaceAll("\\D", ""));
		System.out.println("Discount Percent:" + intdisPercent);

		// Snapshot of the shoes
		File memory = driver.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(memory, new File("./snaps.jpg"));

		// Close the current window
		driver.close();
		driver.quit();

	}

}
