package DFS_BFS;

import java.util.ArrayList;
import java.util.Scanner;

//2018-09-09 
// 체감 난이도: 하
public class BaekJoon_1325 {
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
	static int[] visit;
	static int[] results;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visit = new int[N + 1];
		results = new int[N + 1];
		int max = 0;
		
		for (int i = 0; i < N + 1; i++)
			lists.add(new ArrayList<Integer>());
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			lists.get(b).add(a);
		}

		for (int i = 1; i <= N; i++) {
			resetVisit();
			int ret = DFS(i);
			results[i] = ret;
			if (max < ret)
				max = ret;
		}

		for (int i = 1; i <= N; i++) {
			if (results[i] == max)
				System.out.print(i + " ");
		}
	}

	static void resetVisit() {
		for (int i = 0; i < N + 1; i++)
			visit[i] = 0;
	}

	static int DFS(int node) {
		int ret = 0;
		if (visit[node] == 0)
			ret++;
		else
			return ret;
		visit[node] = 1;
		ArrayList<Integer> list = lists.get(node);
		for (int i = 0; i < list.size(); i++)
			if (visit[list.get(i)] == 0)
				ret += DFS(list.get(i));
		return ret;
	}
}
