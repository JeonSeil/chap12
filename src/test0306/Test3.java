package test0306;
/*
1부터 1000까지의 합을 5개의 스레드가 나누어 합을 구하기 : Thread 클래스를 상속받는 방식으로 구현하기
 t1 : 1 ~ 200까지 합
 t2 : 201 ~400까지 합
 t3 : 401 ~ 600까지 합
 t4 : 601 ~ 800까지 합
 t5 : 801 ~ 1000까지 합

 main 스레드 : 모든 스레드가 종료할때 까지 기다렸다가 
             모든 스레드의 합을 더해서 1 ~ 1000까지의 합 출력하는 프로그램 구현하기    */
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
		System.out.println("1 ~ 1000 까지의 합:" + total);
	}
}