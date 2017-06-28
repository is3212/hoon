package report.jangjihun.r0009;

import java.util.HashMap;
import java.util.Iterator;



public class MapExam2 {
	HashMap hm;
	
	MapExam2(){
		hm=new HashMap();
	}

	public static void main(String[] args){
		MapExam2 me = new MapExam2();
		me.hm.put("1",1);
		me.hm.put("2",2);
		me.hm.put("3",3);
		me.hm.put("4",4);
		me.hm.put("5",5);
		System.out.println(me.hm.containsKey("6")); //containsKey("6") 6이라는 키값이 있는지 없는지 확인
	
		Iterator it=me.hm.keySet().iterator();  //iterator는 Collection (ex : List, ArrayList, LinkedList, Map 등)에서 사용하는 데이터를 읽어주는 역활
		
		while(it.hasNext()){
			String key=(String)it.next();
			System.out.print(key + ",");
			System.out.println(me.hm.get(key));
		}
		
	}
}
