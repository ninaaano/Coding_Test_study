package study001;

import java.util.Arrays;
import java.util.Scanner;

public class p1920 {
	
	// N���� ���� A[1],A[2],...,A[N]�� �־��� ���� �� �� �ȿ�
	// X��� ������ �����ϴ��� �˾Ƴ��� ���α׷�
	
	// 1��° �ٿ� �ڿ��� N(1<=N<=100,000)
	// �� �����ٿ� N���� ������ �־�����
	// �� �����ٿ� M(1<=M<=100,000)
	// �� �����ٿ� M���� ������ �־����µ�
	// �� ������ A�ȿ� �����ϴ��� �˾Ƴ���ȴ�. ��� ������ ������ -231���� ũ�ų� ���� 231���� �۴�

	// M���� �ٿ� ���� ���. �����ϸ� 1, �������� ������ 0 ���
	
//	1. Ž�� �����͸� 1���� �迭�� ������ ���� ����� �迭�� ���� => nlogn
//	2. X��� ������ �����ϴ��� ����Ž���� ����� Ȯ��

	// �����ڵ�
//	N(������ �� ����) M(Ž���� ������ ����)
//	A(������ �迭 �����ϱ�)
//	for(N�� ������ŭ �ݺ��ϱ�) {
//		A �迭 �����ϱ�	
//	}
//	A �迭 �����ϱ�
//	for(M�� ������ŭ �ݺ��ϱ�) {
//		target(ã�ƾ� �ϴ� ��)
	// ���� Ž�� ����
//		start(���� �ε���), end(���� �ε���)
//		while(���� �ε��� <= ���� �ε���) { // Ž���� �κ��� ���� �� ����
//			midi(�߰� �ε���)
//			if(�߾Ӱ� > target) {
//				���� �ε��� = �߰� �ε��� -1
//			}
//			else if(�߾Ӱ�<target) {
//				���� �ε��� = �߰� �ε��� + 1
//			} else {
//				ã�����Ƿ� �ݺ��� �����ϱ�
//			}
//		}
//		if(ã����) 1���
//		else 0 ���
//	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);
		int M = sc.nextInt();
		for(int i=0; i<M; i++) {
			boolean find = false;
			int target = sc.nextInt();
			// ����Ž��
			int start = 0;
			int end = A.length-1;
			while(start <= end) { // Ž���� �κ��� ���� �� ����
				int mid_index = (start+end)/2;
				int mid_value = A[mid_index]; // �迭 �ȿ� �ִ� ���� ��
				if(mid_value > target) {
					end = mid_index -1;
				}else if(mid_value < target) {
					start = mid_index +1;
				}else {
					find = true;
					break;
				}
			}
			if(find==true) System.out.println("1");
			else System.out.println("0");
		}

	}

}
