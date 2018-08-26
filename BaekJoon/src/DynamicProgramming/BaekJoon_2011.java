package DynamicProgramming;

import java.util.Scanner;
//2018-08-24 
//체감 난이도: 중상
public class BaekJoon_2011 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int len = str.length();
		
		int nSingle = 1; // 끝자리가 한자리 경우의 수
		int nDouble = 0; // 끝자리가 두자리 경우의 수
		
		// 0의 처리가 불가능한 예외처리를 위한 변수
		boolean exception = false;

		// 첫 자리가 0 이면  예외처리
		if (str.charAt(0) == '0')
			exception = true;

		if (!exception) {
			for (int i = 1; i < len; i++) {
				//모든 경우의 수는 nCase=nSingle+nDouble 이다
				//nCase%10000000를 구하는 것이므로 
				//nSingle과 nDouble을 1000000으로 나눈 나머지를 넣어도 nCase%10000000의 값은 변하지 않는다
				nSingle %= 1000000;
				nDouble %= 1000000;
				int cur = (str.charAt(i - 1) - '0') * 10 + str.charAt(i) - '0';


				if (cur >= 1 && cur <= 26) {
					if(str.charAt(i)!='0')
					{
						int temp = nSingle;
						nSingle += nDouble;
						nDouble = temp;
					} else {
						nDouble=nSingle;
						nSingle=0;
					}
				} else {
					if (str.charAt(i) == '0') {
						exception = true;
						break;
					}
					nSingle += nDouble;
					nDouble = 0;
				}
				 //System.out.println(cur+": "+nSingle+", "+nDouble);
			}
		}
		if (exception)
			System.out.println("0");
		else
			System.out.println((nSingle + nDouble) % 1000000);
	}
}


