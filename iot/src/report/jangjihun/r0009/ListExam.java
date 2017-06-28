package report.jangjihun.r0009;

import java.util.ArrayList;
import java.util.Collections;

public class ListExam {
	public static void main(String[] args){
		ArrayList<Integer> al=new ArrayList<Integer>(); //데이터타입 int
		for(int i=10;i>=0;i--){
			al.add(((int)(Math.random()*45)+1));               
		}

		Collections.sort(al); 
		for(int i=0;i<al.size();i++){ 
			System.out.println(al.get(i)); 
	}

	}
}
