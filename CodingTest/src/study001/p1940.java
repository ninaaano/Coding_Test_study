package study001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1940 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
//		갑옷을 만드는 재료들은 각자 고유한 번호가 있고
//		갑옷은 2개의 재료로 만드는데 2가지 재료의 고유한 번호를 합쳐
//		M(1<=M<=10,000,000)이 되면 갑옷이 만들어진다
//		N(1<=N<=15,000)개의 재료와 M이 주어졌을 때 몇개의 갑옷을 만들 수 있는지를 구하는 프로그램
		
//		1번째 줄 : 재료의 개수 N
//		2번째 줄 : 필요한 수 M
//		3번째 줄 : N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다

		// N의 범위를 보고 정렬할지 결정. O(nlogn)이나 투포인터 사용
		
//		A[i] + A[j] > M : j--; // 번호의 합이 M보다 크므로 큰 번호 index를 내린다
//		A[i] + A[j] < M  : i++; // 번호의 합이 M보다 작으므로 작은번호 index를 올린다
//		A[i] + A[j] == M : i++; j--; count++; // 양쪽 포인터를 모두 이동시키고 count 증가

//		N(재료의 개수), M(갑옷이 되는 번호)저장하기
//		for(N만큼 반복) {
//			재료 배열 저장하기	
//		}
//		재료 배열 정렬하기
//		while(i<j) {
//			if(재료 합 < M) 작은 번호 재료를 한칸 위로 변경
//			else if(재료 합 > M) 큰 번호 재료를 한칸 아래로 변경
//			else 경우의 수 증가, 양쪽 index 각각 변경
//		}
//		count 출력하기
		
		// Scanner sc = new Scanner(System.in);
		 
		BufferedReader br 
		= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int []A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		int count = 0;
		int i = 0; //A[0] => min
		int j = N-1; //A[N-1]
		
		while(i<j) {
			if(A[i]+A[j] < M) {
				i++;
			} else if(A[i]+A[j] > M) {
				j--;
			}else {
				i++; j--; count++;
			}
		}
		System.out.println(count);
		
		
	}

}

