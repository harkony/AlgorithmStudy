package DynamicProgramming;

import java.util.Scanner;

// 2018-08-31

public class BaekJoon_13703 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k, n;
		k = sc.nextInt();
		n = sc.nextInt();
		// DP[h][t]: t초 후에 h에 있을 경우의 수
		long DP[][] = new long[k + n + 1][n + 1];
		DP[k][0] = 1;

		for (int t = 1; t <= n; t++) {
			for (int h = 0; h < k + n + 1; h++) {
				long  fromHigh = h > 1 ? DP[h - 1][t - 1] : 0;
				long  fromLow = h < k + n ? DP[h + 1][t - 1] : 0;
				DP[h][t] = fromHigh + fromLow;
			}
		}
		
		long sum =  0;

		for (int i = 1; i < k + n + 1; i++)
			sum += DP[i][n];
		System.out.println(sum);

		//print(DP, k + n + 1, n + 1);

	}

	static void print(int arr[][], int k, int n) {
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
