package com.adv.qa.selenium.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.adv.qa.selenium.framework.JDBCDriverInformation_PostgreSQL;

public class DatabaseQuery_PostgreSQL {
	public static final Logger log = LoggerFactory.getLogger(DatabaseQuery_PostgreSQL.class);
	static ResultSet rs = null;
	PreparedStatement stmt = null;
	static Connection connection = null;


	public int getProcessCountPostgreSQL() throws SQLException, SeleniumDaoException{
		int processCount = 0;		
		connection = JDBCDriverInformation_PostgreSQL.getPostgreSqlJDBCConnection();
		try {					
			connection = JDBCDriverInformation_PostgreSQL.getPostgreSqlJDBCConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("Select count(*) AS TOTALCOUNT from  TZXQBTAR");			
			while (rs.next()) {
				processCount = rs.getInt("TOTALCOUNT");			  
			}
		}
		  catch (SQLException e) {
				throw new SeleniumDaoException("Unable to execute query to fetch details"); 
			} finally {
				JDBCDriverInformation_PostgreSQL.releaseResources(connection,stmt);
			}
		return processCount;
	}
	
	public String getStatProcessPostgreSQL(String prcss,String req) throws SQLException, SeleniumDaoException{
		String name = null;		
		connection = JDBCDriverInformation_PostgreSQL.getPostgreSqlJDBCConnection();
		try {
			connection = JDBCDriverInformation_PostgreSQL.getPostgreSqlJDBCConnection();
			Statement st = connection.createStatement();
			  ResultSet rs = st.executeQuery("SELECT STAT FROM TZXQTASK WHERE PROC = '"+prcss+"' AND REQ = '"+req+"'");			
			while (rs.next()) {
			  name = rs.getString("STAT");			  
			}
		}
		  catch (SQLException e) {
				throw new SeleniumDaoException("Unable to execute query to fetch details"); 
			} finally {
				JDBCDriverInformation_PostgreSQL.releaseResources(connection,stmt);
			}
		return name;
	}
	
	public void updateProcessPostgreSQL(String prcss,String req) throws SQLException, SeleniumDaoException{
			
		connection = JDBCDriverInformation_PostgreSQL.getPostgreSqlJDBCConnection();
		try {
			connection = JDBCDriverInformation_PostgreSQL.getPostgreSqlJDBCConnection();
			Statement st = connection.createStatement();
			String sql = "UPDATE TZXQTASK SET HOLD_FLAG = ' ' WHERE PROC = '"+prcss+"' AND REQ = '"+req+"'";
			st.executeUpdate(sql);	

		}
		  catch (SQLException e) {
				throw new SeleniumDaoException("Unable to execute query to fetch details"); 
			} finally {
				JDBCDriverInformation_PostgreSQL.releaseResources(connection,stmt);
			}
	}
	
	public void checkProcessPostgreSQL() throws SQLException, SeleniumDaoException{
		
		connection = JDBCDriverInformation_PostgreSQL.getPostgreSqlJDBCConnection();
		try {
			connection = JDBCDriverInformation_PostgreSQL.getPostgreSqlJDBCConnection();
			Statement st = connection.createStatement();
			String sql = "select * from eventdatemappings";
			st.executeUpdate(sql);	

		}
		  catch (SQLException e) {
				throw new SeleniumDaoException("Unable to execute query to fetch details"); 
			} finally {
				JDBCDriverInformation_PostgreSQL.releaseResources(connection,stmt);
			}
	}
	
	
	//Update TZXQBTAR set HOLD-FLAG to 'Y'
	public void updateHoldFlagPostgreSQL() throws SQLException, SeleniumDaoException{
		
		connection = JDBCDriverInformation_PostgreSQL.getPostgreSqlJDBCConnection();
		try {
			connection = JDBCDriverInformation_PostgreSQL.getPostgreSqlJDBCConnection();
			Statement st = connection.createStatement();
			String sql = "UPDATE TZXQBTAR set HOLD-FLAG to 'Y'";
			st.executeUpdate(sql);	

		}
		  catch (SQLException e) {
				throw new SeleniumDaoException("Unable to execute query to fetch details"); 
			} finally {
				JDBCDriverInformation_PostgreSQL.releaseResources(connection,stmt);
			}
	}

}
