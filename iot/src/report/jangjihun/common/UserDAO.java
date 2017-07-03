package report.jangjihun.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDAO {
	public List<HashMap> doSelect(String sql) {
		List<HashMap> userlist = new ArrayList<HashMap>();
		try {
			Connection con = DBConn2.getCon();
			PreparedStatement prestmt = con.prepareStatement(sql);
			ResultSet rs = prestmt.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData(); //rs의 Column정보를 넘겨줌
			System.out.println(rsmd.getColumnName(1));//Column1인 num이 출력
			System.out.println(rsmd.getColumnCount()); //Column갯수 5 출력
			while (rs.next()) {
				HashMap hm=new HashMap();
				int colCount=rsmd.getColumnCount();
				for(int i=1;i<=colCount;i++){
					String colName = rsmd.getColumnName(i);
					hm.put(colName,rs.getString(colName));
				}
				userlist.add(hm);
			}
			DBConn2.closeCon();
			return userlist;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args){
		UserDAO ud=new UserDAO();
		Insert ud2=new Insert(); //insert 클래스에서 호출
		String sql = "insert into user_info(id, pwd, name, age,class_num) values(?,?,?,?,?)";  //sql문의 순서를 정했으면 링크드해쉬맵을 써야한다!!!!, 해쉬맵을 쓰려면 insert 쿼리문에 써야한다 이건 선생님꺼 보기!!!
		ud2.insertUser(ud2.scannerInput(),sql);                                                                                           
		
		String sql1="select num, id, pwd, name, age,class_num from user_info";
		List<HashMap> userList= ud.doSelect(sql1);
		System.out.println(" = user_info =" );
		for(HashMap hm:userList){
			System.out.println(hm);
		}

}
}