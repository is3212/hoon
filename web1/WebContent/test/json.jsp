<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div calss="container">
<table id="table" data-height="460" class="table table-bordered table-hover">
<thead>
<tr>
<th data-field="jtnum" class="text-center">번호</th>
<th data-field="jttext" class="text-center">내용</th>
</tr>
</thead>
<tbody id="result_tbody">
</tbody>
</table>
</div>
번호:<input type="text" id="jtnum"/><br/>
<input type="button" id="btn2" value="호출"/>
<script>
$("#btn2").click(function(){
	var jtnum=$("#jtnum").val();
	var param={};
	param["jtnum"]=jtnum;
	param=JSON.stringify(param);
	var a={
			type : "POST",
			url : "/test/json_select.jsp",
			dataType:"json",
			beforesend:function(xhr){
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			data:param,
			success:function(result){
				$("#table").bootstrapTable({
					data:result
				});
			},
			error:function(xhr,status,e){
				alert("에러 : " + e);
			},
			done : function(e){
			}
	};
	$.ajax(a);
});
</script>
</body>
</html>