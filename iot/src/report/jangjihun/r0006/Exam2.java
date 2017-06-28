package report.jangjihun.r0006;

public class Exam2 {
	int printFour(int num) {
		for (int i = 1; i < 10; i++) {
			if (i == num) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Exam2 e2 = new Exam2();
		int str = e2.printFour(4);
		System.out.println(str);
	}

}
