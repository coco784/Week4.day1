package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
        List<String>lstwindow=new ArrayList<String>(windowHandles);
        driver.switchTo().window(lstwindow.get(1));
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getTitle());
        
        
	}

}
