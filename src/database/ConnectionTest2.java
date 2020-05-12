package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest2 {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
    	Connection con = ConnectionTest.getConnection("game");
    	Statement stmt = con.createStatement();
    	String clearPieces = "DELETE FROM PIECES";
    	stmt.executeUpdate(clearPieces);
    	}
    }
