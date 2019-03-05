package chap12;
/*
 * Process : OS상태에서 실행중인 프로그램.
 * Runtime  Runtime.getRuntime() : OS로부터 프로세스의 실행 권한을 받기.
 */
public class ProcessEx1 {
	public static void main(String[] args) {
		try {
			Process p1 = Runtime.getRuntime().exec("calc.exe");
			Process p2 = Runtime.getRuntime().exec("notepad.exe");
			Process p3 = Runtime.getRuntime().exec("mspaint.exe");
			System.out.println("main 메서드 종료");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
