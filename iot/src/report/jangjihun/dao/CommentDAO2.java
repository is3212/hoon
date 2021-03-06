package report.jangjihun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import report.jangjihun.common.DBConn2;

public class CommentDAO2 {
	Connection con;
	CommentDAO2() throws ClassNotFoundException, SQLException{
		con = DBConn2.getCon();
	}
	public List<Map> getCommentList(int boardNum) throws SQLException{
		String sql="select num, content, reg_date, UI_num, B_num from comment_info";
		sql+=" where B_num=?";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setInt(1, boardNum);
		
		ResultSet rs= ps.executeQuery();
		ArrayList commentList = new ArrayList();
		while(rs.next()){
			HashMap hm = new HashMap();
			hm.put("num", rs.getString("num"));
			hm.put("content", rs.getString("content"));
			hm.put("reg_date", rs.getString("reg_date"));
			hm.put("UI_num", rs.getString("UI_num"));
			commentList.add(hm);
		}
	rs.close();
	rs=null;
	ps.close();
	ps=null;
	return commentList;
	}
	
	public void closeCon(){
		try{
			DBConn2.closeCon();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		try{
			CommentDAO2 cdao = new CommentDAO2();
			List<Map> commentList = cdao.getCommentList(Integer.parseInt("4"));
			for(Map m2 : commentList){
				System.out.println(m2);
			}
			DBConn2.closeCon();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}
	
}
