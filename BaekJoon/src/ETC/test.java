package ETC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class test {
	public static void main(String[] args) {
		int n = 3;
		int num = 1;
		num <<= n;
		for (int i = 0; i < num; i++) {
			int bit = i;
			int pick[] = new int[n];
			for (int j = 0; j < n; j++, bit >>= 1) {
				pick[j] = (bit & 1);
				//System.out.print(pick[j] + " ");
			}
			//System.out.println();
		}

		
		//DFS(list,new ArrayList<Integer>());
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) 
			list.add(i + 1);
		
		Queue<ArrayList<Integer>> queue_picked=new LinkedList<ArrayList<Integer>>();
		Queue<ArrayList<Integer>> queue_unpicked=new LinkedList<ArrayList<Integer>>();
		queue_picked.add(new ArrayList<Integer>());
		queue_unpicked.add(list);
	
		
		while(!queue_picked.isEmpty()) {
			ArrayList<Integer> picked=queue_picked.poll();
			ArrayList<Integer> unpicked=queue_unpicked.poll();
			for(int i=0;i<picked.size();i++)
				System.out.print(picked.get(i)+" ");
			System.out.println();
			for(int i=0;i<unpicked.size();i++)
			{
				int item=unpicked.get(i);
				ArrayList<Integer> new_unpicked = new ArrayList<Integer>(unpicked);
				ArrayList<Integer> new_picked = new ArrayList<Integer>(picked);
				new_picked.add(item);
				for (int j = 0; j <= i; j++)
					new_unpicked.remove(0);
				queue_picked.add(new_picked);
				queue_unpicked.add(new_unpicked);				
			}
		}
		
		
	}

	public static void DFS(ArrayList<Integer> unpicked, ArrayList<Integer> picked) {
		for(int i=0;i<picked.size();i++)
			System.out.print(picked.get(i)+" ");
		System.out.println();
		
		for (int i = 0; i < unpicked.size(); i++) {
			int item =unpicked.get(i);
			ArrayList<Integer> new_unpicked = new ArrayList<Integer>(unpicked);
			ArrayList<Integer> new_picked = new ArrayList<Integer>(picked);
			new_picked.add(item);
			for (int j = 0; j <= i; j++)
				new_unpicked.remove(0);
			DFS(new_unpicked, new_picked);
		}

	}
}
