package BinarySearch;

import java.util.Scanner;

// 2018-08-30
// 체감 난이도: 하하

public class BaekJoon_2869 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();
		int climb = a;
		int day = 2;
		if (v <= a) {
			System.out.println("1");
			return;
		}
		while (true) {
			if (v <= day* a -(day-1)* b) {
				System.out.println(day);
				return;
			}
			day++;
		}
	}

}
