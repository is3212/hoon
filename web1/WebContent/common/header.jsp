<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
    <%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%!          //! :  ! 이후로는 자바다 jsp가 아니다. 함수를 만들수있다.
public void printStr(String str){
	System.out.println("adsfsfad");
}
%>
<%

String userId=(String) session.getAttribute("useid");
String userName="";
int age=0;
String address="";
String hp1="";
String hp2="";
String hp3="";
boolean login=false;
if(userId!=null){
	userName=(String) session.getAttribute("username");
	 age=(Integer) session.getAttribute("age");
	 address=(String) session.getAttribute("address");
	 hp1=(String) session.getAttribute("hp1");
	 hp2=(String) session.getAttribute("hp2");
	 hp3=(String) session.getAttribute("hp3");
	login=true;
}
String rootPath=request.getContextPath();
Date toDate=new Date();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
String toDateStr=sdf.format(toDate);

String init=request.getParameter("init");                      //세션이 끊겼을때, 
String defaultUrl="";
if(init==null&&!login){
defaultUrl=rootPath + "/user/login.jsp?init=1";
response.sendRedirect(defaultUrl);
}

String nowUrl=request.getRequestURI();  //현재 페이지 url을 요청받아 nowUrl에 저장
String loginStr="로그인";
if(login){
	loginStr="로그아웃";
}
%>
<script src="<%=rootPath %>/js/jquery-3.2.1.js"></script>
<script src="<%=rootPath%>/ui/btsp3.7.7/js/bootstrap.min.js"></script>
<script src="<%=rootPath %>/ui/btsp3.7.7/js/bootstrap-table.js"></script>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap-theme.min.css"/>
<link rel="stylesheet" href="<%=rootPath%>/ui/btsp3.7.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="<%=rootPath %>/ui/common.css"/>
<link rel="stylesheet" href="<%=rootPath %>/ui/btsp3.7.7/css/bootstrap-table.css"/>
<script>
var rootPath="<%=rootPath%>";
$(document).ready(function(){                //document: 문서전체ready: onload,즉 준비가되면,      위에서 받은 url경로를 nowurl에 대입
	var nowUrl="<%=nowUrl%>";
	var obj=$("a[href='" + nowUrl + "']").parent().attr("class","active");   //a[href='" + nowUrl + "'] : nowurl이 들어간 a태그 찾는다.   ,  parent() : 부모 즉, 현재 a태그의 부모는 li이므로 li에 class=active가 설정된다  
})                                                                                                                                                      //.attr( attributeName, value ) : 선택자에 의해 선택된 요소에 하나 이상의 속성을 부여할 수 있다.
function doMovePage(pageId)
{
   var url = "";
   if(pageId == "board")
   {
      url = rootPath + "/board/board_select.jsp";
   }else if(pageId=="main"){
	url=rootPath+"/main.jsp";
   }else if(pageId=="signin"){
	   url=rootPath+"/board/board_signin.jsp";
   }else if(pageId=="password"){
	   url=rootPath+"/board/board_password.jsp";
   }else if(pageId=="modify"){
	   url=rootPath+"/board/board_update.jsp";
   }
   location.href=url;
}

</script>
<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IOT_MAIN</title>
</head>
</body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%=rootPath%>/main.jsp">HOME</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="/board/board_select.jsp">게시판가기</a></li>
            <li><a href="/user/user_info.jsp">유저정보가기</a></li>
            <li><a href="/role/role_select.jsp">권한정보가기</a></li>
            <li><a href="/user/logout_ok.jsp"><%=loginStr %></a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
                  <div class="mastfoot">
          <div class="inner">
              <p>Cover template for <a href="https://getbootstrap.com">Bootstrap</a>, by <a href="https://twitter.com/mdo">@mdo</a>.</p>
                          </div>
          </div>
</html>