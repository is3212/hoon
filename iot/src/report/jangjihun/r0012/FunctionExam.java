package report.jangjihun.r0012;

import java.util.Scanner;

public class FunctionExam {
    int[] arrNum = new int[5];
   Scanner scan = new Scanner(System.in);
   int i=1;
	
	int getNumberFromString(){
		try {
			System.out.println(i + "번째 숫자를 넣어 주세요");
			i++;
		return  Integer.parseInt(scan.next());
		} catch (Exception e) {
			System.out.println("누가 문자 넣으래!");
			i--;
			return getNumberFromString();           //재귀호출
		}
	}
	
	public static void main(String[] args) {
		FunctionExam ee2 = new FunctionExam();
		for (int i = 0; i < ee2.arrNum.length; i++) {
			
			System.out.println((i+1) + "번째 숫자를 넣어 주세요");
			ee2.arrNum[i]=ee2.getNumberFromString();
			}
		for (int i = 0; i < ee2.arrNum.length; i++) {
			System.out.println(ee2.arrNum[i]);
		}
		}
	}


