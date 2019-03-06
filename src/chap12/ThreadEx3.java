package chap12;
/*
 * Thread 우선 순위 : 스케줄러에게 빠른 선택을 받을 수 있도록 설정이 가능하다.
 *     단 우선순위가 높다고 무조건 먼저 선택을 받을 수 있는 것은 아니다. 다만 확률이 높을 뿐임.
 */
class ThreadProperty extends Thread {
	ThreadProperty(String name) {
		this(name,Thread.NORM_PRIORITY);
	}
	ThreadProperty(String name, int p) {
		super(name);
		this.setPriority(p); //우선순위 설정
	}
	@Override
	public void run() {
		try {
			sleep(20); //0.02초
		}catch (InterruptedException e) {}
		for(int i =0;i<50;i++) {
			System.out.println(this.toString());
			/*
			 * Thread.toString()
			 * Thread[First,1,main]
			 *   First : 스레드 이름.
			 *   1     : 우선순위값
			 *   main  : 스레드그룹이름
			 */
		}
	}
}
public class ThreadEx3 {
	public static void main(String[] args) {
		System.out.println("높은우선순위:" + Thread.MAX_PRIORITY);
		System.out.println("기본우선순위:" + Thread.NORM_PRIORITY);
		System.out.println("낮은우선순위:" + Thread.MIN_PRIORITY);
		Thread t1 = new ThreadProperty("First",1);
		Thread t2 = new ThreadProperty("Second");
		Thread t3 = new ThreadProperty("Third",10);
		t1.start();
		t2.start();
		t3.start();
		System.out.println("main 메서드 종료");
	}
}
