package chap12;
/*
 * Runnable �������̽��� �̿��� ������ ��ü ����.
 * => Runnable �������̽��� ������ Ŭ������ ������ ��ü�� �ƴϴ�.
 */
class Runnable1 implements Runnable { //Thread Ŭ������ ��ü �ƴ�.
	@Override
	public void run() {
		for(int i=1;i<=5;i++) {
			//Thread.currentThread() : ���� ���� ����(Running ������) ������ ����
			System.out.println(i + "=" + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}
public class ThreadEx2 {
	public static void main(String[] args) {
		System.out.println("main ������ ����");
		Runnable r = new Runnable1();
		/*
		 * new Thread(r,"First") 
		 *    Thread ��ü�� ����. running�� �����ϴ� run()�޼����  r ���������� run()�޼��带 ����.
		 *    ������ Thread�� �̸��� First��
		 */
		Thread t1 = new Thread(r,"First");
		Thread t2 = new Thread(r,"Second");
//		t1.start(); t2.start();
		t1.run();
		t2.run();
		System.out.println("main ������ ����");
	}
}

