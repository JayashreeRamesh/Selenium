package week3.homeassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitElementAppears {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/appear.html");

		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		WebElement elementreappear = driver.findElement(By.id("btn"));
		
		wait.until(ExpectedConditions.visibilityOf(elementreappear));
		
		
		String text = driver.findElement(By.id("btn")).getText();
		System.out.println("Button which got disappeared and reappeared is :" +text );
		


	}

}
