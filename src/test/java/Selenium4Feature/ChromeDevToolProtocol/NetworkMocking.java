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

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");

		ChromeDriver driver = new ChromeDriver(options);

		DevTools devTools = driver.getDevTools(); // Create devTool instance
		devTools.createSession();
		
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		devTools.addListener(Fetch.requestPaused(), request -> {
			
			if(request.getRequest().getUrl().contains("=shetty")) {
				
				String mockedURL = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println(mockedURL);
				
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedURL),
						Optional.of(request.getRequest().getMethod()),
						request.getRequest().getPostData(), request.getResponseHeaders(),Optional.empty()));
				
				
			}
			else {
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()),
						Optional.of(request.getRequest().getMethod()),
						request.getRequest().getPostData(), request.getResponseHeaders(),Optional.empty()));
				
				
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//button[@routerlink='/library']")).click();
		Thread.sleep(2000);
		String msg = driver.findElement(By.tagName("p")).getText();
		
		System.out.println(msg);
	
	}
	
	

}
