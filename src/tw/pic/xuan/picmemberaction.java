package tw.pic.xuan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class picmemberaction {

	
	



		public void processaction() throws Exception {
		
		}



public static void main(String[] args) throws Exception {
	
	
	PicI pic = picmemberfactory.creatpicmemberfactory();
	pic.createConn();
	
	
	
	pic.imageProcess();
	pic.imageProcessRoad();
	
	pic.closeConn();
	
	try {
	FileInputStream fileinput =new FileInputStream("c:/Temp/test/images01.jpg");
	picMember mem1=new picMember("我的狗",fileinput);
	pic.add(mem1);
	}catch (FileNotFoundException e) {
		System.out.println("檔案沒有找到");
	}

	
	
	
	

	
	Scanner scan = new Scanner(System.in);
	System.out.println("請輸入資料查詢");
	
	int pi = scan.nextInt();
	
	picMember pmember = pic.findById(pi);
	
	if(pmember!=null) {
		System.out.println("這是這個照片的細節"+pmember.getPicid()+"名字:"+pmember.getImageName()+"檔案進制:"+pmember.getFtent());
	}else {
		System.out.println("沒有找到該圖片ID");
	
	}
	
	
	
	
	
	}


	}

