package DynamicProgramming;

import java.util.Scanner;
//2018-08-24 
//ü�� ���̵�: ��
public class BaekJoon_2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long arr[] = new long[91];
		
		// N�ڸ� ��ģ���� 1���� ������ ���� 0���� ������ ���� ���� �� �ִ�.
		// N+1�ڸ����� 1���� ������ ���� N�ڸ����� 0���� ������ ����� ���� ����.
		// N+1�ڸ����� 0���� ������ ���� N�ڸ��� ��� ����� ���� ����.
		// ���� f(n+1)=f(n)+f(n�ڸ� �� 0���� ������ ���)= f(n)+f(n-1) 
		arr[1] = 1;
		arr[2] = 1;
		for (int i = 3; i < n + 1; i++)
			arr[i] = arr[i - 1] + arr[i - 2];

		System.out.println(arr[n]);
	}

}
