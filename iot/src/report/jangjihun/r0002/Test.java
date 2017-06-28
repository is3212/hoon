
package report.jangjihun.r0002;

import java.util.Scanner;

public class Test {
	public void printMutipleTable(int initNum, int maxNum){
		for( int i=initNum;i<=maxNum;i++){
			int j=1;
					for( j=initNum;j<=maxNum-1;j++){
						System.out.print(i + " X " + j + " = " + (i*j) + ",");

				}
					System.out.println(i + " X " + j + " = " + (i*j));	
			}
	}
	
	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.print("수를 입력하시오");
		String str=scan.nextLine();
		int input=Integer.parseInt(str);
		System.out.print("수를 입력하시오");
		String str2=scan.nextLine();
		int input2=Integer.parseInt(str2);
		Test t1=new Test();
		t1.printMutipleTable(input, input2);
	}}