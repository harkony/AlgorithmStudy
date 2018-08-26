import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_2428 {
	public static void main(String [] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long NeedCheck=0;
		int arr[]=new int[N];
		for(int i=0;i<N;i++)
			arr[i]=sc.nextInt();
		
		
		//solution 1
		//time complexity: O(N^2)
		//result: timeout
		/*
		for(int i=0;i<N-1;i++)
		{
			for(int j=i+1;j<N;j++)
			{
				int A=arr[i];
				int B=arr[j];
				if(A<B) {
					int temp=A;
					A=B;
					B=temp;
				}
				if(B>=A*0.9 ) NeedCheck+=1;
			}
		}
		*/
		
		//solution 2
		//time complexity: O(NlogN)
		//result: 

		Arrays.sort(arr);
		for(int i=0,j=0;i<N;i++)
		{
			while(j<N-1 && 10*arr[i] >= 9*arr[j] )
				j++;
			
			//System.out.println("i: "+i+" j: "+j+" k: "+(j-i));
			NeedCheck+=j-i;
			
		}
		
		
		System.out.println(NeedCheck);
	}

}
