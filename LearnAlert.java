package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/alert.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//simple alert
		driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();
		Thread.sleep(2000);
		Alert sa = driver.switchTo().alert();
		System.out.println(sa.getText());
		sa.accept();
		
		//confirm alert
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
		Thread.sleep(2000);
		Alert ca = driver.switchTo().alert();
		System.out.println(ca.getText());
		Thread.sleep(2000);
		ca.dismiss();
		String text = driver.findElement(By.id("result")).getText();
		System.out.println(text);
		
		//prompt alert
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[6]")).click();
		Alert pa = driver.switchTo().alert();
		System.out.println(pa.getText());
		Thread.sleep(2000);
		pa.sendKeys("Testleaf");
		Thread.sleep(2000);
		pa.accept();
		String text2 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
	    System.out.println(text2);
	    
		//sweet simple alert
	    driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
	    String t1 = driver.findElement(By.xpath("//p[text()[normalize-space()='You have clicked and open a dialog that can be inspectable.']]")).getText();
	    System.out.println(t1);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[4]")).click();
	    String text3 = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[4]")).getText();
	    System.out.println(text3);
	    //sweet modal alert
	  // driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[5]")).click();
	    //String t2 = driver.findElement(By.xpath("//p[text()='Unless you close this, you cannot interact with other element. But am inspectable !']")).getText();
	    //System.out.println(t2);
	    //driver.findElement(By.xpath("(//span[text()='Modal Dialog (Sweet Alert)'])/following::span)[1]")).click();
	    
	    //sweet confirm alert
	    driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[7]")).click();
	    String text4 = driver.findElement(By.xpath("(//div[@role='alertdialog']//div)[2]")).getText();
	    System.out.println(text4);
	    driver.findElement(By.xpath("//span[text()='Yes']")).click();
	    String text5 = driver.findElement(By.xpath("//span[text()='Yes']")).getText();
	    System.out.println(text5);
	    
	    //Minimize and Maximize
	    driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[8]")).click();
	    String text6 = driver.findElement(By.xpath("//p[text()='I am Sweet Alert and can be maximized or minimized. By the way, am not a new window.']")).getText();
	    System.out.println(text6);
	    driver.findElement(By.xpath("//a[contains(@class,'ui-dialog-titlebar-icon ui-dialog-titlebar-maximize')]")).click();
	    String text7 = driver.findElement(By.xpath("//p[text()='I am Sweet Alert and can be maximized or minimized. By the way, am not a new window.']")).getText();
	System.out.println(text7);
	
	
	}

}
