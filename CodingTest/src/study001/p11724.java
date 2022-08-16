package study001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p11724 {
	
//	방향 없는 그래프가 주어졌을 때 연결 요소의 개수를 구하는 프로그램 작성
//	
//	1번째 줄에 노드의 개수N (1<=N<=1,000)과 에지의 개수M(0<=M<=Nx(N-1)/2)
//	2번째 줄 부터 M개의 줄에 에지의 양 끝점 u와 v가 주어진다(u는 1보다 크거나 같고 v는 N보다 작거나 같고 u와 v는 같지않다)
//	같은 에지는 한번만 주어진다
//	
//	슈도코드
//	n(노드 개수)m(에지 개수)
//	A(그래프 데이터 저장 인접 리스트)
//	visited(방문 기록 저장 배열)
//	for(n의 개수만큼 반복하기) {
//		A의 인접리스트에 각 ArrayList 초기화하기
//	}
//	for(m의 개수만큼 반복하기) {
//		A 인접리스트에 그래프 데이터 저장하기
//	}
//	for(n의 개수만큼 반복하기) {
//		if(방문하지 않은 노드가 있으면) {
//			연결 요수 개수++
//			DFS 실행하기
//		}
//	}
//	DFS{
//		if(현재 노드 == 방문 노드) return;
//		visited 배열에 현재 노드 방문 기록하기
//		현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행하기(재귀 함수 형태)
//	}
	
	// 방문기록 배열 저장
	static boolean[] visited;
	// 인접리스트
	static ArrayList<Integer>[] A;
	
	public static void main(String[] args) throws IOException {
		// 받을 데이터가 많이 때문에 buffered 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 버퍼리더의 짝꿍 선언
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// 배열 선언. 0은 방문하지 않을 거기때문에 1부터
		visited = new boolean[n+1];
		A = new ArrayList[n+1];
		
		for(int i =1; i<n+1; i++) {
			// A의 인접리스트에 각 ArrayList 초기화하기
			A[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			// 시작점, 끝점 선언
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			// 시작점과 끝점은 양쪽으로 갈 수 있다
			A[s].add(e);
			A[e].add(s);
		}
		// 방문노드 선언
		int count = 0;
		for(int i =1; i<n+1;i++) {
			//방문하지 않은 노드라면
			if(!visited[i]) {
			count++;
			DFS(i);
		
			}
		}
		System.out.println(count);
		
	}

	private static void DFS(int v) {
		if(visited[v]) {
			return;
		}
		visited[v] = true;
		for(int i : A[v]) {
			if(!visited[i]) {
				DFS(i);
			}
		}
	}

}
