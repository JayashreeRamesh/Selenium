package week3.homeassignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://erail.in/");

		driver.manage().window().maximize();

		driver.findElement(By.id("chkSelectDateOnly")).click();

		// Select From Station
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("Mgr Chennai Ctr");
		driver.findElement(By.id("txtStationFrom")).sendKeys(Keys.ENTER, Keys.TAB);

		// Select To Station
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("Delhi");
		driver.findElement(By.id("txtStationTo")).sendKeys(Keys.ENTER, Keys.TAB);

		List<WebElement> table = driver.findElements(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']//tr/td[2]"));

		//Using Array List
		
		List<String> trainNames = new ArrayList<String>();

		for (int i = 0; i < table.size(); i++) {

			String eachTrainName = table.get(i).getText();

			trainNames.add(eachTrainName);
			
			System.out.println(eachTrainName);

		}

		Collections.sort(trainNames);
		System.out.println(trainNames);

	}
}

