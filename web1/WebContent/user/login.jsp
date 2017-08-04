<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn2"%>
<%@ page import="com.test.dto.UserInfo"%>
<link rel="stylesheet" href="<%=rootPath %>/ui/signin.css"/>
<body>

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
        <button id="btn2" type="button"  class="form-control2" >Login in</button>
      </form>

    </div> <!-- /container -->

     <script>
     $("#btn2").click(function(){                            //제이슨을 이용한 ajax
    	 var id=$("#useid").val();
    	 var pwd=$("#userpwd").val();
    	 var param={};
    	 param["useid"]=id;
    	 param["userpwd"]=pwd;
    	 param=JSON.stringify(param);
    	 $.ajax({ 
             type     : "POST"
         ,   url      : "/user/login_ok.jsp"
         ,   dataType : "json" 
         ,   beforeSend: function(xhr) {
             xhr.setRequestHeader("Accept", "application/json");
             xhr.setRequestHeader("Content-Type", "application/json");
         }
         ,   data     : param
         ,   success : function(result){
            alert(result.msg);
            if(result.login=="ok"){
            	location.href="<%=rootPath%>/main.jsp"	
            }else{
            	$("#useid").val("");
            	var pwd=$("#userpwd").val("");
            }
         }
         ,   error : function(xhr, status, e) {
               alert("에러 : "+e);
        },
        done : function(e) {
        }
        });
     });
     </script>
</body>
</html>