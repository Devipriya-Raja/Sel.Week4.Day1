package week4.day1.assignments;


	import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class IRCTCAlertsAndWindow {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.irctc.co.in/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebElement alert = driver.findElement(By.xpath("//div/button[text()='OK']"));
			alert.click();
			WebElement flightsIconClick = driver.findElement(By.xpath("//a/span[@class='allcircle circleone']"));
			flightsIconClick.click();
			Set<String> s=driver.getWindowHandles();	
            Iterator<String> i=s.iterator();	
            
    		
                String parentWindow=i.next();	
                System.out.println("Parent ID is "+parentWindow);
                String ChildWindow=i.next();		
                System.out.println("child ID is "+ChildWindow);		
                if(!parentWindow.equalsIgnoreCase(ChildWindow))			
                {    		
                     
                        // Switching to Child window
                        driver.switchTo().window(ChildWindow);	
                        WebElement elementContactUs = driver.findElement(By.xpath("//li/a[@id='dropdown10']"));
                        elementContactUs.click();
                        WebElement elementEmail =driver.findElement(By.xpath("(//li/div/a[@class='dropdown-item'])[3]"));
                        String contactUS = elementEmail.getText();
                        System.out.println("Contact Email : " +contactUS);
                       }
                driver.switchTo().window(parentWindow);	
                driver.close();
		}
}
