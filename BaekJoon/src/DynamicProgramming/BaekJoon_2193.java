package DynamicProgramming;

import java.util.Scanner;
//2018-08-24 
//체감 난이도: 하
public class BaekJoon_2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long arr[] = new long[91];
		
		// N자리 이친수는 1으로 끝나는 경우와 0으로 끝나느 경우로 나눌 수 있다.
		// N+1자리에서 1으로 끝나는 경우는 N자리에서 0으로 끝나느 경우의 수와 같다.
		// N+1자리에서 0으로 끝나는 경우는 N자리의 모든 경우의 수와 같다.
		// 따라서 f(n+1)=f(n)+f(n자리 중 0으로 끝나는 경우)= f(n)+f(n-1) 
		arr[1] = 1;
		arr[2] = 1;
		for (int i = 3; i < n + 1; i++)
			arr[i] = arr[i - 1] + arr[i - 2];

		System.out.println(arr[n]);
	}

}
