package Selenium4Feature.ChromeDevToolProtocol;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v120.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class emulatorMobileTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = ((HasDevTools) driver).getDevTools();
		devTools.createSession();

		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty()));

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		// navbar-toggler
		driver.findElement(By.className("navbar-toggler")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@routerlink = '/products']")).click();
		
	}

}
