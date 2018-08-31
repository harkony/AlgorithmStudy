package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

// 2018-08-31 
// 체감 난이도: 
// 피드백: 메인 로직 이후에 다양한 경우에 대해서 좀더 생각한 후에 코딩할 필요가 있다.
public class BaekJoon_2512 {
	static int n;
	static int arr[];
	static int limit;
	// idea: 예산의 목록을 sorting한다.
	// 전체 총합의 최대가 되는 값은 arr[i]와 arr[j] 사이에 있을 것이다.
	// + arr[i]보다 작을 수도 있다.
	// + arr[i-1]일 수도 있다.
	// 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int total = 0;
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		limit = sc.nextInt();
		Arrays.sort(arr);
		int min, max, mid;
		min = 0;
		max = n;

		while (min < max) {
			mid = (min + max) / 2;
			int sum = Calculate(arr[mid]);
			if (sum == limit) {
				System.out.println(arr[mid]);
				return;
			} else if (sum < limit)
				min = mid + 1;
			else
				max = mid - 1;
		}
		if(min==n) {
			System.out.println(arr[n-1]);
			return;
		}
		int point_budget = arr[min];

		if (Calculate(point_budget) > limit) {
			while (true) {
				point_budget--;
				if (Calculate(point_budget) <= limit) {
					break;
				}
			}
		} else {
			while (true) {
				point_budget++;
				if (Calculate(point_budget) > limit) {
					point_budget--;
					break;
				}
			}
		}
		System.out.println(point_budget);

	}

	public static int Calculate(int budget) {
		int total = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] > budget)
				total += budget;
			else
				total += arr[i];
		}
		return total;
	}

}
