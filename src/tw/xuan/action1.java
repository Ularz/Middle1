package tw.xuan;

import java.io.PrintWriter;
import java.util.Scanner;

public class action1 {

	
	


public static void main(String[] args) throws Exception {
	iterMember mem = memberfactory.createMemberfactory();
	mem.createConn();
	Scanner  scan = new Scanner(System.in);
	
	while(true) {
		System.out.println("請選擇功能");
		System.out.println("(1)根據ID查會員並且列印txt到特定路徑中");
		System.out.println("(2)新增會員");
		System.out.println("(3)刪除會員透過ID或是模糊");
		System.out.println("(4)修改種類");
		int userput= scan.nextInt();
		
		if (userput==0) {
			break;
		}
		
		if(userput==1) {
			System.out.println("請輸入ID來查詢搜索");
			int id = scan.nextInt();

			member find = mem.findById(id);
			if (find != null) {
				System.out.println("這是這個ID的明細" + "\n" + find.getId() + "編號" + "\n" + "生產年" + find.getYears() + "\n" + "編號:"
						+ find.getTyps() + "\n" + "公司:" + find.getCompanys() + "\n" + "產品" + find.getProducts());

			} else {
				System.out.println("沒有找到該編號的產品");

			}
			if (find != null) {
				PrintWriter writer = new PrintWriter("c:/Temp/test/該編號的明細.txt");
				writer.println("該編號的ID" + find.getId());
				writer.println("生產年:" + find.getYears());
				writer.println("種類:" + find.getTyps());
				writer.println("公司名稱:" + find.getCompanys());
				writer.println("產品名:" + find.getProducts());
				writer.close();
			}

			System.out.println("該編號已經寫入記事本");
			
		}
		
		
		
		if(userput==2) {
			System.out.println("請隨便輸入幫你增加資料到SQL");
			int ad1 = scan.nextInt();
			String ad2= scan.next();
			String ad3= scan.next();
			String ad4= scan.next();
				member m1 = new member(ad1,  ad2, ad3, ad4);
				mem.add(m1);
				System.out.println("已經幫你新增了" + ad1);
			
		}
		
		if(userput==3) {
			System.out.println("請輸入ID來刪除");
			int id1 = scan.nextInt();

			System.out.println("請輸入你的模糊字串刪除");
			String str1 = scan.next();
			// String id1 = scanner.next();

			try {
				// mem.deleteById(id1);
				mem.deleteById(id1, str1);
				System.out.println("已經刪除了" + id1 + " 且 yourStringColumn 包含 'StringValue'" + str1);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
				
	}
	
		if(userput==4) {
			System.out.println("請輸入ID來更新資料");
			int id = scan.nextInt();
			member m2 = mem.findById(id);

			if (m2 != null) {
				System.out.println("這是這個ID的明細" + "\n" + m2.getId() + "編號" + "\n" + "生產年" + m2.getYears() + "\n" + "種類:"
						+ m2.getTyps() + "\n" + "公司:" + m2.getCompanys() + "\n" + "產品" + m2.getProducts());
			}
	//
			System.out.println("請輸入新種類");
			String newtyps = scan.next();
			//String newtyps1 = scanner.next();
					member updatemember = new member(m2.getId(), m2.getYears(), newtyps, m2.getCompanys(), m2.getProducts());
					//member updatemember = new member(m2.getId(), m2.getYears(), newtyps, newtyps1, m2.getProducts());
					try {
						mem.update(updatemember);
						System.out.println("資料已更新");
					} catch (Exception e) {
						// TODO: handle exception
					}
					scan.close();
					mem.closeConn();

}
}
}
}