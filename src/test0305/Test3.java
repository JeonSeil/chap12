package test0305;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
  3.  
 ȭ�����κ��� ��¥�� "2019/05/11"�� ���·� �Է¹޾Ƽ� ������������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 �� �Էµ� ��¥�� ������ �߸��� ��� �޼����� �����ְ� �ٽ� �Է¹޾ƾ� �Ѵ�.
 */
public class Test3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sfin = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat sfout = new SimpleDateFormat("E����");
		while(true) {
			System.out.println("��¥�� 2019/01/01 ���·� �Է��� �ּ���");
			String input = scan.next();
			try {
			    Date day = sfin.parse(input); //parse() : Date <= ���Ŀ� �´� ���ڿ�
			  //format() : ������ �������� ������ ���ڿ� <= Date
			    System.out.println(sfout.format(day));
				System.out.println("��� �Է��Ͻðڽ��ϱ�?(Y/N)");
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
