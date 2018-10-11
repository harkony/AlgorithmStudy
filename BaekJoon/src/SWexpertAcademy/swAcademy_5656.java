package SWexpertAcademy;
//2018-10-11
//체감난이도: 하

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class swAcademy_5656 {
	static int[][] DIR = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int N;
	static int W;
	static int H;
	static int nBLOCK;
	static int nBreak;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			int map[][] = new int[H][W];
			nBLOCK = 0;
			nBreak = 0;
			for (int low = 0; low < H; low++) {
				for (int col = 0; col < W; col++) {
					map[low][col] = sc.nextInt();
					if (map[low][col] > 0)
						nBLOCK++;
				}
			}
			DFS(map, 0, 0);
			System.out.println("#" + testcase + " " + (nBLOCK - nBreak));
		}

	}

	static void DFS(int[][] map, int n, int score) {
		if (n == N) {
			if (score > nBreak) {
				nBreak = score;
			}
		} else {
			// 모든 col에 대해서 구슬을 떨어뜨린다.
			for (int col = 0; col < W; col++) {
				// map의 현재 상태를 복사한다.
				int map_copy[][] = new int[H][W];
				for (int low = 0; low < H; low++)
					map_copy[low] = map[low].clone();
				// 특정 col에 구슬을 떨어뜨린다.
				int s = dropTheBall(map_copy, col);
				// 다음 구슬을 떨어뜨리러 간다.				
				DFS(map_copy, n + 1, score + s);
			}
		}

	}

	//map의 특정 col에 구슬을 떨어뜨렸을 때 깨지는 모든 블록의 수를 반환한다.
	static int dropTheBall(int[][] map, int col) {
		
		for (int low = 0; low < H; low++) {
			if (map[low][col] > 0) {
				int score = Boom(map, low, col);
				shift(map);
				return score;
			}
		}
		return 0;
	}

	//map[low][col] 블록을 깰 때 깨지는 모든 블록의 갯수를 반환한다.
	static int Boom(int[][] map, int low, int col) {
		int scale = map[low][col];
		int score = 1;
		map[low][col] = 0;
		for (int dir = 0; dir < 4; dir++) {
			int nl = low;
			int nc = col;
			for (int s = 1; s < scale; s++) {
				nl += DIR[dir][0];
				nc += DIR[dir][1];
				if (isValid(nl, nc) && map[nl][nc] > 0) {
					score += Boom(map, nl, nc);
				}
			}
		}
		return score;

	}

	static boolean isValid(int low, int col) {
		if (low < 0 || low >= H || col < 0 || col >= W)
			return false;
		return true;
	}

	static void printMap(int[][] mat) {
		for (int low = 0; low < H; low++) {
			for (int col = 0; col < W; col++) {
				System.out.print(mat[low][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void shift(int[][] map) {
		for (int col = 0; col < W; col++) {
			Queue<Integer> queue = new LinkedList();
			for (int j = H - 1; j > -1; j--) {
				if (map[j][col] > 0) {
					queue.add(map[j][col]);
				}
			}
			int index = H - 1;
			while (!queue.isEmpty())
				map[index--][col] = queue.poll();
			while (index > -1)
				map[index--][col] = 0;
		}
	}
}
