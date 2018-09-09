package DFS_BFS;

import java.util.ArrayList;
import java.util.Scanner;

//2018-09-09 
// 체감 난이도: 
public class BaekJoon_11559 {
	static char map[][] = new char[12][6];
	static int visit[][] = new int[12][6];
	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int low = 0; low < 12; low++) {
			String str = sc.nextLine();
			for (int col = 0; col < 6; col++) {
				map[low][col] = str.charAt(col);
			}
		}

		int nBreak=0;
		while(true) {
			boolean remove = false;
			resetVisit();
			for (int low = 0; low < 12; low++) {
				for (int col = 0; col < 6; col++) {
					if (map[low][col] != '.' && visit[low][col] == 0) {
						int cnt = getNeighbor(low, col);
						if (cnt >= 4)
							remove = true;
						visit[low][col] = cnt;
						setNeighbor(low, col, cnt);
					}
				}
			}
			//printMap();
			//print();
			if (remove) {
				for (int low = 0; low < 12; low++) {
					for (int col = 0; col < 6; col++) {
						if (visit[low][col] >= 4) {
							remove(low, col);
						}
					}
				}
				nBreak++;
			}
			if(!remove) break;
			//printMap();
		}
		System.out.println(nBreak);
	}

	public static int getNeighbor(int low, int col) {
		visit[low][col] = 1;
		int neighbor = 1;
		for (int i = 0; i < 4; i++) {
			int next_low = low + dir[i][0];
			int next_col = col + dir[i][1];
			if (checkBoundary(next_low, next_col) && map[low][col] == map[next_low][next_col]) {
				if (visit[next_low][next_col] == 0)
					neighbor += getNeighbor(next_low, next_col);
			}
		}
		return neighbor;
	}

	public static void setNeighbor(int low, int col, int cnt) {
		if (visit[low][col] > cnt)
			return;
		visit[low][col] = cnt;
		for (int i = 0; i < 4; i++) {
			int next_low = low + dir[i][0];
			int next_col = col + dir[i][1];
			if (checkBoundary(next_low, next_col) && map[low][col] == map[next_low][next_col]
					&& visit[next_low][next_col] < cnt) {
				setNeighbor(next_low, next_col, cnt);
			}
		}
	}

	public static boolean checkBoundary(int next_low, int next_col) {
		if (next_low > -1 && next_low < 12 && next_col > -1 && next_col < 6)
			return true;
		else
			return false;
	}

	public static void print() {
		for (int low = 0; low < 12; low++) {
			for (int col = 0; col < 6; col++) {
				System.out.print(visit[low][col]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printMap() {
		for (int low = 0; low < 12; low++) {
			for (int col = 0; col < 6; col++) {
				System.out.print(map[low][col]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void remove(int low, int col) {
		for (int i = low; i > 0; i--)
			map[i][col] = map[i - 1][col];
		map[0][col] = '.';
	}
	
	public static void resetVisit()
	{
		for(int i=0;i<12;i++)
			for(int j=0;j<6;j++)
				visit[i][j]=0;
	}
}
