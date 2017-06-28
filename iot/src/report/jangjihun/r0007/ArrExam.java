package report.jangjihun.r0007;

import java.util.Scanner;

public class ArrExam {
	//Scanner클래스의 nextline함수를 사용하여 초기값과 맥스값을 입력받아주세요
	//위에서 받은 초기값부터 맥스값 까지 반복하는 반복문을 작성해주세요
	//스트링 배열변수를 선언해주세요
	//해당배열변수의 방의 갯수는 위에서 받아온 초기값과 맥스값으로 계산해야 에러가 나지 않습니다.
	//헤당반복문에서  scanner클래스의  nextline함수를 사용하여 위에서 선언한
	//스트링 배열변수에 0번째 인덱스부터 마지막 방의 인덱스까지 값을 받아주세요
	//다음 반복문에서 스트링배열변수가 가진 모든방의 값을 출력해주세요.
	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.print("초기값을 입력하시오");
		String str=scan.nextLine();
		int input1=Integer.parseInt(str);
		
		System.out.print("맥스값을 입력하시오");
		String str2=scan.nextLine();
		int input2=Integer.parseInt(str2);
		
		String[] a=new String[(input2-input1)+1];              //input1-intput2로하면 초기값이 맥스값보다 적으므로 오류
		for(int i=input1;i<=input2;i++){
			System.out.print("스트링 값을 입력하시오");
			String str3=scan.nextLine();
			a[i-input1]=str3;
		}
		
		for(int i=0;i<a.length;i++){
			System.out.println("[" + i + "] 번째 방 값 = " + a[i]);
			
		}
		
	}

}
