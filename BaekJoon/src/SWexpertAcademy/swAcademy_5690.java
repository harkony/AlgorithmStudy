package SWexpertAcademy;

import java.util.Scanner;

//2018-10-11
//체감난이도: 상

public class swAcademy_5690 {
	static int N;
	static int M;
	static char ch[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			String str = sc.nextLine();
			N = Integer.parseInt(str.split(" ")[0]);
			M = Integer.parseInt(str.split(" ")[1]);
			str = sc.nextLine();
			ch = str.toCharArray();

			long ans = 1;
			int cnt = 0;
			int point = 0;
			int remainder = (ch[point] - '0') % M;
			boolean isFinished = false;
			while (true) {
				if (remainder == 0) {
					cnt++;
					point++;
					isFinished = true;
					if (point > N - 1)
						break;
					remainder = (ch[point] - '0') % M;
				} else {
					isFinished = false;
					if (point >= N - 1)
						break;
					remainder = (remainder * 10 + ch[++point] - '0') % M;
				}
			}
			
			System.out.println("#" + testcase + " " + ans);
			/*
			long ans = 1;
			int cnt = 0;
			int remainder = (ch[0] - '0') % M;
			for (int i = 1; i < N; i++) {
				if (remainder == 0) {
					cnt++;
					remainder = (ch[i] - '0') % M;
				} else
					remainder = (remainder * 10 + ch[i] - '0') % M;
			}
			if (remainder == 0) {
				for (int i = 0; i < cnt; i++)
					ans = (ans * 2) % 1000000007;
			} else {
				ans = 0;
			}

			System.out.println("#" + testcase + " " + ans);
			*/
			
			/*

			long DP[] = new long[N];
			if ((ch[N - 1] - '0') % M == 0)
				DP[N - 1] = 1;

			for (int dp = N - 2; dp > -1; dp--) {
				int remainder = (ch[dp] - '0') % M;
				for (int end = dp; end < N - 1; end++) {
					if (remainder % M == 0 && DP[end + 1] > 0) {
						DP[dp] = (DP[dp] + DP[end + 1]) % 1000000007;
					}
					remainder = (remainder * 10 + ch[end + 1] - '0') % M;
				}
				if (DP[dp] > 0)
					DP[dp] = (DP[dp] + 1) % 1000000007;

				// System.out.println("DP["+dp+"] :"+DP[dp]);

			}

			System.out.println("#" + testcase + " " + getNum(0, N - 1));
			*/

		}

	}

	static long getNum(int start, int end) {
		long cnt = 0;
		int remainder = (ch[start] - '0') % M;
		for (int i = start + 1; i <= end; i++) {
			if (remainder == 0)
				cnt += getNum(i, end);
			remainder = (remainder * 10 + ch[i] - '0') % M;
		}
		if (remainder == 0) {
			cnt++;
		}
		// System.out.println(start+","+end+" : "+cnt);

		return cnt % 1000000007;
	}

}