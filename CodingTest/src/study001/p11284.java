package study001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p11284 {
	public static void main(String[] args) throws IOException{
		// 절댓값 힙 자료구조
		// 1. 배열에 정수 x를 넣는다(x는 0이 아님)
		// 2. 배열에서 절댓값이 가장 작은 값을 출력한 후 그 값을 배열에서 제거한다.
		// 절댓값이 가장 작은 값이 여러 개일 경우에는 그 중 가장 작은 수를 출력하고
		// 그 값은 배열에서 제거한다
		
		// 프로그램은 처음에 비어있는 배열에서 시작한다. 절댓값 힙을 구현하시오
		
//		입력
//		1번째 줄 : 연산의 개수 N(1<=N<=100,000)이 주어진다
//		다음 N개의 줄에는 연산과 관련된 정보를 나나태는 정수 x가 주어진다
//		만약 x가 0이 아니라면 배열에 x라는 값을 추가하고,
//		x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고,
//		그 값을 배열에서 제거한다.
//		입력되는 정수는 -231보다 크고, 231보다 작다
//		
//		출력
//		입력에서 0이 주어진 횟수만큼 답을 출력한다
//		만약 배열이 비어있는데 절댓값이 가장 작은 값을 출력하라고 할 때는 0을 출력
	
		// 데이터가 새로 삽입될 때마다 절댓값과 관련된 정렬이 필요하므로,
		// 우선순위 큐로 문제를 쉽게 해결할 수 있다
		// x=0 일때 : 큐가 비어있을때는 0을 출력, 비어 있지 않으면 최솟값 출력, 절댓값이 같으면 음수 우선 출력
		// x=1 일때 : add로 큐에 새로운 값을 추가하고 우선순위 큐 정렬기준으로 자동 정렬
		
		// 슈도코드
//		N(질의 요청 개수)
//		우선순위 큐 선언 // 절댓값 기준으로 정렬되도록 설정하기. 단, 절댓값이 같으면 음수 우선 정렬
//		for(N만큼 반복) {
//			요청이 0일때 : 큐가 비어있으면 0, 비어있지 않으면 큐의 front 값 출력(poll())
//			요청이 1일때 : 새로운 데이터를 우선순위 큐에 더하기(add())
//		}
		
		// 시간복잡도 편의를 위해 버퍼로 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 우선순위 큐 선언 -> 람다식 사용
		PriorityQueue<Integer> myQueue= new PriorityQueue<>((o1,o2)->{
						
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			
			if(first_abs == second_abs) {
				return o1 > o2? 1 : -1; // 절댓값이 같을 경우 음수 우선
			}
			return first_abs-second_abs; // 절댓값이 작은 데이터 우선
			
		}); 
			
			for(int i = 0; i<N; i++) {
				// 데이터 받기
				int request = Integer.parseInt(br.readLine());
				if(request == 0) {
					if(myQueue.isEmpty()) {
						System.out.println("0");
					}else {
						System.out.println(myQueue.poll());
					}
				}else {
					myQueue.add(request);
				}
			}

	}

}
