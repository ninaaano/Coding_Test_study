package study001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11659 {
	
	// 수 N개가 주어졌을 때 i번째 수에서 j번째 수까지의 합을 구하는 프로그램
	
	// 1번째 줄에 수 개수 N(1<=N<=100,000), 합을 구해야 하는 횟수 M(1<=M<=100,000),
	// 2번째 줄에 N개의 수가 주어진다. 각 수는 1,000 보다 작거나 같은 자연수
	// 3번째 줄부터는 M개의 줄에 합을 구해야 하는 구간 i와 j가 주어진다
	
	// 구간 합을 매번 계산한다면 최악의 경우 1억회 이상의 연산 수행. 제한시간 0.5초
	

	// 합 배열 공식 S[i]=S[i-1]+A[i]
	// 구간 합 공식 S[j] - S[i-1]
	
	// suNo(숫자 개수), quizNo(질의 개수) 저장하기
	// for(숫자 개수만큼 반복하기) {
	// 합 배열 생성하기(S[i]=S[i-1]+A[i])
	// }
	// for(질의 개수만큼 반복하기) {
	// 질의 범위 받기(i~j)
	// 구간 합 출력하기 (S[j] - S[i-1])
	// }
	
	public static void main(String[] args) throws IOException{
	
	// Scanner sc = new Scanner(System.in);
	// 수가 크면 BufferedReader가 좋다. 더 빠르기 때문에
		
		BufferedReader bufferedReader = 
				new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stringTokenizer =
				new StringTokenizer(bufferedReader.readLine());
		
		int suNo = Integer.parseInt(stringTokenizer.nextToken());
		int quizNo = Integer.parseInt(stringTokenizer.nextToken());
		
		//숫자형 데이터 다룰때는 long형이 더 좋다
		long[]S = new long[suNo + 1];
		
		stringTokenizer =
				new StringTokenizer(bufferedReader.readLine());
		for(int i =1; i<=suNo; i++) {
			S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
		}
		
		for(int q=0; q<quizNo; q++) {
			stringTokenizer =
					new StringTokenizer(bufferedReader.readLine());
			int i = Integer.parseInt(stringTokenizer.nextToken());
			int j = Integer.parseInt(stringTokenizer.nextToken());
			
			System.out.println(S[j]-S[i-1]);
		}
		
		
		
	}
}
