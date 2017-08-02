<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="/js/jquery-3.2.1.js"></script>
<body>
	<form action="/test/cal_ok.jsp">
		<table border='1'>
			<tr>
				<td>숫자1</td>
				<td>연산자</td>
				<td>숫자2</td>
				<td>버튼</td>
				<td>결과값</td>
			</tr>
			<tr>
				<td><input type="text" name="num1" id="num1" /></td>
				<td><select id="op" name="op">
						<option value="+">+</option>
						<option value="-">-</option>
						<option value="*">*</option>
						<option value="/">/</option>
				</select></td>
				<td><input type="text" name="num2" id="num2" /></td>
				<td><button type="button" id="btn" name="btn">계산</button></td>
				<td><input type="text" id="result" name="result"></td>
			</tr>
		</table>
	</form>
	<script>
		$("#btn").click(function() {
			var num1 = $("#num1").val();
			var op = $("#op").val();
			var num2 = $("#num2").val();
			var param = {};
			param["num1"] = num1;
			param["op"] = op;
			param["num2"] = num2;
			param = JSON.stringify(param);
			$.ajax({
				type : "POST",
				url : "/test/cal_ok.jsp",
				dataType : "json",        //text로 하면 파싱이 안된다. {"num",7} 이런식으로 나온다.
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				},
				data : param,
				success : function(result) {
				$("#result").val(result.msg);
				},
				error : function(xhr, status, e) {
					alert("에러 : " + e);
				},
				done : function(e) {
				}
			});
		});
	</script>
</body>
</html>