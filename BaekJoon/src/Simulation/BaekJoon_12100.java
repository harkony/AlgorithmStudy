package Simulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//2018-09-27
//체감 난이도: 
public class BaekJoon_12100 {
	static int max = 0;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int mat[][] = new int[N][N];
		for (int low = 0; low < N; low++)
			for (int col = 0; col < N; col++)
				mat[low][col] = sc.nextInt();
		
	}

	public static void print(int mat[][]) {
		for (int low = 0; low < N; low++) {
			for (int col = 0; col < N; col++) {
				System.out.print(mat[low][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}