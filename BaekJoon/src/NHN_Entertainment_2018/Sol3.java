package NHN_Entertainment_2018;

import java.util.ArrayList;
import java.util.Scanner;

public class Sol3 {
	static int N;
	static int arr[];
	static int MAX = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		ArrayList<Integer> empty = new ArrayList<Integer>();
		DFS(0, empty, 0);
		System.out.println(MAX);
	}

	public static void DFS(int day, ArrayList<Integer> myCoins, int profit) {
		if (day == N) {
			if (MAX < profit)
				MAX = profit;
		} else {
			ArrayList<Integer> new_myCoins = new ArrayList<Integer>(myCoins);

			// buy
			new_myCoins.add(arr[day]);
			DFS(day + 1, new_myCoins, profit);

			// sell
			if (myCoins.size() > 0) {
				ArrayList<Integer> empty = new ArrayList<Integer>();
				int profit_today = 0;
				int coin_today = arr[day];
				for (int i = 0; i < myCoins.size(); i++)
					profit_today += (coin_today-myCoins.get(i));
				// ¼ö¼ö·á
				profit_today -= 1;
				DFS(day + 1, empty, profit + profit_today);
			}
		}
	}
}
