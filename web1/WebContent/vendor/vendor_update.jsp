<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class=container-view">
<table id="table" data-height="460" class="table table-bordered table-hover">
<thead>
<tr>
<th colspan="2" class="text-center"><h5 class="form-signin-heading">회사 수정 페이지</h5></th>
</tr>
<tr>
<td class="col-md-2">회사이름</td>
<td class="col-md-4"><input type="text" name="viName" id="viName"></td>
</tr>
<tr>
<td>회사설명</td>
<td><input type="text" name="viDesc" id="viDesc"></td>
</tr>
<tr>
<td>회사주소</td>
<td><input type="text" name="viAddress" id="viAddress"></td>
</tr>
<tr>
<td>회사 전화번호</td>
<td><input type="text" name="viPhone" id="viPhone"></td>
</tr>
<tr>
<td colspan="2" align="center">
<button id="btnUpdate" class="btn btn-primary" type="button">회사 수정</button>
<button id="goList" class="btn btn-primary" type="button">취소</button>
</td>
</tr>
</thead>
</table>
</div>
<script>
$("#btnUpdate").click(function(){
	var params={};
	params["command"]="update";
	params["viName"]=$("#viName").val();
	params["viDesc"]=$("#viDesc").val();
	params["viAddress"]=$("#viAddress").val();
	params["viPhone"]=$("#viPhone").val();
	params["viNum"]="<%=request.getParameter("viNum")%>";
	movePageWithAjax(params,"/list.vendor",callbackInsert);
});

function callbackInsert(result){
	alert(result.msg);
	location.href=result.url;
}
$(document).ready(function(){
	var params={};
	params["command"]="view";
	params["viNum"]="<%=request.getParameter("viNum")%>";
	var page={};
	page["nowPage"]="<%=request.getParameter("nowPage")%>";
	params["page"]=page;
	movePageWithAjax(params,"/list.vendor",callback);
});

function callback(result){
	$("#viName").val(result.vendor.viName);
	$("#viDesc").val(result.vendor.viDesc);
	$("#viAddress").val(result.vendor.viAddress);
	$("#viPhone").val(result.vendor.viPhone);
}
$("#goList").click(function(){
	location.href="/vendor/vendor_list.jsp?nowPage=" + <%=request.getParameter("nowPage")%>
});

</script>
</body>
</html>