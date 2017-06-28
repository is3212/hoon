package report.jangjihun.r0005;

public class Exam2 {
	public static void main(String[] args) {
		// 0부터 4까지 반복하는 반복문을 작성하여
		// Cal(int a)라고 선언된 생성자를 호출하여 1부터 5까지 출력을 해보시기 바랍니다.
		Cal[] c = new Cal[5];
		for (int i = 0; i <= 4; i++) {
			c[i] = new Cal((i + 1));
		}
		for (int i = 0; i <= 4; i++) {
			System.out.println(c[i].a);            //생성자안의 a변수 값 출력
		}
	}

}
