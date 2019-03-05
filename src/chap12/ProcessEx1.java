package chap12;
/*
 * Process : OS���¿��� �������� ���α׷�.
 * Runtime  Runtime.getRuntime() : OS�κ��� ���μ����� ���� ������ �ޱ�.
 */
public class ProcessEx1 {
	public static void main(String[] args) {
		try {
			Process p1 = Runtime.getRuntime().exec("calc.exe");
			Process p2 = Runtime.getRuntime().exec("notepad.exe");
			Process p3 = Runtime.getRuntime().exec("mspaint.exe");
			System.out.println("main �޼��� ����");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
