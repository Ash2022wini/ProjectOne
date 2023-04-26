package amazon;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Day1 {

	public static void main(String[] args) {
		ChromeOptions chrome = new ChromeOptions();
		chrome.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(chrome);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		

	}

}
