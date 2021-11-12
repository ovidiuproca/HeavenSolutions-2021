import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class DemoAutomation {

	
	public static void main(String[] args){
		
		System.setProperty("webdriver.chrome.driver", "C:\\browswedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://politrip.com/account/sign-up");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("first-name")).sendKeys("Ovidiu");
		driver.findElement(By.id("last-name")).sendKeys("Proca");
		driver.findElement(By.id("email")).sendKeys("ovidiuproca@hotmail.com");
		driver.findElement(By.id("sign-up-password-input")).sendKeys("Test1234");
		driver.findElement(By.id("sign-up-confirm-password-input")).sendKeys("Test1234");
	    
		
		WebElement variante = driver.findElement(By.xpath("//*[@id=\"sign-up-heard-input\"]"));
		Select sel = new Select(variante);
		sel.selectByValue("socialNetworks");
		
		
		driver.findElement(By.xpath("//*[@id=\" qa_loader-button\"]/span")).click();
		
		driver.findElement(By.id("cookiescript_accept")).click();
		
		driver.findElement(By.xpath("//label[@for='mail-subscription-checkbox']")).click();
		System.out.println(driver.getCurrentUrl());
		
       WebElement scroll = driver.findElement(By.id("mail-subscription-label"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);" , scroll);

       driver.findElement(By.id("qa_signup-participant")).click();
       
       
	}
	
}
