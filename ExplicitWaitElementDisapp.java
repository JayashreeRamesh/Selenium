package week3.homeassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitElementDisapp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/disapper.html");

		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		
		WebElement elementDisappear = driver.findElement(By.id("btn"));
		wait.until(ExpectedConditions.invisibilityOf(elementDisappear));
		
		WebElement msgAppear = driver.findElement(By.xpath("//strong[contains(text(), 'I know')]"));
		
		System.out.println("Text says :" + msgAppear.getText());

	}

}
