<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn2"%>
<%@ page import="com.google.gson.*"%>
<%@ page import="java.util.*"%>
<%
Gson g=new Gson();
HashMap<String, String> hm =g.fromJson(request.getReader(), HashMap.class);
String jtnumStr="";
int jtnum=0;
if(hm!=null){
jtnumStr=hm.get("jtnum");
jtnum=Integer.parseInt(jtnumStr);
}
Connection con=null;
PreparedStatement ps=null;
ArrayList<Map<String,String>> calList= new ArrayList<Map<String,String>>();
try{
con=DBConn2.getCon();
String sql="select jtnum, jttext from json_test";

if(jtnumStr!=null&&!jtnumStr.equals("")){
sql+=" where jtnum=?";
}
ps=con.prepareStatement(sql);
if(jtnumStr!=null&&!jtnumStr.equals("")){
ps.setInt(1,jtnum);
}
ResultSet rs=ps.executeQuery();
while(rs.next()){
Map rhm=new HashMap();
rhm.put("jtnum",rs.getInt("jtnum"));
rhm.put("jttext",rs.getString("jttext"));
calList.add(rhm);
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

String json=g.toJson(calList);
System.out.println(json);
out.print(json);
%>
