package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLeadWindow {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("democsr");
		//to enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//to click login button
		driver.findElement(By.className("decorativeSubmit")).click();
		//click crmsfa
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Accounts']")).click();
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/mergeAccountsForm']")).click();
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstwindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindow.get(1));
		driver.findElement(By.xpath("(//a[@class='linktext'])[3]")).click();
		//System.out.println(driver.getTitle());
		driver.switchTo().window(lstwindow.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String>lst2=new ArrayList<String>(windowHandles2);
		driver.switchTo().window(lst2.get(1));
		driver.findElement(By.linkText("Hema")).click();
		driver.switchTo().window(lst2.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
        System.out.println(driver.getTitle());
	     
	     File source = driver.getScreenshotAs(OutputType.FILE);
	     File dest = new File("./snaps/MergeLead.png");
	     FileUtils.copyFile(source, dest);
	    
	     
	     

	}

}
