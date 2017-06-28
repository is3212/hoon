package report.jangjihun.r0012;

import java.util.ArrayList;
import java.util.HashMap;

public class DataTypeExam4 {
	public static void main(String[] args){
		ArrayList<HashMap> array=new ArrayList<HashMap>();
		HashMap hm=new HashMap();
		hm.put("클래스", "A");
		hm.put("이름", "홍길동");
		hm.put("나이", "20");
		hm.put("성별", "남자");
		array.add(hm);
		
		HashMap hm1=new HashMap();
		hm1.put("클래스", "B");
		hm1.put("이름", "길정이");
		hm1.put("나이", "25");
		hm1.put("성별", "남자");
		array.add(hm1);
		
		HashMap hm2=new HashMap();
		hm2.put("클래스", "C");
		hm2.put("이름", "윤정이");
		hm2.put("나이", "22");
		hm2.put("성별", "여자");
		array.add(hm2);
		
		HashMap hm3=new HashMap();
		hm3.put("클래스", "D");
		hm3.put("이름", "등등이");
		hm3.put("나이", "5");
		hm3.put("성별", "여자");
		array.add(hm3);
		
		for(int i=0;i<array.size();i++){
			HashMap result=array.get(i);               //arraylist를 해쉬맵에 대입
			System.out.print(result.get("클래스") + ",");    //해쉬맵 키값으로 벨류값 뽑기
			System.out.print(result.get("이름") + ",");
			System.out.print(result.get("나이") + ",");
			System.out.println(result.get("성별"));
		}
	}
}
