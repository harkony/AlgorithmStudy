package DynamicProgramming;

import java.util.Scanner;

public class BaekJoon_1463 {
	static int arr[];
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int number = 1;
		arr = new int[n + 1];
		for (int i = 0; i < n + 1; i++)
			arr[i] = -1;
		arr[1]=0;
		
		for(int i=1;i<n;i++)
		{
			if(i*3<n+1  && (arr[i*3]<0 || arr[i*3] > arr[i]+1)) arr[i*3]=arr[i]+1;
			if(i*2<n+1 && (arr[i*2]<0 || arr[i*2] > arr[i]+1)) arr[i*2]=arr[i]+1;
			if(i+1<n+1 && (arr[i+1]<0 || arr[i+1] > arr[i]+1)) arr[i+1]=arr[i]+1;
		}
		System.out.println(arr[n]);

	}


}
