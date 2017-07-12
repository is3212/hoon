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

public class BoardService {
	
	public boolean InsertBoard(HashMap<String,String> hm){
		Connection con = null;
		PreparedStatement ps=null;
		try{
		con=DBConn2.getCon();
		String sql="insert into board(title, content, writer)";
			sql+=" values(?,?,?)";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, hm.get("title"));
			ps.setString(2, hm.get("content"));
			ps.setString(3, hm.get("user_num"));
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

	public boolean deleteBoard(HashMap<String, String> hm){
		Connection con=null;
		PreparedStatement ps=null;
		try{
			con=DBConn2.getCon();
			String sql="delete from board where num=?";
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
	
	public boolean updateBoard(HashMap<String, String> hm){
		Connection con=null;
		PreparedStatement ps=null;
		try{
			con = DBConn2.getCon();
			String sql="update board set title=?, content=?, writer=? where num=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, hm.get("title"));
			ps.setString(2, hm.get("content"));
			ps.setString(3, hm.get("user_num"));
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
	
	public List<HashMap> selectBoard(HashMap<String, String> hm){
		Connection con=null;
		PreparedStatement ps=null;
		try{
		con=DBConn2.getCon();
		List<HashMap> boardlist=new ArrayList<HashMap>();
		hm=new HashMap<String, String>();
		String sql="Select * from board";
		if(hm.get("user_num")!=null){
		sql+=" where writer like ?";
		}
		ps=con.prepareStatement(sql);
		if(hm.get("user_num")!=null){
			ps.setString(1, hm.get("user_num"));
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
