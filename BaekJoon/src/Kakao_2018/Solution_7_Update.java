package Kakao_2018;
//2018-09-15

//idea

//내려오는 블록은 좌우로 움직이지 못하기 때문에 직사각형이 만들어 질 수있는 블록은 5가지 형태밖에 존재하지않다
//또한 그 다섯가지 블록은 모두 아래는 평평하고 위로 튀어나온 형태이므로 위에서부터 좌표를 읽는다면 상대좌표를 이용하여 형태분석이 가능하다.

// comments
// 2차원 배열을 이용하여 상대좌표를 저장했다면 코드 가독성과 코드의 간결성이 더 좋았을 텐데 당시에는 그 생각을 하지 못했다.

import java.util.ArrayList;

public class Solution_7_Update {

	public static void main(String[] args) {
		int arr[][] = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 4, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 4, 4, 0, 0, 0 }, { 0, 6, 0, 0, 3, 0, 4, 0, 0, 0 }, { 6, 6, 6, 2, 3, 0, 0, 0, 5, 5 },
				{ 1, 2, 2, 2, 3, 3, 0, 0, 0, 5 }, { 1, 1, 1, 0, 0, 0, 0, 0, 0, 5 } };

		System.out.println(solution(arr));
	}

	public static int solution(int[][] board) {
		int answer = 0;
		int n = board.length;
		int total = 0;
		ArrayList<Integer> lists = new ArrayList<Integer>();
		int poly[][][] = {
				// type 0
				{ { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 } },
				// type 1
				{ { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 } },
				// type 2 : 310
				{ { 0, 0 }, { -1, 0 }, { -2, 0 }, { 0, 1 } },
				// type 3 : 211
				{ { 0, 0 }, { -1, 0 }, { 0, 1 }, { 0, 2 } },
				// type 4 : 130
				{ { 0, 0 }, { 0, 1 }, { -1, 1 }, { -2, 1 } },
				// type 5 : 121
				{ { 0, 0 }, { 0, 1 }, { -1, 1 }, { 0, 2 } },
				// type 6 : 112
				{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 2 } } };

		while (true) {
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int num = board[i][j];
					if (num == 0 || lists.contains(num))
						continue;
					else {
						int type = getType(board, i, j, n, poly);
						if (type > 1) {
							if (checkVertical(board, i, j, type)) {
								lists.add(num);
								cnt++;
								remove(board, i, j, type, poly);
							}
						}
					}
				}
			}
			total += cnt;
			if (cnt == 0)
				break;
		}
		return total;
	}

	public static int getType(int board[][], int low, int col, int n, int poly[][][]) {
		int num = board[low][col];
		for (int type = 2; type <= 6; type++) {
			boolean flag = true;
			for (int i = 0; i < 4; i++) {
				int l = low + poly[type][i][0];
				int c = col + poly[type][i][1];
				if (!(isValid(l, c, n) && board[l][c] == num)) {
					flag = false;
					break;
				}
			}
			if (flag)
				return type;
		}
		return 1;
	}

	public static void remove(int board[][], int low, int col, int type, int poly[][][]) {
		for (int i = 0; i < 4; i++) {
			int l = low + poly[type][i][0];
			int c = col + poly[type][i][1];
			board[l][c] = 0;
		}
	}

	public static boolean checkVertical(int board[][], int low, int col, int type) {
		boolean flag = true;
		int num = board[low][col];
		if (type >= 4) {
			for (int l = low; l > -1; l--) {
				if (board[l][col] != 0 && board[l][col] != num)
					return false;
			}
			type -= 4;
		}
		if (type >= 2) {
			for (int l = low; l > -1; l--) {
				if (board[l][col + 1] != 0 && board[l][col + 1] != num)
					return false;
			}
			type -= 2;
		}
		if (type >= 1) {
			for (int l = low; l > -1; l--) {
				if (board[l][col + 2] != 0 && board[l][col + 2] != num)
					return false;
			}
			type -= 1;
		}

		return true;
	}

	public static boolean isValid(int low, int col, int n) {
		if (low < 0 || col < 0 || low >= n || col >= n)
			return false;
		return true;
	}

	public static void print(int board[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
