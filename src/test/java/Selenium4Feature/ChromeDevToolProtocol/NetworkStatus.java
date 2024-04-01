package Selenium4Feature.ChromeDevToolProtocol;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.Request;
import org.openqa.selenium.devtools.v120.network.model.Response;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkStatus {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");

		ChromeDriver driver = new ChromeDriver(options);

		DevTools devTools = driver.getDevTools(); // Create devTool instance

		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		devTools.addListener(Network.requestWillBeSent(), request ->{
			
			Request req = request.getRequest();
			System.out.println(req.getUrl()); 
			
		});
		
		devTools.addListener(Network.responseReceived(), response -> {
			
			Response res = response.getResponse();
//			System.out.println(res.getUrl());
//			System.out.println(res.getStatus());
			if(res.getStatusText().startsWith("4")) {
				
				System.out.println(res.getUrl()+"is failing with code"+ res.getStatus());
				
			}
			
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//button[@routerlink='/library']")).click();
	
	}
	
	

}
