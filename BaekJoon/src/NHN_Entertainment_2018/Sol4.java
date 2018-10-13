package NHN_Entertainment_2018;

import java.util.ArrayList;
import java.util.Scanner;

public class Sol4 {
	static int N;
	static int map[][];
	static int DIR[][]={{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map=new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				map[i][j]=(int)sc.nextByte();		
	}	
}
