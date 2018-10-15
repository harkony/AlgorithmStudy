package SWexpertAcademy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//2018-10-12

public class swAcademy_5295 {
	static int MAX;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			int mat[][] = new int[3][N];
			MAX = 0;

			List<Map<Integer, Integer>> lists = new ArrayList<Map<Integer, Integer>>();
			for (int i = 0; i < 3; i++) {
				Map<Integer, Integer> map = new HashMap();
				lists.add(map);
			}

			for (int l = 0; l < 3; l++) {
				Map<Integer, Integer> map = lists.get(l);
				for (int c = 0; c < N; c++) {
					mat[l][c] = sc.nextInt();
					if (map.get(mat[l][c]) == null) {
						map.put(mat[l][c], 1);
					} else {
						map.put(mat[l][c], map.get(mat[l][c]) + 1);
					}
				}
			}
			
			while(!isValid(mat,N,lists)) {
				for (int i = 0; i < N; i++) {
					int numFirstLine = mat[0][i];
					
					if (atSecond == null || atThird == null) {
						lists.get(0).remove(numFirstLine);
						index2Remove.add(i);

						int numSecondLine=mat[1][i];
						int nNumSecondLine=lists.get(1).get(numSecondLine);
						if (nNumSecondLine==1) {
							lists.get(1).remove(numSecondLine);
						} else  {
							lists.get(1).put(numSecondLine, nNumSecondLine - 1);
						}

						int numThirdLine=mat[2][i];
						int nNumThirdLine=lists.get(2).get(numThirdLine);
						if (nNumThirdLine==1) {
							lists.get(2).remove(numThirdLine);
						} else  {
							lists.get(2).put(numThirdLine, nNumThirdLine - 1);
						}
					} else {
						//System.out.println("evey low has "+numFirstLine);
						
					}
				}
				
				
				
			}
			
			
			
			System.out.println("#" + testcase + " " + (N-MAX));
		}
	}
	// remove: list에 들어있는 index를 이용하여 해당 col을 삭제한다.
	public static void remove(int mat[][], int n, ArrayList<Integer> list) {
		int index = 0;
		for (int col = 0; col < n; col++) {
			if (!list.contains(col)) {
				mat[0][index] = mat[0][col];
				mat[1][index] = mat[1][col];
				mat[2][index++] = mat[2][col];
			}
		}
	}

	public static void print(int mat[][], int N) {
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < N; c++) {
				System.out.print(mat[l][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static boolean isValid(int mat[][], int n, List<Map<Integer, Integer>> lists) {
		for (int i = 0; i < n; i++) {
			Integer num = mat[0][i];
			if (lists.get(1).get(num) == null || lists.get(2).get(num) == null || lists.get(1).get(num) != 1
					|| lists.get(2).get(num) != 1)
				return false;
		}
		return true;
	}

}
