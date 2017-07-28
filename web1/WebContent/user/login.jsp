<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn2"%>
<%@ page import="com.test.dto.UserInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=rootPath %>/ui/signin.css"/>
<body>

	<jsp:include page="/common/top.jsp" flush="false">
	<jsp:param value="<%=login %>" name="login"></jsp:param>
	</jsp:include>
<div class="container">
<center><img src="http://cfile25.uf.tistory.com/image/2521124C588467AA12BF0A" style="width:304px;height:250px"></center>
      <form class="form-signin"  action="<%=rootPath %>/user/login_ok.jsp">
        <h2 class="form-signin-heading">Please login</h2>
        <label for="inputEmail" class="sr-only">ID</label>
        <input type="text" name="useid"  id="useid" class="form-control" placeholder="ID" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="userpwd" id="userpwd" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button id="btn2" class="btn btn-lg btn-primary btn-block" type="submit">Login in</button>
      </form>

    </div> <!-- /container -->
    <!--
    <script>
    $("button").click(function(){  //$:  document.getElement와 같다. $() 괄호안에는 태그, id, name 등 모두 쓸 수 있다.    ,  즉 셀렉터라 한다!!,    $모양은 무조건 j쿼리(셀렉터 지원)
    	alert(1);
    });
    $("#btn2").click(function(){  //#이붙으면 id를 찾겠다.  id가 btn2인거에 모두 적용된다.
    	alert(2);
    });
    </script>
     -->
</body>