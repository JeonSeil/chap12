package test0305;

import java.util.Arrays;
import java.util.Scanner;

/*
1.  1부터 99까지의 숫자를 5개를 입력받아  이들의 평균과 중앙값을 구하는 프로그램을 작성하시오
       중앙값은 주어진 수를 크기 순서대로 늘어 놓았을 때 가장 중앙에 놓인 값이다.
 10, 40, 30, 60, 30의 경우, 크기 순서대로 늘어 놓으면
 10 30 30 40 60

이 되고 따라서 중앙값은 30 이 된다.
 */
public class Test1 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		int sum=0;
		Scanner scan = new Scanner(System.in);
		System.out.println("1부터 99까지의 숫자를 5개 입력하세요");
		for(int i=0;i<arr.length;i++) {
			arr[i] = scan.nextInt();
			if(arr[i]<1 || arr[i]>99) {
				System.out.println("1부터 99까지의 숫자만 입력하세요");
				i--;
				continue;
			}
			sum += arr[i];
		}
		Arrays.sort(arr);
		System.out.println("중앙값:" + arr[2] + ", 평균:" + (double)sum/arr.length);
	}
}
