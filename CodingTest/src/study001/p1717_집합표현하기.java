package study001;

import java.util.Scanner;

public class p1717_집합표현하기 {
	
	// 유니온 파인드 문제
	
	// 초기에 {0},{1},{2},...,{n}이 각각 n+1개의 집합을 이루고 있다
	// 여기에 합집합 연산과 두 원소가 같은 집합에 포함돼 있는지를 확인하는 연산을 수행하려고 한다
	// 집합을 표현하는 프로그램을 작성하시오
//	
//	1번째 줄에 n(1<=n<=1,000,000), m(1<=m<=100,000)이 주어진다
//	m은 입력으로 주어지는 연산의 개수다
//	다음 m개의 줄에는 각각의 연산이 주어진다
//	합집합은 0 a b 형태로 입력이 주어진다
//	이는 a가 포함돼있는 집합과 b가 포함돼있는 집합을 합친다는 의미다
//	두 원소가 같은 집합에 포함돼 있는지를 확인하는 연산은 1 a b 형태로 입력이 주어진다
//	이는 a와 b가 같은 집합에 포함돼 있는지를 확인하는 연산이다
//	a와 b는 n이하의 자연수 또는 0이고 같을수도 있다

	// 최대 원소의 개수 1,000,000과 질의 개수 100,000이 큰편이므로 경로 압축이 필요한 유니온 파인드 문제
	
	// 1. 처음에는 노드가 연결돼 있지 않으므로 각 노드의 대표 노드는 자기 자신이다.
	// 각 노드의 값을 자기 인덱스값으로 초기화한다
	// 2. find 연산으로 특정 노드의 대표 노드를 찾고, union 연산으로 2개의 노드를 이용해
	// 각 대표 노드를 찾아 연결한다. 그리고 질의한 값에 따라 결과를 반환한다
	
	// find연산을 수행할 때 재귀함수에서나오면서 탐색한 모든 노드의 대표값을 이번 연산에서 발견한 대표 노드로 변경하는 부분과 => 경로압축
	// union 연산에서 선택된 노드끼리 연결하는 것이 아닌 선택된 노드의 대표끼리 연결하는 부분이
	// 유니온 파인드에서 가장 많이 실수하는 부분이다
	
	// 슈도코드
//	N(원소 개수) M(질의 개수)
//	parent(대표 노드 저장 배열)
//	수열 배열 채우기
//	for(N만큼 반복하기) {
//		대표 노드를 자기 자신으로 초기화하기
//	}
//	for(M만큼 반복하기) {
//		if(0이면) 집합 합치기 => union 연산
//		else 와 같은 집합 원소인지 확인하고 결괏값 출력하기
//	}
//	// union 연산
//	union(a,b){
//		a와 b의 대표 노드 찾기
//		두 원소의 대표 노드끼리 연결하기
//	}
//	// find 연산
//	find(a)	{
//		a가 대표 노드면 리턴
//		아니면 a의 대표 노드값을 find(parent[a]) 값으로 저장 => 재귀 함수 형태
//	}
//	// checkSame => 두 원소가 같은 집합인지 확인
//	checkSame(a,b){
//		a와 b의 대표 노드 찾기
//		두 대표 노드가 같으면 true
//		아니면 false return
//	}
	//대표 노드를 다른 곳에서도 사용해야 하기 때문에 선언
	static int parent[];
	
	public static void main(String[] args) {
		// 코테에선 BufferedReader 쓰는게 훨씬빠르다
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		parent = new int[N+1]; // 이유? 7이 들어오면 7이라는 노드도 생기기때문
		for(int i=0; i<N+1; i++) { // 대표노드 초기화
			parent[i] = i;
		}
		for(int i=0; i<M; i++) { // 질의 계산하는 부분
			int question = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(question==0) { // 0이면 합쳐라 => union
				union(a,b);
			}else { // 두 원소 같은지 보기
				boolean result = checkSame(a,b);
				if(result) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}

	}

	private static void union(int a, int b) {
		// 바로 찾는게 아니라 대표 노드 찾아서 연결하기
		a = find(a);
		b = find(b);
		if(a==b) {
			parent[b] = a; // 두개 연결
		}
	}

	private static int find(int a) {
		// 대표 노드면 리턴
		if(a==parent[a])
		return a;
		else {
			// parent[a] = 이 부분은 빠져나올 때마다 대표 노드를 업데이트를 해주란 뜻. 경로압축. 중요!!!!!
			return parent[a] = find(parent[a]); // value를 index로 바꿔서 또 찾아보기
		}
	}
	
	// 편하게 비교할 수 있게 하는 함수 구현
	private static boolean checkSame(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return true;
		return false;
	}

}
