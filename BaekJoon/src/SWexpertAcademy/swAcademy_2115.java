package SWexpertAcademy;
//2018-09-23
//최대값 갱신 위치와 DFS의 return 시점 조심
//체감 난이도: 중
import java.util.ArrayList;
import java.util.Scanner;

public class swAcademy_2115 {
	static int N;
	static int M;
	static int K;
	static int mat[][];
	static int MAX;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			mat = new int[N][N];
			MAX = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			ArrayList<Integer> test = new ArrayList<Integer>();
			DFS(0, 0, 0, 0, test);
			System.out.println("#" + testcase + " " + MAX);
		}

	}

	static void DFS(int low, int col, int cnt, int benefit, ArrayList<Integer> route) {
		if (low >= N)
			return;
		ArrayList<Integer> new_route = new ArrayList<Integer>(route);
		new_route.add(low);
		new_route.add(col);

		if (cnt < 2) {
			// 선택가능
			if (col + M - 1 < N) {
				int new_benefit=benefit+benefit(low,col);
				if (new_benefit > MAX)
					MAX = new_benefit;

				DFS((low + (col + M) / N), ((col + M) % N), cnt + 1, benefit + benefit(low, col), new_route);
			}

			// 선택하지 않음
			DFS(low + (col + 1) / N, (col + 1) % N, cnt, benefit, new_route);
		}
	}

	static int benefit(int low, int col) {

		int num = 1 << M;
		int max = 0;
		for (int i = 0; i < num; i++) {
			int bit = i;
			int sum = 0;
			int benefit = 0;
			for (int j = 0; j < M; j++, bit >>= 1) {
				if ((bit & 1) == 1) {
					sum += mat[low][col + j];
					benefit += (mat[low][col + j] * mat[low][col + j]);
				}
			}
			if (sum <= K && benefit >= max)
				max = benefit;
		}
		return max;
	}
}
