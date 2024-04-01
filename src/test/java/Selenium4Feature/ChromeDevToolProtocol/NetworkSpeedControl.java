package Selenium4Feature.ChromeDevToolProtocol;

import java.sql.Connection;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.fetch.Fetch;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.ConnectionType;
import org.openqa.selenium.devtools.v120.network.model.Request;
import org.openqa.selenium.devtools.v120.network.model.Response;

import com.google.common.collect.ImmutableList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkSpeedControl {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");

		ChromeDriver driver = new ChromeDriver(options);

		DevTools devTools = driver.getDevTools(); // Create devTool instance
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false,3000,20000,100000,Optional.of(ConnectionType.ETHERNET)));
		// make it true to disconnect the internet.
		
		devTools.addListener(Network.loadingFailed(), loadingFail ->{ // this code will work only is there no internet
			
			System.out.println(loadingFail.getErrorText());
			System.out.println(loadingFail.getTimestamp());
		});
		
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
		// 28257 -- Ethernet, 433 -- CELLULAR4G
		System.out.println(msg);
		
	}
	
	

}
