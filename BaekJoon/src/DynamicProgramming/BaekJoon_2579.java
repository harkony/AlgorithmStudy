package DynamicProgramming;

import java.util.Scanner;

public class BaekJoon_2579 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stage = sc.nextInt();
		int score[] = new int[stage + 1];
		int F[]=new int[stage+1];
		for (int i = 1; i < stage + 1; i++)
			score[i] = sc.nextInt();
		F[0]=0;
		F[1]=score[1];
		F[2]=score[1]+score[2];
		// i번째 자리는 i-2번째까지 최대로 점수를 얻다가 2칸을 점프하거나 i-1번째에서 1칸을 점프해야한다.
		// i-1번째에서 한칸을 점프하기 위해서는 i-2번째를 밟지 않았어야하므로 i-3번째까지 최대여야 한다.
		for(int i=3;i<stage+1;i++) {
			F[i]=max(F[i-3]+score[i-1]+score[i],F[i-2]+score[i]);
			//System.out.println(i+" "+F[i]);
		}
		System.out.println(F[stage]);
		
	
	}
	public static int max(int a,int b)
	{
		if( a<b) return b;
		else return a;
	}


}
