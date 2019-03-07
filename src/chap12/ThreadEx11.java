package chap12;
/*
 * wait(), notify(), notifyAll() 메서드 예제
 * 1. 동기화 영역(동기화블럭, 동기화메서드)에서만 호출이 가능함.
 * 2. Object 클래스의 멤버임.=> 모든 객체는 세가지 메서드를 호출할 수 있다.
 * 3. wait() : 실행 중인 스레드를 대기상태로 변환. lock 해제 함.
 *    notify() : wait() 상태인 스레드 한개를 Runnable 상태로 변환함. 단 스레드 지정은 안됨.
 *    notifyAll() : wait() 상태인 모든 스레드를 Runnable 상태로 변환함. 
 */
class ATM2 implements Runnable {
	private int money = 100000;
	@Override
	public void run() {
		try {
			Thread.sleep((int)(Math.random() * 1000));
		} catch (InterruptedException e) {}
		synchronized (this) {
			while(true) {
				if(money <= 0) {
					notifyAll();
					break;
				}
				withdraw();
				if(money % 20000 == 0) {
					try {
						wait();
					} catch(InterruptedException e) {}
				} else {
					notifyAll();
				}
			}
		}
	}
	private void withdraw() {
		if(money <= 0) return;
		money -= 10000;
		System.out.println(Thread.currentThread().getName() + "출금, 잔액:" + money);
	}
}
public class ThreadEx11 {
	public static void main(String[] args) {
		ATM2 atm = new ATM2();
		Thread mother = new Thread(atm,"MOTHER");
		Thread son = new Thread(atm,"SON");
		mother.start();  son.start();

	}
}
