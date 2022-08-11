package study001;

import java.util.Scanner;

public class p2018 {
	
	public static void main(String[] args) {
		
		// �������ʹ� 2���� �����ͷ� �˰����� �ð� ���⵵�� ����ȭ�Ѵ�. �˰��� �ſ� ����
		
//		��� �ڿ��� N�� ��� ���ӵ� �ڿ����� ������ ��Ÿ�� �� �ִ�.
//		�ڿ��� N(1<=N<=10,000,000)�� �� ���� ���ӵ� �ڿ����� ������ ��Ÿ���� �������� �˰� �ʹ�.
//		�̶� ����ϴ� �ڿ����� N. N�� �Է¹޾� ���ӵ� �ڿ����� ������ ��Ÿ���� �������� ����ϴ� ���α׷� �ۼ�
	
	
		// N�� ������ ũ�⶧���� O(n) => �������� ���. �����ε����� �����ε��� ����
		
//		sum > N : sum = sum - start_index; start_index++;
//		sum < N : end_index++; sum = sum + end_index;
//		sum == N : end_index++; sum = sum + end_index; count++;

//		N ���� ����
//		��� ���� �ʱ�ȭ(count = 1, start_index=1; end_index=1; sum=1)
		// count�� 1�������� �ڱ��ڽ� �ϳ��� �̷���� ����� ���� �̸� ����
//		while(end_index != N) {
//			if(sum == N) count ����, end_index ����, sum�� ����
//			else if(sum > N) sum �� ����, start_index ����
//			else if(sum < N) end_index ����, sum �� ����
//		}
//		count ����ϱ�
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt()	;
		int count = 1;
		int start_index = 1;
		int end_index = 1;
		int sum = 1;
		
		while(end_index != N) {
			if(sum == N) {
				count ++;
				end_index++;
				sum += end_index;
			} else if(sum > N) {
				sum -= start_index;
				start_index++;
			} else {
				end_index++;
				sum += end_index;
			}
		}
		System.out.println(count);
		
	}

}
