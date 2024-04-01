package Selenium4Feature.ChromeDevToolProtocol;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class geoLocationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		// Set up ChromeOptions to include geolocation data and set the language to Spanish      
		
		ChromeOptions options = new ChromeOptions();  
		options.addArguments("start-maximized");
		
//		options.addArguments("--enable-features=Geolocation");        
//		options.addArguments("--lang=es"); 

		ChromeDriver driver = new ChromeDriver(options);

		DevTools devTools = driver.getDevTools(); // Create devTool instance
		
		//DevTools devTools = ((HasDevTools) driver).getDevTools();
		
		devTools.createSession();
		HashMap<String,Object> deviceMetrics = new HashMap<String,Object>();
		deviceMetrics.put("latitude", 40);
		deviceMetrics.put("longitude", 3);
		deviceMetrics.put("accuracy", 1);
				
		driver.executeCdpCommand("Emulation.setGeolocationOverride", deviceMetrics);
		
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		driver.findElement(By.xpath("//h3[contains(@class, 'LC20lb')]")).click();
		String title = driver.findElement(By.tagName("h1")).getText();
		
		System.out.println(title);
		
	}

}
