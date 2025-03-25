package testjava;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.junit.jupiter.api.Test;

public class GET {
	@Test
    public static void main(String[] args) {
        // Set the path of the GeckoDriver executable
        System.setProperty("webdriver.gecko.driver", "D:/chromedriver-win64/geckodriver.exe");

        // Create FirefoxOptions instance
        FirefoxOptions options = new FirefoxOptions();

        // Create a new instance of the Firefox driver with options
        WebDriver driver = new FirefoxDriver(options);
        try {
            // Launch the Google website
            driver.get("https://gorest.co.in/rest-console");

            // Locate the search input field
            WebElement dropdownOption = driver.findElement(By.id("rsq_type"));
            WebElement sendElement = driver.findElement(By.id("rsq_send"));            
            WebElement urlElement = driver.findElement(By.id("rsq_url"));
            WebElement headerElement = driver.findElement(By.id("rsq_header_value_0"));
            WebElement statusElement = driver.findElement(By.id("rsp-body-title"));
            
            // Pick option from dropdown
            Select dropdown = new Select(dropdownOption);
            dropdown.selectByVisibleText("GET");
            System.out.println("Dropdown Done");
            
            // Wait for 3 seconds
            Thread.sleep(3000);
            
            // Clear and insert the Url 
            urlElement.clear();
            urlElement.sendKeys("https://gorest.co.in/public/v2/users/7792455");
            System.out.println("Url Done");
            Thread.sleep(3000);
            
            // Insert the header with Authorized Key
            headerElement.sendKeys("Bearer 1e3ef4fb1616451f028408f9a842e511ead09824b23ca320ab2c8f744e729b1e");
            System.out.println("Header Done");          
            Thread.sleep(3000);

            // Sebd Request
            sendElement.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            
            String statusText = statusElement.getText();
            System.out.println(statusText);
            Thread.sleep(3000);
            
            System.out.println("Done All");
            Thread.sleep(3000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();	
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}