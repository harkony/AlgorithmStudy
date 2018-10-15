package Kakao_2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//2018-09-15

public class Solution_4 {
	public static void main(String[] args) {
		int food_times[] = { 20, 20, 20 };
		for (int k = 0; k < 100; k++)
			System.out.println(k + "," + solution2(food_times.clone(), k));
	}

	public static int solution(int[] food_times, long k) {
		ArrayList<Integer> exist = new ArrayList<Integer>();
		int len = food_times.length;
		for (int i = 1; i <= len; i++)
			exist.add(i);
		int[] sort = food_times.clone();
		Arrays.sort(sort);

		int min_prev = 0;
		int min;
		for (int i = 0; i < len; i++) {
			min = sort[i];
			long t = (min - min_prev) * exist.size();
			if (t == 0)
				continue;
			else if (t > k)
				break;

			for (int j = 0; j < exist.size(); j++) {
				if (food_times[exist.get(j) - 1] == min) {
					exist.remove(j);
					j--;
				}
			}
			k -= t;
			min_prev = min;
		}
		if (exist.size() == 0) {
			return -1;
		} else {
			return exist.get((int) k % exist.size());
		}

	}

	public static int solution2(int[] food_times, long k) {
		int len = food_times.length;
		long LIMIT = 0;

		// key: 음식의 양 value: 해당 음식의 양과 같은 음식의 index
		Map<Integer, ArrayList<Integer>> map = new HashMap();
		for (int i = 0; i < len; i++) {
			int amount = food_times[i];
			ArrayList<Integer> list = map.get(amount);
			if (list == null)
				list = new ArrayList<Integer>();

			LIMIT += amount;
			list.add(i);
			map.put(amount, list);
		}
		if (LIMIT <= k) {
			return -1;
		}
		// 음식의 양을 정렬
		int[] sort = food_times.clone();
		Arrays.sort(sort);

		int min_prev = 0;
		int min_cur = 0;
		long additional_t =  0;
		int n_exist = len;
		long last_t = k;

		for (int i = 0; i < len; i++) {

			// 남은 음식중에 가장 적게 남음 음식의 양
			min_cur = sort[i];

			// 이전에 이미 먹은 양은 뺸다
			int last = min_cur - min_prev;
			if (last == 0)
				continue;

			// last만큼 도는데 걸리는 시간
			additional_t =  (last * n_exist);
			if (additional_t > last_t) {
				break;
			}
			last_t -= additional_t;
			min_prev = min_cur;
			ArrayList<Integer> list = map.get(min_cur);
			n_exist -= list.size();
			for (int j = 0; j < list.size(); j++) {
				food_times[list.get(j)] = 0;
			}
		}
		
		int ans = 0;
		int pos = (int) (last_t % n_exist);
		int cur_pos = 0;
		for (int i = 0; i < len; i++) {
			if (food_times[i] != 0) {
				if (pos == cur_pos) {
					ans = i + 1;
					break;
				} else {
					cur_pos++;
				}
			}
		}
		return ans;

	}

	public static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
