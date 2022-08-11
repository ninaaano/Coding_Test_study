package study001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11659 {
	
	// �� N���� �־����� �� i��° ������ j��° �������� ���� ���ϴ� ���α׷�
	
	// 1��° �ٿ� �� ���� N(1<=N<=100,000), ���� ���ؾ� �ϴ� Ƚ�� M(1<=M<=100,000),
	// 2��° �ٿ� N���� ���� �־�����. �� ���� 1,000 ���� �۰ų� ���� �ڿ���
	// 3��° �ٺ��ʹ� M���� �ٿ� ���� ���ؾ� �ϴ� ���� i�� j�� �־�����
	
	// ���� ���� �Ź� ����Ѵٸ� �־��� ��� 1��ȸ �̻��� ���� ����. ���ѽð� 0.5��
	

	// �� �迭 ���� S[i]=S[i-1]+A[i]
	// ���� �� ���� S[j] - S[i-1]
	
	// suNo(���� ����), quizNo(���� ����) �����ϱ�
	// for(���� ������ŭ �ݺ��ϱ�) {
	// �� �迭 �����ϱ�(S[i]=S[i-1]+A[i])
	// }
	// for(���� ������ŭ �ݺ��ϱ�) {
	// ���� ���� �ޱ�(i~j)
	// ���� �� ����ϱ� (S[j] - S[i-1])
	// }
	
	public static void main(String[] args) throws IOException{
	
	// Scanner sc = new Scanner(System.in);
	// ���� ũ�� BufferedReader�� ����. �� ������ ������
		
		BufferedReader bufferedReader = 
				new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stringTokenizer =
				new StringTokenizer(bufferedReader.readLine());
		
		int suNo = Integer.parseInt(stringTokenizer.nextToken());
		int quizNo = Integer.parseInt(stringTokenizer.nextToken());
		
		//������ ������ �ٷ궧�� long���� �� ����
		long[]S = new long[suNo + 1];
		
		stringTokenizer =
				new StringTokenizer(bufferedReader.readLine());
		for(int i =1; i<=suNo; i++) {
			S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
		}
		
		for(int q=0; q<quizNo; q++) {
			stringTokenizer =
					new StringTokenizer(bufferedReader.readLine());
			int i = Integer.parseInt(stringTokenizer.nextToken());
			int j = Integer.parseInt(stringTokenizer.nextToken());
			
			System.out.println(S[j]-S[i-1]);
		}
		
		
		
	}
}
