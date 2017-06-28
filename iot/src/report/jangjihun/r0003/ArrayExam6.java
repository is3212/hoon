package report.jangjihun.r0003;

public class ArrayExam6 {
	public int[] table(int[] params) {                   //배열로도 넣을 수 있다
		int[] a = new int[params[0]];
		for (int i = params[1]; i <= params[2]; i++) {
			a[i] = (i+1) * 2;
		}
		return a;
	}
	public void printTable(int[] a){
		for (int i = 1; i <= a.length; i++) {
			System.out.println(i + "번째 로또 번호는 " + a[i - 1]);
	}
		
		
	}

	public void random(int initNum, int maxNum) {
		int[] a = new int[maxNum];

		for (int i = initNum; i <= a.length; i++) {
			a[i - 1] = (int) (Math.random() * 45) + 1; // 랜덤변수 (int)
														// (Math.random() * 45)=
														// 0.xxx~44.xx에서 int이므로
														// 0~44가 나온다, 1에서 45가
														// 나와야하므로 +1을 해준다.
			for (int j = initNum; j < i; j++) { // 1번방부터 1번방 밑으로(0번방)을 하나씩 비교 ,
												// 2번방이면 1번방,0번방 비교, 3번방이면
												// 2번방,1번방,0번방 비교......
				if (a[i - 1] == a[j - 1]) { // 만약 1번방이 0번방과 같다면
					i--; // 다시 1번방으로 가서 랜덤값 새로 만든다.
				}

			}

		}

		for (int i = initNum; i <= a.length; i++) {
			System.out.println(i + "번째 로또 숫자는 " + a[i - 1]);
		}

	}

	public static void main(String[] args) {
		ArrayExam6 t6 = new ArrayExam6();
		int[] params={10,0,9};                          //배열 초기화
		int[] a=t6.table(params);
		t6.printTable(a);
		System.out.println();
		t6.random(1, 6);

	}
}
