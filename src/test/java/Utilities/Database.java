package Utilities;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Database {

	
	public Database () {
		
		connecttomydatabase();
		
	}
	
	WebDriver driver = Browsers.driver;
	
	static String dbUrl = "jdbc:mysql://localhost:3306/automation";
	
	static String username = "root";
	static String password = "Megadeth13*";

	public static String url = "";
	
	public static void connecttomydatabase () {
	
	    try {
	    	
	   
	    	 Connection con = DriverManager.getConnection(dbUrl, username, password);
	    	 Statement stmt = con.createStatement();
	         String query = "SELECT url FROM url LIMIT 1;";  
	         
            
	         ResultSet rs = stmt.executeQuery(query);
	         
	         
	         if (rs.next()) {
	        	 
	        	 url = rs.getString("url");
	        	 
	         }
	         
	         
	         
	         System.out.println(url);
	         
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
		
		
	}
	
	
	
	public static void main (String [] args) {
		
		
		connecttomydatabase();
	}
	
	
	
}
