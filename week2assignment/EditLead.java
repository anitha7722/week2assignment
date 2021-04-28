package week2assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
		 //1.Launch the browser
		  driver.get("http://leaftaps.com/opentaps/control/login");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 //2.Enter the username 
		  driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		//3. Enter the password 
		  driver.findElement(By.id("password")).sendKeys("crmsfa");
		//3. Click on Login Button using Class Locator
		  driver.findElement(By.className("decorativeSubmit")).click();
		  String text = driver.findElement(By.tagName("h2")).getText();
		  System.out.println(text);
		 
		// 4.Click crm/sfa link 
		  driver.findElement(By.linkText("CRM/SFA")).click();
	    
	    //5.Click Leads link
		  driver.findElement(By.linkText("Leads")).click();
		//6.	Click Find leads
		  driver.findElement(By.linkText("Find Leads")).click();
		// 7.	Enter first name
		  driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Anitha");
		  Thread.sleep(5000);
		// 8.	Click Find leads button
		  driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		// 9. Click on first resulting lead
		  driver.findElement(By.xpath("//a[@href='/crmsfa/control/viewLead?partyId=10362']")).click();
		// 10. Verify title of the page
		  String Title = driver.findElement(By.xpath("//div[text()='View Lead']")).getText();
		  System.out.println(Title);

		  String OldName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		  String Old = OldName.replaceAll("[^a-zA-Z]", " ");
		  System.out.println("Old name is -" + Old);
		//11. Click Edit
		  driver.findElement(By.linkText("Edit")).click();
		//12. Change the company name
		  driver.findElement(By.id("updateLeadForm_companyName")).clear();
		  driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Atinashop");
		//13. Click Update
		  driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		//14. Confirm the changed name appears
		  String UpdateName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
			String CompanyName = UpdateName.replaceAll("[^a-zA-Z]", " ");
			System.out.println("Company Name  Updated to -" + CompanyName);

			if (Old.equals(CompanyName)) {
				System.out.println("Lead got updated and both the company names are same ");

			} else {
				System.out.println("Lead is Updated");
			}
			driver.close();
		

	}

}
