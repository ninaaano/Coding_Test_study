package study001;

import java.util.Scanner;

public class p1427 {
	
	public static void main(String[] args) {
		
		// ������������ �ڸ��� �����ϱ�
		// 1��° �ٿ� ������ �� N�� �־�����. N�� 1,000,000,000���� �۰ų� ���� �ڿ�����
		
		// �������� �̿�
		// String  ������ ������ �����͸� �޾� int�� �迭�� ����. �̶��� subString() �Լ��� �����
		// ���ڸ� �� �ڸ��� ���� ���� �� �迭�� �����Ѵ�
		
		// �迭�� �����͸� ���� ���� �˰����� �̿��� �������� �����Ѵ�.
		// �ִ��� ã�� ������ �Ǵ� �ڸ��� swap �Ѵ�
		
		// �����ڵ�
//		str(������ ��)
//		A(�ڸ��� ���� ������ ������ �迭)
//		for(str�� ���̸�ŭ �ݺ��ϱ�) {
//			A �迭 ���� -  str.subString ����ϱ�
//		}
//		for(i:0~str�� ���̸�ŭ �ݺ��ϱ�) {
//			for(j:i+1-str�� ���̸�ŭ �ݺ��ϱ�) {
//				���� �������� Max�� ã��
//			}
//			���� i�� ���� Max�� �� Max���� �� ũ�� swqp �����ϱ�
//		}
//		A �迭 ����ϱ�

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		// Integer �迭�� ��ȯ�ϱ� ���� [] ����
		int A[] = new int[str.length()];
		// ������ �ֱ�
		for(int i=0; i<str.length(); i++) {
			// i,i+1 ���� ��ĭ�� �̵�.str�� String�̱� ������ Integer�� ����ȯ ������Ѵ�.
			A[i] = Integer.parseInt(str.substring(i,i+1));
		}
		// ��������
		for(int i=0; i<str.length(); i++) {
			int Max = i;
			for(int j=i+1; j<str.length(); j++) {
				if(A[j]>A[Max]) {
					Max = j;
				}
			}
				if(A[i]<A[Max]) {
					// �ڸ��ٲ� ���� ����. ������ �ٸ��� ���� �ٸ��� ���´�
					int temp = A[i];
					A[i] = A[Max];
					A[Max] = temp;
				}
				
			}
			for(int i = 0; i<str.length(); i++) {
				System.out.print(A[i]);
			}
		}
		
		
		
	}

