package Kakao_2018;

//2018-09-15

// 시간이 부족하여 naive한 방법을 시도하였으나 반정도는 오답이었다.

import java.util.HashMap;
import java.util.Map;

public class Solution_4 {
	public static void main(String[] args) {
		int food_times[] = {3,0,2};
		int k=5;
		System.out.println(solution(food_times, k));
	}

	public static int solution(int[] food_times, long k) {
		int point = 0;
		int n = food_times.length;
		long total = 0;
		for (int i = 0; i < n; i++)
			total += food_times[i];
		if (total < k)
			return -1;
		for (long i = 0; i < k; i++) {
			print(food_times,n);
			point %= n;
			if (food_times[point] > 0) {	
				food_times[point++]--;

			} else {
				while (food_times[point] < 1)
					point = (point + 1) % n;
				food_times[point++] -= 1;

			}
		}
		print(food_times,n);
		return ((point) % n) + 1;
	}

	public static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
