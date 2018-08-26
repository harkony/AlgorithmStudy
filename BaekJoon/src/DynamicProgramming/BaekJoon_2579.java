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
		// i��° �ڸ��� i-2��°���� �ִ�� ������ ��ٰ� 2ĭ�� �����ϰų� i-1��°���� 1ĭ�� �����ؾ��Ѵ�.
		// i-1��°���� ��ĭ�� �����ϱ� ���ؼ��� i-2��°�� ���� �ʾҾ���ϹǷ� i-3��°���� �ִ뿩�� �Ѵ�.
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
