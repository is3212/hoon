package report.jangjihun.r0012;

import java.util.ArrayList;
import java.util.HashMap;

public class DataTypeExam {
	public static void main(String[] args){
		//ArrayList<Object> list1=new ArrayList<Object>();   //object로 선언했으면 <object>로 선언해야하한다.
		ArrayList<Integer> list1=new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		ArrayList<String> list2=new ArrayList<String>();
		list2.add("가");
		list2.add("나");
		ArrayList<String> list3=new ArrayList<String>();
		list3.add("a");
		list3.add("b");
		//HashMap<Object, ArrayList<Object>> hm=new HashMap<Object,ArrayList<Object>>(); //Integer, String 모두 사용할 수 있는 Object
		HashMap<Object, ArrayList> hm=new HashMap<Object,ArrayList>();
		hm.put(list1.get(0), list1);
		hm.put(list2.get(0), list2);
		hm.put(list3.get(0), list3);
		
		System.out.println(hm);
	}

}
