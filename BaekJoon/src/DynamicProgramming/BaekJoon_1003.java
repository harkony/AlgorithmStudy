package DynamicProgramming;

import java.util.Scanner;

public class BaekJoon_1003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int arr[]=new int[T];
		for(int i=0;i<T;i++)
			arr[i]=sc.nextInt();
		
		int call_0[]=new int[41];
		int call_1[]=new int[41];
		call_0[0]=1;
		call_0[1]=0;
		call_1[0]=0;
		call_1[1]=1;
		
		for(int i=2;i<41;i++)
		{
			call_0[i]=call_0[i-1]+call_0[i-2];
			call_1[i]=call_1[i-1]+call_1[i-2];
		}
		
		for(int i=0;i<T;i++)
			System.out.println(call_0[arr[i]]+" "+call_1[arr[i]]);
	}


}
