package study001;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2252_줄세우기 {
	
	// N명의 학생들을 키 순서대로 줄을 세우려고 한다
	// 각 학생의 키를 직접 재서 정렬하면 간단하겠지만 마땅한 방법이 없어
	// 두 학생의 키를 비교하는 방법을 사용하기로 했다
	// 모든 학생을 비교한 것이 아니라 일부 학생들의 키만 비교해봤다
	// 일부 학생들의 키를 비교한 결과가 주어졌을때 줄을 세우는 프로그램 작성
	
	// 1번째 줄에 N(1<=N<=32,000) , M(1<=M<=100,000)이 주어진다
	// M은 키를 비교한 횟수, M개의 줄에는 키를 비교한 두 학생의 번호 A,B가 주어진다
	// 이는 학생 A가 학생 B 앞의 서야한다는 의미다. 학생들의 번호는 1번부터 N번 까지
	// 1번째 줄부터 앞에서부터 줄을 세운 결과 출력. 답이 여러가지 일 경우에는 아무거나 출력
	
	// 학생들을 노드로 생각하고, 키 순서 비교 데이터로 에지를 만든다고 생각
	// 노드의 순서를 도출하는 가장 기본적인 문제
	// 답이 여러개일 경우 아무것이나 출력해도 된다는 전제는 위상 정렬의 결괏값이 항상 유일하지 않다는 알고리즘의 전제와 동일하다
	
	// 1. 인접리스트에 노드 데이터를 저장하고 진입 차수 배열값을 업데이트 한다
	// 2. 다음 순서에 따라 위상 정렬 수행
	
	// 위상 정렬 수행 과정
	// 1. 진입 차수가 0인 노드를 큐에 저장한다
	// 2. 큐에서 데이터를 poll해 해당 노드를 탐색 결과에 추가하고, 해당 노드가 가리키는 노드의 진입차수를 1씩 감소한다
	// 3. 감소했을 때 진입 차수가 0이 되는 노드를 큐에 offer한다
	// 4. 큐가 빌 때 까지 1-3을 반복한다
	
	// 슈도코드
//	학생 수만큼 인접리스트 초기화하기
//	진입 차수 배열 초기화하기
//	for(학생 수만큼 반복하기) {
//		인접 리스트 데이터 저장하기
//		진입 차수 배열 초기 데이터 저장하기
//	}
//	// 위상정렬 수행하기
//	큐 생성하기
//	for(학생 수) {
//		진입 차수 배열의 값이 0인 학생(노드)을 큐에 삽입하기
//	}
//	while(큐가 빌 때까지) {
//		현재 노드 = 큐에서 데이터 poll
//		현재 노드값 출력하기
//		for(현재 노드에서 갈 수 있는 노드의 개수) {
//			타깃 노드 진입 차수 배열 --
//			if(타깃 노드의 진입 차수가 0이면) {
//				큐에 타깃 노드 추가하기
//			}
//		}
//	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			A.add(new ArrayList<Integer>());
		}
		int indegree[] = new int[N+1];
		for(int i=0; i<M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			A.get(S).add(E);
			indegree[E]++; // 진입차수 배열 데이터 저장 부분
		}
		// 위상정렬 실행
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(indegree[i]==0) { // 값이 0이란 건 해당 노드를 바라보는 엣지가 없다는 뜻
				queue.offer(i);
			}
		}
		while(!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now+" ");
			for(int next : A.get(now)) {
				indegree[next]--;
				if(indegree[next]==0) { // 들어갈 준비가 되어있다
					queue.offer(next);
				}
			}
		}
	}

}
