package tw.xuan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class memberimpl implements iterMember {

	public void add(member m) throws SQLException {
		String sqlstr = "Insert into yearGifts(years, typs, companys,products)values(?,?,?,?)";
		PreparedStatement state = conn.prepareStatement(sqlstr);
			state.setInt(1, m.getYears());
			state.setString(2, m.getTyps());
			state.setString(3, m.getCompanys());
			state.setString(4, m.getProducts());
			state.executeUpdate();
			state.close();
		}
	

	@Override
	public void update(member m) throws SQLException {
		String sqlstr = "Update yearGifts set typs=?,products=?,years=? where id=? and companys=?";
		//String sqlstr = "Update yearGifts set typs=?,products=?,years=? ";
		PreparedStatement state = conn.prepareStatement(sqlstr);
			state.setString(1, m.getTyps());
			state.setString(2, m.getProducts());
			state.setInt(3, m.getYears());
			state.setInt(4, m.getId());
			state.setString(5, m.getCompanys());
			
			state.executeUpdate();
			state.close();

		}
	

	@Override
	public void deleteById(int id,String StringValue) throws SQLException {
		//String sqlstr = "Delete from yearGifts where String like ?";
		String sqlstr = "Delete from yearGifts where id =? or products LIKE ? or companys LIKE ? or typs LIKE ?";
		//String sqlstr = "Delete from yearGifts where id =? ";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		//state.setString(1,"%"+keyword+"%" );
			state.setInt(1, id);
			state.setString(2, "%" + StringValue + "%");
			state.setString(3, "%" + StringValue + "%");
			state.setString(4, "%" + StringValue + "%");
			state.executeUpdate();
			state.close();

		}
	

	@Override
	public member findById(int id) throws SQLException {
		//String sqlstr = "select * from yearGifts where String like '%公司%'";
		String sqlstr = "select * from yearGifts where id = ?";
		PreparedStatement state = conn.prepareStatement(sqlstr);
			state.setInt(1, id);
		//state.setString(id, sqlstr);
			ResultSet rs = state.executeQuery();
			member m = null;
			if (rs.next()) {
				m = new member(rs.getInt("id"), rs.getInt("years"), rs.getString("typs"), rs.getString("companys"), rs.getString("products"));
			}
			rs.close();
			state.close();
			return m;
		}
	
	

	private Connection conn;

	@Override
	public void createConn() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String urlstr = "jdbc:sqlserver://localhost:1433;databaseName=Middletest;user=watcher;password=ms0339957;encrypt=true;trustServerCertificate=true";
		conn = DriverManager.getConnection(urlstr);
		System.out.println("Connection Status:" + !conn.isClosed());
	}

	@Override
	public void closeConn() throws SQLException {
		if (conn == null) {
			conn.close();
		}
		System.out.println("Connection Closed");
	}
	
}

