package report.jangjihun.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Insert {
Scanner scan=new Scanner(System.in);
	
	public LinkedHashMap scannerInput(){     //해쉬맵 함수를 이용해서 값을 Scanner로 입력받는다.
		LinkedHashMap<String,String> hm=new LinkedHashMap<String,String>();  //링크드해쉬맵은 순서가 있고, 그냥 해쉬맵은 순서가 없다~!!!!!!!!!!!!!!!!!!!!!!!
		
	
		System.out.print("id를 입력하시오");
		hm.put("id", scan.nextLine());
		
		System.out.print("pwd를 입력하시오");
		hm.put("pwd", scan.nextLine());
		
		System.out.print("name을 입력하시오");
		hm.put("name", scan.nextLine());
		
		System.out.print("age를 입력하시오");
		hm.put("age", scan.nextLine());
		
		System.out.print("class_num을 입력하시오");
		hm.put("class_num", scan.nextLine());
		
		return hm;
		
	
		}
	
	
	public boolean insertUser(HashMap<String,String> hm,String sql) { // insert문 , 해쉬맵 함수를 매개변수로 받아 insert한다.
		try {
			Connection con = DBConn2.getCon();
			String[] keys=hm.keySet().toArray(new String[hm.size()]);  //keySet() 키에 대한 배열을 가져온다. 즉 리스트
			PreparedStatement prestmt = con.prepareStatement(sql);
			for(int i=0;i<keys.length;i++){
			prestmt.setString(i+1,hm.get(keys[i]));    // 물음표가 5개
			}
			int result = prestmt.executeUpdate(); 
			DBConn2.closeCon();
			if (result == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

}
