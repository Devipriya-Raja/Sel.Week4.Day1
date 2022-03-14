package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ChercherExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(frame);
		
		WebElement inputTopic = driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input"));
		inputTopic.sendKeys("Happy Learning");
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(frame2);
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='a']"));
		checkBox.click();
		
		driver.switchTo().defaultContent();
			 WebElement frame3 =driver.findElement(By.xpath("//iframe[@id='frame2']"));
				driver.switchTo().frame(frame3);
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='animals']"));
		Select animals= new Select(dropDown);
		animals.selectByIndex(3);
	}

}
