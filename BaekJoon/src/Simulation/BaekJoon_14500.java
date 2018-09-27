package Simulation;

import java.util.Scanner;

//2018-09-27
//체감 난이도: 상
//visit reset 시점에 대한 고민 필요
public class BaekJoon_14500 {
	static int max = 0;
	static int N;
	static int M;
	static int mat[][];
	static boolean visited[][];
	static int DIR[][]= {{1,0},{-1,0},{0,1},{0,-1}};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		mat = new int[N][M];
		for (int low = 0; low < N; low++) 
			for (int col = 0; col < M; col++)
				mat[low][col] = sc.nextInt();

		for (int low = 0; low < N; low++) {
			visited=new boolean[N][M];
			for (int col = 0; col < M; col++) {
				visited[low][col]=true;
				DFS(low,col,1,mat[low][col]);
				specialCase(low,col);
			}
		}
		System.out.println(max);

	}
	public static void specialCase(int low,int col) {
		int n=0;
		int sum=mat[low][col];
		int min=Integer.MAX_VALUE;
		for(int dir=0;dir<4;dir++)
		{
			int nl=low+DIR[dir][0];
			int nc=col+DIR[dir][1];
			if(nl<0 || nc<0 || nl>=N || nc>=M)
				continue;
			int nValue=mat[nl][nc];			
			n++;
			sum+=nValue;
			min=Math.min(min,nValue);
		}
		if(n==4)
			sum-=min;
		if(n>2) {
			max=Math.max(sum, max);
		}
	}
	public static void DFS(int low,	int col,int cnt,int sum) {
		if(cnt==4) {
			max=Math.max(max, sum);
		} else {
			for(int dir=0;dir<4;dir++)
			{
				int nl=low+DIR[dir][0];
				int nc=col+DIR[dir][1];
				if(nl<0 || nc<0 || nl>=N || nc>=M || visited[nl][nc])
					continue;	
				visited[nl][nc]=true;
				DFS(nl,nc,cnt+1,sum+mat[nl][nc]);
				visited[nl][nc]=false;
			}
		}
	}
}