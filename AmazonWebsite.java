package week4.day1.assignments;


import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonWebsite {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement searchBar = driver.findElement(By.xpath("//div/input[@id='twotabsearchtextbox']"));
		searchBar.sendKeys("oneplus 9 pro ");
		WebElement searchClick = driver.findElement(By.xpath("//div/span/input[@type='submit']"));
		searchClick.click();
		//Total No. of Results
		List<WebElement> resultsRecords = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> symbol = driver.findElements(By.xpath("//span[@class='a-price-symbol']"));
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		List<WebElement> numberofratings = driver.findElements(By.xpath("//span[@class='a-size-base s-underline-text']"));	
		String Nameoffirst = resultsRecords.get(0).getText();
		String symboloffirst = symbol.get(0).getText();
		String priceoffirst = price.get(0).getText();
		priceoffirst = priceoffirst.replaceAll(",", "");
		String ratingsoffirst = numberofratings.get(0).getText();
		System.out.println("price of the "+Nameoffirst+ " : " + symboloffirst+priceoffirst);
		System.out.println("Number of the Ratings : "+ratingsoffirst);
		List<WebElement> hover = driver.findElements(By.xpath("//i/span[@class='a-icon-alt']"));	
		
		Actions builder = new Actions(driver);
		builder.moveToElement(hover.get(0)).click().build().perform();
		WebElement numberofGlobalratings = driver.findElement(By.xpath("//span[@class='a-size-base a-color-secondary totalRatingCount']"));	
		WebElement ratingStars = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-beside-button a-text-bold']"));	
		
		
		String numberofGlobalratingsoffirst = numberofGlobalratings.getText();
		String ratingStarsoffirst = ratingStars.getText();
				
				System.out.println("Number of the Global Ratings : "+numberofGlobalratingsoffirst);
				System.out.println("Number of the Rating Stars : "+ratingStarsoffirst);
				WebElement table1 = driver.findElement(By.xpath("//table[contains(@class,'a-normal a-align-center a-spacing-base')]"));
				

				List<WebElement> rows = table1.findElements(By.tagName("tr"));
				/*System.out.println(rows);
				System.out.println("No.of rows : "+rows.size());
				for (int i=0;i<rows.size();i++) {
					WebElement eachrow = rows.get(i);
					
					List<WebElement> cols = eachrow.findElements(By.tagName("td"));
					for (int j=0;j<cols.size();j++) {
						WebElement eachCol=cols.get(j);
						String tabledata = eachCol.getText();
						System.out.print(tabledata+",");
					}
					System.out.println();
				}*/
				//for (int i=0;i<rows.size();i++) {
					WebElement row0 = rows.get(0);
					WebElement tdColdata5star = row0.findElements(By.tagName("td")).get(0);
					WebElement tdColdataPercent = row0.findElements(By.tagName("td")).get(2);
					String text = tdColdata5star.getText();
					String text1 = tdColdataPercent.getText();
					System.out.println(text + " percent is : "+text1);
					
					builder.moveToElement(resultsRecords.get(0)).click().build().perform();
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
			                    WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
			                    addToCart.click();
			                   // WebElement proceedToCart = driver.findElement(By.xpath("//div[@class='a-row a-spacing-top-small']/span/span/input[@type='submit']"));
			                    //WebElement addToCart = driver.findElement(By.xpath("//div[@class='a-column a-span11 a-text-left a-spacing-top-large']/span/span[@id='attach-accessory-cart-subtotal']"));
			                    WebElement Cart = driver.findElement(By.xpath("//div[@class='a-row a-spacing-top-small']/form/span/span/input[@type='submit']"));
			                    Cart.click();
			                    String Subtotal = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")).getText();
			                    Subtotal = Subtotal.replaceAll(",", "");
			                    double number1 = Double.parseDouble(Subtotal);
			                    int number2 = (int) number1;
			                    System.out.println("Subtotal : "+number2);
			                    int number = Integer.parseInt(priceoffirst);
			                    System.out.println("Price : "+number);
			                    if(number==number1)
			                    {
			                    	System.out.println("Subtotal and Price are same ");
			                    }
			                   }
				}
				
	
					
					
				
}
