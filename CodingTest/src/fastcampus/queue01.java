package fastcampus;

import java.util.ArrayList;

public class queue01<T> {

	// Java ArrayList 클래스를 활용해 큐를 다루는 enqueue, dequeue 기능 구현
	// dequeue 기능 호출 시, 큐에 데이터가 없을 경우, null 리턴
	// 다양한 데이터 타입을 다룰 수 있도록 Java Generic 타입 문법 활용해보기
	
		private ArrayList<T> queue =  new ArrayList<T>();
		
		public void enqueue(T item) {
			queue.add(item);
		}
		
		public T dequeue() {
			if(queue.isEmpty()) {
				return null;
			}
			return queue.remove(0);
		}
		public boolean isEmpty() {
			return queue.isEmpty();
		}
		
	
	
	public static void main(String[] args) {

		queue01<Integer> mq = new queue01<Integer>();
		mq.enqueue(1);
		mq.enqueue(2);
		mq.enqueue(3);
		System.out.println(mq.dequeue());
		System.out.println(mq.dequeue());
		System.out.println(mq.dequeue());
	}

}
