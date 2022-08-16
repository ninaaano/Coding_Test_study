package study001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2178 {
	// �̷� Ž���ϱ�
	// NxM ũ���� �̷ΰ� �־��� ��(1,1)���� ����� (N,M)�� ��ġ�� �̵��ϱ� ���� 
	// ������ �ϴ� ĭ ���� �ּڰ��� ���ϴ� ���α׷�
	
	// 1��° �ٿ� �� ���� N,M(2<=N, M<=100), �� ���� N���� �ٿ��� �̷��� ������ M���� ������ �־�����
	// ������ ������ �پ �Էµȴ�
	// �ð� ���⵵ ������ �۾Ƽ� �����ϰ� Ǯ� �Ǵ� ����
	
	// 1��° �ٿ� �������ϴ� ĭ ���� �ּڰ��� ����Ѵ�. �׻� ���� ��ġ�� �̵��� �� ���� ����
	// �Է����� �־�����
	// �ּڰ��� ã�� ����. BFS�� ������ ������ �ش� ���̿��� �� �� �ִ� ��� Ž���� ��ģ ��
	// ���� ���̷� �Ѿ�� �����̴� 
	
	// �����ڵ�
//	dx,dy(�����¿츦 Ž���ϱ� ���� define�� ���� ����)
//	A(������ ���� 2���� ���)
//	N(row), M(column)
//	visited(�湮 ��� ���� �迭)
//	A �迭 �ʱ�ȭ �ϱ�
//	visited �迭 �ʱ�ȭ�ϱ�
//	for(N�� ������ŭ �ݺ��ϱ�) {
//		for(M�� ������ŭ �ݺ��ϱ�) {
//			A �迭�� ������ �����ϱ�
//		}
//	}
//	BFS(0,0) �����ϱ�
//	BFS { // BFS �����ϱ�
//		ť �ڷᱸ���� ���� ��� �����ϱ�(add ����)
//		visited �迭�� ���� ��� �湮 ����ϱ�
//		while(ť�� ������� �� ����) {
//			ť���� ��� �����͸� ��������(poll ����)
//			for(�����¿� Ž��){
//				if(�̵��� �� �ִ� ĭ�̸鼭 �湮���� ���� ���) { // validation üũ
//					visited �迭�� �湮 ����ϱ�
//					A �迭�� depth�� ���� ����� depth + 1�� ������Ʈ�ϱ� // Ưȭ�� �κ�. 
//					ť�� ������ �����ϱ�(add ����)
//				}
//			}
//		}
//	}
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0}; // �Ʒ�, ������, ��, ����Ž�� ex) x�δ� 0, y�δ� 1��ŭ Ž��
	static boolean[][] visited; //  �湮 ��� ���� �迭
	static int[][] A; // ������ ���� 2���� ���
	static int N,M; // row, column

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// �ʱ�ȭ. tokenizer�� �޾����ϱ� String��. int�� ����ȯ
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine()); // N�� M���̿� ������ ���� ������
			String line = st.nextToken(); // ������ �� ���� �� �ִ� line ���� ex) 10110101 > �Ʒ� subString���� 1 / 0 / 1 / 1 ��ĭ�� �����ش�
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(line.substring(j,j+1)); // ��ĭ�� ���鼭 �����͸� �տ��� �ϳ��� ��� ���ڷ� �־��ִ� ����
			}
		}
		BFS(0,0);
		System.out.println(A[N-1][M-1]);
	}

	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j}); // ������ ����
		// queue�� �������� ��� �����ش�
		while(!queue.isEmpty()) {
			int now[] = queue.poll(); // �̴� ���� Ž���� �Ϸ�Ʊ� ������
			visited[i][j] = true; // �迭�� true�� �������ش�
			for(int k = 0; k<4; k++) { // 4�� ���� ������ dx,dy�� �����¿� Ž���� �Ϸ��� �ϱ� ����
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if(x >= 0 && y >= 0 && x < N && y < M) { // �迭�� �Ѿ�� �ȵǱ� ������ ��ȿ�� �˻�
					if(A[x][y] != 0 && !visited[x][y]) { // 0�̿��� ���� ���ų� ��湮 ���� ��� x 
						// ���� �� �� �ִ�. Ž�� ����
						visited[x][y] = true;
						A[x][y] = A[now[0]][now[1]] +1; // �ٽ�!!  A�迭�� ������ �ִ� �ڸ��� depth + 1 ������Ʈ.
						queue.add(new int[] {x,y}); // queue�� ������ ����.
					}
				}
				
			}
		}
		
	}

}
