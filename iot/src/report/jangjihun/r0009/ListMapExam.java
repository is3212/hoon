package report.jangjihun.r0009;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ListMapExam {
	// 스트링, 인티져로 구성된 HashMap 변수를 선언해주세요
//HashMap 변수명은 pointHm이라고 해주세요.
	//pointHm에 학생의 이름키값과 점수 벨류값을 10개 넣어주세요
	//학생이름은 A군, B군, C군.... 으로 입력해주세요.
	//해당 pointHm을 ArrayList에 추가해주세요.
	//반복문을 사용하여 ArrayList에 추가된 pointHm을 출력해주세요.
public static void main(String[] args){
	Scanner scan=new Scanner(System.in);
	System.out.println("인원수를 입력하세요");
	int count=Integer.parseInt(scan.nextLine());
	
	String[] name=new String[count];
	int[] age=new int[count];
	String[] sex=new String[count];
	
	for(int i=0;i<count;i++){
		System.out.println("이름을 입력하세요");
		name[i]=scan.nextLine();
	}
	
	for(int i=0;i<count;i++){
		System.out.println("나이를 입력하세요");
		age[i]=Integer.parseInt(scan.nextLine());
	}
	
	for(int i=0;i<count;i++){
		System.out.println("성별을 입력하세요");
		sex[i]=scan.nextLine();
	}
	
	ArrayList<HashMap<HashMap<String, Integer>,String>> arrList = new ArrayList<HashMap<HashMap<String, Integer>,String>>();
	for(int i=0;i<name.length;i++){
		HashMap<String, Integer> pointHm = new HashMap<String, Integer>();
		HashMap<HashMap<String, Integer>,String> pointHm2 = new HashMap<HashMap<String, Integer>,String>();
		pointHm.put(name[i], age[i]);
		pointHm2.put(pointHm,sex[i]);
	  arrList.add(pointHm2);
	}

	for(int i=0;i<arrList.size();i++){
	System.out.println(arrList.get(i));
}
}


		
	}

