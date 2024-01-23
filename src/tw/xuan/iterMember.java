package tw.xuan;

import java.sql.SQLException;

public interface iterMember {

	public void add(member m) throws SQLException;

	public void update(member m) throws SQLException;

	//public void deleteById(int id) throws SQLException;
	
	//public void deleteById(String keyword) throws SQLException;
	
	public member findById(int id) throws SQLException;

	public void createConn() throws Exception;

	public void closeConn() throws SQLException;

	void deleteById(int id, String StringValue) throws SQLException;



}
