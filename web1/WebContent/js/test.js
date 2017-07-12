/**
 * 
 */

function checkValue(fObj){
var maxNum=fObj.elements.length;


var result="";
for(var i=0;i<maxNum;i++){
	var eObj=fObj.elements[i];
		if(i%2==1 && i!=maxNum-1){
			var checkNum=new Number(eObj.value);
			if(isNaN(checkNum)){
			alert("짝수인" + (i+1) +"번째는  숫자만 입력하라고!!!");
			eObj.value="";
			eObj.focus();
			return false;
		}
		}
		if(eObj.value!="전송"){
		result+=eObj.value;
		}
	if(i==maxNum-1){
		eObj.value=result
	}
}
return false;
}