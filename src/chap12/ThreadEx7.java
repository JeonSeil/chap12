package chap12;
//join() : 스레드가 종료할때 까지 대기
class JoinThread extends Thread {
	long sum = 0;
	@Override
	public void run() {
		for(int i=1;i<=100;i++) {
			sum += i;
		}
	}
}
//RunnableEx7 구현하기.
public class ThreadEx7 {
	public static void main(String[] args) {
		System.out.println("스레드를 이용하여 100까지의 합 구하기");
		JoinThread t1 = new JoinThread();
		t1.start(); //병렬환경에서 t1.run() 호출
		try {
			t1.join(); //t1스레드가 종료할때까지 main 메서드 대기.
		}catch(InterruptedException e) {}
		System.out.println("결과:" + t1.sum);
	}
}
