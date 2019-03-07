package chap12;
/*
 * 생산자 스레드 : 데이터를 만드는 기능
 * 소비자 스레드 : 생산자가 생성한 데이터를 사용하는 기능
 * 
 * 한 계좌를 엄마와 아들이 공유함.
 * 계좌에 금액이 0원이면 아들은 wait 상태로 변경되고, 엄마가 입금하면 깨어나도록 프로그램 구현하기.
 * 계좌에 금액이 존재하면, 엄마는  아들이 돈을 꺼낼때 까지 wait 상태로  변경
 * [조건] 
 *   아들 잔액을 0으로 만든다. 엄마는 10000 ~ 30000 까지 만단위로 임의로 입금함.
 *   실행시 무작위로 sleep 한다.  
 */
class Account {
	int money;
	synchronized void output() {
		while(money == 0) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		notifyAll();
		System.out.println(Thread.currentThread().getName() + ":" + money + "원 출금");
		money = 0;
	}
	synchronized void input() {
		while(money > 0) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		money = ((int)(Math.random() * 3) + 1) * 10000;
		notifyAll();
		System.out.println();
		System.out.println(Thread.currentThread().getName() + ":" + money + "원 입금");
	}
}
class Mother extends Thread { //생산자 스레드
	Account account;
	Mother(Account account){
		super("Mother");
		this.account = account;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			account.input();
			try {
				sleep((int)(Math.random() * 3000));
			}catch(InterruptedException e) {}
		}
	}
}
class Son extends Thread { //소비자 스레드
	Account account;
	Son(Account account){
		super("Son");
		this.account = account;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			account.output();
			try {
				sleep((int)(Math.random() * 300));
			}catch(InterruptedException e) {}
		}
	}
}
public class ThreadEx12 {
	public static void main(String[] args) {
		Account a = new Account();
		Thread mother = new Mother(a);
		Thread son = new Son(a);
		son.start(); mother.start();
}
}
