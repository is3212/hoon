package report.jangjihun.r0006;

public class Exam3 {
	int getIndexFromArray(int[] arr, int num){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==num){
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args){
		int[] a=new int[5];
		for(int i=0;i<5;i++){
			a[i]=(i+1)*10;
		}
		Exam3 e=new Exam3();
		int idx=e.getIndexFromArray(a,30);
		System.out.println("30값이 있는 인덱스 번호 = " + idx);
		
	}

}
