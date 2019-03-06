package chap12;
class PrintThreadRunnable2 implements Runnable {
	char ch;
	PrintThreadRunnable2(char ch) {
		this.ch = ch;
	}
	static  int[] arr = new int[1]; 
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			synchronized(arr) {  //임계영역. 동기화 영역(동기화 블럭)
				for(int j=0;j<80;j++) {
					System.out.print(ch);
				}
			}
			System.out.println();
		}
	}
}
public class RunnableEx5 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new PrintThreadRunnable2('A'));
		Thread t2 = new Thread(new PrintThreadRunnable2('B'));
		Thread t3 = new Thread(new PrintThreadRunnable2('C'));
		t1.start(); t2.start(); t3.start();
	}
}
