package test0305;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
  CalendarŬ������ SimpleDateFormatŬ������ �̿��ؼ�
  
  2019���� �ſ� �ι�° �Ͽ����� ��¥�� ����Ͻÿ�
  
  Calendar.DAY_OF_WEEK_IN_MONTH  : �ش������ ���°
  Calendar.DAY_OF_WEEK   : ���� 1:�Ͽ���
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
				if(cal.get(Calendar.DAY_OF_WEEK) == 1 //�Ͽ���
						&& cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 2) { //2��°����
					Date day = cal.getTime();
					SimpleDateFormat sf = new SimpleDateFormat
							          ("yyyy-MM-dd �� 2��° E���� �Դϴ�");
					System.out.println(sf.format(day));
				}
			}
		}
	}
}
