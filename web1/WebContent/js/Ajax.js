/**
 * 
 */
var str = "name,id,pwd";
var strs = str.split(",");    //split : 문자열을 배열로 만들어준다. ,로 구분해서     strs[0]=name 이렇게 
var param = "";
for(var i=0;i<strs.length;i++){
	var value = document.getElementById(strs[i]).value;
	param += "&" + strs[i] + "=" + value;
}

var AjaxUtil= function(url, arrParams, method, aSync){        //method와 aSync를 안넣어주면
	this.fAction=url;
	this.fMethod=method ? method : "get";                                 //method는 undefine 이므로 get방식이 된다.
	var params="?action=LOGIN&id=" + encodeURIComponent(userid);
	this.fAsync=aSync ? aSync : true;       //싱크 true면 비동기 false면 동기,         //aSync는 undefine 이므로 true이므로 비동기가 된다.
	xmlHttpObj.onreadystatechange=function(){              //서버에 요청한걸 서버로부터 응답이 준비되었을때 처리할 동작을 지정
		if(xmlHttpObj.readyState==4 && xmlHttpObj.status==200){         //200일때 로직 다 돌고 완료, 4일때 컴플릿 된거,  0=요청이 초기화 되지 않음
			//1 : 서버 접속이 이루어짐, 2:요청이 수신됨, 3:처리요청 됨, 4:완성된 요청과 응답이 준비됨.          200:ok,     404:페이지를 찾을 수 없음
			var result=decodeURLIComponent(xmlHttpObj.responseText);
			if(result=="success"){
				location.href="../user/welcome.jsp"
			}else{
				alert(result);
			}
		}
	}
	xmlHttpObj.open(method, url+params,sync);
	if(method=="post"){
		xmlHttpObj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");    //파일 업로드하기위해서 post방식 쓴다 get방식은 못함
	}
	xmlHttpObj.send(params);
}