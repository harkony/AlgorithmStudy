package LinePlus_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Sol2 {
	public static void main(String[] args) throws IOException {
		Map<Integer, Integer> map = new HashMap();
		boolean exception = false;
		ArrayList<Integer> list = new ArrayList<Integer>();
		try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			final int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				String[] split = str.split(" ");
				for (int index = 0; index < split.length - 1; index++) {
					int up = Integer.parseInt(split[index]);
					int down = Integer.parseInt(split[index + 1]);
					if (map.get(up) == null)
						map.put(up, down);
					else if (map.get(up) != down) {
						exception = true;
						break;
					}
					if (!list.contains(up))
						list.add(up);
				}
				int last = Integer.parseInt(split[split.length - 1]);
				if (!list.contains(last))
					list.add(last);
				// @todo Write your code here.
			}
			// @todo Write your code here.
		}
		if (exception)
			System.out.println("-1");
		else {
			Collections.sort(list,new DescendingInteger());
			for (int i = 0; i < list.size(); i++) {
				if (map.get(list.get(i)) == null) {
					System.out.print(list.get(i) + " ");
				}
			}
		}
	}

	static class DescendingInteger implements Comparator<Integer> {
		@Override
		public int compare(Integer a, Integer b) {
			return a.compareTo(b);
		}
	}

}
