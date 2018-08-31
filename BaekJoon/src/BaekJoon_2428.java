import java.util.Arrays;
import java.util.Scanner;

//2018-08-31 
//ü�� ���̵�: 
//�ǵ��: += (point -i-1) ���� ������ ���ǿ� ���ؼ� ���� �����ϰ� �ڵ��� �ʿ䰡 �ִ�.
public class BaekJoon_2428 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long NeedCheck = 0;
		long arr[] = new long[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextLong();

		Arrays.sort(arr);
		int point = 1;
		for (int i = 0; i < N - 1; i++) {
			if(point==i) point+=1;
			if (point == N) {
				//System.out.println(i + " : " + (point - i));
				NeedCheck += (point - i-1);
			}
			else {
				while (point<N && 10*arr[i] >= 9 * arr[point] )
					point++;				
				//System.out.println(i + " : " + (point - i));
				NeedCheck += (point - i-1);
			}
		}
		System.out.println(NeedCheck);
	}

}
