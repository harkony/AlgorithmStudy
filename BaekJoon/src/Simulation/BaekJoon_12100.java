package Simulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//2018-09-28	
//체감 난이도: 중상
//어려운 디버깅과 만들기 어려운 testcase .........
public class BaekJoon_12100 {
	static int LIMIT_MOVE = 5;
	static int MAX = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int map[][] = new int[n][n];
		for (int low = 0; low < n; low++)
			for (int col = 0; col < n; col++)
				map[low][col] = sc.nextInt();
		Game game = new Game(map, n);
		DFS(game, 0);
		System.out.println(MAX);
	}

	public static void DFS(Game game, int len) {
		if (len == LIMIT_MOVE) {
			int max = game.getMax();
			if (max > MAX)
				MAX = max;
		} else {

			Game copy1 = new Game(game);
			copy1.moveUp();
			DFS(copy1, len + 1);

			Game copy2 = new Game(game);
			copy2.moveDown();
			DFS(copy2, len + 1);

			Game copy3 = new Game(game);
			copy3.moveLeft();
			DFS(copy3, len + 1);

			Game copy4 = new Game(game);
			copy4.moveRight();
			DFS(copy4, len + 1);
		}
	}

	public static class Game {
		int map[][];
		int n;

		Game(int map[][], int n) {
			this.map = new int[n][n];
			for (int i = 0; i < n; i++)
				this.map[i] = map[i].clone();
			this.n = n;
		}

		Game(Game game) {
			this.n = game.n;
			this.map = new int[n][n];
			for (int low = 0; low < n; low++) {
				for (int col = 0; col < n; col++) {
					this.map[low][col] = game.map[low][col];
				}
			}
		}

		public void moveUp() {
			shiftUp();
			mergeUp();
		}

		public void moveDown() {
			shiftDown();
			mergeDown();
		}

		public void moveLeft() {
			shiftLeft();
			mergeLeft();
		}

		public void moveRight() {
			shiftRight();
			mergeRight();
		}

		public void shiftUp() {
			for (int col = 0; col < n; col++) {
				for (int low = 0; low < n - 1; low++) {
					int cnt = 0;
					while (map[low][col] == 0 && cnt < n) {
						for (int l = low; l < n - 1; l++)
							map[l][col] = map[l + 1][col];
						map[n - 1][col] = 0;
						cnt++;
					}
				}
			}
		}

		public void shiftDown() {
			for (int col = 0; col < n; col++) {
				for (int low = n - 1; low > 0; low--) {
					int cnt = 0;
					while (map[low][col] == 0 && cnt < n) {
						for (int l = low; l > 0; l--)
							map[l][col] = map[l - 1][col];
						map[0][col] = 0;
						cnt++;
					}
				}
			}
		}

		public void shiftLeft() {
			for (int low = 0; low < n; low++) {
				for (int col = 0; col < n - 1; col++) {
					int cnt = 0;
					while (map[low][col] == 0 && cnt < n) {
						for (int c = col; c < n - 1; c++)
							map[low][c] = map[low][c + 1];
						map[low][n - 1] = 0;
						cnt++;
					}
				}
			}
		}

		public void shiftRight() {
			for (int low = 0; low < n; low++) {
				for (int col = n - 1; col > 0; col--) {
					int cnt = 0;
					while (map[low][col] == 0 && cnt < n) {
						for (int c = col; c > 0; c--)
							map[low][c] = map[low][c - 1];
						map[low][0] = 0;
						cnt++;
					}
				}
			}
		}

		public boolean mergeUp() {
			boolean isMerged = false;
			for (int col = 0; col < n; col++) {
				for (int low = 0; low < n - 1; low++) {
					if (map[low][col] == map[low + 1][col] && map[low][col] != 0) {
						map[low][col] *= 2;
						isMerged = true;
						for (int l = low + 1; l < n - 1; l++)
							map[l][col] = map[l + 1][col];
						map[n - 1][col] = 0;
					}
				}
			}
			return isMerged;
		}

		public boolean mergeDown() {
			boolean isMerged = false;
			for (int col = 0; col < n; col++) {
				for (int low = n - 1; low > 0; low--) {
					if (map[low][col] == map[low - 1][col] && map[low][col] != 0) {
						map[low][col] *= 2;
						isMerged = true;
						for (int l = low - 1; l > 0; l--)
							map[l][col] = map[l - 1][col];
						map[0][col] = 0;
					}
				}
			}
			return isMerged;
		}

		public boolean mergeLeft() {
			boolean isMerged = false;
			for (int low = 0; low < n; low++) {
				for (int col = 0; col < n - 1; col++) {
					if (map[low][col] == map[low][col + 1] && map[low][col] != 0) {
						map[low][col] *= 2;
						isMerged = true;
						for (int c = col + 1; c < n - 1; c++)
							map[low][c] = map[low][c + 1];
						map[low][n - 1] = 0;
					}
				}
			}
			return isMerged;
		}

		public boolean mergeRight() {
			boolean isMerged = false;
			for (int low = 0; low < n; low++) {
				for (int col = n - 1; col > 0; col--) {
					if (map[low][col] == map[low][col - 1] && map[low][col] != 0) {
						map[low][col] *= 2;
						isMerged = true;
						for (int c = col - 1; c > 0; c--)
							map[low][c] = map[low][c - 1];
						map[low][0] = 0;
					}
				}
			}
			return isMerged;
		}

		public int getMax() {
			int max = 0;
			for (int low = 0; low < n; low++) {
				for (int col = 0; col < n; col++) {
					if (map[low][col] > max)
						max = map[low][col];
				}
			}
			return max;
		}

		public void print() {
			for (int low = 0; low < n; low++) {
				for (int col = 0; col < n; col++) {
					System.out.print(map[low][col] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}