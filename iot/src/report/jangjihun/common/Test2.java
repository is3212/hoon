package report.jangjihun.common;

import java.util.ArrayList;

public class Test2 {
	public static void main(String[] args){
		ArrayExam t=new ArrayExam();
		ArrayList al=t.getArrayList(0,9);
		for(int i=0; i<10;i++){ 
			al.add(i);
		}
		System.out.println(al);
	}

}
