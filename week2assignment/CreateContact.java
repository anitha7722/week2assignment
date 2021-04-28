package week2assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
		 //Pseudo Code
		 
		 //1. Launch URL "http://leaftaps.com/opentaps/control/login"
		  driver.get("http://leaftaps.com/opentaps/control/login");
		  driver.manage().window().maximize();
		
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 // 2. Enter UserName and Password Using Id Locator
		  driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		  driver.findElement(By.id("password")).sendKeys("crmsfa");
		//3. Click on Login Button using Class Locator
		  driver.findElement(By.className("decorativeSubmit")).click();
		  String text = driver.findElement(By.tagName("h2")).getText();
		  System.out.println(text);
		 
		// 4. Click on CRM/SFA Link
		  driver.findElement(By.linkText("CRM/SFA")).click();
	    //5. Click on contacts Button
		  driver.findElement(By.linkText("Contacts")).click();
		//6.click on create contact
		  driver.findElement(By.linkText("Create Contact")).click();
	    //7. Enter FirstName Field Using id Locator
		  driver.findElement(By.id("firstNameField")).sendKeys("Anitha");
		// 8. Enter LastName Field Using id Locator
		  driver.findElement(By.id("lastNameField")).sendKeys("S");
		 // 9. Enter FirstName(Local) Field Using id Locator
		  driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("AN"); 
		 //10. Enter LastName(Local) Field Using id Locator
		  driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("NA");
		 //11. Enter Department Field Using any Locator of Your Choice
		  driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Atinashop");
		 // 12. Enter Description Field Using any Locator of your choice 
		  driver.findElement(By.id("createContactForm_description")).sendKeys("love to learn");
		 //13. Enter your email in the E-mail address Field using the locator of your choice
		  driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("ani@gmail.com");
		 //14. Select State/Province as NewYork Using Visible Text
		  WebElement eleDropdown1 = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		  Select dd1 = new Select (eleDropdown1);
		  dd1.selectByVisibleText("Indiana");
		 //15. Click on Create Contact
		  driver.findElement(By.name("submitButton")).click();
		 // 16. Click on edit button 
		  driver.findElement(By.linkText("Edit")).click();
		 //17. Clear the Description Field using .clear
		  driver.findElement(By.id("updateContactForm_description")).clear();
		 //18. Fill ImportantNote Field with Any text
		  driver.findElement(By.id("updateContactForm_description")).sendKeys("learn selenium with love");
		 // 19. Click on update button using Xpath locator
		  driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		 //20. Get the Title of Resulting Page.
          String Title = driver.getTitle();
          System.out.println(Title);
          driver.close();
	}



	

}

