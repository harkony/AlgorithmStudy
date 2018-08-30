//2018-8-27

package SWexpertAcademy;

import java.util.Scanner;

public class swAcademy_2383 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int loop=0;loop<T;loop++)
		{
			int n=sc.nextInt();
			int mat[][]=new int[n][n];
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					mat[i][j]=sc.nextInt();
				}
			}
			
		}
	}
	class Person{
		int x;
		int y;
		int x_stair;
		int y_stair;
		int distance2stair;
	}
	class Stair{
		int x_stair;
		int y_stair;
	}
}
