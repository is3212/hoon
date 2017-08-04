<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="com.test.common.DBConn2" %>
    <%@ page import="com.google.gson.*" %>
    <%@ page import="java.util.*" %>
<%
Gson g=new Gson();
Connection con=null;
PreparedStatement ps=null;
ArrayList<Map<String,String>> viList = new ArrayList<Map<String,String>>();
try{
con=DBConn2.getCon();
String sql="select vinum,viname from vendor_info";
ps=con.prepareStatement(sql);
ResultSet rs=ps.executeQuery();
while(rs.next()){
Map rhm=new HashMap();
rhm.put("vinum",rs.getInt("vinum"));
rhm.put("viname",rs.getString("viname"));
viList.add(rhm);
}
}catch(Exception e){
System.out.println(e);
}finally{
if(ps!=null){
ps.close();
ps=null;
}
DBConn2.closeCon();
}

String json=g.toJson(viList);
System.out.println(json);
out.print(json);
%>