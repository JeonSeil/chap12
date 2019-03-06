package chap12;
/*
 * 동기화 예제 2: synchronized 예약어를 사용함.
 *   1. 동기화 블럭   
 *   2. 동기화 메서드 <== 예제 
 *   
 * 동기화 메서드 사용시 공유객체에 존재해야 한다.  
 */
class PrintThread3 extends Thread {
	Printer ptr;
	char ch;
	PrintThread3(char ch, Printer ptr) {
		this.ch = ch;
		this.ptr = ptr;
	}
	public void run() {
		for(int i=0;i<20;i++) {  
	//		ptr.printChar(ch);
			printChar(ch);
		}
	}
	public  synchronized void printChar(char ch) { //동기화 메서드
		for(int i=0;i<80;i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
}
class Printer {
	public synchronized void printChar(char ch) { //동기화 메서드
		for(int i=0;i<80;i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
}
public class ThreadEx6 {
	public static void main(String[] args) {
		Printer ptr = new Printer();
		PrintThread3 t1 = new PrintThread3('A',ptr);
		PrintThread3 t2 = new PrintThread3('B',ptr);
		PrintThread3 t3 = new PrintThread3('C',ptr);
		t1.start(); t2.start(); t3.start();
	}
}
