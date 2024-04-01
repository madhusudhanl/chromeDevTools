package experiment;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearchNameprint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
			
		ChromeOptions options = new ChromeOptions();  
		options.addArguments("start-maximized");
		options.addArguments("acceptInsecureCerts:true");
		//options.addArguments("incognito");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("smart watch",Keys.ENTER);
		
		JavascriptExecutor js = driver;
		js.executeScript("window.scrollBy(0,1200)","");
		
		List<WebElement> prods = driver.findElements(By.xpath("//div[contains(@class,'s-title-instructions-style')]"));
		Iterator<WebElement> itr = prods.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next().getText());
		}
		
		// printing all name in amazon website.
	}

}
