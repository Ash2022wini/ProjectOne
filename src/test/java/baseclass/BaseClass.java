package baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseClass extends AbstractTestNGCucumberTests{
	public static ChromeDriver driver;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	@BeforeMethod
	public void preCondition() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ashwini.premanand\\eclipse-workspace\\Set1\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		}
	public void login() {
		driver.get("https://analytics-qa.iriworldwide.com/unify-analyticsqa/index.html");
		WebElement userid = driver.findElement(By.id("userID"));
		userid.sendKeys("Unifyqa34");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("QaTest@34");
		WebElement loginbutton = driver.findElement(By.id("login"));
		loginbutton.click();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	public void createflow() throws InterruptedException {
		WebElement menubutton = driver.findElement(By.xpath("/html/body/div[1]/div[8]/div[1]/ul/li[1]/a[1]"));
		menubutton.click();
		WebElement apps = driver.findElement(By.xpath("(.//a[@class='mm-subopen mm-fullsubopen'])[3]"));
		js.executeScript("arguments[0].click();", apps);
		WebElement isselector = driver.findElement(By.xpath("//a[@id='menu-Intelligence-Suite-3.X']"));
		js.executeScript("arguments[0].click();", isselector);
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		System.out.println("Successfully inside the Frame");
		WebElement createbutton = driver.findElement(By.xpath("//span[normalize-space()='Create']"));
		wait.until(ExpectedConditions.visibilityOf(createbutton));
	    js.executeScript("arguments[0].click();", createbutton);
	    Thread.sleep(3000);
	    }
	public void connection() {
		WebElement connection = driver.findElement(By.xpath("//div[@id='main-menu0']//span[@class='operation__icon']"));
	    js.executeScript("arguments[0].click();",connection);
	    }
	public void fileconnection() {
		WebElement fileconnection = driver.findElement(By.xpath("//span[normalize-space()='File Connection']"));
	    js.executeScript("arguments[0].click();", fileconnection);
	    driver.findElement(By.xpath("//input[@title='Click here to select file']")).sendKeys("C:\\Users\\ashwini.premanand\\Desktop\\Test Data\\CSVfile.csv");
	    }
	public void delimeterfile() throws InterruptedException {
		WebElement radiobuttoncomma = driver.findElement(By.xpath("//input[@value='Comma']"));
	    js.executeScript("arguments[0].click()", radiobuttoncomma);
	    WebElement headersdefinedon = driver.findElement(By.xpath("//label[@for='mat-slide-toggle-2-input']//span[@class='mat-slide-toggle-thumb']"));
	    js.executeScript("arguments[0].click()", headersdefinedon);
	    WebElement csvdonebutton = driver.findElement(By.xpath("/html[1]/body[1]/is-root[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/is-parse-csv[1]/div[1]/div[3]/is-button[2]/button/span[1]"));
	    wait.until(ExpectedConditions.visibilityOf(csvdonebutton));
	    js.executeScript("arguments[0].click()", csvdonebutton);
	    Thread.sleep(5000);
	    
	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}

}


