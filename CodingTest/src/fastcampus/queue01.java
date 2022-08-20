package fastcampus;

import java.util.ArrayList;

public class queue01<T> {

	// Java ArrayList Ŭ������ Ȱ���� ť�� �ٷ�� enqueue, dequeue ��� ����
	// dequeue ��� ȣ�� ��, ť�� �����Ͱ� ���� ���, null ����
	// �پ��� ������ Ÿ���� �ٷ� �� �ֵ��� Java Generic Ÿ�� ���� Ȱ���غ���
	
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
