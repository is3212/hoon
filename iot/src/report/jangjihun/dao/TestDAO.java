package report.jangjihun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import report.jangjihun.common.DBConn2;
import report.jangjihun.common.Exam2;

public class TestDAO {
	
Scanner scan=new Scanner(System.in);
HashMap<String,String> hm=new HashMap<String,String>();

	public HashMap scannerInput(){     //해쉬맵 함수를 이용해서 값을 Scanner로 입력받는다.
		
		System.out.print("title를 입력하시오");
		hm.put("title", scan.nextLine());
		
		System.out.print("content를 입력하시오");
		hm.put("content", scan.nextLine());
		
		System.out.print("writer을 입력하시오");
		hm.put("writer", scan.nextLine());
		
		Date d = new Date();                                                                                                                        //
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 내컴퓨터 시간
		
		hm.put("reg_date", sdt.format(d));
		
		return hm;
	}
	
	public HashMap scannerInput2(){
		HashMap<String,String> hm2=new HashMap<String,String>();
		hm2=this.hm;
		return hm2;
	}
	
	public List<Map> selectTest() { 
		List<Map> userlist = new ArrayList<Map>();
		try {
			Connection con = DBConn2.getCon();
			String sql = "select *from test ";   //띄어쓰기 해주기!!!!!!!!!!!!!!!!
			//sql+="where te.writer=ui.num;";
			PreparedStatement prestmt = con.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery();
			while (rs.next()) {
				Map hm=new HashMap();
				hm.put("num", rs.getString("num"));
				hm.put("title", rs.getString("title"));
				hm.put("content", rs.getString("content"));
				hm.put("writer", rs.getString("writer"));
				hm.put("reg_date", rs.getString("reg_date"));
				//hm.put("id", rs.getString("id"));
				//hm.put("name", rs.getString("name"));
				userlist.add(hm);
			}
			DBConn2.closeCon();
			return userlist;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Map> selectTest2(){
		List<Map> testList = new ArrayList<Map>();
		try{
			Connection con = DBConn2.getCon();
			
			String sql = "SELECT T.*, UI.ID, UI.NAME FROM TEST AS T, USER_INFO AS UI";
			sql += " WHERE T.WRITER = UI.NUM;";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Map hm = new HashMap();
				hm.put("num",rs.getString("num"));
				hm.put("title",rs.getString("title"));
				hm.put("content",rs.getString("content"));
				hm.put("writer",rs.getString("writer"));
				hm.put("reg_date",rs.getString("reg_date"));
				hm.put("id",rs.getString("id"));
				hm.put("name",rs.getString("name"));
				testList.add(hm);
			}
			DBConn2.closeCon();
			return testList;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public boolean InsertTest(HashMap<String,String> hm){
		try {
			Connection con = DBConn2.getCon();
			String sql="select * from user_info where num =?";
			PreparedStatement prestmt = con.prepareStatement(sql);
			prestmt.setString(1,hm.get("writer"));
			ResultSet rs=prestmt.executeQuery();
			if(rs.next()){
			sql = "insert into test(title, content, writer, reg_date )";
			sql+="values(?,?,?,?);";         //now()는 now()로 써야한다 ?쓰면 안된다.
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1,hm.get("title"));    // 물음표가 4개
			prestmt.setString(2, hm.get("content"));
			prestmt.setString(3, hm.get("writer"));
			prestmt.setString(4,hm.get("reg_date"));
			int result = prestmt.executeUpdate();
			DBConn2.closeCon();
			if (result == 1) {
				return true;
			}
			}
			else{
				System.out.println(hm.get("writer") + "번호를 가진 사람이 유저인포테이블에 없어요 자시가!!");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateTest(){
		try{
			Connection con=DBConn2.getCon();
			String sql="update test set name='장지훈' where name='홍길동'";
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
	
	
	public boolean deleteTest(HashMap<String,String> hm){
		try{
			Connection con = DBConn2.getCon();
			String sql="select * from user_info where num =(select writer from test where num=?);";
			PreparedStatement prestmt = con.prepareStatement(sql);
			prestmt.setString(1,hm.get("writer"));
			ResultSet rs=prestmt.executeQuery();
			if(rs.next()==false){
			con=DBConn2.getCon();
			sql="delete from test where num=?";
		prestmt=con.prepareStatement(sql);
		prestmt.setString(1,hm.get("writer"));
		int result=prestmt.executeUpdate();
		DBConn2.closeCon();
		if (result >0) {
			return true;
		}
			}
			else{
				System.out.println(hm.get("writer") + "번호를 가진 사람이 유저인포테이블에 있어서 삭제 불가능!!!!!!!!");
			}
				
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args) {
		TestDAO td = new TestDAO();
	    td.InsertTest(td.scannerInput()); //리턴받은 hm값 넣는다.
		//e2.updateUser();
	    System.out.println("======test=======");
		List<Map> userList = td.selectTest(); 
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i));
		}
		System.out.println();
		System.out.println("======조인=======");
		List<Map> list = td.selectTest2();
		for(Map m : list){
			System.out.println(m);
		}
		td.deleteTest(td.scannerInput2());
	}
}
