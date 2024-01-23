package tw.xuan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class load {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		String urlstr = "jdbc:sqlserver://localhost:1433;databaseName=Middletest;user=watcher;password=ms0339957;encrypt=true;trustServerCertificate=true";
		String csvFilePath = "c:/Temp/test/test1.csv";
		String insertQuery = "INSERT INTO yearGifts( years,typs,companys,products) VALUES ( ?, ?, ?, ?)";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
				Connection connection = DriverManager.getConnection(urlstr);
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {

			br.readLine();
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(","); // 
				for (int i = 0; i < data.length; i++) {
					statement.setString(i + 1, data[i]);
				}
				statement.addBatch();
			}

			statement.executeBatch(); // 

			// 

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
}
