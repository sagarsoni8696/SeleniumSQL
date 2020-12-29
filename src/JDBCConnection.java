import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JDBCConnection 
{
	public static void main(String[] args) throws SQLException
	{
		//String host = "localhost";
		//String port = "3306";
	   
		//Use database not table 
		String ConnectionURL = "jdbc:mysql://localhost:3306/qadbt";
		
        Connection Con = (Connection) DriverManager.
               getConnection(ConnectionURL, "root", "Swagat@8696");
        
        Statement Stm = (Statement) Con.createStatement();
        ResultSet Rs = Stm.executeQuery("SELECT * FROM BankCredentials WHERE UserName = 'SagarSoni8696'");
        
        while(Rs.next())
        {
	      //System.out.println(Rs.getString("Scenario"));
	      //System.out.println(Rs.getString("UserName"));
	      //System.out.println(Rs.getString("Password"));
	     // System.out.println(Rs.getString("AGE"));
	       
	      System.setProperty("webdriver.chrome.driver", "S:\\Browser Drivers\\Chrome Driver\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.get("https://www1.royalbank.com/cgi-bin/rbaccess/rbcgi3m01?F6=1&F7=IB&F21=IB&F22=IB&REQUEST=ClientSignin&LANGUAGE=ENGLISH&_ga=2.19292152.1912912898.1608260769-355526156.1608260769");
	      
	      driver.findElement(By.cssSelector("input[class='ccUsername']")).sendKeys(Rs.getString("UserName"));
	      driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Password");
	      driver.findElement(By.cssSelector("button[class='yellowBtnLarge']")).click();
	      
	      driver.close();
        }
	
	}

}
