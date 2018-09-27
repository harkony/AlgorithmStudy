package Simulation;


import java.util.Scanner;

//2018-09-14 
//체감 난이도: 중하	
public class BaekJoon_1614 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int unable=sc.nextInt();
		long limit=sc.nextLong();
		long cnt=0;
		// 엄지부터 새끼를 거쳐 다시 엄지를 거치는 것을 1 cycle이라 할때
		// k cycle을 돌면 엄지부터 새끼까지 k+1, 2k, 2k ,2k ,k번 사용한다.
		// k-1 cyle을 돌면 k,2k-2,2k-2,2k-2,k-1번
		
		if(unable==1) {
		// k-1 cycle을 돌고 7번을 더센다, k=limit
			cnt=8*limit;
		} else if(unable==5) {
		// k cycle을 돌고 3을 더센다
			cnt=8*limit+4;
		} else { 
			if(limit%2==0) { 
				// 2 * half = limit 일때
				// half cycle을 돌면
				// half+1, limit,limit,limit, half 번 사용하였다.
				// 여기서 unable 전까지 더 셀 수 있으므로
				// 4*limit+1+(unable-2)
				cnt=4*limit+unable-1;
			} else {
				// 2 * half + 1 = limit 일때
				// half cycle을 돌면
				// half cycle을 돌면
				// half+1, limit-1,limit-1,limit-1, half 번 사용하였다.
				// 4*limit -3
				cnt=4*limit+5-unable;
			}
		}
		
		
		System.out.println(cnt);
	}
}