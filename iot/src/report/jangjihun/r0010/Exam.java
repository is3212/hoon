package report.jangjihun.r0010;

import java.util.HashMap;

public class Exam {
	public static void main(String[] args){
		HashMap hm =new HashMap(); //hashmap 키값 중복 불가능
		hm.put("test","test");
		System.out.println(hm.containsKey("test"));
	}

}
