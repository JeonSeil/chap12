package test0305;

import java.util.Calendar;
import java.util.Scanner;

/*
년도와 월을 입력받아서 달력을 출력하기. 
년도가 9999이면 종료하도록 구현하기 단 2차원 배열을 사용할것 
*/
public class Test4 {
	public static void main(String[] args) {
		int[][] cal = new int[7][7];
		Scanner scan = new Scanner(System.in);
		while (true) {
			cal = new int[7][7];
			System.out.println("년도를 입력하세요(종료:9999)");
			int year = scan.nextInt();
			if(year == 9999) break;
			System.out.println("월을 입력하세요");
			int mon = scan.nextInt();
			if(mon < 1 || mon > 12) {
				System.out.println("유효하지 않는 월 입니다. 다시 입력하세요");
				continue;
			}
			Calendar calendar = Calendar.getInstance();
			calendar.set(year,mon-1,1); 
			int firstWeek = calendar.get(Calendar.DAY_OF_WEEK); 
			int lastday = calendar.getActualMaximum(Calendar.DATE);
			System.out.printf("%10d년 %02d월\n",year,mon);			
			System.out.printf("%4s%4s%4s%4s%4s%4s%4s\n","일","월","화","수","목","금","토");
			/*
			    cal =
			                일                    토   
			         0 0 0 0 0 0 0  <- 1번째주
			         0 0 0 0 0 0 0  <- 2번째주
			         0 0 0 0 0 0 0  
			         0 0 0 0 0 0 0
			         0 0 0 0 0 0 0
			         0 0 0 0 0 0 0
			         0 0 0 0 0 0 0  <- 7번째 주
			 */
			for(int i=1;i<=lastday;i++) {
				calendar.set(year,mon-1,i); 
				cal[calendar.get(Calendar.WEEK_OF_MONTH)-1]
					[calendar.get(Calendar.DAY_OF_WEEK)-1] = i;
			}
			// 배열 출력
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