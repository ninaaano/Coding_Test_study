package study001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class p12891 {
	// ��������
	static int myArr[];
	static int checkArr[];
	static int checkSecret;
	
	public static void main(String[]args) throws IOException{
//		�����̵� ������ �˰��� : 2���� �����ͷ� ������ ������ ���� ������ ������ ä��
//		�̵��ϸ� ������ �ذ�. �������� �˰���� �ſ� ����ϰ� ������ ����
		
		// �����̵� ������ / ���� ���ڿ��� ���õ� �迭 ó��
		
//		// ������ ����
//		S(���ڿ�ũ��) P(�κ� ���ڿ��� ũ��)
//		A(���ڿ� ������)
//		checkArr(��й�ȣ üũ �迭)
//		// ���� ����
//		myArr(���� ���� �迭)
//		checkSecret(�� ���� ���ڿ� ���õ� ������ �����ߴ��� �Ǵ��ϴ� ����)
//		P ���� (0 ~ P-1) ��ŭ S �迭�� �����ϰ�, ��ȿ�� ��й�ȣ���� �Ǵ��ϱ�
//		for(i�� P���� S���� �ݺ�) {
//			j ���� (i-P)
//			// �� �κ��� �Լ��� ���� ����
//		}
		
		BufferedReader br =  new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int Result = 0;
		checkArr = new int[4];
		myArr = new int[4];
		// ���̰� S��ŭ
		char A[] = new char[S];
		checkSecret = 0;
		
		A = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		
		for(int  i=0; i<4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if(checkArr[i]==0) {
				checkSecret++;
			}
		}
		
		for(int i=0; i<P; i++) { // �κ� ���ڿ� ó�� ���� �� ����
			Add(A[i]);
		}
		if(checkSecret == 4) Result++;
		
		// �����̵� ������
		// j�� �� ó��
		for(int i = P; i <S; i++) {
			int j = i-P	;
			Add(A[i]);
			Remove(A[j]);
			if(checkSecret == 4) Result++;
		}
		
		System.out.println(Result);
		br.close();
	
	}

	private static void Remove(char c) {
		switch (c) {
		case 'A':
			if(myArr[0]==checkArr[0]) checkSecret--;
			myArr[0]--;
			break;
		case 'C':
			if(myArr[1]==checkArr[1]) checkSecret--;
			myArr[1]--;
			break;
		case 'G':
			if(myArr[2]==checkArr[2]) checkSecret--;
			myArr[2]--;
			break;
		case 'T':
			if(myArr[3]==checkArr[3]) checkSecret--;
			myArr[3]--;
			break;
		}
	}

	private static void Add(char c) {
		switch (c) {
		case 'A':
			myArr[0]++;
			if(myArr[0]==checkArr[0]) checkSecret++;
			break;
		case 'C':
			myArr[1]++;
			if(myArr[1]==checkArr[1]) checkSecret++;
			break;
		case 'G':
			myArr[2]++;
			if(myArr[2]==checkArr[2]) checkSecret++;
			break;
		case 'T':
			myArr[3]++;
			if(myArr[3]==checkArr[3]) checkSecret++;
			break;
		}
		
	}

}
