package study001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p11724 {
	
//	���� ���� �׷����� �־����� �� ���� ����� ������ ���ϴ� ���α׷� �ۼ�
//	
//	1��° �ٿ� ����� ����N (1<=N<=1,000)�� ������ ����M(0<=M<=Nx(N-1)/2)
//	2��° �� ���� M���� �ٿ� ������ �� ���� u�� v�� �־�����(u�� 1���� ũ�ų� ���� v�� N���� �۰ų� ���� u�� v�� �����ʴ�)
//	���� ������ �ѹ��� �־�����
//	
//	�����ڵ�
//	n(��� ����)m(���� ����)
//	A(�׷��� ������ ���� ���� ����Ʈ)
//	visited(�湮 ��� ���� �迭)
//	for(n�� ������ŭ �ݺ��ϱ�) {
//		A�� ��������Ʈ�� �� ArrayList �ʱ�ȭ�ϱ�
//	}
//	for(m�� ������ŭ �ݺ��ϱ�) {
//		A ��������Ʈ�� �׷��� ������ �����ϱ�
//	}
//	for(n�� ������ŭ �ݺ��ϱ�) {
//		if(�湮���� ���� ��尡 ������) {
//			���� ��� ����++
//			DFS �����ϱ�
//		}
//	}
//	DFS{
//		if(���� ��� == �湮 ���) return;
//		visited �迭�� ���� ��� �湮 ����ϱ�
//		���� ����� ���� ��� �� �湮���� ���� ���� DFS �����ϱ�(��� �Լ� ����)
//	}
	
	// �湮��� �迭 ����
	static boolean[] visited;
	// ��������Ʈ
	static ArrayList<Integer>[] A;
	
	public static void main(String[] args) throws IOException {
		// ���� �����Ͱ� ���� ������ buffered ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ���۸����� ¦�� ����
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// �迭 ����. 0�� �湮���� ���� �ű⶧���� 1����
		visited = new boolean[n+1];
		A = new ArrayList[n+1];
		
		for(int i =1; i<n+1; i++) {
			// A�� ��������Ʈ�� �� ArrayList �ʱ�ȭ�ϱ�
			A[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			// ������, ���� ����
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			// �������� ������ �������� �� �� �ִ�
			A[s].add(e);
			A[e].add(s);
		}
		// �湮��� ����
		int count = 0;
		for(int i =1; i<n+1;i++) {
			//�湮���� ���� �����
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
