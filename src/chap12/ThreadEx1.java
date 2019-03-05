package chap12;
/*
 * Thread ��ü �����ϱ�
 * 1. Thread Ŭ������ ��ӹ޾� ������ ���� <= ThreadEx1.java
 * 2. Runnable �������̽��� �����Ͽ� �����带 ���� <= ThreadEx2.java
 */
class Thread1 extends Thread {
	Thread1(String name) {
		super(name);
	}
	//�����尡 �����ؾ��� ����� ����.
	@Override
	public void run() {         //3. Running ����. run �޼��� ���� ����
		for(int i=1;i<=5;i++) {
			System.out.println(i + "=" + getName());
			try {
				sleep(1000);   //4. ������. => ������ ����� Runnable ����.
			}catch(InterruptedException e) {}
		}
	} //5. dead ����. run�޼��� ����.
}
public class ThreadEx1 {
	public static void main(String[] args) {
		System.out.println("main ������ ����");
		Thread1 t1 = new Thread1("First");   //1. new ����
		Thread1 t2 = new Thread1("Second");  //1. new ����
//		t1.start();                          //2. Runnable ����. ���డ�ɻ���. ���ջ���
//		t2.start();                         //2. Runnable ����. ���డ�ɻ���. ���ջ���
		/*
		 * start() : �������� ����
		 *   1. ���ÿ����� ����ȭ ��.
		 *   2. ���ÿ��� run()�޼��� ȣ��
		 */
		t1.run();
		t2.run();
		System.out.println("main ������ ����");
	}
}
