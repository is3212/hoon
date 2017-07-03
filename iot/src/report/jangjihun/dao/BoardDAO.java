package report.jangjihun.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import report.jangjihun.common.DBConn2;
//transaction 인서트 딜리트 업데이트 중 오류가 뜬거 빼고 돌리기
//인서트에서 오류 나고 딜리트 업데이트가 잘 실행됐다면
//딜리트, 업데이트만 실행, 인서트는 실행 안되게
public class BoardDAO {
	Connection con;
	public void setConnection() throws ClassNotFoundException, SQLException{
		con=DBConn2.getCon();
	}
	
	public List<HashMap> selectBoard(){
		try{
		List<HashMap> userlist=new ArrayList<HashMap>();
		String sql="select * from board;";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		ResultSetMetaData rsmd=rs.getMetaData();
		while(rs.next()){
			HashMap hm=new HashMap();
			int colCount=rsmd.getColumnCount();
			for(int i=1;i<=colCount;i++){
				String colName=rsmd.getColumnName(i);
				hm.put(colName, rs.getString(colName));
			}
			userlist.add(hm);
		}
		DBConn2.closeCon();
		return userlist;
	}catch (SQLException e){
		e.printStackTrace();
	}
	return null;
}



	public boolean insertBoard() {
		String sql="insert into board(title, content, writer, reg_date) values('게시판제목3','게시판내용3',3,now());";
		try{
		Statement st=con.createStatement();
		int result=st.executeUpdate(sql);
		if(result==1){
			con.commit();
			st.close();
			st=null;
			return true;
		}
		}catch(Exception e){
			try{
				con.rollback();
			}catch (SQLException e1){
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updateBoard() {
		String sql="update board1 set title='으하하하하' where num='4'";
		try{
		Statement st=con.createStatement();
		int result=st.executeUpdate(sql);
		if(result==1){
			con.commit();
			st.close();
			st=null;
			return true;
		}
		}catch(Exception e){
			try{
				con.rollback();
			}catch (SQLException e1){
				e1.printStackTrace();
			}
		}
		return false;
		}
	
	
	public boolean deleteBoard() {
		String sql="delete from board where num='13'";
		try{
		Statement st=con.createStatement();
		int result=st.executeUpdate(sql);
		if(result>0){
			con.commit();
			st.close();
			st=null;
			return true;
		}
		}catch(Exception e){
			try{
				con.rollback();
			}catch (SQLException e1){
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	
	public static void main(String[] args){
		BoardDAO bdao=new BoardDAO();
		try{
			bdao.setConnection();
			bdao.insertBoard();
			bdao.updateBoard();
			bdao.deleteBoard();
			List<HashMap> userList = bdao.selectBoard(); 
			for (int i = 0; i < userList.size(); i++) {
				System.out.println(userList.get(i));
			}
		}catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}

	
	}
}

