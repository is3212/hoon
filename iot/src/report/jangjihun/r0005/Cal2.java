package report.jangjihun.r0005;

public class Cal2 {
	// int형 변수 2개를 멤버변수로(클래스안에서 생성해야된다는 것) 생성
	// 스트링형 변수 1개를 생성
	// num1,num2,operator 로 변수이름 지정
	// printPlus(),printMinus(),printMultiple(),printDivision();
	// Cal2(int num1, int num2, String operator) 생성자를 선언하여
	// 각각의 멤버변수에 대입해주세요
	// 그리고 위의 함수를 호출했을때 원하는 결과값을 출력해주세요
	int num1;
	int num2;
	String operator = " ";

	Cal2(int num1, int num2, String operator) {
		this.num1 = num1;
		this.num2 = num2;
		this.operator = operator;
	}

	void printPlus() {
		System.out.println(num1 + " + " + num2 + "= " + (num1+num2));
	}

	void printMinus() {
		System.out.println(num1 + " - " + num2 + "= " + (num1-num2));
	}

	void printMultiple() {
		System.out.println(num1 + " * " + num2 + "= " + (num1*num2));
	}

	void printDivision() {
		System.out.println(num1 + " / " + num2 + "= " + (num1/num2));
	}

	void printRandome() {
		System.out.println("연산자 오류");
	}

	public static void main(String[] args) {
		Cal2 c = new Cal2(4, 2, "*");
		
		if (c.operator.equals("+")) {
			System.out.println("연산자 사용 : " + c.operator);
			c.printPlus();
		} else if (c.operator.equals("-")) {
			System.out.println("연산자 사용 : " + c.operator);
			c.printMinus();
		} else if (c.operator.equals("*")) {
			System.out.println("연산자 사용 : " + c.operator);
			c.printMultiple();
		} else if (c.operator.equals("/")) {
			System.out.println("연산자 사용 : " + c.operator);
			c.printDivision();
		} else {
			c.printRandome();
		}

	}
}
