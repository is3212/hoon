package report.jangjihun.r0005;

import java.util.ArrayList;
import java.util.List;

public class ExamList {
	public static void main(String[] args) {
		ArrayList<Cal> list = new ArrayList<Cal>(); // 리스트가 큰개념 어레이리스타가 작은개념(포함되는)
		                                                                                           // <>=오직 이 데이터타입만 사용하기 <Cal>= Cal데이터 타입만
		for (int i = 0; i < 3; i++) {
			Cal c = new Cal(i);
			list.add(c); // c배열의 0(첫)번째 방에 어레이리스트 추가 어레이리스트는 무조건 첫번째방부터 들어간다.
		}
		
			list.get(1); // c배열의 0번째방에서 어레이리스트 빼오기
			
					
			System.out.println(list.get(1));
		}
	}





