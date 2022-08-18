package study001;

import java.util.Scanner;

public class p11074 {
	
	// 소유하고 있는 동전은 총 N종류이고, 각 동전의 개수가 많다
	// 동전을 적절히 사용해 그 가격의 합을 K로 만들려고 한다
	// 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성
	
	// 1번째 줄에 N과 K(1<=N<=10, 1<=K<=100,000,000)
	// 2번째 줄 부터 N개의 줄에 동전의 가격 A가 오름차순으로 주어진다
	// (1<=A<=1,000,000, A1 =1, i<=2일 때 Ai는 Ai-1의 배수)

	// 1번째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값 출력 
	// 그리디 알고리즘
	// 현재 상태에서 항상 최선의 수를 선택해서 해를 찾는 방법
	// = > 최대한 큰 금액의 동전으로 구성함
	// 동전 가격 Ai가 앞에 나오는 동전 가격 Ai-1의 배수가 된다는 조건 중요
	
	
	// 슈도코드
//	N(동전 개수)K(목표 금액)
//	A(동전 데이터 배열)
//	배열 선언 for(N만큼 반복하기) {
//		A배열 저장하기
//	}
//	// 가치가 큰 동전부터 선택하여 개수를 최소로 구성할 수 있음
//	for(N만큼 반족 => N - 1 ~0으로 역순으로 반복하기) {
//		if(현재 K보다 동전 가치가 작으면) {
//			동전 수 += 목표금액 / 현재 동전 가치
//					목표 금액 = 목표금액 % 현재 동전 가치
//		}
//	}
//	누적된 동전 수 출력하기
//	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc  =  new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int A[] = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		// 그리디 알고리즘 => 최대한 큰 동전 먼저 사용
		int count = 0;
		// 역순으로 탐색
		for(int i = N-1; i >= 0; i--) {
			if(A[i]<=K) {
				count += (K/A[i]); // 몫을 더해준다
				K = K%A[i];
			}
		}
		 System.out.println(count);
	}

}
