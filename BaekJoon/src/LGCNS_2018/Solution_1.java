package LGCNS_2018;

import java.util.Arrays;

public class Solution_1 {

	public static void main(String[] args) {
		int p[] = { 11, 2, 3, 6, 4, 8, 3, 4, 3 };
		int t[] = { 6, 4, 3, 2, 1 };

		System.out.println(solution(p, t));

	}

	public static int solution(int[] people, int[] tshirts) {
		int answer = 0;
		int index_p = 0;
		int index_t = 0;
		int len_p = people.length;
		int len_t = tshirts.length;

		Arrays.sort(people);
		Arrays.sort(tshirts);

		//작은 사람부터 입을 수 있는 가장 작은 티셔츠 순으로 가져간다.
		while (index_p < len_p && index_t < len_t) {
			if (people[index_p] <= tshirts[index_t]) {
				index_p++;
				index_t++;
				answer++;
			} else {
				index_t++;
			}
		}

		return answer;
	}
}
