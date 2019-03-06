package chap12;
//join() : �����尡 �����Ҷ� ���� ���
class JoinThread extends Thread {
	long sum = 0;
	@Override
	public void run() {
		for(int i=1;i<=100;i++) {
			sum += i;
		}
	}
}
//RunnableEx7 �����ϱ�.
public class ThreadEx7 {
	public static void main(String[] args) {
		System.out.println("�����带 �̿��Ͽ� 100������ �� ���ϱ�");
		JoinThread t1 = new JoinThread();
		t1.start(); //����ȯ�濡�� t1.run() ȣ��
		try {
			t1.join(); //t1�����尡 �����Ҷ����� main �޼��� ���.
		}catch(InterruptedException e) {}
		System.out.println("���:" + t1.sum);
	}
}
