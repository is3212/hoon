package report.jangjihun.r0012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataTypeExam5 {
	// 스캐너로 직접 입력받아서 5번 출력

	Scanner scan = new Scanner(System.in);

	public void setHashMapToArrayList(ArrayList<HashMap> array) {            //함수로 이용
		HashMap hm = new HashMap();
		System.out.print("클래스를 입력하시오");
		hm.put("클래스", scan.nextLine());

		System.out.print("이름을 입력하시오");
		hm.put("이름", scan.nextLine());

		System.out.print("나이를 입력하시오");
		hm.put("나이", scan.nextLine());

		System.out.print("성별을 입력하시오");
		hm.put("성별", scan.nextLine());
		
		System.out.println();
		array.add(hm);

	}

	public static void main(String[] args) {
		ArrayList<HashMap> array = new ArrayList<HashMap>();
		DataTypeExam5 dte5 = new DataTypeExam5();

		for (int i = 0; i < 5; i++) {
			dte5.setHashMapToArrayList(array);
		}
		for (HashMap hm1 : array) {
			System.out.print(hm1.get("클래스") + ",");
			System.out.print(hm1.get("이름") + ",");
			System.out.print(hm1.get("나이") + ",");
			System.out.println(hm1.get("성별"));
		}
	}
}
