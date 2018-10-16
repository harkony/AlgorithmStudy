package Kakao_2018;
//2018-09-15

//idea
//�������� ����� �¿�� �������� ���ϱ� ������ ���簢���� ����� �� ���ִ� ����� 5���� ���¹ۿ� ���������ʴ�
//���� �� �ټ����� ����� ��� �Ʒ��� �����ϰ� ���� Ƣ��� �����̹Ƿ� ���������� ��ǥ�� �д´ٸ� �����ǥ�� �̿��Ͽ� ���ºм��� �����ϴ�.


// comments
// 2���� �迭�� �̿��Ͽ� �����ǥ�� �����ߴٸ� �ڵ� �������� �ڵ��� ���Ἲ�� �� ������ �ٵ� ��ÿ��� �� ������ ���� ���ߴ�.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution_7 {

	public static void main(String[] args) {
		int arr[][] = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 4, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 4, 4, 0, 0, 0 }, { 0, 6, 0, 0, 3, 0, 4, 0, 0, 0 }, { 6,6,6, 2, 3, 0, 0, 0, 5, 5 },
				{ 1, 2, 2, 2, 3, 3, 0, 0, 0, 5 }, { 1, 1, 1, 0, 0, 0, 0, 0, 0, 5 } };

		System.out.println(solution(arr));
	}

	public static int solution(int[][] board) {
		int answer = 0;
		int n = board.length;
		int total = 0;
		ArrayList<Integer> lists = new ArrayList<Integer>();
	
		while (true) {
			int cnt=0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int num = board[i][j];
					if (num == 0 || lists.contains(num))
						continue;
					else {

						boolean valid = false;
						int type = getType(board, i, j, n);

						//System.out.println(i + "," + j + " type: " + type);
						if (type == 0)
							continue;
						else {
							if (type == 1) {
								valid = check(board, i + 1, j + 1, n) && check(board, i + 1, j + 2, n);
							} else if (type == 2) {
								valid = check(board, i + 2, j - 1, n);
							} else if (type == 3) {
								valid = check(board, i + 2, j + 1, n);
							} else if (type == 4) {
								valid = check(board, i + 1, j - 1, n) && check(board, i + 1, j - 2, n);
							} else if (type == 5) {
								valid = check(board, i + 1, j + 1, n) && check(board, i + 1, j - 1, n);
							}
							if (valid) {
								lists.add(num);
								cnt++;
								remove(board, i, j, type);
							}
						}
					}
				}

			}
			total+=cnt;
			if(cnt==0 ) break;
		}
		return total;
	}
	
	public static int getType(int board[][], int low, int col, int n) {
		int type = 0;
		int num = board[low][col];
		// 1: 211 2: 13 3:31 4:112 5:121
		if (col + 2 < n && low + 1 < n && board[low + 1][col] == num && board[low + 1][col + 1] == num
				&& board[low + 1][col + 2] == num)
			type = 1;
		else if (low + 2 < n && col - 1 >= 0 && board[low + 1][col] == num && board[low + 2][col] == num
				&& board[low + 2][col - 1] == num)
			type = 2;
		else if (low + 2 < n && col + 1 < n && board[low + 1][col] == num && board[low + 2][col] == num
				&& board[low + 2][col + 1] == num)
			type = 3;
		else if (col - 2 >= 0 && low + 1 < n && board[low + 1][col] == num && board[low + 1][col - 1] == num
				&& board[low + 1][col - 2] == num)
			type = 4;
		else if (low + 1 < n && col - 1 >= 0 && col + 1 < n && board[low + 1][col] == num
				&& board[low + 1][col + 1] == num && board[low + 1][col - 1] == num)
			type = 5;

		return type;
	}

	public static void remove(int board[][], int low, int col, int type) {
		if (type == 1) {
			board[low][col] = 0;
			board[low + 1][col] = 0;
			board[low + 1][col + 1] = 0;
			board[low + 1][col + 2] = 0;

		} else if (type == 2) {
			board[low][col] = 0;
			board[low + 1][col] = 0;
			board[low + 2][col] = 0;
			board[low + 2][col - 1] = 0;

		} else if (type == 3) {
			board[low][col] = 0;
			board[low + 1][col] = 0;
			board[low + 2][col] = 0;
			board[low + 2][col + 1] = 0;

		} else if (type == 4) {
			board[low][col] = 0;
			board[low + 1][col] = 0;
			board[low + 1][col - 1] = 0;
			board[low + 1][col - 2] = 0;

		} else if (type == 5) {
			board[low][col] = 0;
			board[low + 1][col] = 0;
			board[low + 1][col + 1] = 0;
			board[low + 1][col - 1] = 0;

		}
	}

	public static boolean check(int board[][], int low, int col, int n) {
		for (int i = low - 1; i > -1; i--) {
			if (board[i][col] > 0)
				return false;
		}
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
	
	
	public static boolean isValid(int low, int col, int n) {
		if(low<0 ||col<0 || low>=n || col>=n)
			return false;
		return true;
	}

}
