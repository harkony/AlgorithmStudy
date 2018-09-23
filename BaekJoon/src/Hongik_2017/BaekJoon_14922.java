package Hongik_2017;

import java.util.Arrays;
import java.util.Scanner;

//2018-08-31 
//체감 난이도: 하
public class BaekJoon_14922 {
	static int n;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		float min=Float.MAX_VALUE;
		int u=0;
		for(int start=0;start<n-1;start++)
		{
			float avg=AVG(start,2);
			for(int k=3;k<=n-start;k++)
			{
				if(arr[start+k-1] <= avg ) {
					avg=AVG(start,k);
				} else {
					break;
				}
			}
			//System.out.println(arr[start]+" : "+avg);
			if(avg<min) {
				min=avg;
				u=start;
			}
		}
		System.out.println(u);

	}
	public static float AVG(int start,int k)
	{
		float sum=0;
		for(int i=0;i<k;i++)
			sum+=arr[start+i];
		return sum/k;
	}
}
