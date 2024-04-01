package Selenium4Feature.ChromeDevToolProtocol;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.fetch.Fetch;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.Request;
import org.openqa.selenium.devtools.v120.network.model.Response;

import com.google.common.collect.ImmutableList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkBlockingURLS {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");

		ChromeDriver driver = new ChromeDriver(options);

		DevTools devTools = driver.getDevTools(); // Create devTool instance
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
				
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		long startTime = System.currentTimeMillis();
		driver.findElement(By.linkText("Browse Products")).click();
//		Thread.sleep(2000);
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.xpath("//button[@class='add-to-cart btn btn-default']")).click();
		String msg = driver.findElement(By.tagName("p")).getText();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		//414, 389
		System.out.println(msg);
		
	}
	
	

}
