package report.jangjihun.r0005;

public class Robot {
	String name;
	int age;
	int makeYear;
	
	public Robot(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	void doKick(){
	System.out.println(age + "살 먹은 로봇 " + name + "발차기를 하다.");	
	}
	
	void doRun(){
		System.out.println(age + "살 먹은 로봇 " + name + "달리기를 하다.");
	}
	
	void doChange(){
		System.out.println(age + "살 먹은 로봇 " + name + "변신을 하다.");
	}
	
	
	
	public static void main(String[] args){
		Robot e=new Robot("지로봇",4);
		e.doKick();
		e.doRun();
		e.doChange();
		
	}

}
