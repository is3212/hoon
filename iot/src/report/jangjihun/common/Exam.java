package report.jangjihun.common;

public class Exam {
	public static void main(String[] args){
		DBConn dbc=new DBConn();
		dbc.a=3;
		System.out.println(dbc.a);                        //3
		System.out.println(DBConn.a);              //3
		DBConn.a=4;
		System.out.println(dbc.a);                        //4
		dbc=new DBConn();
		System.out.println(dbc.a);                       //4 , 1로 안되고 4가 된다. 초기화 안됨!
		
		int a=DBConn.getInt();      //static 함수
		
	}

}
