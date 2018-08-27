package DynamicProgramming;

import java.util.Scanner;

//2018-08-27 
//체감 난이도: 중상
public class BaekJoon_2157 {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int n, m, k;
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		//mat_origin[x][y]는 x에서 y로 가는 직항 항로의 기내식 만족도를 뜻한다. 
		int mat_origin[][] = new int[n+1][n+1];
		//mat_route[x][y]는 0에서 x까지 y번만에 갈 때 얻을 수 있는 기내식 만족도의 최대값이다.
		int mat_route[][] = new int[n+1][m+1];

		
		for (int i = 0; i < k; i++) {
			int s, d, score;
			s = sc.nextInt() ;
			d = sc.nextInt() ;
			score = sc.nextInt();
			// 출발지와 도착지가 같은 여러 항로가 있을때 
			// 기내식의 만족도가 가장 높은 항로만 저장한다
			if (mat_origin[s][d] < score)
				mat_origin[s][d] = score;
		}

		
		
		for (int i = 1; i <= n; i++)
			mat_route[i][1] = mat_origin[1][i];

		//print(mat_origin,n,n,0);
		//print(mat_route,n,m,1);
		
		
		
		// i까지
		for (int i = 3; i <= n; i++) {
			// j번만에
			for (int j = 2; j <= m; j++) {
				int max = 0;
				// p를 거쳐간다.
				for (int p = 2; p < i; p++) {
					int score1toP=mat_route[p][j-1];
					int scorePtoN=mat_origin[p][i];
					int score=score1toP+scorePtoN;
					
					//System.out.println(i+","+j+","+p+","+scoreP+","+scorePtoN);
					if(score1toP !=0 && scorePtoN !=0 && score>max )
						max=score;
				}
				mat_route[i][j]=max;
			}
		}
		int max=0;
		for(int i=1;i<m;i++)
			if(mat_route[n][i]>max) max=mat_route[n][i];
		System.out.println(max);
		//print(mat_route,n,m,1);
	}
	public static void print(int[][] mat,int l,int c,int start)
	{
		for(int i=1;i<=l;i++)
		{
			for(int j=start;j<=c;j++)
				System.out.print(mat[i][j]+" ");
			
			System.out.println();
		}
		System.out.println();
	}
}
