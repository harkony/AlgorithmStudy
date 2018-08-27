package DynamicProgramming;

import java.util.Scanner;

//2018-08-27 
//체감 난이도: 
public class BaekJoon_11729 {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k=1;
		for(int i=0;i<n-1;i++)
			k=k*2+1;
		
		System.out.println(k+"\n"+Function(n,1,3));
	}
	public static String Function(int n,int s,int d)
	{		
		if(n==1) return new String(s+" "+d);
		int last;
		if(s+d==4) last=2;
		else if(s+d==3) last=3;
		else last=1;
		String str=Function(n-1,s,last)+"\n"+s+" "+d+"\n"+Function(n-1,last,d);
		return str;
	}
	
}
