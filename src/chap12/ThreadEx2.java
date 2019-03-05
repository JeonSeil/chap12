package chap12;
/*
 * Runnable 인터페이스를 이용한 스레드 객체 생성.
 * => Runnable 인터페이스를 구현한 클래스는 스레드 객체가 아니다.
 */
class Runnable1 implements Runnable { //Thread 클래스의 객체 아님.
	@Override
	public void run() {
		for(int i=1;i<=5;i++) {
			//Thread.currentThread() : 현재 실행 중인(Running 상태인) 스레드 리턴
			System.out.println(i + "=" + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}
public class ThreadEx2 {
	public static void main(String[] args) {
		System.out.println("main 스레드 시작");
		Runnable r = new Runnable1();
		/*
		 * new Thread(r,"First") 
		 *    Thread 객체를 생성. running을 수행하는 run()메서드는  r 참조변수의 run()메서드를 수행.
		 *    생성된 Thread의 이름은 First임
		 */
		Thread t1 = new Thread(r,"First");
		Thread t2 = new Thread(r,"Second");
//		t1.start(); t2.start();
		t1.run();
		t2.run();
		System.out.println("main 스레드 종료");
	}
}

