package study001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2178 {
	// 미로 탐색하기
	// NxM 크기의 미로가 주어질 때(1,1)에서 출발해 (N,M)의 위치로 이동하기 위해 
	// 지나야 하는 칸 수의 최솟값을 구하는 프로그램
	
	// 1번째 줄에 두 정수 N,M(2<=N, M<=100), 그 다음 N개의 줄에는 미로의 내용이 M개의 정수로 주어진다
	// 각각의 수들은 붙어서 입력된다
	// 시간 복잡도 범위가 작아서 무시하고 풀어도 되는 문제
	
	// 1번째 줄에 지나야하는 칸 수의 최솟값을 출력한다. 항상 도착 위치로 이동할 수 있을 때만
	// 입력으로 주어진다
	// 최솟값을 찾는 문제. BFS가 적합한 이유는 해당 깊이에서 갈 수 있는 노드 탐색을 마친 후
	// 다음 깊이로 넘어가기 때문이다 
	
	// 슈도코드
//	dx,dy(상하좌우를 탐색하기 위한 define값 정의 변수)
//	A(데이터 저장 2차원 행렬)
//	N(row), M(column)
//	visited(방문 기록 저장 배열)
//	A 배열 초기화 하기
//	visited 배열 초기화하기
//	for(N의 개수만큼 반복하기) {
//		for(M의 개수만큼 반복하기) {
//			A 배열에 데이터 저장하기
//		}
//	}
//	BFS(0,0) 실행하기
//	BFS { // BFS 구현하기
//		큐 자료구조에 시작 노드 삽입하기(add 연산)
//		visited 배열에 현재 노드 방문 기록하기
//		while(큐가 비어있을 떄 까지) {
//			큐에서 노드 데이터를 가져오기(poll 연산)
//			for(상하좌우 탐색){
//				if(이동할 수 있는 칸이면서 방문하지 않은 노드) { // validation 체크
//					visited 배열에 방문 기록하기
//					A 배열에 depth를 현재 노드의 depth + 1로 업데이트하기 // 특화된 부분. 
//					큐에 데이터 삽입하기(add 연산)
//				}
//			}
//		}
//	}
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0}; // 아래, 오른쪽, 위, 왼쪽탐색 ex) x로는 0, y로는 1만큼 탐색
	static boolean[][] visited; //  방문 기록 저장 배열
	static int[][] A; // 데이터 저장 2차원 행렬
	static int N,M; // row, column

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 초기화. tokenizer로 받았으니까 String값. int로 형변환
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine()); // N과 M사이에 공백이 들어갔기 때문에
			String line = st.nextToken(); // 한줄을 다 읽을 수 있는 line 선언 ex) 10110101 > 아래 subString에서 1 / 0 / 1 / 1 한칸씩 끊어준다
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(line.substring(j,j+1)); // 한칸씩 가면서 데이터를 앞에서 하나씩 끊어서 숫자로 넣어주는 형태
			}
		}
		BFS(0,0);
		System.out.println(A[N-1][M-1]);
	}

	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j}); // 데이터 삽입
		// queue가 빌때까지 계속 돌려준다
		while(!queue.isEmpty()) {
			int now[] = queue.poll(); // 뽑는 순간 탐색이 완료됐기 때문에
			visited[i][j] = true; // 배열을 true로 변경해준다
			for(int k = 0; k<4; k++) { // 4번 도는 이유가 dx,dy로 상하좌우 탐색을 하려고 하기 때문
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if(x >= 0 && y >= 0 && x < N && y < M) { // 배열을 넘어가면 안되기 때문에 유효성 검사
					if(A[x][y] != 0 && !visited[x][y]) { // 0이여서 갈수 없거나 기방문 했을 경우 x 
						// 이제 갈 수 있다. 탐색 시작
						visited[x][y] = true;
						A[x][y] = A[now[0]][now[1]] +1; // 핵심!!  A배열에 직전에 있던 자리에 depth + 1 업데이트.
						queue.add(new int[] {x,y}); // queue에 데이터 삽입.
					}
				}
				
			}
		}
		
	}

}
