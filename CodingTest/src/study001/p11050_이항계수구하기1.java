package study001;

import java.util.Scanner;

public class p11050_이항계수구하기1 {
	
	// 자연수 N과 정수 K가 주어졌을 때 이항계수 (n k)를 구하는 프로그램 작성
	
	// 1번째 줄에 N과 K가 주어진다(1<=N<=10, 0<=K<=N)
	// (n k)를 출력한다
	
	// 조합에서 가장 기본이 되는 문제. 일반 점화식 이용
	// D[i][j] = i개 중 j개를 뽑는 경우의 수
	// 조합 점화식
	// D[i][j] = D[i-1][j] + D[i-1][j-1]
	
	// 슈도코드
//	N(총 개수), K(선택 수)
//	D(DP 배열)
//	for(i - N 만큼 반복하기) {
//		D 배열 초기화하기
//		D[i][1] = i // i개에서 1개 선택 경우의 수는 i개
//		D[i][0] = 1 // i개에서 1개도 선택하지 않는 경우의 수는 0개
//		D[i][i] = 1 // i개에서 모두 선택하는 경우의 수는 1개
//	}
//	for(i - N만큼 반복하기) {
//		for(j - i만큼 반복하기) { // 고르는 수의 갯가 전체 개수를 넘을 수 없음
//			D[i][j] = D[i-1][j] + D[i-1][j-1]; //조합 점화식
//		}
//	}
//	D[N][K] 출력하기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N,K;
		N = sc.nextInt();
		K = sc.nextInt();
		int D[][];
		D = new int[N+1][N+1]; // 11로 체워도 된다. 조건이 10까지라서
		// 초기화
		for(int i = 0; i<=N; i++) {
			D[i][i] = 1;
			D[i][0] = 1;
			D[i][1] = i;
		}
		// 점화식으로 배열 완성하기
		// 바텀-업 방식 사용
		for(int i = 2; i<=N; i++) { // 2인 이유는 1로 초기화를 했기 때문에
			for(int j=1; j<i; j++) { // 1부터 i까지인 이유는 커지면 안되기 때문에. 위에서 초기화해서 같을 수 없음
				D[i][j] = D[i-1][j] + D[i-1][j-1];
			}
		}
		System.out.println(D[N][K]);
		
		}

}
