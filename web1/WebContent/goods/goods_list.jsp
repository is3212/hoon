<%@include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th data-field="giNum" class="text-center">상품번호</th>
					<th data-field="giName" class="text-center">상품이름</th>
					<th data-field="giDesc" class="text-center">상품설명</th>
					<th data-field="viNum" class="text-center">생산자번호</th>
					<th data-field="viName" class="text-center">생산자이름</th>
				</tr>
			</thead>
			<tbody id="result_tbody">
			</tbody>
		</table>
	</div>
	<div class="jb-center" style="text-align: center">
		<ul class="pagination" id="page">
		</ul>
	</div>
	<select id="s_vendor">
		<option value="">회사선택</option>
	</select>
	<br /> vendor 번호 :
	<input type="text" id="vinum" />
	<input type="button" id=btn value="호출" />
	<div id="result_div" class="container"></div>
	<script>
		var thisBlockCnt = 0;
		var thisNowPage = 0;
		var thisTotalPage = 0;
		function callback(results) {
			var goodsList = results.list;
			var pageInfo=results.page;
			setPagination(pageInfo,"page");
			setEvent(pageInfo);
			$("#table").bootstrapTable('destroy');
			$("#table").bootstrapTable({
				data : goodsList
			});
		}
		$(document).ready(function() {
			var page = {};
			page["nowPage"] = "1";
			var params = {};
			params["page"] = page;
			params["command"] = "list";
			goPage(params, "/list.goods", callback);
		});
		function setEvent(pageInfo) {
			$("ul[class='pagination']>li:not([class='disabled'])>a").click(
					function() {
						var thisNowPage=pageInfo.nowPage;
						var thisBlockCnt=pageInfo.blockCnt;
						var thisTotalPage=pageInfo.totalPageCnt;
						var goPageNum = new Number(this.innerHTML);
						if (isNaN(goPageNum)) {
							if (this.innerHTML == "◀") {
								thisNowPage -= 1;
							} else if (this.innerHTML == "◀◀") {
								thisNowPage = Math.floor((thisNowPage - 1)
										/ thisBlockCnt) * 10 - 9;
								;
							} else if (this.innerHTML == "◀◀◀") {
								thisNowPage = 1;
							} else if (this.innerHTML == "▶") {
								thisNowPage += 1;
							} else if (this.innerHTML == "▶▶") {
								thisNowPage = Math.floor((thisNowPage - 1)
										/ thisBlockCnt) * 10 + 11;
							} else if (this.innerHTML == "▶▶▶") {
								thisNowPage = thisTotalPage;
							}
							if (thisNowPage <= 0) {
								thisNowPage = 1;
							} else if (thisNowPage > thisTotalPage) {
								thisNowPage = thisTotalPage;
							}
							goPageNum = thisNowPage;
						}
						var page = {};
						page["nowPage"] = "" + goPageNum;
						var params={};
						params["page"]=page;
						params["command"] = "list";
						goPage(params, "/list.goods", callback);
					})
		}
		$("#btn").click(function() {
			var vinum = $("#vinum").val();
			var viname = $("#s_vendor").val();
			var param = {};
			param["vinum"] = vinum;
			param["s_vendor"] = viname;
			param = JSON.stringify(param);
			var a = {
				type : "POST",
				url : "/test/goods_select.jsp",
				dataType : "json",
				beforesend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				},
				data : param,
				success : function(result) {
					$("#table").bootstrapTable({
						data : result
					});
				},
				error : function(xhr, status, e) {
					alert("에러 : " + e);
				},
				complete : function(e) {
				}
			};
			$.ajax(a);
		});
	</script>
</body>
</html>