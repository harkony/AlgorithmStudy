package LinePlus_2018;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sol1 {
	public static void main(String... args) {
		String input = new Scanner(System.in).nextLine().trim();
		final StringTokenizer tokenizer = new StringTokenizer(input);
		Map<Integer,Integer> map=new HashMap();
		int last = 20000;
		// int total_distance=0;
		for(int dist=4;dist<=178;dist++)
		{
			if(dist<=40)
				map.put(dist, 720);
			else {
				int divider = (dist - 40) / 8;
				if ((dist - 40) % 8 > 0)
					divider += 1;
				int cost = 720 + divider * 80;
				map.put(dist, cost);
			}
		}
		
		
		while (tokenizer.hasMoreTokens()) {
			int distance = Integer.parseInt(tokenizer.nextToken());
			if(map.get(distance)==null || last<map.get(distance)){
				break;
			} else{
				last-=map.get(distance);
			}
			
			// @todo Write your code here.
		}
		System.out.println(last);
		// @todo Write your code here.
	}
}
