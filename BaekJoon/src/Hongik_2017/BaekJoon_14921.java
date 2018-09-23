package Hongik_2017;

import java.util.Arrays;
import java.util.Scanner;

//2018-08-31 
//체감 난이도: 하
public class BaekJoon_14921 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		int min = Integer.MAX_VALUE;
		int sum;
		int head = 0;
		int tail = n - 1;
		while (head < tail) {
			int head_value = arr[head];
			while (head < tail - 1 && Math.abs(head_value + arr[tail]) >= Math.abs(head_value + arr[tail - 1])) {
				tail -= 1;
			}

			sum = head_value + arr[tail];
			if (Math.abs(min) > Math.abs(sum))
				min = sum;
			head += 1;

		}
		System.out.println(min);

	}

}
