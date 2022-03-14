package week4.day1.assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContactsWindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leaftaps.com/opentaps/control/main");
		WebElement elementUsername = driver.findElement(By.xpath("//input[@id='username']"));
		elementUsername.sendKeys("Demosalesmanager");
		WebElement elementPassword = driver.findElement(By.xpath("//input[@name='PASSWORD']"));
		elementPassword.sendKeys("crmsfa");
		WebElement elementLogin = driver.findElement(By.xpath("//input[@class='decorativeSubmit']"));
		elementLogin.click();
		WebElement elementCrmlink = driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]"));
		elementCrmlink.click();
		WebElement elementContactsTab = driver.findElement(By.xpath("//a[text()='Contacts']"));
		elementContactsTab.click();
        WebElement elementMergeContacts = driver.findElement(By.xpath("//a[text()='Merge Contacts']"));
        elementMergeContacts.click();
        WebElement elementFromContactWidget = driver.findElement(By.xpath("(//a/img[@src='/images/fieldlookup.gif'])[1]"));
        elementFromContactWidget.click();
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
                    WebElement elementFirstElementinContacts = driver.findElement(By.xpath("(//div/a[@class='linktext'])[1]"));
                    elementFirstElementinContacts.click();
                   }
            driver.switchTo().window(parentWindow);
            WebElement elementToContactWidget = driver.findElement(By.xpath("(//a/img[@src='/images/fieldlookup.gif'])[2]"));
            elementToContactWidget.click();
            Set<String> s2=driver.getWindowHandles();	
            Iterator<String> i2=s2.iterator();	
            
    		
                String parentWindow1=i2.next();	
                System.out.println("Parent ID is "+parentWindow1);
                String ChildWindow1=i2.next();		
                System.out.println("child ID is "+ChildWindow1);		
                if(!parentWindow1.equalsIgnoreCase(ChildWindow1))			
                {    		
                     
                        // Switching to Child window
                        driver.switchTo().window(ChildWindow1);	
                        WebElement elementFirstElementinContacts1 = driver.findElement(By.xpath("(//div/a[@class='linktext'])[6]"));
                        elementFirstElementinContacts1.click();
                       }
            driver.switchTo().window(parentWindow1);
            WebElement elementMerge = driver.findElement(By.xpath("//a[text()='Merge']"));
    		elementMerge.click(); 
    		driver.switchTo().alert().accept();
    		System.out.println("The Title is "+ driver.getTitle());
	}
}
    		
