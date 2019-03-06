package test0305;

import java.util.Calendar;
import java.util.Scanner;

/*
�⵵�� ���� �Է¹޾Ƽ� �޷��� ����ϱ�. 
�⵵�� 9999�̸� �����ϵ��� �����ϱ� �� 2���� �迭�� ����Ұ� 
*/
public class Test4 {
	public static void main(String[] args) {
		int[][] cal = new int[7][7];
		Scanner scan = new Scanner(System.in);
		while (true) {
			cal = new int[7][7];
			System.out.println("�⵵�� �Է��ϼ���(����:9999)");
			int year = scan.nextInt();
			if(year == 9999) break;
			System.out.println("���� �Է��ϼ���");
			int mon = scan.nextInt();
			if(mon < 1 || mon > 12) {
				System.out.println("��ȿ���� �ʴ� �� �Դϴ�. �ٽ� �Է��ϼ���");
				continue;
			}
			Calendar calendar = Calendar.getInstance();
			calendar.set(year,mon-1,1); 
			int firstWeek = calendar.get(Calendar.DAY_OF_WEEK); 
			int lastday = calendar.getActualMaximum(Calendar.DATE);
			System.out.printf("%10d�� %02d��\n",year,mon);			
			System.out.printf("%4s%4s%4s%4s%4s%4s%4s\n","��","��","ȭ","��","��","��","��");
			/*
			    cal =
			                ��                    ��   
			         0 0 0 0 0 0 0  <- 1��°��
			         0 0 0 0 0 0 0  <- 2��°��
			         0 0 0 0 0 0 0  
			         0 0 0 0 0 0 0
			         0 0 0 0 0 0 0
			         0 0 0 0 0 0 0
			         0 0 0 0 0 0 0  <- 7��° ��
			 */
			for(int i=1;i<=lastday;i++) {
				calendar.set(year,mon-1,i); 
				cal[calendar.get(Calendar.WEEK_OF_MONTH)-1]
					[calendar.get(Calendar.DAY_OF_WEEK)-1] = i;
			}
			// �迭 ���
			for (int i = 0; i < cal.length; i++) {
				for (int j = 0; j < cal[i].length; j++) {
					if (cal[i][j] == 0)
						System.out.print("   ");
					else
						System.out.printf("%3d", cal[i][j]);
				}
				System.out.println();
			}
		}
	}
}