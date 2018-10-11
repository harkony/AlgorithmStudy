package SWexpertAcademy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//2018-10-11
//체감난이도: 

public class swAcademy_5658 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();

			// 전체 길이
			int len = str.length();
			// 한변의 길이
			int n = len / 4;

			ArrayList<Long> list = new ArrayList<Long>();
			Map<Long, Boolean> hash = new HashMap();

			// 한변의 길이 만큼 회전시킨다
			for (int rotate = 0; rotate < n; rotate++) {
				// 처음 시작점
				int init = rotate;
				// 사각형 이므로 side는 4개
				for (int side = 0; side < 4; side++) {
					// 각 side의 시작점을 구한다
					int start = init + side * n;

					// 10진수로 변환시키기 위한 초기값
					long decimal = 0;
					// 16진수의 자리값
					long w = 1;
					// 16진수를 10진수로 변환시키는데 1의 자리 부터 보기 위해 뒤에서 부터 읽는다.
					for (int i = n - 1; i > -1; i--) {
						int index = (start + i) % len;
						char ch = str.charAt(index);
						long d;
						// ascii code에서 알파벳 대문자는 숫자보다 크므로
						if (ch > '9') {
							d = (ch - 'A' + 10) * w;
							decimal += (ch - 'A' + 10) * w;
						} else {
							d = (ch - '0') * w;
							decimal += (ch - '0') * w;
						}
						w *= 16;
					}
					// 중복값 체크를 위한 hash
					if (hash.get(decimal) == null) {
						list.add(decimal);
						hash.put(decimal, true);
					}
				}
			}
			// 정렬
			Collections.sort(list);
			System.out.println("#" + testcase + " " + list.get(list.size() - K));
		}

	}

}
