package tw.pic.xuan;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;





public interface PicI {
	public void add(picMember m) throws SQLException;

	public void update(picMember m) throws SQLException;

	public void deleteById(int id) throws SQLException;

	public picMember findById(int id) throws SQLException;
	
	public void imageProcess()throws  SQLException, FileNotFoundException;
	
	public void imageProcessRoad () throws SQLException, IOException;

	public void createConn() throws Exception;

	public void closeConn() throws SQLException;

	

	

}
