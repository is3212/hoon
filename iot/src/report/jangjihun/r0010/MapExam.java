package report.jangjihun.r0010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapExam extends HashMap{
	MapExam(){
		
	}
public String put(String key){
	if(!containsKey(key)){
		put(key, "test");
		return "잘들어 갔어요";
	}
	return "이미 있음";
}
	public String toString(){
		String result="";
		List<String> keys= new ArrayList<>(keySet());
		for(int i=0;i<keys.size();i++){                        //가지고 있는 방 만큼 반복
			String key=(String) keys.get(i);
			Object value=(Object) get(key);
			result+="[" + key + "," + value + "]\n";
		}
		if(result.equals("")){
			result="아무값도 없습니다.";
		}
		return result;
	}
	public static void main(String[] args){
		MapExam me=new MapExam();
		me.put("abc","abc");

		System.out.println(me);
	}

}
