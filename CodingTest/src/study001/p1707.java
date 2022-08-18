package study001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1707 {
	
	// 이분 그래프 판별하기
	// 각 집합에 속한 노드끼리 서로 인접하지 않는 두 집합으로 그래프의 노드를 나눌 수 있을 때
	// 이 그래프를 '이분 그래프' 라고 한다.
	// 그래프가 주어졌을 때 이 그래프가 이분 그래프인지 여부를 판별하는 프로그램 작성
	// ex) 1(A) - 2(B) - 3(A) 인접한 집합은 서로 다르다   

//	입력은 여러 개의 사례로 구성돼있는데
//	1번째 줄에 테스트 케이스의 개수 K(2<=K<=5)가 주어진다
//	각 사례의 1번째 줄에 그래프의 노드의 기수 V(1<=V<=20,000)와
//	에지의 개수 E(1<=E<=200,000)가 빈칸을 사이에 두고 순서대로 주어진다
//	각 노드에는 1부터 V까지 차례로 번호가 붙어있다
//	이어서 2번째 줄부터 E개의 줄에 걸쳐 에지와 관련된 정보가 주어지는데
//	각 줄에 인접한 두 노드의 번호가 공백 문자를 사이에 두고 주어진다

//	노드의 집합을 2개로 나누는데, 인접한 노드끼리 같은 집합이 되지 않도록
//	적절하게 임의로 분할할 수 있다. 트리의 경우 항상 이분 그래프가 된다
//	사이클이 발생하지 않으면 탐색을 하면서 다음 노드를 이번 노드와 다른 집합으로 지정하면 되기 때문
//	단, 사이클이 발생했을 때는 이런 이분 그래프가 불가능 할 때가 있다.
	
// 판별법 => 탐색한 노드에 다시 접근했을 때 현재 노드의 집합과 같으면 이분 그래프가 불가능하다
// BFS/DFS 매커니즘을 완벽하게 파악해야한다
	// DFS처럼 탐색하는데 로직에 시작한 노드가 지금 노드와 같은 집합인지 판별
	
//	1. 입력된 그래프 데이터를 인접리스트로 구현한다 => 가중치가 없는
//	2. 모든 노드로 각각 DFS 탐색 알고리즘을 적용해 탐색을 수행한다
//	DFS를 실행할 때 현재 노드에서 연결된 노드 중 이미 방문한 노드가 나와 같은 집합이면 이분그래프가 아닌 것으로 판별
//	실행결과가 이분 그래프가 아니면 이후 노드는 탐색하지 않는다
//	주의할점! 그래프가 항상 이어져있다고 말하지 않았다
//	3. 이분 그래프 여부를 정답으로 출력한다
//	4. 사례의 개수만큼 과정 1~3을 반복한다
	// 여기에서 모든 노드를 DFS로 실행하는 이유는 그래프의 모든 노드가 이어져 있지 않고
	// 여러 개의 부분 그래프로 이뤄진 케이스가 존재할 수 있기 때문이다
	
	// 슈도코드
//	N(노드 개수)M(에지 개수)check(이분 그래프 체크 배열)
//	A(그래프 데이터 저장 인접 리스트) visited(방문 기록 저장 배열)
//	N(테스트 케이스)
//	for(N의 개수만큼 반복하기) {
//		V(노드 개수)
//		E(에지 개수)
//		for(V의 개수만큼 반복하기) {
//			A 인접 리스트의 각 ArrayList 초기화하기
//		}
//		for(M의 개수만큼 반복하기) {
//			A 인접 리스트에 그래프 데이터 저장하기
//		}
//		for(V의 개수만큼 반복하기) {
//			각 노드에서 DFS 실행 => 결과가 이분 그래프가 아니면 반복 종료
//		}
//		이분 그래프 여부를 정답으로 출력하기
//	}
//	DFS{ // DFS 구현하기
//		현재 노드 출력하기
//		visited 배열에 현재 노드 방문 기록하기
//		if(현재 노드의 연결 노드 중 방문하지 않은 노드로) {
//			현재 노드와 다른 집합으로 연결 노드 집합 저장하기
//			DFS 실행하기(재귀 형태)
//		}
//		else { // 이미 방문한 노드인데, 현재 나의 노드와 같은 집합이면 이분그래프가 아님
//			
//		}
//	}
	
	//전역함수 선언
	// 그래프 인접 리스트 저장
	static ArrayList<Integer>[] A;
	static int[] check;
	static boolean[] visited;
	static boolean IsEven;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 받기
		int testCase = Integer.parseInt(br.readLine());
		for(int t=0; t<testCase; t++) { // 주어진 테스트 케이스 만큼 돌림
			String[] s = br.readLine().split(" "); // 공백을 기준으로
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			// 엣지를 인접리스트에 넣어주기전에 초기화. 배열의 갯수 지정
			// 배열의 갯수를 노드의 갯수만큼 하는데 문제에선 1번부터 자동으로 연결됐다 했기 때문에
			// V+1부터 해준다
			A = new ArrayList[V+1];
			// static으로 선언한건 다 초기화 해야함
			visited = new boolean[V+1]; // 0번째는 사용 안할거기 때문에
			check = new int[V+1];
			IsEven = true;
			// 각 배열마다 arraylist로 선언
			for(int i = 1; i<= V; i++) {
				A[i] = new ArrayList<Integer>();
			}
			// 엣지의 데이터(정보)를 인접리스트에 넣어주기(저장하기)
			for(int i=0; i<E; i++) {
				s = br.readLine().split(" ");
				int start = Integer.parseInt(s[0]);
				int end = Integer.parseInt(s[1]);
				// 양쪽으로 다 더해줘야함
				A[start].add(end);
				A[end].add(start);
			}
			// 그래프가 여러개의 그래프니까 모든 점에서 시작해야한다
			// 모든 노드에서 DFS 실행 해야함
			for(int i=1; i<=V; i++) {
				if(IsEven) {
				DFS(1);
				}else {
					break;
				}
			}
			if(IsEven) System.out.println("YES");
			else System.out.println("NO");
		}
		
	}
	private static void DFS(int start) {
		// 이번에 들어온 노드.
		visited[start] = true; // 탐색완료
		for(int i:A[start]) { // 인접리스트로 받아서 start에서 연결된 모든 노드 탐색
			if(!visited[i]) { // 방문 노드가 아니다
				// 바로 직전에 있는 노드와 다른 집합으로 분류해주는것이 필요
				check[i]=(check[start] +1)%2; // 1,0으로 구분해줄거임
				DFS(i);
			}else if(check[start]==check[i]) { // 이미 방문한 노드인데 똑같은 집합이다?
				IsEven = false;{
				}
			}
		}
	}

}
