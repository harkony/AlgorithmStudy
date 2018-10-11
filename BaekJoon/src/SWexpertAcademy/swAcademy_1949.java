package SWexpertAcademy;

//2018-09-26

//ü�����̵�: �߻� 


import java.util.Scanner;

public class swAcademy_1949 {
	static int N;
	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int longest;
	static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			N = sc.nextInt();
			K = sc.nextInt();
			int map[][] = new int[N][N];
			int max=0;
			for (int low = 0; low < N; low++) {
				for (int col = 0; col < N; col++) {
					map[low][col] = sc.nextInt();
					if(map[low][col]>max)
						max=map[low][col];
				}
			}
			longest=0;
			for (int low = 0; low < N; low++) {
				for (int col = 0; col < N; col++) {
					if(map[low][col]==max) {
						boolean visit[][]=new boolean[N][N];
						DFS(map,visit,max,low,col,1,false);
					}
				}
			}		
			System.out.println("#" + testcase + " " + longest);
		}

	}

	

	public static void DFS(int mat[][],boolean visit[][],int h,int low, int col,int len,boolean dig) {
		if(len>longest)
			longest=len;
		visit[low][col]=true;
		
		for (int i = 0; i < 4; i++) {
			int lowNext = low + dir[i][0];
			int colNext = col + dir[i][1];

			if (lowNext > -1 && lowNext < N && colNext > -1 && colNext < N && !visit[lowNext][colNext]) {
				if( h > mat[lowNext][colNext]) {
					//���� ������ ���� ��ġ���� ���� ���� ���簡 �ʿ����
					DFS(mat, visit,mat[lowNext][colNext],lowNext, colNext,len+1,dig);				
				} else if (h > mat[lowNext][colNext]-K && !dig){
					//���� ������ ���� ��ġ���� ������ ���縦 ���� �ذ� �����ϰ�, ���� �������� �ʾ��� ���
					DFS(mat, visit,h-1,lowNext, colNext,len+1,true);
				}
			}
		}
		visit[low][col]=false;
	}

	public static void print(int[][] mat) {
		for (int low = 0; low < N; low++) {
			for (int col = 0; col < N; col++)
				System.out.print(mat[low][col] + " ");
			System.out.println();
		}
		System.out.println();
	}
}
