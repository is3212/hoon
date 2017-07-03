package report.jangjihun.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Exam2 {
	Scanner scan=new Scanner(System.in);
	
	public HashMap scannerInput(){     //해쉬맵 함수를 이용해서 값을 Scanner로 입력받는다.
		HashMap<String,String> hm=new HashMap<String,String>();
		
		System.out.print("id를 입력하시오");
		hm.put("id", scan.nextLine());
		
		System.out.print("pwd를 입력하시오");
		hm.put("pwd", scan.nextLine());
		
		System.out.print("name을 입력하시오");
		hm.put("name", scan.nextLine());
		
		System.out.print("age를 입력하시오");
		hm.put("age", scan.nextLine());
		
		return hm;
	}
	
	public List<String> getUserIDList(String name) { // select 문
		List<String> userlist = new ArrayList<String>();
		try {
			Connection con = DBConn2.getCon();
			String sql = "select num,id,pwd,name,age from user ";   //띄어쓰기 해주기!!!!!!!!!!!!!!!!
			if (!name.equals("")) {
				sql+= "where name =?";  //?
			}
			PreparedStatement prestmt = con.prepareStatement(sql);
			if(!name.equals("")){
				prestmt.setString(1, name);           //위에 ?가 한개이고 첫번째이니까 1을 넣는다. 물음표에 name을 바인딩 시킨다.
			}
			ResultSet rs = prestmt.executeQuery();
			while (rs.next()) {
				userlist.add(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4));
			}
			DBConn2.closeCon();
			return userlist;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertUser(HashMap<String,String> hm) { // insert문 , 해쉬맵 함수를 매개변수로 받아 insert한다.
		try {
			Connection con = DBConn2.getCon();
			String sql = "insert into user(id, pwd, name, age) values(?,?,?,?)";
			PreparedStatement prestmt = con.prepareStatement(sql);
			prestmt.setString(1,hm.get("id"));    // 물음표가 4개
			prestmt.setString(2, hm.get("pwd"));
			prestmt.setString(3, hm.get("name"));
			prestmt.setString(4, hm.get("age")); //age는 int이므로
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
	
	public boolean deleteUser(){  //delete 문
		try{
			Connection con=DBConn2.getCon();
			String sql="delete from user where num='3'";
		PreparedStatement prestmt=con.prepareStatement(sql);
		int result=prestmt.executeUpdate();
		DBConn2.closeCon();
		if (result >0) {
			return true;
		}
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateUser(){ //update 문
		try{
			Connection con=DBConn2.getCon();
			String sql="update user set name='장지훈' where name='홍길동'";
			PreparedStatement prestmt=con.prepareStatement(sql);
			int result=prestmt.executeUpdate();
			DBConn2.closeCon();
			if(result==1){
				return true;
			}
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		Exam2 e2 = new Exam2();
		e2.insertUser(e2.scannerInput()); //리턴받은 hm값 넣는다.
		//e2.deleteUser();
		//e2.updateUser();
		List<String> userList = e2.getUserIDList(""); 
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i));
		}

	}
}
