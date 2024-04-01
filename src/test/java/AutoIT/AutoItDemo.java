package AutoIT;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoItDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("incognito");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://smallpdf.com/pdf-to-word");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("(//span[contains(@class,'gGeCVP')])[1]")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Lenovo\\Documents\\AutoIT-Script\\FileUpload.exe");
		/*
		 * // converting the document and checking for downloads.
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 * wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
		 * "//span[contains(@class,'iiSRjo')]")));
		 * 
		 * driver.findElement(By.xpath("//span[contains(@class,'iiSRjo')]")).click();
		 * 
		 * wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
		 * "(//span[contains(@class,'iiSRjo')])[2]")));
		 * 
		 * driver.findElement(By.xpath("(//span[contains(@class,'iiSRjo')])[2]")).click(
		 * );
		 			not working since application is changing every time*/
	}

}
