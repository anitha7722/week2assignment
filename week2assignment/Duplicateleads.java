package week2assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Duplicateleads {

	private static final Object LeadName = null;

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
		
		//7.	Click on Email
		  driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[3]")).click();
		//9	Enter Email
		  driver.findElement(By.name("emailAddress")).sendKeys("ani@gmail.com");
		  Thread.sleep(2000);
		//10	Click find leads button
		  driver.findElement(By.linkText("Find Leads")).click();
		  Thread.sleep(5000);
		//11	Capture name of First Resulting lead
		  driver.findElement(By.xpath("//a[@href='/crmsfa/control/viewLead?partyId=10171']")).click();
		//12	Click First Resulting lead
		  driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		//13	Click Duplicate Lead
		  driver.findElement(By.xpath("//a[@class='subMenuButton']")).click();
		//14	Verify the title as 'Duplicate Lead'
		  String title = driver.getTitle();
			System.out.println(title);
			if(title.contains("Duplicate Lead")) {
				System.out.println("This page is Duplicate Lead");

			}
			else
			{
				System.out.println("The page title is not Duplicate Lead");

			}

		//15	Click Create Lead
			driver.findElement(By.name("submitButton")).click();
		//16	Confirm the duplicated lead name is same as captured name
		//17	Close the browser (Do not log out)
			String DuplicateName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
			if(LeadName.equals(DuplicateName))
			{
				System.out.println("Created Duplicate Name");
			}
			else
			{
				System.out.println("No Duplicate Created");
			}
			driver.close();


	}

}
