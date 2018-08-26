package DynamicProgramming;

import java.util.Scanner;
//2018-08-24 
// 체감 난이도: 하
public class BaekJoon_1912 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		int max[]=new int[n];
		int total_max;
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		max[0]=arr[0];
		
		for(int i=1;i<n;i++)
		{
			if(max[i-1]<0) max[i]=arr[i];
			else {
				max[i]=max[i-1]+arr[i];
			}
		}
		total_max=max[0];
		for(int i=1;i<n;i++)
		{
			if(max[i]>total_max) total_max=max[i];
		}
		System.out.println(total_max);
		
	}


}
