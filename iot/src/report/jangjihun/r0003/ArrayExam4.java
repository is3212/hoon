package report.jangjihun.r0003;

public class ArrayExam4 {
	// 메인메소드
	// 포문 1부터 10까지
	// 100개의 자리수를 가지고있는 인트형 배열변수를 만들어주세요.
	// 위에 작성 포문에서 배열변수에 값을 넣어주시는데 2의 배수가 들어가게 만들어주세요
	// 2,4,6,7,10,12 ....
	// int 배열변수를 선언해주시고 자리수는 10개짜리로 만들어주세요
	// 포문에서 각각의 index에 2의 배수의 값을 넣어주세요
	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 10; i >=1; i--) {
			a[10-i] = i * 2;

		}
		for (int j = 10; j >=1; j--) {
			System.out.println((10- j) + "번째방의 값 = " + a[10-j]);
		}
	}

}
