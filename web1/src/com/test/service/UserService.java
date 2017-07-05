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

public class UserService {
	
	public boolean InsertUser(HashMap<String,String> hm){
		Connection con = null;
		PreparedStatement ps=null;
		try{
		con=DBConn2.getCon();
		String sql="insert into user_info(id, pwd, name, class_num, age)";
			sql+=" values(?,?,?,?,?)";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, hm.get("id"));
			ps.setString(2, hm.get("pwd"));
			ps.setString(3, hm.get("name"));
			ps.setString(4, hm.get("class_num"));
			ps.setString(5, hm.get("age"));
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

	public boolean deleteUser(HashMap<String, String> hm){
		Connection con=null;
		PreparedStatement ps=null;
		try{
			con=DBConn2.getCon();
			String sql="delete from user_info where num=?";
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
	
	public boolean updateUser(HashMap<String, String> hm){
		Connection con=null;
		PreparedStatement ps=null;
		try{
			con = DBConn2.getCon();
			String sql="update user_info set name=?, class_num=?, age=? where num=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, hm.get("name"));
			ps.setString(2, hm.get("class_num"));
			ps.setString(3, hm.get("age"));
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
	
	public List<HashMap> selectUser(HashMap<String, String> hm){
		Connection con=null;
		PreparedStatement ps=null;
		try{
		con=DBConn2.getCon();
		List<HashMap> userlist=new ArrayList<HashMap>();
		hm=new HashMap<String, String>();
		String sql="Select * from user_info";
		if(hm.get("name")!=null){
		sql+=" where name like ?";
		}
		ps=con.prepareStatement(sql);
		if(hm.get("name")!=null){
			ps.setString(1, hm.get("name"));
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
		userlist.add(hm2);
		}
		con.close();
		return userlist;
	}catch(SQLException | ClassNotFoundException e){
		e.printStackTrace();
	}
	return null;
	}
}
