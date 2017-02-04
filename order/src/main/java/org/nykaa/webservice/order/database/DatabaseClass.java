package org.nykaa.webservice.order.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseClass {

	// JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/report";
    
	//  Database credentials
    static final String USER = "root";
    static final String PASS = "password";
    
    private String jdbcDriver;
    private String dbUrl;
    private String userName;
    private String password;
    
    public DatabaseClass(){
    	this.jdbcDriver = JDBC_DRIVER;
    	this.dbUrl = DB_URL;
    	this.userName = USER;
    	this.password = PASS;
    }
    
    public DatabaseClass(String jdbcDriver, String dbUrl, String userName, String password){
    	this.jdbcDriver = jdbcDriver;
    	this.dbUrl = dbUrl;
    	this.userName = userName;
    	this.password = password;
    }
    
	public List<List<String>> execute(String query, String[] fields){
		Connection conn = null;
		Statement stmt = null;
		List<List<String>> dbData = new ArrayList<List<String>>();
		System.out.println("DataBase Connectivity started.");
		
		try{
			//Register JDBC driver
			Class.forName(this.jdbcDriver);

			//Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(this.dbUrl, this.userName, this.password);

			//Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// fetching data
			while(rs.next()){
				List<String> row = new ArrayList<String>();
				for(String field : fields){
					row.add(rs.getString(field));
				}				
				dbData.add(row);
			}
			//Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
			dbData.add(new ArrayList<String>());
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
			dbData.add(new ArrayList<String>());
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		return dbData;
	}
	
}
