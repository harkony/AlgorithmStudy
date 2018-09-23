package DynamicProgramming;

import java.util.Scanner;

//2018-08-27 
//체감 난이도: 중상
public class BaekJoon_11062 {
	static int[] arr;
	static int[][] dp;

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int loop = 0; loop < T; loop++) {
			int n = sc.nextInt();
			arr = new int[n];
			dp = new int[n][n];

			for (int loop2 = 0; loop2 < n; loop2++)
				arr[loop2] = sc.nextInt();

			for (int i = 0; i < n - 1; i++)
			{	
				dp[i][i + 1] = arr[i] > arr[i + 1] ? arr[i] : arr[i + 1];
				dp[i][i]=arr[i];
			}
			dp[n-1][n-1]=arr[n-1];
			
			System.out.println(DP(0, n - 1));	
		}
	}

	public static int DP(int i, int j) {
		if(dp[i][j]!=0) return dp[i][j];
		// 상대방이 최선의 선택을 하는 과정이 필요.
		dp[i][j] = max(min(arr[i] + DP(i + 2, j), arr[i] + DP(i + 1, j - 1)),
				min(arr[j] + DP(i, j - 2), arr[j] + DP(i + 1, j - 1)));

		return dp[i][j];
	}

	public static int min(int a, int b) {
		if (a < b)
			return a;
		else
			return b;
	}

	public static int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

}
