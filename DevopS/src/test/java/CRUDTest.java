import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class CRUDTest {
	private WebDriver webDriver;
	private String BASE_URL = "http://localhost:8080/user-management/";


	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
		webDriver = new ChromeDriver();
	}

	@AfterEach
	void tearDown() throws Exception {
		webDriver.quit();
	}

	@Test
	void test_GetUserList() {
		webDriver.navigate().to(BASE_URL + "UserServlet/dashboard");
		String html = webDriver.findElement(By.xpath("//table[@class='table']/tbody/tr")).getAttribute("innerHTML");
		System.out.println("--- TEST GET USER LIST ---");
		System.out.println(html);
		assert(html.contains("Joey"));
	}
	
	@Test
	void test_AddNewUser() {
		webDriver.navigate().to(BASE_URL + "UserServlet/dashboard");
		// go to add new user page
		webDriver.findElement(By.xpath("//a[contains(.,'Add New User')]")).click();
		// fill in form
		webDriver.findElement(By.id("name")).sendKeys("Test User");
		webDriver.findElement(By.id("email")).sendKeys("testuser@gmail.com");
		webDriver.findElement(By.id("psw")).sendKeys("123456");
		webDriver.findElement(By.className("signupbtn")).click();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String html = webDriver.findElement(By.xpath("//a[contains(.,'Back to Dashboard')]")).getAttribute("innerHTML");
		System.out.println("--- TEST ADD NEW USER ---");
		System.out.println(html);
		assert(html.contains("Back to Dashboard"));	
	}
	
	@Test
	void test_editUser() {
		webDriver.navigate().to(BASE_URL + "UserServlet/dashboard");
		webDriver.findElement(By.xpath("//tbody//tr[last()]//td[last()]//a")).click();
		System.out.println("--- TEST EDIT USER ---");
		System.out.println(webDriver.getCurrentUrl());
		System.out.println(webDriver.getPageSource());
		webDriver.findElement(By.name("name")).clear();
		webDriver.findElement(By.name("name")).sendKeys("Marie");
		webDriver.findElement(By.className("btn-success")).click();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String html = webDriver.findElement(By.xpath("//tbody//tr[last()]//td")).getAttribute("innerHTML");
		System.out.println(html);
		assert(html.contains("Marie"));
	}
	
	@Test
	void test_deleteUser() {
		webDriver.navigate().to(BASE_URL + "UserServlet/dashboard");
		webDriver.findElement(By.xpath("//tbody//tr[last()]//td[last()]//a[last()]")).click();
		System.out.println("--- TEST DELETE USER ---");
		System.out.println(webDriver.getCurrentUrl());
		System.out.println(webDriver.getPageSource());
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String html = webDriver.findElement(By.xpath("//tbody//tr[last()]//td")).getAttribute("innerHTML");
		System.out.println(html);
		assert(!html.contains("Marie"));
	}

}
