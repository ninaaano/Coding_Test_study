package study001;

import java.util.Scanner;

public class p1541 {
	// 최솟값을 만드는 괄호 배치 찾기
	// 양수와 +,- 그리고 괄호를 이용해 어떤 수식을 만들었다
	// 그리고 괄호를 모두 지우고, 다시 괄호를 적절히 넣어 이 수식의 값을 최소로 만들려고 한다
	// 이렇게 수식의 괄호를 다시 적절하게 배치해 수식의 값을 최소로 만드는 프로그램을 작성
	
	// 1번째 줄에 식이 주어진다. 식은 '0'~'9', '+','-' 만으로 이루어져 있고
	// 가장 처음과 마지막 문자는 숫자다
	// 그리고 연속해서 2개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다
	// 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다
	
	// 그리디의 관점에서 생각
	// 가장 작은 최솟값을 만들기 위해서는 가능한 한 큰 수를 빼야한다
	// 수식이 더하기와 빼기 연산만으로 이뤄져있기 때문에
	// 더하기에 해당하는 부분에 괄호를 쳐서 먼저 모두 계산한 후 빼기를 실행

	// -가 되는 숫자가 크면 클수록 전체 수식의 결과는 최소가 된다
	
	// 1. 가장 먼저 더하기 연산을 실행한다
	// 2. 가장 앞에 있는 값에서 더하기 연산으로 나온 결괏값을 모두 뺀다
	
	// 슈도 코드
//	answer(정답 변수)
//	들어온 데이터를 "-" 기호를 기준으로 split() 수행하기
//	for(나눠진 데이터 개수만큼 반복하기) {
//		결괏값 = mySum() 함수 수행하기
//				if(가장 앞 데이터일 때) answer에 결괏값 더하기
//				else answer에 결괏값 빼기
//	}
//	answer 출력하기
//	mySum() 함수 구현하기 { // 현재 String에 있는 수를 모두 더하는 함수
//		현재 들어온 Stirng값을 "+" 기호 기준으로 split() 수행하기
//		for(나눠진 데이터 개수만큼 반복하기) {
//			String 값을 Integer형으로 변환해 리턴값에 더하기
//		}
//		전체 합 리턴하기
//	}

	static int answer = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		// 긴 String을 받을 땐 nextLine 선언
		String example = sc.nextLine();
		// spilt 하려면 String 배열로 선언
		String[] str = example.split("-");
		for(int i = 0; i<str.length; i++) {
			// 결괏값 temp 선언
			int temp = mySum(str[i]);
			if(i==0) answer = answer + temp;
			else answer = answer - temp;
		}
		System.out.println(answer);

	}

	private static int mySum(String a) {
		int sum = 0;
		// 실행하면 +를 인식 못하기 때문에 [+] 해준다
		String[] temp = a.split("[+]");
		for(int i=0; i<temp.length; i++) {
			sum = sum+Integer.parseInt(temp[i]);
		}
		return sum;
	}

}
