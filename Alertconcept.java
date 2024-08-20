package com.alertconcept;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alertconcept {
       
	   protected static String url="https://demoqa.com/alerts";
	   WebDriver driver;

@BeforeSuite 
public void startchromebrowser() {
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}	

@BeforeMethod
public void openurl() {
	  driver.get(url);
}

@Test
public void acceptalert() throws InterruptedException {
	   WebElement alertbtn=driver.findElement(By.id("alertButton"));
	   alertbtn.click();
	   Thread.sleep(2000);
	   
	   Alert al=driver.switchTo().alert();
	   al.accept();
	   Thread.sleep(2000);
	   System.out.println("accept alert");
}

@Test
public void dismissalert() throws InterruptedException {
	   WebElement alertbtn=driver.findElement(By.id("alertButton"));
	   alertbtn.click();
	   Thread.sleep(2000);
	   
	   Alert al=driver.switchTo().alert();
	   al.dismiss();
	   Thread.sleep(2000);
	   System.out.println("dismiss alert");
}

@Test
public void gettext() throws InterruptedException {
	   WebElement alertbtn=driver.findElement(By.id("alertButton"));
	   alertbtn.click();
	   Thread.sleep(2000);
	   
	   Alert al=driver.switchTo().alert();
	   System.out.println(al.getText());
	   al.accept();
	   Thread.sleep(2000);
	   System.out.println("get text of the alert box");
}

@Test
public void acceptconfirm() throws InterruptedException {
	   WebElement confirmbtn=driver.findElement(By.id("confirmButton"));
	   confirmbtn.click();
	   Thread.sleep(2000);
	   
	   Alert al=driver.switchTo().alert();
	   al.accept();
	   Thread.sleep(2000);
	   System.out.println("accept confirm alert");
}

@Test
public void dismissconfirm() throws InterruptedException {
	   WebElement confirmbtn=driver.findElement(By.id("confirmButton"));
	   confirmbtn.click();
	   Thread.sleep(2000);
	   
	   Alert al=driver.switchTo().alert();
	   al.dismiss();
	   Thread.sleep(2000);
	   System.out.println("dismiss confirm alert");
}

@Test
public void acceptpromt() throws InterruptedException {
	   WebElement promtbtn=driver.findElement(By.id("promtButton"));
	   ((JavascriptExecutor)driver).executeScript("arguments[0].click()",promtbtn);
	   Thread.sleep(2000);
	   
	   Alert al=driver.switchTo().alert();
	   al.sendKeys("bhanu");
	   al.accept();
	   Thread.sleep(2000);	  
}

@Test
public void dismisspromt() throws InterruptedException {
	   WebElement promtbtn=driver.findElement(By.id("promtButton"));
	   ((JavascriptExecutor)driver).executeScript("arguments[0].click()",promtbtn);
	   Thread.sleep(2000);
	   
	   Alert al=driver.switchTo().alert();	  
	   al.dismiss();
	   Thread.sleep(2000);	  
}

@AfterSuite
public void closechromebrowser() {
	  driver.quit();
}

}
