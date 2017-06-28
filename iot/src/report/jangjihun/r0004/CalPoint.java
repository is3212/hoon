package report.jangjihun.r0004;

import java.util.Scanner;

//6명의 학생들의 점수를 입력받아 합계 평균 계산하고, 오름차순
public class CalPoint {
	public static void main(String[] args) {
		int[] a = new int[6];

		int result = 0;
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < a.length; i++) {
			System.out.print((i + 1) + "번째 학생의 점수를 입력하시오");
			String str = scan.nextLine();
			a[i] = Integer.parseInt(str);
			result += a[i];

		}
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {                                            //a[0]을 a[1~5]까지 비교 .... 
					int temp = a[i];                                    
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}

		for (int c = 0; c < a.length; c++) {
			System.out.println("학생들의 점수 오름차순 = " + a[c]);

		}
		System.out.println("학생들의 점수 합 = " + result);
		System.out.println("학생들의 점수 평균 = " + result / a.length);
	}
}
