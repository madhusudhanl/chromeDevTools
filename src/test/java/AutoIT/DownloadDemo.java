package AutoIT;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String downloadPath=System.getProperty("user.dir");		
		
		WebDriverManager.chromedriver().setup();

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);

		ChromeOptions options = new ChromeOptions();
		
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("start-maximized");
		options.addArguments("incognito");

		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("File Download")).click();
		driver.findElement(By.linkText("cake.jpg")).click();
		Runtime.getRuntime().exec("C:\\Users\\Lenovo\\Documents\\AutoIT-Script\\FileDownload.exe");
		Thread.sleep(3000);
		File df = new File(downloadPath + File.separator +"cake.jpg");
		if(df.exists()) {
			
			System.out.println("File Downloaded");
		}else {
			
			System.out.println("File Not Downloaded");
		}

	}

}
