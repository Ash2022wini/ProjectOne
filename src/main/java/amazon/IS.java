package amazon;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IS {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ashwini.premanand\\eclipse-workspace\\Set1\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver d = new ChromeDriver(co);
		d.get("https://analytics-qa.iriworldwide.com/unify-analyticsqa/index.html");
		d.manage().window().maximize();
		WebElement userid = d.findElement(By.id("userID"));
		userid.sendKeys("Unifyqa34");
		WebElement password = d.findElement(By.id("password"));
		password.sendKeys("QaTest@34");
		WebElement loginbutton = d.findElement(By.id("login"));
		loginbutton.click();	
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement menubutton = d.findElement(By.xpath("/html/body/div[1]/div[8]/div[1]/ul/li[1]/a[1]"));
		menubutton.click();
		JavascriptExecutor js = (JavascriptExecutor)d;
		WebElement apps = d.findElement(By.xpath("(.//a[@class='mm-subopen mm-fullsubopen'])[3]"));
		js.executeScript("arguments[0].click();", apps);
		WebElement isselector = d.findElement(By.xpath("//a[@id='menu-Intelligence-Suite-3.X']"));
		js.executeScript("arguments[0].click();", isselector);
		Thread.sleep(5000);
		d.switchTo().frame(0);
		System.out.println("Successfully inside the Frame");
		
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(50));
		WebElement createbutton = d.findElement(By.xpath("//span[normalize-space()='Create']"));
		wait.until(ExpectedConditions.visibilityOf(createbutton));
	    js.executeScript("arguments[0].click();", createbutton);
	    Thread.sleep(3000);
	    WebElement connection = d.findElement(By.xpath("//div[@id='main-menu0']//span[@class='operation__icon']"));
	    js.executeScript("arguments[0].click();",connection);
	    WebElement fileconnection = d.findElement(By.xpath("//span[normalize-space()='File Connection']"));
	    js.executeScript("arguments[0].click();", fileconnection);
	    d.findElement(By.xpath("//input[@title='Click here to select file']")).sendKeys("C:\\Users\\ashwini.premanand\\Desktop\\Test Data\\CSVfile.csv");
	    WebElement radiobuttoncomma = d.findElement(By.xpath("//input[@value='Comma']"));
	    js.executeScript("arguments[0].click()", radiobuttoncomma);
	    WebElement headersdefinedon = d.findElement(By.xpath("//label[@for='mat-slide-toggle-2-input']//span[@class='mat-slide-toggle-thumb']"));
	    js.executeScript("arguments[0].click()", headersdefinedon);
	    WebElement csvdonebutton = d.findElement(By.xpath("/html[1]/body[1]/is-root[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/is-parse-csv[1]/div[1]/div[3]/is-button[2]/button/span[1]"));
	    wait.until(ExpectedConditions.visibilityOf(csvdonebutton));
	    js.executeScript("arguments[0].click()", csvdonebutton);
	    Thread.sleep(5000);
	    WebElement managecolumn = d.findElement(By.xpath("/html[1]/body[1]/is-root[1]/is-flow-builder[1]/div[1]/div[1]/span[2]/is-tool-menu[1]/div[1]/div[6]/div[1]/span[2]"));
	    js.executeScript("argument[0].click()", managecolumn);
	    WebElement rename = d.findElement(By.xpath("//input[@id='mat-input-5']"));
	    rename.sendKeys("test678");
	    WebElement mcdonebutton = d.findElement(By.xpath("/html[1]/body[1]/is-root[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/is-manage-columns[1]/div[1]/div[2]/is-button[2]/button[1]/span[1]"));
	    js.executeScript("arguments[0].click()", mcdonebutton);
	    
	    
	    
	    
	}

}
