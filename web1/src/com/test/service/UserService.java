package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.common.DBConn;
import com.test.common.DBConn2;
import com.test.dto.UserInfo;

public class UserService {
	
	public boolean InsertUser(UserInfo ui){
		Connection con = null;
		PreparedStatement ps=null;
		try{
		con=DBConn2.getCon();
		String sql="insert into user_info(useid,username,age,address,hp1,hp2,hp3,userpwd)";
			sql+=" values(?,?,?,?,?,?,?,?)";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, ui.getUserId());
			ps.setString(2, ui.getUserName());
			ps.setInt(3, ui.getUserAge());
			ps.setString(4, ui.getUserAddress());
			ps.setString(5, ui.getUserHp1());
			ps.setString(6, ui.getUserHp2());
			ps.setString(7, ui.getUserHp3());
			ps.setString(8, ui.getUserPwd());
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

	
	
	
	
	
	
	public boolean deleteUser(UserInfo ui){
		Connection con=null;
		PreparedStatement ps=null;
		try{
			con=DBConn2.getCon();
			String sql="delete from user_info where usernum=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, ui.getUserNum());
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
	
	public boolean updateUser(UserInfo ui){
		Connection con=null;
		PreparedStatement ps=null;
		try{
			con = DBConn2.getCon();
			String sql="update user_info set username=?, useid=?, age=? where usernum=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, ui.getUserName());
			ps.setString(2, ui.getUserId());
			ps.setInt(3, ui.getUserAge());
			ps.setInt(4, ui.getUserNum());
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
	
	public String checkPwd(String pwd1, String pwd2){
		if(pwd1.equals(pwd2)){
			return "로그인 성공";
		}
		return "비밀번호 틀렸어 임마!";
	}
	public String loginUser(UserInfo ui){
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = DBConn2.getCon();
			String sql = "select userpwd from user_info where useid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ui.getUserId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String userpwd = rs.getString("userpwd");
				return checkPwd(userpwd, ui.getUserPwd());
			}
		}catch(Exception e){
			
		}
		return "그런 아이디 없다잖아!!";
		
	}

	public List selectUser(UserInfo ui){
		Connection con=null;
		PreparedStatement ps=null;
		try{
		con=DBConn2.getCon();
		//List userlist=new ArrayList();
		String sql = "select usernum,useid,username,age,address,hp1,hp2,hp3,userpwd from user_info";
        if(ui.getUserName()!=null){
           sql += " where username like ?";
        }
        ps=con.prepareStatement(sql);
        if(ui.getUserName()!=null){
        	ps.setString(1, ui.getUserName());
        }
        ResultSet rs = ps.executeQuery();
		List userList = new ArrayList();
		while(rs.next()){
			UserInfo ui2=new UserInfo();
			ui2.setUserNum(rs.getInt("usernum"));
			ui2.setUserName(rs.getString("username"));
			ui2.setUserId(rs.getString("useid"));
			ui2.setUserAge(rs.getInt("age"));
			ui2.setUserAddress(rs.getString("address"));
			ui2.setUserHp1(rs.getString("hp1"));
			ui2.setUserHp2(rs.getString("hp2"));
			ui2.setUserHp3(rs.getString("hp3"));
			ui2.setUserPwd(rs.getString("userpwd"));
			userList.add(ui2);
		}
		return userList;
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	}

}
