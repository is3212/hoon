<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<div class="container">
<div class="container" style="text-align : center; padding-top : 20px;padding-bottom:20px;">
<label>회사이름 : </label><input type="text" id="viName"/>
<input type="button" id="searchVendor" value="검색"/>
</div>
<table id="table" data-height="460" class="table table-bordered table-hover">
<thead>
<tr>
<th data-field="viNum" class="text-center">회사번호</th>
<th data-field="viNum" class="text-center">회사이름</th>
<th data-field="viNum" class="text-center">회사설명</th>
<th data-field="viNum" class="text-center">회사주소</th>
<th data-field="viNum" class="text-center">회사전화번호</th>
</tr>
</thead>
<tbody id="result_tbody">
</tbody>
</table>
<button id="btnInsert" class="btn btn-primary" type="button">상품등록</button>
</div>
<div class="jb-center" style="text-align:center">
<ul class="pagination" id="papge">
</ul>
</div>
<script>

</script>