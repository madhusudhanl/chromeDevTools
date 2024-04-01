package experiment;

import java.awt.Window;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
			
		ChromeOptions options = new ChromeOptions();  
		options.addArguments("start-maximized");
		options.addArguments("acceptInsecureCerts:true");
		options.addArguments("incognito");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("smart watch",Keys.ENTER);
		
		JavascriptExecutor js = driver;
		js.executeScript("window.scrollBy(0,1200)","");
		
		WebElement prod = driver.findElement(By.xpath("(//div[contains(@class,'s-title-instructions-style')])[3]"));
		int prods = driver.findElements(By.xpath("//div[contains(@class,'s-title-instructions-style')]")).size();
		
		
		Actions a = new Actions(driver);
		a.click(prod).build().perform();
		
		Set<String> handles = driver.getWindowHandles();
		
		System.out.println(handles);
		System.out.println(driver.getWindowHandle());
        
        // Iterate through the handles
        for (String handle : handles) {
            // Switch to the new tab if it's not the main tab
            if (!handle.equals(driver.getWindowHandle())) { // compare's with current window handle and new open window handle.
                driver.switchTo().window(handle); // if it not equal it will switch to new window/tab
                break;
            }
        }
		
		System.out.println(driver.getTitle());
		
	}

}
