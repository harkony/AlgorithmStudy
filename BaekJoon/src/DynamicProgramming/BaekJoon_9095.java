package DynamicProgramming;

import java.util.Scanner;
//2018-08-24 
// ü�� ���̵�: ��
public class BaekJoon_9095 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int index[]=new int[T];
		for(int i=0;i<T;i++)
			index[i]=sc.nextInt();
		int arr[]=new int[11];
		arr[1]=1;
		arr[2]=2;
		arr[3]=4;
		for(int i=4;i<11;i++)
			arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
		for(int i=0;i<T;i++)
			System.out.println(arr[index[i]]);
	}

}
