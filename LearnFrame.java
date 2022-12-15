package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrame {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/frame.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snap/frame.png");
		FileUtils.copyFile(source, destination);
		driver.switchTo().frame(0);
		WebElement fr1 = driver.findElement(By.xpath("//button[@id='Click']"));
         fr1.click();
		System.out.println(fr1.getText());
		driver.switchTo().defaultContent();
		//driver.switchTo().frame(2);
		WebElement nestedf = driver.findElement(By.xpath("//iframe[@src='page.xhtml']"));
		driver.switchTo().frame(nestedf);
		driver.switchTo().frame("frame2");
		WebElement fr2 = driver.findElement(By.xpath("//button[text()='Click Me']"));
		fr2.click();
		System.out.println(fr2.getText());
		
		
		
		
		
	
		
		
		
	

	}

}
