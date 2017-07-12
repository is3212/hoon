package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.common.DBConn2;

public class CommentService {
	
	public boolean InsertComment(HashMap<String,String> hm){
		Connection con = null;
		PreparedStatement ps=null;
		try{
		con=DBConn2.getCon();
		String sql="insert into comment_info(content, UI_num, B_num)";
			sql+=" values(?,?,?)";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, hm.get("content"));
			ps.setString(2, hm.get("UI_num"));
			ps.setString(3, hm.get("B_num"));
			int result=ps.executeUpdate();
			if(result==1){
				con.commit();
				return true;
			}
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		try{
			ps.close();
			DBConn2.closeCon();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
		return false;
	}

	public boolean deleteComment(HashMap<String, String> hm){
		Connection con=null;
		PreparedStatement ps=null;
		try{
			con=DBConn2.getCon();
			String sql="delete from comment_info where num=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, hm.get("num"));
			int result=ps.executeUpdate();
			if(result>0){
				con.commit();
				return true;
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				DBConn2.closeCon();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updateComment(HashMap<String, String> hm){
		Connection con=null;
		PreparedStatement ps=null;
		try{
			con = DBConn2.getCon();
			String sql="update comment_info set content=?, UI_num=?, B_num=? where num=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, hm.get("content"));
			ps.setString(2, hm.get("UI_num"));
			ps.setString(3, hm.get("B_num"));
			ps.setString(4, hm.get("num"));
			int result=ps.executeUpdate();
			if(result==1){
				con.commit();
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
		e.printStackTrace();
		}finally{
			try{
				con.close();
				DBConn2.closeCon();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
		return false;
}
	
	public List<HashMap> selectComment(HashMap<String, String> hm){
		Connection con=null;
		PreparedStatement ps=null;
		try{
		con=DBConn2.getCon();
		List<HashMap> boardlist=new ArrayList<HashMap>();
		hm=new HashMap<String, String>();
		String sql="Select * from comment_info";
		if(hm.get("num")!=null){
		sql+=" where num like ?";
		}
		ps=con.prepareStatement(sql);
		if(hm.get("num")!=null){
			ps.setString(1, hm.get("num"));
		}
		ResultSet rs=ps.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();
		while(rs.next()){
		HashMap hm2 = new HashMap();	
		int colCount=rsmd.getColumnCount();
		for(int i=1;i<=colCount;i++){
			String colName=rsmd.getColumnName(i);
			hm2.put(colName, rs.getString(colName));
		}
		boardlist.add(hm2);
		}
		con.close();
		return boardlist;
	}catch(SQLException | ClassNotFoundException e){
		e.printStackTrace();
	}
	return null;
	}
}
