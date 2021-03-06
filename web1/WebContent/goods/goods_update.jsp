<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container-view">
<table id="table" data-height="460" class="table table-bordered table-hover">
<thead>
<tr>
<th colspan="2" class="text-center"><h5 class="form-signin-heading">상품 등록 페이지</h5></th>
</tr>
<tr>
<td class="col-md-2">상품이름</td>
<td class="col-md-4"><input type="text" name="giName" id="giName"></td>
<tr>
<td>상품설명</td>
<td><input type="text" name="giDesc" id="giDesc"></td>
</tr>
<tr>
<td>생산자번호</td>
<td><select id="s_vendor"></select></td>
</tr>
<tr>
<td colspan="2" align="center">
<button id="btnUpdate" class="btn btn-primary" type="button">상품 수정</button>
<button id="goList" class="btn" type="button">취소</button>
</td>
</tr>
</thead>
</table>
</div>
<!-- /container -->

<script>
$("#btnUpdate").click(function(){
	var params={};
	params["command"]="update";
	params["giDesc"]=$("#giDesc").val();
	params["giName"]=$("#giName").val();
	params["viNum"]=$("#s_vendor").val();
	params["giNum"]="<%=request.getParameter("giNum")%>";
	movePageWithAjax(params,"/list.goods", callbackInsert);
})

$(document).ready(function(){
	var params={};
	params["command"]="vendorlist";
	movePageWithAjax(params,"/list.goods",callback);
})

function callbackInsert(result){
	alert(result.msg);
	location.href=result.url;
}
function callback(result){
	var vendorList=result.vendorList;
	var selStr= "<option value=''>회사선택</option>";
	for(var i=0, max=vendorList.length;i<max;i++){
		var vendor=vendorList[i];
		selStr+="<option value='" + vendor.viNum + "'>" + vendor.viName + "</option>";
	}
	$("#s_vendor").html(selStr);
	
	var params={};
	params["command"]="view";
	params["giNum"]="<%=request.getParameter("giNum")%>";
	var page={};
	page["nowPage"]="<%=request.getParameter("nowPage")%>";
	params["page"]=page;
	movePageWithAjax(params,"/list.goods",callback2);
}
function callback2(result){
	$("#giDesc").val(result.goods.giDesc);
	$("#giName").val(result.goods.giName);
	$("#s_vendor").val(result.goods.viNum);
}
$("#goList").click(function(){
	location.href="/goods/goods_list.jsp?nowPage=" + <%=request.getParameter("nowPage")%>
});
</script>
</body>
</html>