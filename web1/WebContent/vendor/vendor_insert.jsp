<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container-view">
<table id="table" data-height="460" class="table table-bordered table-hover">
<thead>
<tr>
<th colspan="2" class="text-center"><h5 class="form-signin-heading">회사 등록 페이지</h5></th>
</tr>
<tr>
<td class="col-md-2">회사이름</td>
<td class="col-md-2"><input type="text" name="viName" id="viName"></td>
</tr>
<tr>
<td>회사설명</td>
<td><input type="text" name="viDesc" id="viDesc"></td>
</tr>
<td>회사주소</td>
<td><input type="text" name="viAddress" id="viAddress"></td>
</tr>
<td>회사 전화번호</td>
<td><input type="text" name="viPhone" id="viPhone"></td>
</tr>
<tr>
<td colspan="2" align="center">
<button id="btnInsert" class="btn btn-primary" type="button">회사등록</button>
<button id="goList" class="btn" type="button">취소</button>
</td>
</tr>
</table>
</div>
<script>
$("#btnInsert").click(function(){
	var params={};
	params["command"]="insert";
	params["viName"]=$("#viName").val();
	params["viDesc"]=$("#viDesc").val();
	params["viAddress"]=$("#viAddress").val();
	params["viPhone"]=$("#viPhone").val();
	movePageWithAjax(params,"/list.vendor",callbackInsert);
})
function callbackInsert(result){
	alert(result.msg);
	location.href=result.url;
}
$("#goList").click(function(){
	location.href="/vendor/vendor_list.jsp?nowPage=" + <%=request.getParameter("nowPage")%>
});
</script>
</body>
</html>