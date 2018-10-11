package SWexpertAcademy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//2018-10-11
//ü�����̵�: 

public class swAcademy_5658 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();

			// ��ü ����
			int len = str.length();
			// �Ѻ��� ����
			int n = len / 4;

			ArrayList<Long> list = new ArrayList<Long>();
			Map<Long, Boolean> hash = new HashMap();

			// �Ѻ��� ���� ��ŭ ȸ����Ų��
			for (int rotate = 0; rotate < n; rotate++) {
				// ó�� ������
				int init = rotate;
				// �簢�� �̹Ƿ� side�� 4��
				for (int side = 0; side < 4; side++) {
					// �� side�� �������� ���Ѵ�
					int start = init + side * n;

					// 10������ ��ȯ��Ű�� ���� �ʱⰪ
					long decimal = 0;
					// 16������ �ڸ���
					long w = 1;
					// 16������ 10������ ��ȯ��Ű�µ� 1�� �ڸ� ���� ���� ���� �ڿ��� ���� �д´�.
					for (int i = n - 1; i > -1; i--) {
						int index = (start + i) % len;
						char ch = str.charAt(index);
						long d;
						// ascii code���� ���ĺ� �빮�ڴ� ���ں��� ũ�Ƿ�
						if (ch > '9') {
							d = (ch - 'A' + 10) * w;
							decimal += (ch - 'A' + 10) * w;
						} else {
							d = (ch - '0') * w;
							decimal += (ch - '0') * w;
						}
						w *= 16;
					}
					// �ߺ��� üũ�� ���� hash
					if (hash.get(decimal) == null) {
						list.add(decimal);
						hash.put(decimal, true);
					}
				}
			}
			// ����
			Collections.sort(list);
			System.out.println("#" + testcase + " " + list.get(list.size() - K));
		}

	}

}
