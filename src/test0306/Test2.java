package test0306;
/*
1���� 1000������ ���� 5���� �����尡 ������ ���� ���ϱ� : Thread Ŭ������ ��ӹ޴� ������� �����ϱ�
 t1 : 1 ~ 200���� ��
 t2 : 201 ~400���� ��
 t3 : 401 ~ 600���� ��
 t4 : 601 ~ 800���� ��
 t5 : 801 ~ 1000���� ��

 main ������ : ��� �����尡 �����Ҷ� ���� ��ٷȴٰ� 
             ��� �������� ���� ���ؼ� 1 ~ 1000������ �� ����ϴ� ���α׷� �����ϱ�    */
class SumThread extends Thread {
	int start,end,sum;
	SumThread(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public void run() {
		for(int i=start;i<=end;i++) {
			sum += i;
		}
	}
}
public class Test2 {
	public static void main(String[] args) throws InterruptedException {
		SumThread[] tarr = new SumThread[5];
		int total = 0;
		for(int i=0;i<tarr.length;i++) {
			tarr[i] = new SumThread(i*200+1,(i+1)*200);
			tarr[i].start();
		}
		for(SumThread t : tarr) {
			t.join();
			total += t.sum;
		}
		System.out.println("1 ~ 1000 ������ ��:" + total);
	}
}