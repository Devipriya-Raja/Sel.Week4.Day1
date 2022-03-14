package week4.day1.assignments;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class FunWithFrames {

	public static void main(String[] args) {
		
	WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leafground.com/pages/frame.html");
		driver.switchTo().frame(0);
		
		WebElement click = driver.findElement(By.xpath("//body/button[@id='Click']"));
		String beforeClick = click.getText();
		System.out.println("First Click Me");
		System.out.println(beforeClick);
		click.click();
		String afterClick = click.getText();
		System.out.println(afterClick);
		driver.switchTo().defaultContent();
		WebElement nestediFrame = driver.findElement(By.xpath("//iframe[@src='page.html']"));
		driver.switchTo().frame(nestediFrame);
		driver.switchTo().frame(0);
		WebElement click1 = driver.findElement(By.xpath("//body/button[@id='Click1']"));
		String beforeClick1 = click1.getText();
		System.out.println("Second Click Me");
		System.out.println(beforeClick1);
		click1.click();
		String afterClick1 = click1.getText();
		System.out.println(afterClick1);
		//Finding out no of frames 
		driver.switchTo().defaultContent();
		List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
		System.out.println(totalFrames.size());
		for(int i=0;i<totalFrames.size();i++) {
			System.out.println(i+"="+totalFrames.get(i).getText());
		};
	}
}
		
		
		
		
