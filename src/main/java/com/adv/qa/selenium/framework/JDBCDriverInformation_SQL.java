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


public class JDBCDriverInformation_SQL{
	private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
	
	
//	private static String url = "jdbc:jtds:sqlserver://ghdacsqae55.coa.local:1433/Q55Q;user=q55qadm;password=q55q";
//	private static String url = "jdbc:sqlserver://192.168.35.41\\PROGRESSO09-VM\\MSSQLSERVER;user=progressouser;password=progressouser";
//	private static String url = "jdbc:sqlserver://192.168.31.62\\sqlexpress;user=htmladm;password=html";
	
	static ResultSet rs = null;
	static Statement st = null;
	PreparedStatement stmt = null;
	static Connection connection = null;
	
	
	public static Connection getSqlJDBCConnection(){
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
//			Class.forName("com.mysql.jdbc.Driver");
		} catch(java.lang.ClassNotFoundException e) {
			log.error("ClassNotFoundException: ");
			log.error(e.getMessage());
		}

		try {
			connection = DriverManager.getConnection("jdbc:jtds:sqlserver://ghdacsqae55.coa.local:1433/Q55Q", "q55qadm", "q55q");
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
