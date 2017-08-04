<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/js/jquery-3.2.1.js"></script>
<body>
연산자 : <input type="text" id="op"/><input type="button" id="getCal" value="계산리스트호출"/>
<div id="result_div" class="container"></div>
<script>
var list = [{"result":"4","calnum":"6","op":"+","num1":"2","num2":"2"},
	   {"result":"4","calnum":"7","op":"+","num1":"2","num2":"2"},
	   {"result":"1","calnum":"8","op":"-","num1":"4","num2":"3"},
	   {"result":"6","calnum":"9","op":"*","num1":"2","num2":"3"},
	   {"result":"2","calnum":"10","op":"/","num1":"10","num2":"5"}];
	$("#getCal").click(function(){
	      var tableStr="<table border='1'>";
	      tableStr+="<tr>";
	      tableStr+="<td>result</td>";
	      tableStr+="<td>calnum</td>";
	      tableStr+="<td>op</td>";
	      tableStr+="<td>num1</td>";
	      tableStr+="<td>num2</td>";
	      tableStr+="</tr>";
	   for(var i=0, max=list.length;i<max;i++){
	      var m = list[i];
	      tableStr+="<tr>";
	      tableStr+="<td>" + m.result + "</td>";
	      tableStr+="<td>" + m.calnum + "</td>";
	      tableStr+="<td>" + m.op + "</td>";
	      tableStr+="<td>" + m.num1 + "</td>";
	      tableStr+="<td>" + m.num2 + "</td>";
	      tableStr+="</tr>";
	   }
	   tableStr+="</table>";
	   $("#result_div").html(tableStr);
	});
	
</script>
</body>
</html>