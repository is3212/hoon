package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.common.DBConn2;
import com.test.dto.BoardInfo;

public class BoardService {
	
	public boolean InsertBoard(BoardInfo bi){
		Connection con = null;
		PreparedStatement ps=null;
		try{
		con=DBConn2.getCon();
		String sql="insert into Board_info(bititle,bicontent,bipwd,creusr,credat)";
			sql+=" values(?,?,?,?,?)";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, (bi).getBoardTitle());
			ps.setString(2, bi.getBoardContent());
			ps.setString(3, bi.getBoardPwd());
			ps.setString(4, bi.getBoardUser());
			ps.setString(5, bi.getBoardDate());
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
	
	public boolean deleteBoard(BoardInfo bi){
		Connection con=null;
		PreparedStatement ps=null;
		try{
			con=DBConn2.getCon();
			String sql="delete from board_info where binum=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, bi.getBoardNum());
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

	public List selectBoard(BoardInfo bi){
		Connection con=null;
		PreparedStatement ps=null;
		try{
		con=DBConn2.getCon();
		String sql = "select binum,bititle,bicontent,bipwd,creusr,credat from board_info";
        if(bi.getBoardTitle()!=null){
           sql += " where bititle like ?";
        }
        ps=con.prepareStatement(sql);
        if(bi.getBoardTitle()!=null){
        	ps.setString(1, bi.getBoardTitle());
        }
        ResultSet rs = ps.executeQuery();
		List boardList = new ArrayList();
		while(rs.next()){
			BoardInfo bi2=new BoardInfo();
			bi2.setBoardNum(rs.getInt("binum"));
			bi2.setBoardTitle(rs.getString("bititle"));
			bi2.setBoardContent(rs.getString("bicontent"));
			bi2.setBoardPwd(rs.getString("bipwd"));
			bi2.setBoardUser(rs.getString("creusr"));
			bi2.setBoardDate(rs.getString("credat"));
			boardList.add(bi2);
		}
		return boardList;
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	}

}
