package report.jangjihun.r0008;

import java.util.Scanner;
//아빠 클래스에서 배열변수를 선언하시고 10명의 학생의 점수를 입력받아주세요
//단 배열변수의 데이터 타입은 int형이여야 합니다.
//출력함수는 아바 클래스에 선언해주시고
//
public class Father {
	int a=3;
	Scanner scan;
	String str1, str2, str3;
	int input1, input2;
	//int[] index=new int[10];
	int[] graPoint=new int[10];
	//int[] oriPoint=new int[10];
	
	Father(){
		scan=new Scanner(System.in);
		inputFromScanner1();              //생성자에 함수 넣은것
		inputFromScanner2();             //그러면 아들클래스 메인에서 s.inputFromScanner1(); 안써줘도된다.
		inputPoint();
		pointStudent();
		//gradeStudent();
	}

	void inputFromScanner1(){
		str1=scan.nextLine();
		input1=Integer.parseInt(str1);
	}
	void inputFromScanner2(){
		str2=scan.nextLine();
		input2=Integer.parseInt(str2);
	}
	
	void loof(){
	for(int i=input1;i<=input2;i++){
		System.out.println(i);
	}
	}
	void inputPoint(){
		for(int i=0;i<graPoint.length;i++){
			System.out.println("학생들의 점수를 입력하시오");
			str3=scan.nextLine();
			graPoint[i]=Integer.parseInt(str3);
			//oriPoint[i]=Integer.parseInt(str3);
		}
		}
	void printPoint(){
		for(int i=0;i<graPoint.length;i++){
			System.out.println((i+1) + "번째 학생의 점수 = " + graPoint[i]);
	}
}
	void pointStudent(){
		for(int i=0;i<graPoint.length;i++){
			for(int j=i+1;j<graPoint.length;j++){
				if(graPoint[i]<graPoint[j]){
					int temp=graPoint[i];
					graPoint[i]=graPoint[j];
					graPoint[j]=temp;
				}
			}
		}
	}
	void printGrade(){
		for(int i=0;i<graPoint.length;i++){
			System.out.println((i+1) + "등 점수 = " + graPoint[i]);
	}
	}
	//void gradeStudent(){
	//	for(int i=0;i<oriPoint.length;i++){
		//	for(int j=0;j<oriPoint.length;j++)
		//	if(oriPoint[i]==graPoint[j]){
			//	index[i]=i+1;
		//	}
	//	}
		
//	}
	//void printGradeStudent(){
		//for(int i=0;i<graPoint.length;i++){
			//System.out.println((i+1) + "등 학생 = " + index[i] + "번째 학생");
	//}
//	}
}