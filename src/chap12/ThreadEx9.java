package chap12;
/*
 * ���󽺷��� : �Ϲݽ������� ���� ������ �ϴ� ������
 *           �Ϲݽ����尡 ����Ǹ�, ���󽺷��嵵 ����ȴ�. 
 */
class DaemonThread extends Thread {
	@Override
	public void run() {
		while(true) {
			System.out.println(this);
			try {
				sleep(100);
			}catch (InterruptedException e) {}
		}
	}
}
public class ThreadEx9 {
	public static void main(String[] args) {
		Thread t1 = new DaemonThread();
		Thread t2 = new DaemonThread();
		t1.setDaemon(true); //���󽺷���� ����. new ���¿����� ������ ������.
		t2.setDaemon(true); //���󽺷���� ����. new ���¿����� ������ ������.
		t1.start(); t2.start();
		try {
			Thread.sleep(2000);
		}catch (InterruptedException e) {}
		System.out.println("main �޼��� ����");
	}
}
