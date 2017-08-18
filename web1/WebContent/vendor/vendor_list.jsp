<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<div class="container">
<div class="container" style="text-align : center; padding-top : 20px;padding-bottom:20px;">
<select id="s_vendor" class="selectpicker">
</select>
<label>회사이름 :  </label><input type="text" id="viName"/>
<input type="button" id="searchVendor" value="검색"/>
</div>
<table id="table" data-height="460" class="table table-bordered table-hover">
<thead>
<tr>
<th data-field="viNum" class="text-center">회사번호</th>
<th data-field="viName" class="text-center">회사이름</th>
<th data-field="viDesc" class="text-center">회사설명</th>
<th data-field="viAddress" class="text-center">회사주소</th>
<th data-field="viPhone" class="text-center">회사전화번호</th>
</tr>
</thead>
<tbody id="result_tbody">
</tbody>
</table>

<center><button id="btnInsert" class="btn btn-primary" type="button">회사등록</button> <button id="btnGoList" class="btn btn-primary" type="button">리스트 가기</button></center> 


</div>
<div class="jb-center" style="text-align:center">
<ul class="pagination" id="page">
</ul>
</div>
<script>
var pageInfo={};
var nowPage="<%=request.getParameter("nowPage")%>";

if(nowPage=="null"){
	nowPage="1";
}

$("#btnInsert").click(function(){
	location.href="/vendor/vendor_insert.jsp";
})
$("#searchVendor").click(function(){
	var viName=$("#viName").val().trim();
	var viNum=$("#s_vendor").val().trim();
	if(viName==""&& viNum==""){
		alert("회사번호나 회사이름을 입력해주세요");
		return;
	}
	var params={};
	if(viName!=""){
		params["viName"]=viName;
	}
	if(viNum!=""){
		params["viNum"]=viNum;
	}
	params["command"]="list";
	var page={};
	page["nowPage"]=nowPage;
	params["page"]=page;
	movePageWithAjax(params,"/list.vendor",callback);
});
function callback(results){
	var vendorList=results.list;
	var vendorList2=results.list2;
	pageInfo=results.page;
	var search=results.search;
	var vendorStr="<option value=' '>회사번호 선택</option>";
	for(var i=0, max=vendorList2.length;i<max;i++){
		var vendor=vendorList2[i];
		var selectStr="";
		if(search.viNum==vendor.viNum){
			selectStr="selected";
		}
		vendorStr+="<option value='" + vendor.viNum + "' " + selectStr + ">" + vendor.viNum + "</option>";
	}
	$("#s_vendor").html(vendorStr);
	var params={};
	if(search.viNum!=0){
		params["viNum"]=search.viNum;
	}
	if(search.viName){
		params["viName"]=search.viName;
	}
	makePagination(pageInfo,"page");
	setEvent(pageInfo,"/list.vendor");
	$("#table").bootstrapTable("destroy");
	var tableStr="";
	for(var i=0, max=vendorList.length;i<max;i++){
		var vendor=vendorList[i];
		tableStr+="<tr data-view='" + vendor.viNum+"'>";
		tableStr+="<td class='text-center'>" + vendor.viNum+"</td>";
		tableStr+="<td class='text-center'>" + vendor.viName+"</td>";
		tableStr+="<td class='text-center'>" + vendor.viDesc+"</td>";
		tableStr+="<td class='text-center'>" + vendor.viAddress+"</td>";
		tableStr+="<td class='text-center'>" + vendor.viPhone+"</td>";
		tableStr+="</tr>";
	}
	$("#result_tbody").html(tableStr);
	$("tbody[id='result_tbody']>tr[data-view]").click(function(){
		var params={};
		params["viNum"]=this.getAttribute("data-view");
		params["command"]="view";
		var page={};
		page["nowPage"]=pageInfo.nowPage;
		params["page"]=page;
		movePageWithAjax(params,"/list.vendor",callBackView);
	});
}
function callBackView(result){
	var url=result.url + "?nowPage=" + result.page.nowPage + "&viNum=" + result.vendor.viNum + "&viName=" + result.vendor.viName + "&viDesc=" + result.vendor.viDesc + "&viAddress=" + result.vendor.viAddress + "&viPhone=" + result.vendor.viPhone;
location.href=url;
}
$(document).ready(function(){
	var page={};
	page["nowPage"]=nowPage;
	var params={};
	params["page"]=page;
	params["command"]="list";
	movePageWithAjax(params,"/list.vendor",callback);
});
$("#btnGoList").click(function(){
	location.href="/vendor/vendor_list.jsp?nowPage=" + <%=request.getParameter("nowPage")%>
});
</script>