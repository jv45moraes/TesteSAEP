package packageConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	private final static String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final static String URL = "jdbc:sqlserver://localhost:57725;encrypt=false;databaseName=Teste";
	private final static String User = "sa";
	private final static String Password = "2jv42pm5";
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName(Driver);
			return DriverManager.getConnection(URL,User,Password);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro na conexão!", e);
		}
		
	}
	
	public static void closeConnection(Connection con) {
			try {
				if(con != null) {
				con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		closeConnection(con);
			try {
				if(stmt != null) {
				stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		closeConnection(con, stmt);
			try {
				if(rs != null) {
				rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
