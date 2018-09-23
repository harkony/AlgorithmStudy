package DynamicProgramming;

import java.util.Scanner;

//2018-08-27 
//체감 난이도: 하
public class BaekJoon_14501 {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int T[]=new int[n+1];
		int P[]=new int[n+1];
		int PAY[]=new int[n+1];
		for(int i=0;i<n;i++)
		{
			T[i]=sc.nextInt();
			P[i]=sc.nextInt();
		}
		T[n]=0;
		P[n]=0;
		PAY[n]=0;
		for(int i=n-1;i>=0;i--)
		{
			if(i+T[i]<=n)
			{		
				PAY[i]=max(P[i]+PAY[i+T[i]],PAY[i+1]);
				
			} else {
				PAY[i]=PAY[i+1];
			}
		}
		System.out.println(PAY[0]);
	}
	public static int max(int a,int b)
	{
		if( a>b) return a;
		else return b;
	}
}
