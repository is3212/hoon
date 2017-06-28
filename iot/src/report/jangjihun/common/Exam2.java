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
		HashMap hm=new HashMap();
		
		System.out.print("id를 입력하시오");
		hm.put("id", scan.nextLine());
		
		System.out.print("pwd를 입력하시오");
		hm.put("pwd", scan.nextLine());
		
		System.out.print("name을 입력하시오");
		hm.put("name", scan.nextLine());
		
		System.out.print("age를 입력하시오");
		hm.put("age", Integer.parseInt(scan.nextLine()));
		
		return hm;
	}
	
	public List<String> getUserIDList(String name) { // select 문
		List<String> userlist = new ArrayList<String>();
		try {
			Connection con = DBConn2.getCon();
			String sql = "select id,pwd,name,age from user ";
			if (!name.equals("")) {
				sql+= "where name ='" + name + "'";
			}
			PreparedStatement prestmt = con.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery();
			while (rs.next()) {
				userlist.add(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getInt(4));
			}
			DBConn2.closeCon();
			return userlist;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertUser(HashMap hm) { // insert문 , 해쉬맵 함수를 매개변수로 받아 insert한다.
		try {
			Connection con = DBConn2.getCon();
			String sql = "insert into user(id, pwd, name, age) values('" + hm.get("id") + "','"+ hm.get("pwd") + "','" + hm.get("name") + "','" + hm.get("age") + "')";
			PreparedStatement prestmt = con.prepareStatement(sql);
			int result = prestmt.executeUpdate(); // 넘어오는값이 숫자 이므로 인트, Affected rows: 1 이게 들어가서,  마리아db에서 바뀐 줄
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
