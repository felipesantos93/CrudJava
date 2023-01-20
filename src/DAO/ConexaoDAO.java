package DAO;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoDAO {
	
	Connection conn;
	Statement st;
	
	public Connection conectarBD() {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancoteste?serverTimezone=UTC", "root", "120993"); 
			st = conn.createStatement();		
			return conn;
		} catch (ClassNotFoundException | SQLException erro ) {
			JOptionPane.showMessageDialog(null, "Drive não está na biblioteca ou erro na conexão com o banco");
			return null;
		}  		
	}
	
	public boolean desconectarBD() {
		try {
			conn.close();
			return true;
		} catch (SQLException e) {
			return false;	
		}
	}
        
}
	
	