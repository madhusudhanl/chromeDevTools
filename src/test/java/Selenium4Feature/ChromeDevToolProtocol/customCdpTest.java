package Selenium4Feature.ChromeDevToolProtocol;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class customCdpTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools(); // Create devTool instance
		
		// DevTools devTools = ((HasDevTools) driver).getDevTools();
		devTools.createSession();
		HashMap<String,Object> deviceMetrics = new HashMap<String,Object>();
		deviceMetrics.put("width", 600);
		deviceMetrics.put("height", 1000);
		deviceMetrics.put("deviceScaleFactor", 75);
		deviceMetrics.put("mobile", true);

		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		// navbar-toggler
		driver.findElement(By.className("navbar-toggler")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@routerlink = '/products']")).click();
		
		if(driver != null) {
			driver.quit();
			
		}

	}

}
