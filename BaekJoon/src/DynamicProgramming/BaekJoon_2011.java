package DynamicProgramming;

import java.util.Scanner;
//2018-08-24 
//ü�� ���̵�: �߻�
public class BaekJoon_2011 {
	public static void main(String[] args) {
		//�Է�
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int len = str.length();
		
		int nSingle = 1; // ���ڸ��� ���ڸ� ����� ��
		int nDouble = 0; // ���ڸ��� ���ڸ� ����� ��
		
		// 0�� ó���� �Ұ����� ����ó���� ���� ����
		boolean exception = false;

		// ù �ڸ��� 0 �̸�  ����ó��
		if (str.charAt(0) == '0')
			exception = true;

		if (!exception) {
			for (int i = 1; i < len; i++) {
				//��� ����� ���� nCase=nSingle+nDouble �̴�
				//nCase%10000000�� ���ϴ� ���̹Ƿ� 
				//nSingle�� nDouble�� 1000000���� ���� �������� �־ nCase%10000000�� ���� ������ �ʴ´�
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


