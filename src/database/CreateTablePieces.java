package database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTablePieces {
	public static void main(String[] args) throws SQLException {
		
		final String DB_NAME = "game";
		final String TABLE_NAME = "PIECES";
		
		//use try-with-resources Statement
		try (Connection con = ConnectionTest.getConnection(DB_NAME);
				Statement stmt = con.createStatement();
		) {
			int result = stmt.executeUpdate("CREATE TABLE PIECES (" +
					"PIECE_NAME VARCHAR(20) NOT NULL," +
					"ROW INT NOT NULL," +
					"COLUMN INT NOT NULL," +
					"HEALTH INT NOT NULL," +
					"PRIMARY KEY (PIECE_NAME)" +
					")");
			if(result == 0) {
				System.out.println("Table " + TABLE_NAME + " has been created successfully");
			} else {
				System.out.println("Table " + TABLE_NAME + " is not created");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
