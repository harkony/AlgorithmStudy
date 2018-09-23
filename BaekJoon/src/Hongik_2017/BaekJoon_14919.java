package Hongik_2017;
import java.util.Arrays;
import java.util.Scanner;

//2018-08-31 
//float으로 읽으면 안풀리는 문제
//string으로 소수점 아래자리만 읽어 파싱해야한다.
//체감 난이도: 중상
public class BaekJoon_14919 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result[]=new int[N];
		int numConvert[]=new int[N];
		float BASE=1000000/(float)N;
		//System.out.println("BASE: "+BASE);
		sc.nextLine();
		String str=sc.nextLine();
		String splits[]=str.split(" ");
	
		for(int i=0;i<splits.length;i++)
		{
		
			int num=Integer.parseInt(splits[i].substring(2));
			for(int k=0;k<8-splits[i].length();k++) num*=10;
			
			//System.out.println(num);
			for(int j=0;j<N;j++)	
			{
				if( BASE * j <= (float) num &&  BASE*(j+1) > (float) num)
				{	
					result[j]+=1;
					break;
				}
			}
		}
		
		for(int i=0;i<N;i++)
			System.out.print(result[i]+" ");
		System.out.println();
	}

}
