package Simulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//2018-09-27
//체감 난이도: 하
public class BaekJoon_13458 {
	static int N;
	static int arr[];
	static int B;
	static int C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, Integer> map = new HashMap();
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		long total = 0;
		for (int i = 0; i < N; i++) {
			if (map.get(arr[i]) == null) {
				int abst = arr[i] - B;
				if(abst<=0) {
					map.put(arr[i], 1);
					total+=1;
					continue;
				}					
				int quot = (abst) / C;
				int remain = (abst) % C;

				if (remain > 0) {
					map.put(arr[i], quot + 2);
					total+=(quot+2);
				} else {
					map.put(arr[i], quot + 1);
					total+=(quot+1);
				}

			} else {
				total += map.get(arr[i]);
			}
		}
		System.out.println(total);
	}
}