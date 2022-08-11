package study001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1940 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
//		������ ����� ������ ���� ������ ��ȣ�� �ְ�
//		������ 2���� ���� ����µ� 2���� ����� ������ ��ȣ�� ����
//		M(1<=M<=10,000,000)�� �Ǹ� ������ ���������
//		N(1<=N<=15,000)���� ���� M�� �־����� �� ��� ������ ���� �� �ִ����� ���ϴ� ���α׷�
		
//		1��° �� : ����� ���� N
//		2��° �� : �ʿ��� �� M
//		3��° �� : N���� ������ ���� ������ ��ȣ���� ������ ���̿� �ΰ� �־�����

		// N�� ������ ���� �������� ����. O(nlogn)�̳� �������� ���
		
//		A[i] + A[j] > M : j--; // ��ȣ�� ���� M���� ũ�Ƿ� ū ��ȣ index�� ������
//		A[i] + A[j] < M  : i++; // ��ȣ�� ���� M���� �����Ƿ� ������ȣ index�� �ø���
//		A[i] + A[j] == M : i++; j--; count++; // ���� �����͸� ��� �̵���Ű�� count ����

//		N(����� ����), M(������ �Ǵ� ��ȣ)�����ϱ�
//		for(N��ŭ �ݺ�) {
//			��� �迭 �����ϱ�	
//		}
//		��� �迭 �����ϱ�
//		while(i<j) {
//			if(��� �� < M) ���� ��ȣ ��Ḧ ��ĭ ���� ����
//			else if(��� �� > M) ū ��ȣ ��Ḧ ��ĭ �Ʒ��� ����
//			else ����� �� ����, ���� index ���� ����
//		}
//		count ����ϱ�
		
		// Scanner sc = new Scanner(System.in);
		 
		BufferedReader br 
		= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int []A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		int count = 0;
		int i = 0; //A[0] => min
		int j = N-1; //A[N-1]
		
		while(i<j) {
			if(A[i]+A[j] < M) {
				i++;
			} else if(A[i]+A[j] > M) {
				j--;
			}else {
				i++; j--; count++;
			}
		}
		System.out.println(count);
		
		
	}

}

