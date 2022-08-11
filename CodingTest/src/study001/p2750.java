package study001;

import java.util.Scanner;

public class p2750 {

	public static void main(String[] args) {
		// 수 정렬하기
		// N개의 수가 주어졌을 대 이를 오름차순 정렬하는 프로그램을 작성 => 정렬 알고리즘
		
		// 입력
		// 1번째 줄 : 수의 개수 N (1~1000사이)
		// 2번째 줄 : N개의 줄에 숫자가 주어진다. 이 수는 절대값이 1000보다 작거나 같은 정수다
		// 수는 중복되지 않는다
		
		// 출력
		// 1번째 줄부터 N개의 줄에 오름차순 정렬한 결과를 1줄에 1개씩 출력
		
		// 슈도 코드
//		N(정렬할 수 개수)
//		A(정렬할 배열 선언)
//		for(i:0~N~1) { => 100p 개수
//			for(j:0~N~1-i) { => 정렬하는 범위 <- 아직 정렬하지 않은 배열의 영역
//				현재 A 배열의 값보다 1칸 오른쪽 배열의 값이 더 작으면 두 수 바꾸기
//			}
//		}
//		A 배열 출력
		
		// 버블 정렬 사용, 두 수 바꾸기 => swap 연산
		Scanner sc = new Scanner(System.in);
		// 변수 N 선언
		int N = sc.nextInt();
		// 배열 선언
		int A[] = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i]=sc.nextInt();
		}
		
		// 버블 정렬을 구현하는 영역
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N-1-i; j++) { // 루프가 돌수록 정렬된 데이터가 생겨서 범위가 좁아지게 된다. 적게 돌게 하기위해 N-1-i
				if(A[j]>A[j+1]) {
					// j를 담을 변수 선언
					int temp = A[j];
					A[j]=A[j+1];
					A[j+1] = temp; // 스왑
				}
			}
		
		}
		for(int i=0; i<N; i++) {
			System.out.println(A[i]);
		}
		
	}

}
