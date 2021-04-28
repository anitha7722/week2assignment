package week2assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeads {

	private static final CharSequence LeadId = null;

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
		//7.	Click on Phone
		  driver.findElement(By.linkText("Phone")).click();
		  Thread.sleep(2000);
		//8.	Enter phone number
		  driver.findElement(By.name("phoneNumber")).sendKeys("123");
		  Thread.sleep(5000);
		//9.	Click find leads button
		  driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		  Thread.sleep(5000);
		//10	Capture lead ID of First Resulting lead and Click First Resulting lead
		  driver.findElement(By.xpath("(//a[@href='/crmsfa/control/viewLead?partyId=11267'])[2]")).click();
		//11.Click Delete
		  driver.findElement(By.linkText("Delete")).click();
		//13	Click Find leads
		  driver.findElement(By.linkText("Find Leads")).click();
		 Thread.sleep(5000);
		//14	Enter captured lead ID
		  driver.findElement(By.name("id")).sendKeys(LeadId);
			//15	Click find leads button
		  driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			//16	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		   //17	Close the browser (Do not log out)
		  String Text = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
			 System.out.println(Text);
			 if(Text.contains("No records to display")) {
				 System.out.println("Lead is deleted");
			 }
			 else
			 {
				 System.out.println("Lead is not deleted");
			 }

			 driver.close();
	}

}
