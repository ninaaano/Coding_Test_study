package study001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p11284 {
	public static void main(String[] args) throws IOException{
		// ���� �� �ڷᱸ��
		// 1. �迭�� ���� x�� �ִ´�(x�� 0�� �ƴ�)
		// 2. �迭���� ������ ���� ���� ���� ����� �� �� ���� �迭���� �����Ѵ�.
		// ������ ���� ���� ���� ���� ���� ��쿡�� �� �� ���� ���� ���� ����ϰ�
		// �� ���� �迭���� �����Ѵ�
		
		// ���α׷��� ó���� ����ִ� �迭���� �����Ѵ�. ���� ���� �����Ͻÿ�
		
//		�Է�
//		1��° �� : ������ ���� N(1<=N<=100,000)�� �־�����
//		���� N���� �ٿ��� ����� ���õ� ������ �����´� ���� x�� �־�����
//		���� x�� 0�� �ƴ϶�� �迭�� x��� ���� �߰��ϰ�,
//		x�� 0�̶�� �迭���� ������ ���� ���� ���� ����ϰ�,
//		�� ���� �迭���� �����Ѵ�.
//		�ԷµǴ� ������ -231���� ũ��, 231���� �۴�
//		
//		���
//		�Է¿��� 0�� �־��� Ƚ����ŭ ���� ����Ѵ�
//		���� �迭�� ����ִµ� ������ ���� ���� ���� ����϶�� �� ���� 0�� ���
	
		// �����Ͱ� ���� ���Ե� ������ ���񰪰� ���õ� ������ �ʿ��ϹǷ�,
		// �켱���� ť�� ������ ���� �ذ��� �� �ִ�
		// x=0 �϶� : ť�� ����������� 0�� ���, ��� ���� ������ �ּڰ� ���, ������ ������ ���� �켱 ���
		// x=1 �϶� : add�� ť�� ���ο� ���� �߰��ϰ� �켱���� ť ���ı������� �ڵ� ����
		
		// �����ڵ�
//		N(���� ��û ����)
//		�켱���� ť ���� // ���� �������� ���ĵǵ��� �����ϱ�. ��, ������ ������ ���� �켱 ����
//		for(N��ŭ �ݺ�) {
//			��û�� 0�϶� : ť�� ��������� 0, ������� ������ ť�� front �� ���(poll())
//			��û�� 1�϶� : ���ο� �����͸� �켱���� ť�� ���ϱ�(add())
//		}
		
		// �ð����⵵ ���Ǹ� ���� ���۷� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// �켱���� ť ���� -> ���ٽ� ���
		PriorityQueue<Integer> myQueue= new PriorityQueue<>((o1,o2)->{
						
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			
			if(first_abs == second_abs) {
				return o1 > o2? 1 : -1; // ������ ���� ��� ���� �켱
			}
			return first_abs-second_abs; // ������ ���� ������ �켱
			
		}); 
			
			for(int i = 0; i<N; i++) {
				// ������ �ޱ�
				int request = Integer.parseInt(br.readLine());
				if(request == 0) {
					if(myQueue.isEmpty()) {
						System.out.println("0");
					}else {
						System.out.println(myQueue.poll());
					}
				}else {
					myQueue.add(request);
				}
			}

	}

}
