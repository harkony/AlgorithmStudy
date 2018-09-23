package LGCNS_2018;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_4 {
	public static void main(String[] args) {
		int N = 4;
		int dir[][] = { { 3, 2 }, { 3, 1 }, { 3, 4 } };
		int query[][] = { { 4, 2 }, { 3, 1 }, { 2, 2 } };
		int answer[] = solution(N, dir, query);
		for (int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
	}

	public static int[] solution(int N, int[][] directory, int[][] query) {
		int[] answer = new int[query.length];
		ArrayList<Node> nodes = new ArrayList<Node>();
		for (int i = 0; i <= N; i++) {
			Node node = new Node(i);
			nodes.add(node);
		}

		for (int i = 0; i < directory.length; i++) {
			nodes.get(directory[i][0]).add(directory[i][1]);
			nodes.get(directory[i][1]).add(directory[i][0]);
		}

		for (int i = 0; i < query.length; i++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			int start = query[i][0];
			int dest = query[i][1];
			boolean visit[] = new boolean[N + 1];
			int dist[] = new int[N + 1];
			dist[start] = 1;
			queue.add(start);
			while (!queue.isEmpty()) {
				int curr = queue.poll();
				if (curr == dest)
					break;
				if (!visit[curr]) {
					visit[curr] = true;
					ArrayList<Integer> list = nodes.get(curr).connected;
					for (int j = 0; j < list.size(); j++) {
						int next = list.get(j);
						if (!visit[next]) {
							queue.add(next);
							dist[next] = dist[curr] + 1;
						}
					}
				}
			}
			answer[i] = dist[dest];
		}
		return answer;
	}

	public static class Node {
		int nodeNum;
		ArrayList<Integer> connected = new ArrayList<Integer>();

		Node(int nodeNum) {
			this.nodeNum = nodeNum;
		}

		public void add(int node) {
			connected.add(node);
		}
	}
}
