/**
 * 공통함수 javascript파일
 */
//javascript Number 객체 비교 프로토타입 함수 추가
Number.prototype.equals=function(obj){
	if(obj instanceof Number){
		return this.toString()==obj.toString();
	}
	return this==obj;
}

//Ajax + json을 이용한 페이지 이동 공통 함수
function movePageWithAjax(pParams,pUrl,pCallBackFunc, pMethod){
	var params=JSON.stringify(pParams);           //params를 스트링으로 받아온다
	$.ajax({
		type : pMethod?pMethod:"POST",              //pMethod가 undefined면 type이 post가 된다.
		url : pUrl,
		dataType:"json",                //json으로 받겟다!!!
		beforeSend:function(xhr){
			xhr.setRequestHeader("Accept","application/json");                                      //   /json 형태로 보내겠다!!!
			xhr.setRequestHeader("Content-Type","application/json");
		}
	,  data : params
	,  success:pCallBackFunc
	,  error : function(xhr,status,e){
		alert("에러 : " + e);
	},
	complete : function(){   //무조건 실행
	}
	});
}


//pagination 이벤트 적용 공통 함수
//단 ul태그 > li 태그 > a태그 형식이여야하며
//ul태그의 class명은 반드시 pagination이여야 함
function setEvent(pageInfo,pUrl) {
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
				movePageWithAjax(params, pUrl, callback);
			})
}

//하단 페이지 블락을 자동으로 만들어주는 공통함수
//param : pageInfo => 페이지 정보
//param : objId=> 생성한 페이지 블락을 넣어줄 객체 아이디
function makePagination(pageInfo, objId){
	var pageStr = "";
	var sNum=pageInfo.startBlock;
	var eNum=pageInfo.endBlock;
	var nPage=pageInfo.nowPage;
	var nTotal=pageInfo.totalPageCnt;
	if(nPage==1){
		pageStr += "<li class='disabled'><a >◀◀◀</a></li>";
		pageStr += "<li class='disabled'><a >◀◀</a></li>";
		pageStr += "<li class='disabled' ><a >◀</a></li>";
	}else{ 
		pageStr="<li><a>◀◀◀</a></li>";
		pageStr += "<li><a>◀◀</a></li>";
		pageStr += "<li><a>◀</a></li>";
	}
	for(var i=sNum, max=eNum;i<=max;i++){
		if(i==nPage){
			pageStr += "<li class='active'><a>" + i + "</a></li>";
		}else{
			pageStr += "<li><a>" + i + "</a></li>";
		}
	}
	if(nPage==nTotal){
		pageStr += "<li class='disabled'><a>▶</a></li>";
		pageStr += "<li class='disabled'><a>▶▶</a></li>";
		pageStr += "<li class='disabled'><a>▶▶▶</a></li>";
	}else{ 
		pageStr += "<li><a>▶</a></li>";
		pageStr += "<li><a>▶▶</a></li>";
		pageStr += "<li><a>▶▶▶</a></li>";
	}

	$("#" + objId).html(pageStr);
}