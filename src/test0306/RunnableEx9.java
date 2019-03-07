package test0306;

//1. ThreadEx9.java 예제를 Runnable 방식으로 변경하여 RunnableEx9.java 프로그램 구현하기
class DaemonRunnable implements Runnable {
	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread());
			try {
				Thread.sleep(100);
			}catch (InterruptedException e) {}
		}
	}
}
public class RunnableEx9 {
	public static void main(String[] args) {
		DaemonRunnable r = new DaemonRunnable();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.setDaemon(true); 
		t2.setDaemon(true); 
		t1.start(); t2.start();
		try {
			Thread.sleep(2000);
		}catch (InterruptedException e) {}
		System.out.println("main 메서드 종료");
	}
}
