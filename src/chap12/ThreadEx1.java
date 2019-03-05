package chap12;
/*
 * Thread 객체 생성하기
 * 1. Thread 클래스를 상속받아 스레드 생성 <= ThreadEx1.java
 * 2. Runnable 인터페이스를 구현하여 스레드를 생성 <= ThreadEx2.java
 */
class Thread1 extends Thread {
	Thread1(String name) {
		super(name);
	}
	//스레드가 수행해야할 기능을 구현.
	@Override
	public void run() {         //3. Running 상태. run 메서드 실행 상태
		for(int i=1;i<=5;i++) {
			System.out.println(i + "=" + getName());
			try {
				sleep(1000);   //4. 대기상태. => 대기상태 종료시 Runnable 상태.
			}catch(InterruptedException e) {}
		}
	} //5. dead 상태. run메서드 종료.
}
public class ThreadEx1 {
	public static void main(String[] args) {
		System.out.println("main 스레드 시작");
		Thread1 t1 = new Thread1("First");   //1. new 상태
		Thread1 t2 = new Thread1("Second");  //1. new 상태
//		t1.start();                          //2. Runnable 상태. 실행가능상태. 경합상태
//		t2.start();                         //2. Runnable 상태. 실행가능상태. 경합상태
		/*
		 * start() : 스레드의 시작
		 *   1. 스택영역을 병렬화 함.
		 *   2. 스택영역 run()메서드 호출
		 */
		t1.run();
		t2.run();
		System.out.println("main 스레드 종료");
	}
}
