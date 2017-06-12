package com.adv.qa.selenium.framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.adv.qa.selenium.helpers.SeleniumDaoException;


public class JDBCDriverInformation_PostgreSQL{
	private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

	static ResultSet rs = null;
	static Statement st = null;
	PreparedStatement stmt = null;
	static Connection connection = null;
	
	
	
/**
 * Took Reference from URL: https://jdbc.postgresql.org/download.html 
 * If you are using Java 8 or newer then you should use the JDBC 4.2 version.
 * PostgreSQL JDBC 4.2 Driver, 42.1.1
 * @return
 */
	
	public static Connection getPostgreSqlJDBCConnection(){
		try {
			 
			Class.forName("org.postgresql.Driver");
			
//			Class.forName("java.sql.Driver");
			
		} catch(java.lang.ClassNotFoundException e) {
			log.error("ClassNotFoundException: ");
			log.error(e.getMessage());
		}

		try {

			connection = DriverManager.getConnection("jdbc:postgresql://voyager.e5qa.dockworker.uk:15432/advanced", "e5", "e5");
			
			
		} catch(SQLException ex) {
			log.error("SQLException: " + ex.getMessage());
		}

		return connection;	
		}
	
	/**
	 *  Releases a Statement/Connection resource.  
	 * @throws SeleniumDaoException
	 */
	public static void releaseResources(Connection con, Statement stmt) throws SeleniumDaoException{
		if(stmt != null){
			try {
				stmt.close();				
			} catch (SQLException e) {
				log.info("Unable to released Statement resource");
				throw new SeleniumDaoException(" Unable to Close the Statement",e);
			}
		}
		
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				log.info("Unable to released Connection resource");
				throw new SeleniumDaoException(" Unable to Close the Connection",e);
			}
		}
		
	}
}
