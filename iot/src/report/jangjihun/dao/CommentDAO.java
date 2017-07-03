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

public class CommentDAO {
//comment_info
	Connection con;
	public void setConnection() throws ClassNotFoundException, SQLException{
		con=DBConn2.getCon();
	}
	public List<HashMap> selectComment(){
		try{
		List<HashMap> comlist=new ArrayList<HashMap>();
		String sql="select * from comment_info;";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		ResultSetMetaData rsmd=rs.getMetaData();
		while(rs.next()){
			HashMap hm=new HashMap();
			int colCount=rsmd.getColumnCount();
			for(int i=1;i<=colCount;i++){
				String colName=rsmd.getColumnName(i);
				hm.put(colName,rs.getString(colName));
			}
			comlist.add(hm);
			}
		DBConn2.closeCon();
		return comlist;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean insertComment(){
		String sql="insert into comment_info(content,UI_num,B_num,reg_date) values('코멘트내용1',2,15,now());";
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
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updateComment(){
		String sql="update comment_info set comment='댓글' where num='1';";
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
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean deleteComment(){
		String sql="delete from comment_info where num='2';";
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
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		CommentDAO ctao=new CommentDAO();
		try{
			ctao.setConnection();
			//ctao.insertComment();
			//ctao.updateComment();
			//ctao.deleteComment();
			List<HashMap> comlist = ctao.selectComment();
			for(int i=0;i<comlist.size();i++){
				System.out.println(comlist.get(i));
			}
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	}
	
	
}
