package chap12;
class JoinThreadRunnable implements Runnable {
	long sum = 0;
	@Override
	public void run() {
		for(int i=1;i<=100;i++) {
			sum += i;
		}
	}
}
public class RunnableEx7 {
	public static void main(String[] args) {
		System.out.println("스레드를 이용하여 100까지의 합 구하기");
		JoinThreadRunnable r = new JoinThreadRunnable();
		Thread t1 = new Thread(r);
		t1.start(); 
		try {
			t1.join();
		}catch(InterruptedException e) {}
		System.out.println("결과:" + r.sum);
	}
}
