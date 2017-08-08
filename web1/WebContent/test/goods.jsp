<%@include file="/common/header.jsp" %>
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
<table id="table" data-height="460" class="table table-bordered table-hover">
<thead>
<tr>
<th data-field="vinum" class="text-center">회사번호</th>
<th data-field="viname" class="text-center">회사이름</th>
<th data-field="videsc" class="text-center">사업분류</th>
<th data-field="viaddress" class="text-center">회사주소</th>
<th data-field="viphone" class="text-center">회사 전화번호</th>
<th data-field="vicredat" class="text-center">등록날짜</th>
<th data-field="vicretim" class="text-center">등록시간</th>
<th data-field="ginum" class="text-center">상품번호</th>
<th data-field="giname" class="text-center">상품이름</th>
<th data-field="gidesc" class="text-center">상품분류</th>
<th data-field="gicredat" class="text-center">출고날짜</th>
<th data-field="gicretim" class="text-center">출고시간</th>
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
</select><br/>
vendor 번호 : <input type="text" id="vinum"/>
<input type="button" id=btn value="호출"/>
<div id="result_div" class="container"></div>
<script>
var thisBlockCnt=0;
var thisNowPage=0;
var thisTotalPage=0;
function callback(results){
	var vendorList=results.vendorList;
	var goodsList=results.goodsList;
	var pageInfo=results.pageInfo;
 
	var pageStr="<li><a>◀◀◀</a></li>";
	pageStr+="<li><a>◀◀</a></li>";
	pageStr+="<li><a>◀</a></li>";
	var blockCnt= new Number(pageInfo.blockCnt);
	thisBlockCnt=blockCnt;
	var nowPage=new Number(pageInfo.nowPage);
	thisNowPage=nowPage;
	var startBlock=Math.floor((nowPage-1)/blockCnt)*10+1; 
	var endBlock=startBlock+blockCnt-1;
	var totalPageCnt=new Number(pageInfo.totalPageCnt);
	thisTotalPage=totalPageCnt
	if(endBlock>totalPageCnt){
		endBlock=totalPageCnt;
	}
	for(var i=startBlock,max=endBlock;i<=max;i++){
		if(i==pageInfo.nowPage){
			pageStr+="<li class='active'><a>" + i + "</a></li>";
		}else{
		pageStr+="<li><a>" + i + "</a></li>";
		}
	}
	pageStr+="<li><a>▶</a></li>";
	pageStr+="<li><a>▶▶</a></li>";
	pageStr+="<li><a>▶▶▶</a></li>";

	$("#page").html(pageStr);
	for(var i=0, max=vendorList.length;i<max;i++){
		$("#s_vendor").append("<option value='" + vendorList[i].vinum + "'>" + vendorList[i].viname + "</option>");
	}
    $("#table").bootstrapTable('destroy');
	$("#table").bootstrapTable({
		data:goodsList
	});
	setEvent();
}
$(document).ready(function(){
	var params={};
	params["nowPage"]="1";
	goPage(params, "/test/vendorinfo.jsp", callback);
});
function setEvent(){
	$("ul[class='pagination']>li>a").click(function(){
		var goPageNum=new Number(this.innerHTML);
		if(isNaN(goPageNum)){
			if(this.innerHTML=="◀"){
				thisNowPage-=1;
			}else if(this.innerHTML=="◀◀"){
				thisNowPage=Math.floor((thisNowPage-1)/thisBlockCnt)*10-9;;
			}else if(this.innerHTML=="◀◀◀"){
				thisNowPage=1;
			}else if(this.innerHTML=="▶"){
				thisNowPage+=1;
			}else if(this.innerHTML=="▶▶"){
				thisNowPage=Math.floor((thisNowPage-1)/thisBlockCnt)*10+11;
			}else if(this.innerHTML=="▶▶▶"){
				thisNowPage=thisTotalPage;
			}
			if(thisNowPage<=0){
				thisNowPage=1;
			}else if(thisNowPage>thisTotalPage){
				thisNowPage=thisTotalPage;
			}
			goPageNum=thisNowPage;
		}
		var params={};
		params["nowPage"]="" +goPageNum; 
		goPage(params,"/test/vendorinfo.jsp",callback);
	})
}
$("#btn").click(function(){
	var vinum=$("#vinum").val();
	var viname=$("#s_vendor").val();
	var param={};
	param["vinum"]=vinum;
	param["s_vendor"]=viname;
	param=JSON.stringify(param);
	var a={
			type:"POST",
			url : "/test/goods_select.jsp",
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
			complete:function(e){	
			}
	};
	$.ajax(a);
});
</script>
</body>
</html>