package SWexpertAcademy;

//2018-8-27
// 일반적인 시뮬레이션 방법으로는 풀리지 않는다
// 요세푸스 알고리즘을 이용하자.



import java.util.ArrayList;
import java.util.Scanner;

public class swAcademy_4411 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			long N = sc.nextLong();
			long K = sc.nextLong();
			long fnk=1;
			for(long n=1;n<N;n++)
			{
				fnk= (fnk+K)%(n+1)+1;
			}
			System.out.println("#" + (i + 1) + " " +fnk);
			
		}
	}


}
