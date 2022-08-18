package study001;

import java.util.Arrays;
import java.util.Scanner;

public class p1920 {
	
	// N개의 정수 A[1],A[2],...,A[N]이 주어져 있을 때 이 안에
	// X라는 정수가 존재하는지 알아내는 프로그램
	
	// 1번째 줄에 자연수 N(1<=N<=100,000)
	// 그 다음줄에 N개의 정수가 주어진다
	// 그 다음줄에 M(1<=M<=100,000)
	// 그 다음줄에 M개의 수들이 주어지는데
	// 이 수들이 A안에 존재하는지 알아내면된다. 모든 정수의 범위는 -231보다 크거나 같고 231보다 작다

	// M개의 줄에 답을 출력. 존재하면 1, 존재하지 않으면 0 출력
	
//	1. 탐색 데이터를 1차원 배열에 저장한 다음 저장된 배열을 정렬 => nlogn
//	2. X라는 정수가 존재하는지 이진탐색을 사용해 확인

	// 슈도코드
//	N(정렬할 수 개수) M(탐색할 숫자의 개수)
//	A(정렬할 배열 선언하기)
//	for(N의 개수만큼 반복하기) {
//		A 배열 저장하기	
//	}
//	A 배열 정렬하기
//	for(M의 개수만큼 반복하기) {
//		target(찾아야 하는 수)
	// 이진 탐색 시작
//		start(시작 인덱스), end(종료 인덱스)
//		while(시작 인덱스 <= 종료 인덱스) { // 탐색할 부분이 없을 때 까지
//			midi(중간 인덱스)
//			if(중앙값 > target) {
//				종료 인덱스 = 중간 인덱스 -1
//			}
//			else if(중앙값<target) {
//				시작 인덱스 = 중간 인덱스 + 1
//			} else {
//				찾았으므로 반복문 종료하기
//			}
//		}
//		if(찾았음) 1출력
//		else 0 출력
//	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);
		int M = sc.nextInt();
		for(int i=0; i<M; i++) {
			boolean find = false;
			int target = sc.nextInt();
			// 이진탐색
			int start = 0;
			int end = A.length-1;
			while(start <= end) { // 탐색할 부분이 없을 때 까지
				int mid_index = (start+end)/2;
				int mid_value = A[mid_index]; // 배열 안에 있는 실제 값
				if(mid_value > target) {
					end = mid_index -1;
				}else if(mid_value < target) {
					start = mid_index +1;
				}else {
					find = true;
					break;
				}
			}
			if(find==true) System.out.println("1");
			else System.out.println("0");
		}

	}

}
