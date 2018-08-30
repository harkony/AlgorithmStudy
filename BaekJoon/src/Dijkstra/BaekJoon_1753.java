package Dijkstra;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

// 2018-08-30 
// 체감 난이도: 
public class BaekJoon_1753 {
	static int V, E;
	static int start;
	static int d[];
	static ArrayList<CollectionPair> adj = new ArrayList<CollectionPair>();
	static final int INF = 3300000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();
		start = sc.nextInt();

		for (int i = 0; i < V + 1; i++)
			adj.add(new CollectionPair());

		d = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			d[i] = INF;
		}
		d[start] = 0;

		for (int i = 1; i <= E; i++) {
			int u, v, x;
			u = sc.nextInt();
			v = sc.nextInt();
			x = sc.nextInt();
			adj.get(u).add(v, x);
		}

		PriorityQueue<Pair> priorityqueue = new PriorityQueue<Pair>();
		for (int i = 1; i <= V; i++) {
			if (i == start)
				priorityqueue.add(new Pair(i, 0));
			else
				priorityqueue.add(new Pair(i, INF));
		}

		while (!priorityqueue.isEmpty()) {
			Pair pop = priorityqueue.poll();
			int index = pop.des;
			int distance = pop.weight;
			// System.out.println(index+","+distance);
			if (d[index] >= distance && distance < INF) {

				CollectionPair cp = adj.get(index);
				// System.out.println(index+" has "+cp.size()+" neighbor");
				for (int i = 0; i < cp.size(); i++) {
					Pair p = cp.getPair(i);
					int des = p.des;
					int w = p.weight;
					int new_w = w + distance;
					if (new_w < d[des]) {
						d[des] = new_w;
						// System.out.println(index+" has new great route to "+des+" : "+new_w);
						priorityqueue.add(new Pair(des,new_w));
					}

				}
			}
		}

		print();
	}

	static class Pair implements Comparable<Pair> {
		int des;
		int weight;

		public Pair(int index, int distance) {
			this.des = index;
			this.weight = distance;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			if (this.weight > o.weight)
				return 1;
			else
				return -1;
		}

	}


	public static void print() {
		for (int i = 0; i < V; i++) {
			if (d[i + 1] == INF)
				System.out.println("INF");
			else
				System.out.println(d[i + 1]);
		}
	}

	static class CollectionPair {
		ArrayList<Pair> list = new ArrayList<Pair>();

		void add(int des, int weight) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).des == des ) {
					if(list.get(i).weight > weight) {
						list.get(i).weight = weight;
						return;
					} else return;
				}
			}
			list.add(new Pair(des, weight));
		}

		int size() {
			return list.size();
		}

		int getWeightTo(int index) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).des == index)
					return list.get(i).weight;
			}
			return INF;
		}

		Pair getPair(int index) {
			return list.get(index);
		}
	}
}
