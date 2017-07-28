<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>IOT_MAIN</title>
<body>
<jsp:include page="/common/top.jsp" flush="false">
	<jsp:param value="<%=login %>" name="login"></jsp:param>
	</jsp:include>
    <div class="container">

      <div class="starter-template">
        <h1><%=userId %> 님</h1>
        <p class="lead">いらっしゃいませ~!</p>
      </div>

    </div><!-- /.container -->
</body>