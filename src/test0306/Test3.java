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
class SumRunnable implements Runnable {
	int start,end,sum;
	SumRunnable(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public void run() {
		for(int i=start;i<=end;i++) {
			sum += i;
		}
	}
}
public class Test3 {
	public static void main(String[] args) throws InterruptedException {
		SumRunnable[] arr = new SumRunnable[5];
		Thread[] tarr = new Thread[5];
		int total = 0;
		for(int i=0;i<tarr.length;i++) {
			arr[i] = new SumRunnable(i*200+1,(i+1)*200);
			tarr[i] = new Thread(arr[i]);
			tarr[i].start();
		}
		for(int i=0;i<tarr.length;i++) {
			tarr[i].join();
			total += arr[i].sum;
		}
		System.out.println("1 ~ 1000 ������ ��:" + total);
	}
}