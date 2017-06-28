package report.jangjihun.r0002;
//배열
public class ArrayExam {
	public void printMutipleTable(int[] a, int[] b){
		
		for(int i=0;i<a.length;i++){
			
		 for(int j=0;j<b.length;j++){
			System.out.print(a[i]+ "x" + b[j] + "값 = " +(a[i]*b[j]) + ",");
		 }
		 System.out.println();
	}
	}
	public static void main(String[] args){
		ArrayExam  t01=new ArrayExam();
		int [] a= {1,2,3,4,5,6,7,8,9};
		int [] b= {1,2,3,4,5,6,7,8,9};
t01.printMutipleTable(a, b);
		}
	}

