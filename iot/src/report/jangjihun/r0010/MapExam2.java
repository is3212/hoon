package report.jangjihun.r0010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapExam2 extends HashMap{
	// hashmap을 상속 받아주세요.
	// 키타입은 string,벨류타입은 integer로 선언해주세요
	// 키는 아무거나 넣으셔도 되지만, 벨류는 반드시 숫자만 입력하셔야합니다
	// 총 10개의 키값을 생성해주세요.
	// toString() 함수를 오버라이딩 하여서
	// 해당 해쉬맵이 가지고 있는 전체 숫자를 더한 값을 출력해주세요

	public String toString() {
		String result = "";
		int sum = 0;
		List<String> keyList = new ArrayList<>(keySet()); //keySet(): key리스트 얻어온다
		for (int i = 0; i < keyList.size(); i++) {
			String key = keyList.get(i);
			Integer value = (int) get(key);
			sum += value;
			result = "전체 숫자 더한 값 = " + sum;
		}
		return result;
	}

	public static void main(String[] args) {
		MapExam2 m2 = new MapExam2();
		String[] a = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		int[] b = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
		for (int i = 0; i < a.length; i++) {
			m2.put(a[i], b[i]);
		}
		System.out.println(m2);

	}
}
