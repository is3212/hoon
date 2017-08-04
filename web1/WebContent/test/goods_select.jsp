<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="com.test.common.DBConn2" %>
    <%@ page import="com.google.gson.*" %>
    <%@ page import="java.util.*" %>
<%
Gson g=new Gson();
HashMap<String,String> hm=g.fromJson(request.getReader(),HashMap.class);  
//request.getReader() : 서블릿에서 <body>를 읽을수있음,읽어온 데이타를 hashmap 형태로 저장
String vinumStr="";
String vinameStr="";
String viname="";

if(hm!=null){
vinumStr=hm.get("vinum");
vinameStr=hm.get("s_vendor");
}

if(vinameStr.equals("1")){
	viname="애플";
}else if(vinameStr.equals("2")){
	viname="쌍용자동차";
}else if(vinameStr.equals("3")){
	viname="현대자동차";
}

Connection con=null;
PreparedStatement ps=null;
ArrayList<Map<String,String>> viList = new ArrayList<Map<String,String>>();
try{
con=DBConn2.getCon();
String sql="select vi.vinum,vi.viname,vi.videsc,vi.viaddress,vi.viphone,vi.vicredat,vi.vicretim,gi.ginum,gi.giname,gi.gidesc,gi.gicredat,gi.gicretim";
sql+=" from vendor_info vi, goods_info gi where gi.vinum=vi.vinum";

if((vinumStr!=null&&!vinumStr.equals(""))|| (vinameStr!=null&&!vinameStr.equals(""))){
sql+=" and (vi.vinum=? or vi.viname=?)";
}
ps=con.prepareStatement(sql);
if((vinumStr!=null&&!vinumStr.equals(""))|| (vinameStr!=null&&!vinameStr.equals(""))){
ps.setString(1, vinumStr);
ps.setString(2,viname);
}
ResultSet rs=ps.executeQuery();
while(rs.next()){
Map rhm=new HashMap();
rhm.put("vinum",rs.getInt("vi.vinum"));
rhm.put("viname",rs.getString("vi.viname"));
rhm.put("videsc",rs.getString("vi.videsc"));
rhm.put("viaddress",rs.getString("vi.viaddress"));
rhm.put("viphone",rs.getString("vi.viphone"));
rhm.put("vicredat",rs.getString("vi.vicredat"));
rhm.put("vicretim",rs.getString("vi.vicretim"));
rhm.put("ginum",rs.getInt("gi.ginum"));
rhm.put("giname",rs.getString("gi.giname"));
rhm.put("gidesc",rs.getString("gi.gidesc"));
rhm.put("gicredat",rs.getString("gi.gicredat"));
rhm.put("gicretim",rs.getString("gi.gicretim"));
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