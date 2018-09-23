package LGCNS_2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_3 {
	public static void main(String[] args) {
		int health[] = { 200,120,150 };
		int items[][] = {{30,100}, {500,30}, {100,400}};

		int ans[] = solution(health, items);
		for (int i = 0; i < ans.length; i++)
			System.out.print(ans[i] + " ");
	}

	public static int[] solution(int[] health, int[][] items) {
		boolean isUse[] = new boolean[health.length];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		int len_h = health.length;
		int len_i = items.length;
		for (int i = 0; i < len_i; i++)
			map.put(items[i][0], i);

		//print(health,items);
		quickSort_1dimension(0, len_h - 1, health);
		quickSort_2dimension(0, len_i - 1, items);
		//print(health,items);
		for (int i = 0; i < len_i; i++) {
			for (int j = 0; j < len_h; j++) {
				int key = items[len_i - 1 - i][0];
				if (items[len_i - 1 - i][1]+100 <= health[j]  && !isUse[j] && map.get(key) != null) {
					//System.out.println(health[j]+" is using "+key+","+items[len_i - 1 - i][1]);
					answer.add(map.get(items[len_i - 1 - i][0]) + 1);
					map.remove(key);
					isUse[j] = true;
				}
			}
		}

		int arr[] = new int[answer.size()];
		for (int i = 0; i < answer.size(); i++)
			arr[i] = answer.get(i);
		Arrays.sort(arr);
		return arr;
	}

	// https://www.java2novice.com/java-sorting-algorithms/quick-sort/ 참고하였음
	public static void quickSort_2dimension(int lowerIndex, int higherIndex, int items[][]) {

		int i = lowerIndex;
		int j = higherIndex;
		int pivot = items[lowerIndex + (higherIndex - lowerIndex) / 2][0];
		while (i <= j) {

			while (items[i][0] < pivot) {
				i++;
			}
			while (items[j][0] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers_2dimension(i, j, items);
				i++;
				j--;
			}
		}
		if (lowerIndex < j)
			quickSort_2dimension(lowerIndex, j, items);
		if (i < higherIndex)
			quickSort_2dimension(i, higherIndex, items);
	}

	// https://www.java2novice.com/java-sorting-algorithms/quick-sort/ 참고하였음
	public static void quickSort_1dimension(int lowerIndex, int higherIndex, int items[]) {

		int i = lowerIndex;
		int j = higherIndex;
		int pivot = items[lowerIndex + (higherIndex - lowerIndex) / 2];
		while (i <= j) {

			while (items[i] < pivot) {
				i++;
			}
			while (items[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers_1dimension(i, j, items);
				i++;
				j--;
			}
		}
		if (lowerIndex < j)
			quickSort_1dimension(lowerIndex, j, items);
		if (i < higherIndex)
			quickSort_1dimension(i, higherIndex, items);
	}

	public static void exchangeNumbers_1dimension(int i, int j, int items[]) {
		int temp = items[i];
		items[i] = items[j];
		items[j] = temp;

	}

	public static void exchangeNumbers_2dimension(int i, int j, int items[][]) {
		int temp = items[i][0];
		items[i][0] = items[j][0];
		items[j][0] = temp;

		temp = items[i][1];
		items[i][1] = items[j][1];
		items[j][1] = temp;

	}

	public static void print(int health[],int items[][]) {
		for(int i=0;i<health.length;i++)
			System.out.print(health[i]+" ");
		System.out.println();
		
		for(int i=0;i<items.length;i++)
		{
			for(int j=0;j<items[0].length;j++)
			{
				System.out.print(items[i][j]+" ");
			}
			System.out.println();	
		}
		System.out.println();		
	}

}
