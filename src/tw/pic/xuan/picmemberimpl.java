package tw.pic.xuan;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class picmemberimpl implements PicI {



	public picmemberimpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(picMember m) throws SQLException {
		String sqlstr = "insert into Picturetest (imageName,ftent)values(?,?)";
		PreparedStatement state =con.prepareStatement(sqlstr);
		state.setString(1, m.getImageName());
		state.setBytes(2, m.getFtent());
		state.executeUpdate();
		state.close();
		
	}

	@Override
	public void imageProcessRoad() throws SQLException, IOException {
		String sqlstr = "select * from Picturetest where picid=?";
		PreparedStatement state = con.prepareStatement(sqlstr);
		state.setInt(1, 1);
		ResultSet rs = state.executeQuery();
		if (rs.next()) {
			Blob blob = rs.getBlob(3);
			int length = (int) blob.length();

			BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream("c:/Temp/test/myimages01.jpg"));
			bos1.write(blob.getBytes(1, length));
			bos1.flush();
			bos1.close();

			rs.close();
			state.close();

			System.out.println("圖片已經讀取出來");
		}
		
	}

	@Override
	public void imageProcess() throws SQLException, FileNotFoundException {
		FileInputStream finput = new FileInputStream("c:/Temp/test/images01.jpg");
		String sqlstrString = "insert into Picturetest(imageName,ftent)values(?,?)";
		PreparedStatement state = con.prepareStatement(sqlstrString);
		state.setString(1, "我的狗狗");
		state.setBinaryStream(2, finput);
		state.execute();
		state.close();
		System.out.println("圖片已經放入");
		
	}

	@Override
	public void update(picMember m) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public picMember findById(int id) throws SQLException {
		String sqlstr = "Select * from Picturetest where picid=?";
		PreparedStatement state = con.prepareStatement(sqlstr);
		state.setInt(1, id);
		ResultSet rs = state.executeQuery();
		picMember m = null;
		
		if(rs.next()) {
			m=new picMember(rs.getInt("picid"),rs.getString("imageName"),rs.getBytes("ftent"));
		}
		rs.close();
		state.close();
		return m;
	}
	private Connection con;
	;
	@Override
	public void createConn() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String urlstr = "jdbc:sqlserver://localhost:1433;databaseName=Middletest;user=watcher;password=ms0339957;encrypt=true;trustServerCertificate=true";
		con=(DriverManager.getConnection(urlstr));
		System.out.println("Connection Status:" + !con.isClosed());
	}

	@Override
	public void closeConn() throws SQLException {
		if (con == null) {
			con.close();
		}
		System.out.println("Connection Closed");
	}

	
	
}

	

	
	


	
		
	


