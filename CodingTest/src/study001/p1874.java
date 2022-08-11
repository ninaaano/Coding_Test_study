package study001;

import java.util.Scanner;
import java.util.Stack;

public class p1874 {

	public static void main(String[] args) {		
		// 스택으로 오름차순 수열 만들기
		// 임의의 수열을 스택에 넣었다가 출력하는 방식으로 오름차순 수열을 출력할 수 있는지 확인하고,
		// 출력할 수 있다면 push와 pop 연산을 어떤 순서로 수행해야 하는지 알아내는 프로그램 작성

//		입력
//		1번째 줄에 수열의 개수n(1<=n<=100,000)이 주어진다.
//		2번째 줄에서 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 1개씩 순서대로 주어진다
//		이 때 같은 정수가 두번 이상 나오지 않는다
//		
//		출력
//		오름차순 수열을 만들기 위한 연산 순서 출력. push 연산은 +, pop 연산은 -
//		불가능 할때는 NO를 출력한다
		
		// 스택의 원리 파악하기 FILO
		
//		N(수열 개수) A[](수열 배열)
//		수열 배열 채우기
//		for(N만큼 반복) {
//			if(현재 수열 값 >= 오름차순 자연수) {
//				while(값이 같아질 때까지) {
//					push()
//					(+)저장
//				}else(현재 수열 값<오름차순 자연수){
//					pop()
//					if(스택 pop 결괏값 > 수열의 수) NO 출력
//					else (-)저장
//				}
//			}
//			if(-값을 출력한 적이 없으면) 저장한 값 출력
//		}
		
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		int A[] = new int[N];
		for(int i=0; i<N;i++) {
			A[i] = sc.nextInt()	;
		}
		Stack<Integer> stack = new Stack<>();
		// 오름차순 자연수 num 선언
		int num = 1;
		boolean result = true;
		// 저장하기 위해 스트링 버퍼 선언
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
