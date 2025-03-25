import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.Test;
public class NegativePost {
@Test
    public static void main(String[] args) {
	
    System.setProperty("webdriver.gecko.driver", "D:/chromedriver-win64/geckodriver.exe");

    FirefoxOptions options = new FirefoxOptions();
    Properties properties = new Properties();
    WebDriver driver = new FirefoxDriver(options);
            
        try {
            // Launch the Google website
            driver.get("https://gorest.co.in/rest-console");

            // Locate the search input field
            WebElement dropdownOption = driver.findElement(By.id("rsq_type"));
            WebElement sendElement = driver.findElement(By.id("rsq_send"));            
            WebElement urlElement = driver.findElement(By.id("rsq_url"));
            WebElement headerElement = driver.findElement(By.id("rsq_header_value_0"));
            WebElement bodyElement = driver.findElement(By.id("rsq_body"));
            WebElement statusElement = driver.findElement(By.id("rsp-body-title"));
            
            // Pick option from dropdown
            Select dropdown = new Select(dropdownOption);
            dropdown.selectByVisibleText("POST");
            System.out.println("Dropdown Done");
            
            // Wait for 3 seconds
            Thread.sleep(3000);
            
            // Clear and insert the Url 
            urlElement.clear();
            urlElement.sendKeys("https://gorest.co.in/public/v2/users");
            System.out.println("Url Done");
            Thread.sleep(3000);
            
            // Insert the header with Authorized Key
            try {
                FileInputStream input = new FileInputStream("config.properties");
                properties.load(input);
                String token = properties.getProperty("github.token");
                headerElement.sendKeys("Bearer " + token);
                System.out.println("GitHub Token: " + token);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Thread.sleep(3000);          
         
            // Insert the body with the correct message
            bodyElement.sendKeys("{"
            		+ "  \"name\": \"Testing1\","
            		+ "  \"email\": \"testing_testing@testing3.example\","
            		+ "  \"gender\": \"female\","
            		+ "  \"status\": \"active\""
            		+ "}");            
            System.out.println("Body Done");
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