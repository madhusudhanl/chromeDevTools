package Selenium4Feature.ChromeDevToolProtocol;

import java.net.URI;
import java.time.Duration;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAuthentication2 { // Not working

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");

		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Predicate<URI> uriPredicate = uri -> uri.getHost().contains("https://the-internet.herokuapp.com/basic_auth");

		((HasAuthentication) driver).register(uriPredicate, UsernameAndPassword.of("admin", "admin"));

		driver.get("https://the-internet.herokuapp.com/");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Basic Auth")).click();
	}

}
