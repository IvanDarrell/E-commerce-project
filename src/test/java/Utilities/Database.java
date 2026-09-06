package Utilities;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Database {

	private WebDriver driver;
	
	public Database (WebDriver driver) {
		this.driver = driver;
		connecttomydatabase();
		getUsersInfo();
	}
	
	
	
	static String dbUrl = "jdbc:mysql://localhost:3306/automation";
	
	static String username = "root";
	static String password = "Megadeth13*";

	public static String url = "";
	
	public static List<Map<String, Object>> userinfo;
	
	public static Map<String, Object> data = new HashMap<>();
	public static void connecttomydatabase () {
	
	    try {
	    	
	   
	    	 Connection con = DriverManager.getConnection(dbUrl, username, password);
	    	 Statement stmt = con.createStatement();
	         String query = "SELECT * FROM url WHERE url = 'https://shop.qaautomationlabs.com/';";  
	         
            
	         ResultSet rs = stmt.executeQuery(query);
	         
	         
	         if (rs.next()) {
	        	 
	        	 url = rs.getString("url");
	        	 
	         }
	         
	         
	         
	         System.out.println(url);
	         
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
		
		
	}
	
	
	public static void getUsersInfo() {
		
		try { 
			
		
		Connection con = DriverManager.getConnection(dbUrl, username, password);
	    Statement stmt = con.createStatement();
	    String query = "SELECT * FROM ecommerceuser LIMIT 1;";  
			
	    ResultSet rs = stmt.executeQuery(query);	
	    ResultSetMetaData metaData = rs.getMetaData();
	    int columnCount = metaData.getColumnCount();	
	    
	    
	    
	    List<Map<String, Object>> tableData = new ArrayList<>();

	    while (rs.next()) {
	        Map<String, Object> row = new HashMap<>();
	        
	        for (int i = 1; i <= columnCount; i++) {
	            String columnName = metaData.getColumnName(i);
	            Object columnValue = rs.getObject(i);
	            
	            row.put(columnName, columnValue);
	        }
	        tableData.add(row);
	        data = row;	
	    }
	    
	    
	    userinfo = tableData;
		
		} catch (Exception e) {
			
		}
		
	}
	
	
	
	public static void main (String [] args) {
		
		
		getUsersInfo();
		System.out.println(data.get("birthday"));
	}
	
	
	
}
