package chap12;
/*
 * InterruptedException 예외 발생하여 sleep 중인 스레드를 깨우기.
 */
class InterruptThread extends Thread {
	@Override
	public void run() {
		System.out.println("자고 있습니다. 깨우지 마세요.");
		try {
			sleep(100000);
		} catch (InterruptedException e) {
			System.out.println("누가 깨웠니?");
			e.printStackTrace();
		}
	}
}
public class ThreadEx8 {
	public static void main(String[] args) {
		InterruptThread t1 = new InterruptThread();
		t1.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		t1.interrupt(); //t1 스레드에 InterruptedException 예외 발생함.
	}
}