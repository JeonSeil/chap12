package test0305;

import java.util.Arrays;
import java.util.Scanner;

/*
1.  1���� 99������ ���ڸ� 5���� �Է¹޾�  �̵��� ��հ� �߾Ӱ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�
       �߾Ӱ��� �־��� ���� ũ�� ������� �þ� ������ �� ���� �߾ӿ� ���� ���̴�.
 10, 40, 30, 60, 30�� ���, ũ�� ������� �þ� ������
 10 30 30 40 60

�� �ǰ� ���� �߾Ӱ��� 30 �� �ȴ�.
 */
public class Test1 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		int sum=0;
		Scanner scan = new Scanner(System.in);
		System.out.println("1���� 99������ ���ڸ� 5�� �Է��ϼ���");
		for(int i=0;i<arr.length;i++) {
			arr[i] = scan.nextInt();
			if(arr[i]<1 || arr[i]>99) {
				System.out.println("1���� 99������ ���ڸ� �Է��ϼ���");
				i--;
				continue;
			}
			sum += arr[i];
		}
		Arrays.sort(arr);
		System.out.println("�߾Ӱ�:" + arr[2] + ", ���:" + (double)sum/arr.length);
	}
}
