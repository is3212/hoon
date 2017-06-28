package report.jangjihun.r0011;

import java.util.Scanner;

public class ExceptionExam3 {
	final int INITNUM;
	int[] arrNum;
	ExceptionExam3(int INITNUM){
		this.INITNUM=INITNUM;
	}
	
	public static void main(String[] args){
		ExceptionExam3 e3=new ExceptionExam3(3);
		e3.arrNum=new int[e3.INITNUM];
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<e3.arrNum.length;i++){
			try{
				System.out.println("숫자를 입력하시오");
				e3.arrNum[i]=Integer.parseInt(scan.nextLine());

			} catch(Exception e){
				i--;
				System.out.println("누가 문자 넣으래!!!");
			}
		}
		for(int j=0;j<e3.arrNum.length;j++){
			System.out.println(e3.arrNum[j]);
		}
	}

}
