package week4.day1.assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://dev45736.service-now.com/navpage.do");
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame);
		
		
		WebElement elementeUsername = driver.findElement(By.xpath("//input[@name='user_name']"));
		elementeUsername.sendKeys("admin");
		 
		WebElement elementPassword = driver.findElement(By.xpath("//input[@name='user_password']"));
		elementPassword.sendKeys("gOF7oltVdVL3");
		driver.findElement(By.xpath("//div/button[@type='submit']")).click();
		
		WebElement search = driver.findElement(By.xpath("//input[@id='filter']"));
		search.sendKeys("incident");
		
		WebElement all = driver.findElement(By.xpath("(//div[@class='sn-widget-list-content']/div[text()='All'])[2]"));
		all.click();
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame1);
		//WebElement createNew = driver.findElement(By.xpath("//div[@class='navbar-header']/button[text()='New']"));
		//Actions action = new Actions(driver);
		//action.moveToElement(createNew).click().build().perform();
		boolean staleElement = true; 

		while(staleElement){

		  try{

			  WebElement createNew = driver.findElement(By.xpath("//div[@class='navbar-header']/button[text()='New']"));
				Actions action = new Actions(driver);
				action.moveToElement(createNew).click().build().perform();
			  
		     staleElement = false;


		  } catch(StaleElementReferenceException e){

		    staleElement = true;

		  }

		}
		
		
		
		WebElement lookUP = driver.findElement(By.xpath("//span[@class='input-group-btn']/button[@type='button']"));
		lookUP.click();
		Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();		
        		
        	
            String parentWindow=i1.next();	
            System.out.println("Parent ID is "+parentWindow);
            String childWindow=i1.next();		
            System.out.println("child ID is "+childWindow);
            		
            if(!parentWindow.equalsIgnoreCase(childWindow))			
            {    		
                 
                    // Switching to Child window
                    driver.switchTo().window(childWindow);	
                    WebElement table = driver.findElement(By.xpath("//table[@id='sys_user_table']"));
                
                    List<WebElement> rows = table.findElements(By.tagName("tr"));
    				
    					WebElement row0 = rows.get(3);
    					WebElement tdColdata = row0.findElements(By.tagName("td")).get(2);
    					tdColdata.click();
    					
    				
                   }
            driver.switchTo().window(parentWindow);	
            WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
			driver.switchTo().frame(frame3);
            WebElement shortDes = driver.findElement(By.xpath("//input[@id='incident.short_description']"));
            shortDes.sendKeys("Request for help");
            WebElement id = driver.findElement(By.xpath("//input[@type='text']"));
           String idNumber = id.getAttribute("value");
           //System.out.println(idNumber);
    		//driver.switchTo().frame(frame);
    		 //WebElement submit = driver.findElement(By.xpath("//span[@type='submit']/button[text()='Submit']"));
    		 //submit.click();
    		 WebElement submit1 = driver.findElement(By.xpath("//div[@class='form_action_button_container']/button[text()='Submit']"));
    		 submit1.click();
    		 
    		 
    		 WebElement SelectNumber = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
    		 Select s = new Select(SelectNumber);
    		 s.selectByVisibleText("Number");
    		 WebElement searchNumber = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
    		 searchNumber.sendKeys(idNumber,Keys.ENTER);
    		 WebElement table1 = driver.findElement(By.xpath("//table[@id='incident_table']"));
             
             List<WebElement> rows = table1.findElements(By.tagName("tr"));
				
					WebElement row0 = rows.get(2);
					WebElement tdColdata = row0.findElements(By.tagName("td")).get(2);
					String searchID = tdColdata.getText();
					
					if (idNumber.equals(searchID)) {
						System.out.println(idNumber+" created successfully");
					}
					else {
						System.out.println(searchID);
					}
    		 
	}

}
