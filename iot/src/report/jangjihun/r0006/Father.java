package report.jangjihun.r0006;

public class Father {
	private String address = "서울시 강서구 가양동";  //private는 자기만 사용할수있다 son클래스에서 사용 못함
	private int age = 65;
	private String name = "박철수";
	
	int getAge(){                                //son클래스에서 father 클래스에서 private로 선언된 변수를 사용하기 위해서 함수를 만들어 private 사용가능하게 만든다.
		return this.age;
	}
	String getAdress(){               //son클래스에서 father 클래스에서 private로 선언된 변수를 사용하기 위해서 함수를 만들어 private 사용가능하게 만든다.
		return address;
	}
	
	String getName(){              //son클래스에서 father 클래스에서 private로 선언된 변수를 사용하기 위해서 함수를 만들어 private 사용가능하게 만든다.
		return name;
	}
	
	void setName(String name){    
		this.name = name;
	}
}
