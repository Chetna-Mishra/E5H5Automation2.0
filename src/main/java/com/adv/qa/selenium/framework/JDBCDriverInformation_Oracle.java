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


public class JDBCDriverInformation_Oracle{
	private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
	

    
    static ResultSet rs = null;
	static Statement st = null;
	PreparedStatement stmt = null;
	static Connection connection = null;
	

	public static Connection getOracleJDBCConnection(){
		

		try {
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch(java.lang.ClassNotFoundException e) 
		
		{
			log.error("ClassNotFoundException: ");
			log.error(e.getMessage());
		}

		try {
			
// Oracle DB with the host:10.31.8.72, port:1522, 	service:pdb1, user= qah5adm, pass=QAH5, Ref Site http://www.orafaq.com/wiki/JDBC
		
						
/*Connection URL for Automation Server*/			
connection = DriverManager.getConnection("jdbc:oracle:thin:@10.31.8.72:1522/pdb1", "qah5adm", "QAH5");

			
/*Connection URL for AIX Server*/			
		
//connection = DriverManager.getConnection("jdbc:oracle:thin:@ghdbrac2.coa.local:1521/GHDB12C", "q55aadm", "Q55A");
			
			
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
				throw new SeleniumDaoException("Unable to Close the Statement",e);
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
