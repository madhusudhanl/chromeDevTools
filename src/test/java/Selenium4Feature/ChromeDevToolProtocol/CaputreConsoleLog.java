package Selenium4Feature.ChromeDevToolProtocol;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.google.common.collect.ImmutableList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaputreConsoleLog {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("incognito");

		ChromeDriver driver = new ChromeDriver(options);

		DevTools devTools = driver.getDevTools(); // Create devTool instance
		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.css")));

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.xpath("//button[@class='add-to-cart btn btn-default']")).click();
		driver.findElement(By.linkText("Cart")).click();
		WebElement input = driver.findElement(By.id("exampleInputEmail1"));
		Thread.sleep(2000);
		input.click();
		input.sendKeys(Keys.BACK_SPACE, "22");

		LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logs = entry.getAll();

		for (LogEntry e : logs) {

			System.out.println(e.getMessage());
		}

}

}
