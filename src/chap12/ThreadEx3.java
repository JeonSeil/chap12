package chap12;
/*
 * Thread �켱 ���� : �����ٷ����� ���� ������ ���� �� �ֵ��� ������ �����ϴ�.
 *     �� �켱������ ���ٰ� ������ ���� ������ ���� �� �ִ� ���� �ƴϴ�. �ٸ� Ȯ���� ���� ����.
 */
class ThreadProperty extends Thread {
	ThreadProperty(String name) {
		this(name,Thread.NORM_PRIORITY);
	}
	ThreadProperty(String name, int p) {
		super(name);
		this.setPriority(p); //�켱���� ����
	}
	@Override
	public void run() {
		try {
			sleep(20); //0.02��
		}catch (InterruptedException e) {}
		for(int i =0;i<50;i++) {
			System.out.println(this.toString());
			/*
			 * Thread.toString()
			 * Thread[First,1,main]
			 *   First : ������ �̸�.
			 *   1     : �켱������
			 *   main  : ������׷��̸�
			 */
		}
	}
}
public class ThreadEx3 {
	public static void main(String[] args) {
		System.out.println("�����켱����:" + Thread.MAX_PRIORITY);
		System.out.println("�⺻�켱����:" + Thread.NORM_PRIORITY);
		System.out.println("�����켱����:" + Thread.MIN_PRIORITY);
		Thread t1 = new ThreadProperty("First",1);
		Thread t2 = new ThreadProperty("Second");
		Thread t3 = new ThreadProperty("Third",10);
		t1.start();
		t2.start();
		t3.start();
		System.out.println("main �޼��� ����");
	}
}
