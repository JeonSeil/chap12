package chap12;
class PrintThreadRunnable3 implements Runnable {
	Printer ptr;
	char ch;
	PrintThreadRunnable3(char ch, Printer ptr) {
		this.ch = ch;
		this.ptr = ptr;
	}
	public void run() {
		for(int i=0;i<20;i++) {  
			ptr.printChar(ch);
		}
	}
}
public class RunnableEx6 {
	public static void main(String[] args) {
		Printer ptr= new Printer();
		Thread t1 = new Thread(new PrintThreadRunnable3('A',ptr));
		Thread t2 = new Thread(new PrintThreadRunnable3('B',ptr));
		Thread t3 = new Thread(new PrintThreadRunnable3('C',ptr));
		t1.start(); t2.start(); t3.start();
	}
}
