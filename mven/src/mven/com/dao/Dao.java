package mven.com.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;



public class Dao {
	private static Connection link;
	

public static Connection getconnection(){
	try {
		Properties properties = new Properties();
		properties.load(new FileInputStream("src/coonect.properties"));
		Class.forName(properties.getProperty("driver"));
		link = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("pass"));
		
		
	} catch (Exception e) {
		System.out.println(e);
		
	}
	return link;

	}


}
