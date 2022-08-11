package study001;

import java.util.Scanner;

public class p2018 {
	
	public static void main(String[] args) {
		
		// 투포인터는 2개의 포인터로 알고리즘의 시간 복잡도를 최적화한다. 알고리즘 매우 간단
		
//		어떠한 자연수 N은 몇개의 연속된 자연수의 합으로 나타낼 수 있다.
//		자연수 N(1<=N<=10,000,000)을 몇 개의 연속된 자연수의 합으로 나타내는 가짓수를 알고 싶다.
//		이때 사용하는 자연수는 N. N을 입력받아 연속된 자연수의 합으로 나타내는 가짓수를 출력하는 프로그램 작성
	
	
		// N의 범위가 크기때문에 O(n) => 투포인터 사용. 시작인덱스와 종료인덱스 지정
		
//		sum > N : sum = sum - start_index; start_index++;
//		sum < N : end_index++; sum = sum + end_index;
//		sum == N : end_index++; sum = sum + end_index; count++;

//		N 변수 저장
//		사용 변수 초기화(count = 1, start_index=1; end_index=1; sum=1)
		// count가 1인이유는 자기자신 하나로 이루어진 경우의 수를 미리 저장
//		while(end_index != N) {
//			if(sum == N) count 증가, end_index 증가, sum값 변경
//			else if(sum > N) sum 값 변경, start_index 증가
//			else if(sum < N) end_index 증가, sum 값 변경
//		}
//		count 출력하기
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt()	;
		int count = 1;
		int start_index = 1;
		int end_index = 1;
		int sum = 1;
		
		while(end_index != N) {
			if(sum == N) {
				count ++;
				end_index++;
				sum += end_index;
			} else if(sum > N) {
				sum -= start_index;
				start_index++;
			} else {
				end_index++;
				sum += end_index;
			}
		}
		System.out.println(count);
		
	}

}
