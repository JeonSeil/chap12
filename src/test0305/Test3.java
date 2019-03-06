package test0305;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
  3.  
 화면으로부터 날짜를 "2019/05/11"의 형태로 입력받아서 무슨요일인지 출력하는 프로그램을 작성하시오.
 단 입력된 날짜의 형식이 잘못된 경우 메세지를 보여주고 다시 입력받아야 한다.
 */
public class Test3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sfin = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat sfout = new SimpleDateFormat("E요일");
		while(true) {
			System.out.println("날짜를 2019/01/01 형태로 입력해 주세요");
			String input = scan.next();
			try {
			    Date day = sfin.parse(input); //parse() : Date <= 형식에 맞는 문자열
			  //format() : 지정된 형식으로 설정된 문자열 <= Date
			    System.out.println(sfout.format(day));
				System.out.println("계속 입력하시겠습니까?(Y/N)");
				input = scan.next();
//				if(input.toUpperCase().equals("Y")) continue;
				if(input.equalsIgnoreCase("Y")) continue;
				else break;
			} catch (ParseException e) {
				continue;
			}
		}
	}
}
