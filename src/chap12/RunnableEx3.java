package chap12;
class RunnablePriority implements Runnable  {
	@Override
	public void run() {
		try {
			Thread.sleep(20); //0.02√ 
		}catch (InterruptedException e) {}
		for(int i =0;i<50;i++) {
			System.out.println(Thread.currentThread());
		}
	}
}
public class RunnableEx3 {
	public static void main(String[] args) {
		RunnablePriority r = new RunnablePriority();
		Thread t1 = new Thread(r,"First");
		Thread t2 = new Thread(r,"Second");
		Thread t3 = new Thread(r,"Third");
		t1.setPriority(1);
		t2.setPriority(5);
		t3.setPriority(10);
		t1.start();
		t2.start();
		t3.start();
	}
}
