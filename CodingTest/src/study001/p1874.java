package study001;

import java.util.Scanner;
import java.util.Stack;

public class p1874 {

	public static void main(String[] args) {		
		// �������� �������� ���� �����
		// ������ ������ ���ÿ� �־��ٰ� ����ϴ� ������� �������� ������ ����� �� �ִ��� Ȯ���ϰ�,
		// ����� �� �ִٸ� push�� pop ������ � ������ �����ؾ� �ϴ��� �˾Ƴ��� ���α׷� �ۼ�

//		�Է�
//		1��° �ٿ� ������ ����n(1<=n<=100,000)�� �־�����.
//		2��° �ٿ��� n���� �ٿ��� ������ �̷�� 1�̻� n������ ������ 1���� ������� �־�����
//		�� �� ���� ������ �ι� �̻� ������ �ʴ´�
//		
//		���
//		�������� ������ ����� ���� ���� ���� ���. push ������ +, pop ������ -
//		�Ұ��� �Ҷ��� NO�� ����Ѵ�
		
		// ������ ���� �ľ��ϱ� FILO
		
//		N(���� ����) A[](���� �迭)
//		���� �迭 ä���
//		for(N��ŭ �ݺ�) {
//			if(���� ���� �� >= �������� �ڿ���) {
//				while(���� ������ ������) {
//					push()
//					(+)����
//				}else(���� ���� ��<�������� �ڿ���){
//					pop()
//					if(���� pop �ᱣ�� > ������ ��) NO ���
//					else (-)����
//				}
//			}
//			if(-���� ����� ���� ������) ������ �� ���
//		}
		
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		int A[] = new int[N];
		for(int i=0; i<N;i++) {
			A[i] = sc.nextInt()	;
		}
		Stack<Integer> stack = new Stack<>();
		// �������� �ڿ��� num ����
		int num = 1;
		boolean result = true;
		// �����ϱ� ���� ��Ʈ�� ���� ����
		StringBuffer bf = new StringBuffer();
		for (int i=0; i<A.length; i++) {
			int su = A[i];
			if(su >= num) {
				while(su>=num) {
				stack.push(num++);
				bf.append("+\n");
			}
			stack.pop();
			bf.append("-\n");
		}else{
			int n = stack.pop();
			if(n>su) {
				System.out.println("NO");
				break;
			}else {
				bf.append("-\n");
			}
		}
		}
		if(result) System.out.println(bf.toString());
	}

}
