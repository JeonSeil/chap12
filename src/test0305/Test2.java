package test0305;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
  Calendar클래스와 SimpleDateFormat클래스를 이용해서
  
  2019년의 매월 두번째 일요일의 날짜를 출력하시오
  
  Calendar.DAY_OF_WEEK_IN_MONTH  : 해당요일이 몇번째
  Calendar.DAY_OF_WEEK   : 요일 1:일요일
  Date cal.getTime() 
 */
public class Test2 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		for(int i=0;i<12;i++) {
			cal.set(2019,i,1);
			int lastday = cal.getActualMaximum(Calendar.DATE);
			for(int j=1;j<=lastday;j++) {
				cal.set(2019,i,j);
				if(cal.get(Calendar.DAY_OF_WEEK) == 1 //일요일
						&& cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 2) { //2번째요일
					Date day = cal.getTime();
					SimpleDateFormat sf = new SimpleDateFormat
							          ("yyyy-MM-dd 은 2번째 E요일 입니다");
					System.out.println(sf.format(day));
				}
			}
		}
	}
}
