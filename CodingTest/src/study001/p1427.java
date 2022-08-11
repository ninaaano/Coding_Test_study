package study001;

import java.util.Scanner;

public class p1427 {
	
	public static void main(String[] args) {
		
		// 내림차순으로 자릿수 정렬하기
		// 1번째 줄에 정렬할 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수다
		
		// 선택정렬 이용
		// String  변수로 정렬할 데이터를 받아 int형 배열에 저장. 이때는 subString() 함수를 사용해
		// 숫자를 각 자릿수 별로 나눈 후 배열에 저장한다
		
		// 배열의 데이터를 선택 정렬 알고리즘을 이용해 내림차순 정렬한다.
		// 최댓값을 찾아 기준이 되는 자리와 swap 한다
		
		// 슈도코드
//		str(정렬할 수)
//		A(자릿수 별로 구분해 저장한 배열)
//		for(str의 길이만큼 반복하기) {
//			A 배열 저장 -  str.subString 사용하기
//		}
//		for(i:0~str의 길이만큼 반복하기) {
//			for(j:i+1-str의 길이만큼 반복하기) {
//				현재 범위에서 Max값 찾기
//			}
//			현재 i의 값과 Max값 중 Max값이 더 크면 swqp 수행하기
//		}
//		A 배열 출력하기

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		// Integer 배열로 변환하기 위해 [] 선언
		int A[] = new int[str.length()];
		// 데이터 넣기
		for(int i=0; i<str.length(); i++) {
			// i,i+1 부터 한칸씩 이동.str은 String이기 때문에 Integer로 형변환 해줘야한다.
			A[i] = Integer.parseInt(str.substring(i,i+1));
		}
		// 선택정렬
		for(int i=0; i<str.length(); i++) {
			int Max = i;
			for(int j=i+1; j<str.length(); j++) {
				if(A[j]>A[Max]) {
					Max = j;
				}
			}
				if(A[i]<A[Max]) {
					// 자리바꿀 변수 선언. 순서가 다르면 값이 다르게 나온다
					int temp = A[i];
					A[i] = A[Max];
					A[Max] = temp;
				}
				
			}
			for(int i = 0; i<str.length(); i++) {
				System.out.print(A[i]);
			}
		}
		
		
		
	}

