package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_2294 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int coin[] = new int[n];
		int nCoin[] = new int[10100];
		int useless = 0;
		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			if (temp > k) {
				useless += 1;

			}
			coin[i] = temp;
		}
		n -= useless;
		Arrays.sort(coin);

		for (int i = 0; i < k + 1; i++)
			nCoin[i] = 0;
		for (int i = 0; i < n; i++) {
			nCoin[coin[i]] = 1;
		}
		if (n > 0) {
			for (int price = coin[0]; price < k + 1; price++) {
				for (int j = 0; j < n; j++) {
					if (nCoin[price] == 0 || price + coin[j] > k)
						break;
					if (nCoin[price] + 1 < nCoin[price + coin[j]] || nCoin[price + coin[j]] == 0)
						nCoin[price + coin[j]] = nCoin[price] + 1;
				}
			}
			
			if (nCoin[k] == 0)
				System.out.println("-1");
			else
				System.out.println(nCoin[k]);
		} else
			System.out.println("-1");

	}

}
