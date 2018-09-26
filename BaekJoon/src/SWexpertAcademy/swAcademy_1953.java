package SWexpertAcademy;

//2018-09-26

//ü�����̵�: ���� 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swAcademy_1953 {
	static int N; // map�� ����ũ��
	static int M; // map�� ����ũ��
	static int R; // ��Ȧ ������ġ
	static int C; // ��Ȧ ������ġ
	static int L; // ���� �ð�
	static int map[][];
	static int DIR[][][] = { 
			{ { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 } }, 
			{ { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } },
			{ { -1, 0 }, { 1, 0 }, { 0, 0 }, { 0, 0 } }, 
			{ { 0, 0 }, { 0, 0 }, { 0, -1 }, { 0, 1 } },
			{ { -1, 0 }, { 0, 0 }, { 0, 0 }, { 0, 1 } }, 
			{ { 0, 0 }, { 1, 0 }, { 0, 0 }, { 0, 1 } },
			{ { 0, 0 }, { 1, 0 }, { 0, -1 }, { 0, 0 } }, 
			{ { -1, 0 }, { 0, 0 }, { 0, -1 }, { 0, 0 } } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			Queue<Integer> queue = new LinkedList<Integer>(); // low,col,len�� �ִ´�.
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();
			map = new int[N][M];
			int cnt = 0;
			for (int low = 0; low < N; low++) {
				for (int col = 0; col < M; col++) {
					map[low][col] = sc.nextInt();
				}
			}
			queue.add(R);
			queue.add(C);
			queue.add(-1);
			queue.add(1);

			while (!queue.isEmpty()) {
				int low = queue.poll();
				int col = queue.poll();
				int from = queue.poll();
				int len = queue.poll();
				

				int type = map[low][col];
				if(len>L || type<0)
					continue;
				// System.out.println(low+","+col);
				//System.out.println(low + "," + col);
				cnt++;
				map[low][col] = -1;
				int dir = 4;
				for (int i = 0; i < dir; i++) {
					int nl = low + DIR[type][i][0];
					int nc = col + DIR[type][i][1];
					if (nl < 0 || nl >= N || nc < 0 || nc >= M || map[nl][nc] < 1)
						continue;
					int ntype = map[nl][nc];
					int ndir = i % 2 == 0 ? i + 1 : i - 1;
					if (DIR[ntype][ndir][0] + DIR[ntype][ndir][1] == 0)
						continue;

					queue.add(nl);
					queue.add(nc);
					queue.add(i);
					queue.add(len + 1);

				}
			} // queue end
			System.out.println("#" + testcase + " " + cnt);
		} // testcase loop end
	}

}
