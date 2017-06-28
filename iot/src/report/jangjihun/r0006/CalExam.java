package report.jangjihun.r0006;

import java.util.Scanner;

public class CalExam {
	//반복문을 사용하여 Scanner클래스를 이용해
	//총 10명의 학생의 점수를 받아주세요
	//10명의 학생의 총점과 평균을 구해주세요.
	
	public static void main(String[] args){
		int[] a= new int[10];
		int[] b= new int[10]; //처음 입력했던 점수 순서 저장하는 배열 선언
		int result=0;
		int temp=0;
		Scanner scan=new Scanner(System.in);
		for(int i=1;i<=a.length;i++){
			System.out.print(i + "번째 학생의 점수를 입력하시오");
			String str=scan.nextLine();
			a[i-1]=Integer.parseInt(str);
			b[i-1]=a[i-1];
			result+=a[i-1];                                //점수 누적=합
		}
		 //1등부터 10등까지 점수
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i]<a[j]){
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		for (int c = 0; c < a.length; c++) {
			System.out.println((c+1) + " 등의 점수  = " + a[c] + "점");
		}
		
		//학생들의 등수
		for(int i=0;i<a.length;i++){ 
			for(int j=0;j<a.length;j++){ 
		if(a[i]==b[j]){ //1~9등 까지의 점수가 원래의 인덱스 점수와 같다면
			System.out.println((i+1) + " 등  = " + (j+1) + "번째 학생");
		}
		}
		}

		
		System.out.println("학생들의 점수 합 = " + result);
		System.out.println("학생들의 점수 평균 = " + result / a.length);
	}
}



