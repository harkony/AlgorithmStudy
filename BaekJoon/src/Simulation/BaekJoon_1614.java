package Simulation;


import java.util.Scanner;

//2018-09-14 
//ü�� ���̵�: ����	
public class BaekJoon_1614 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int unable=sc.nextInt();
		long limit=sc.nextLong();
		long cnt=0;
		// �������� ������ ���� �ٽ� ������ ��ġ�� ���� 1 cycle�̶� �Ҷ�
		// k cycle�� ���� �������� �������� k+1, 2k, 2k ,2k ,k�� ����Ѵ�.
		// k-1 cyle�� ���� k,2k-2,2k-2,2k-2,k-1��
		
		if(unable==1) {
		// k-1 cycle�� ���� 7���� ������, k=limit
			cnt=8*limit;
		} else if(unable==5) {
		// k cycle�� ���� 3�� ������
			cnt=8*limit+4;
		} else { 
			if(limit%2==0) { 
				// 2 * half = limit �϶�
				// half cycle�� ����
				// half+1, limit,limit,limit, half �� ����Ͽ���.
				// ���⼭ unable ������ �� �� �� �����Ƿ�
				// 4*limit+1+(unable-2)
				cnt=4*limit+unable-1;
			} else {
				// 2 * half + 1 = limit �϶�
				// half cycle�� ����
				// half cycle�� ����
				// half+1, limit-1,limit-1,limit-1, half �� ����Ͽ���.
				// 4*limit -3
				cnt=4*limit+5-unable;
			}
		}
		
		
		System.out.println(cnt);
	}
}