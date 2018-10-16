package Kakao_2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//2018-09-15

public class Solution_5_Update {
	public static void main(String[] args) {
		int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 1 } };
		int[][] ret = solution(nodeinfo);
		int len = ret[0].length;
		for (int i = 0; i < len; i++)
			System.out.print(ret[0][i] + " ");
		System.out.println();
		for (int i = 0; i < len; i++)
			System.out.print(ret[1][i] + " ");

	}

	public static int[][] solution(int[][] nodeinfo) {
		int N = nodeinfo.length;
		int[][] answer = new int[2][N];

		// key: Y, value: list of node at level Y
		Map<Integer, ArrayList<Node>> nodes = new HashMap();
		// YÀÇ list
		ArrayList<Integer> levels = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			int x = nodeinfo[i][0];
			int y = nodeinfo[i][1];

			Node node = new Node(i + 1, x, y);
			ArrayList<Node> list = nodes.get(y);
			if (list == null) {
				list = new ArrayList<Node>();
				levels.add(y);
			}
			list.add(node);
			nodes.put(y, list);
		}

		Collections.sort(levels);
		Node root = makeTree(nodes, levels);
		ArrayList<Integer> list1 = preOrderTraversal(root, answer[0], new ArrayList<Integer>());
		ArrayList<Integer> list2 = postOrderTraversal(root, answer[1], new ArrayList<Integer>());
		for (int i = 0; i < list1.size(); i++)
			answer[0][i] = list1.get(i);
		for (int i = 0; i < list2.size(); i++)
			answer[1][i] = list2.get(i);

		return answer;
	}

	static ArrayList<Integer> preOrderTraversal(Node node, int visit[], ArrayList<Integer> list) {
		list.add(node.node_num);
		if (node.left_child != null) {
			preOrderTraversal(node.left_child, visit, list);
		}
		if (node.right_child != null) {
			preOrderTraversal(node.right_child, visit, list);
		}
		return list;
	}

	static ArrayList<Integer> postOrderTraversal(Node node, int visit[], ArrayList<Integer> list) {
		if (node.left_child != null) {
			postOrderTraversal(node.left_child, visit, list);
		}
		if (node.right_child != null) {
			postOrderTraversal(node.right_child, visit, list);
		}
		list.add(node.node_num);
		return list;
	}

	static Node makeTree(Map<Integer, ArrayList<Node>> nodes, ArrayList<Integer> levels) {
		int nlevel = levels.size();
		// set root;
		Node root = nodes.get(levels.get(nlevel - 1)).get(0);
		root.left_boundary = Integer.MIN_VALUE;
		root.right_boundary = Integer.MAX_VALUE;

		for (int i = nlevel - 1; i > 0; i--) {
			ArrayList<Node> upper = nodes.get(levels.get(i));
			int nU = upper.size();
			for (int u = 0; u < nU; u++) {
				Node U = upper.get(u);
	
				for (int j = i - 1; j > -1; j--) {
					ArrayList<Node> down = nodes.get(levels.get(j));
					int nD=down.size();
					boolean foundChild = false;
					for (int d = 0; d < nD; d++) {
						Node D = down.get(d);
						//System.out.println(U.node_num+" "+D.node_num);;
						if (D.x > U.left_boundary && D.x < U.x  ) {
							// left child condition
							U.left_child = D;
							D.parent = U;
							D.right_boundary = U.x;
							D.left_boundary = U.left_boundary;
							foundChild = true;						
						} else if (D.x < U.right_boundary && D.x > U.x ) {
							// right child condition
							U.right_child = D;
							D.parent = U;
							D.left_boundary = U.x;
							D.right_boundary = U.right_boundary;
							foundChild = true;						
						}
					}
					if(foundChild){
						break;
					}
				} //
			}
		}
		return root;
	}

	static class Node {
		int node_num;
		int x;
		int y;
		int left_boundary;
		int right_boundary;
		Node parent = null;
		Node left_child = null;
		Node right_child = null;

		Node(int node_num, int x, int y) {
			this.node_num = node_num;
			this.x = x;
			this.y = y;
		}
	}
}
