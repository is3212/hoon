<%@include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="container">
	<div class="container" style="text-align: center; padding-top: 20px;padding-bottom: 20px;">
		<select id="s_vendor" class="selectpicker">
		</select>
		<label>상품이름 : </label> <input type="text" id="giName"/>
		<input type="button" id="searchGoods" value="검색"/>
		</div>
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th data-field="giNum" class="text-center">상품번호</th>
					<th data-field="giName" class="text-center">상품이름</th>
					<th data-field="giDesc" class="text-center">상품설명</th>
					<th data-field="viNum" class="text-center">생산자번호</th>
					<th data-field="viName" class="text-center">회사이름</th>
				</tr>
			</thead>
			<tbody id="result_tbody">
			</tbody>
		</table>
		<center><button id="btnInsert" class="btn btn-primary" type="button">상품등록</button></center>
	</div>
	<div class="jb-center" style="text-align: center">
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
		location.href="/goods/goods_insert.jsp";
	})
	$("#searchGoods").click(function(){
		var giName=$("#giName").val().trim();
		var viNum=$("#s_vendor").val().trim();
		if(giName=="" && viNum==""){
			alert("회사 선택이나 제품명을 입력해주세요");
			return
		}
		var params={};
		if(giName!=""){
			params["giName"]=giName;
		}
		if(viNum!=""){
			params["viNum"]=viNum;	
		}
		params["command"]="list";
		var page={};
		page["nowPage"]=nowPage;
		params["page"]=page;
		movePageWithAjax(params,"/list.goods",callback);
	});
		function callback(results) {
			var goodsList = results.goodslist;
			pageInfo=results.page;
			var vendorList=results.vendorlist;
			var search=results.search;
			var vendorStr="<option value=' '>회사선택</option>";
			for(var i=0, max=vendorList.length;i<max;i++){
				var vendor=vendorList[i];
			var selectStr="";
			if(search.viNum==vendor.viNum){
				selectStr="selected";
			}
				vendorStr+="<option value='" + vendor.viNum + "' " + selectStr  + ">" + vendor.viName + "</option>";	
			}
			$("#s_vendor").html(vendorStr);
			var params={};
			if(search.viNum!=0){
				params["viNum"]=search.viNum;
			}
			if(search.giName){
				params["giName"]=search.giName;
			}
			makePagination(pageInfo,"page");
			setEvent(pageInfo,"/list.goods");
			$("#table").bootstrapTable('destroy');
			var tableStr="";
			for(var i=0, max=goodsList.length;i<max;i++){
				var goods=goodsList[i];
				tableStr+="<tr data-view='" + goods.giNum + "'>";
				tableStr+="<td class='text-center'>" + goods.giNum+"</td>";
				tableStr+="<td class='text-center'>" + goods.giName+"</td>";
				tableStr+="<td class='text-center'>" + goods.giDesc+"</td>";
				tableStr+="<td class='text-center'>" + goods.viNum+"</td>";
				tableStr+="<td class='text-center'>" + goods.viName+"</td>";
				tableStr+="</tr>";
			}
			$("#result_tbody").html(tableStr);
			$("tbody[id='result_tbody']>tr[data-view]").click(function(){
				var params={};
				params["giNum"]=this.getAttribute("data-view");
				params["command"]="view";
				var page={};
				page["nowPage"]=pageInfo.nowPage;
				params["page"]=page;
				movePageWithAjax(params, "/list.goods", callBackView);
			});
			}
	function callBackView(result){
		var url=result.url + "?nowPage=" + result.page.nowPage + "&giNum=" + result.goods.giNum + "&giName=" + result.goods.giName + "&giDesc=" + result.goods.giDesc + "&viNum=" + result.goods.viNum + "&viName=" + result.goods.viName;
		location.href=url;
	}
		$(document).ready(function() {
			var page = {};
			page["nowPage"] = nowPage;
			var params = {};
			params["page"] = page;
			params["command"] = "list";
			movePageWithAjax(params, "/list.goods", callback);
		});
		
	</script>
</body>
</html>