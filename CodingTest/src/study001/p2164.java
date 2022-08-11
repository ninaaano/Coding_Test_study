package study001;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2164 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		카드게임
//		N장의 카드가 있다. 각각의 카드는 차례로 1에서 N까지의 번호가 붙어있으며, 1번 카드가 가장 위,
//		N번 카드가 가장 아래인 상태로 놓여있다. 이제 다음과 같은 동작을 카드가 1장 남을 때까지 반복한다
//		먼저 가장 위에 있는 카드를 바닥에 버린다. 그 다음 가장 위에 있는 카드를 가장 아래에 있는 카드 밑으로 옮긴다.
//		예를 들어 N=4 일때, 카드는 위에서부터 1,2,3,4의 순서대로 놓여있따.
//		1을 버리면 2,3,4 가 남는다. 여기서 2를 가장 아래로 옮기면 순서가 3,4,2가 된다
//		3을 버리면 4,2가 남고 4를 밑으로 옮기면 순서가 2,4가 된다.
//		마지막 2를 버리면 카드 4가 남는다.
//		N이 주어졌을 때 가장 마지막에 남는 카드를 구하는 프로그램을 작성하시오
//		
//		입력
//		1번째 줄에 정수N (1<=n<=500,000)이 주어진다
//		출력
//		1번째 줄에 남는 카드의 번호를 출력한다
		

		// 슈도 코드
//		N(카드의 개수) myQueue(카드 저장 자료구조)
//		for(카드의 개수만큼 반복) {
//			큐에 카드 저장하기
//		}
//		while(카드가 1장 남을 때 까지) {
//			맨 위의 카드를 버림 : poll()
//			맨 위의 카드를 가장 아래의 카드 밑으로 이동 : poll() > add()
//		}
//		마지막으로 남은 카드 출력
		
		// 스캐너로 입력받기 위해 sc 선언
		Scanner sc = new Scanner(System.in);
		// Queue 선언. Integer로 받을거임
		Queue<Integer> myQueue= new LinkedList<>();
		// 카드 갯수를 받을 N 선언
		int N = sc.nextInt();
		// 카드가 1부터 시작. for문을 돌려서 N번 받아야 한다
		for(int i=1; i<=N; i++) {
			myQueue.add(i);
		}
			// 카드가 1장 남을때까지 while문 반복. 1장이 남으면 빠져나간다
			while(myQueue.size()>1) {
				// 버린다
				myQueue.poll();
				// 변수를 선언. 데이터를 받아서 myQueue에 넣어주는 과정을 거치기 위해
				int temp = myQueue.poll();
				// 뽑기 위해 add
				myQueue.add(temp);
			}
			// 출력
			System.out.println(myQueue.poll());
		}

	}


