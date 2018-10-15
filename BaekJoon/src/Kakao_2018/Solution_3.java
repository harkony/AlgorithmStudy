package Kakao_2018;
//2018-09-15

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//idea
//그냥 계산문제로 풀이하였다

class Solution_3 {
	public static void main(String[] args) {
		String[][] relation = { 
				{ "100", "ryan", "music", "2" },
				{ "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, 
				{ "400", "con", "computer", "4" }, 
				{ "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } 
				};
		System.out.println(solution(relation));
	}

	public static int solution(String[][] relation) {
		int answer = 0;
		int nLow = relation.length;
		int nCol = relation[0].length;
		Queue<ArrayList<Integer>> queue = new LinkedList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
		
		
		for (int i = 0; i < nCol; i++) {
			ArrayList<Integer> cols = new ArrayList<Integer>();
			cols.add(i);
			queue.add(cols);
		}

		while (!queue.isEmpty()) {
			ArrayList<Integer> cols = queue.poll();
			if (isUnique(relation, nLow, nCol, cols)) {
				boolean flag=true;
				for(int i=0;i<ans.size();i++) {
					if(cols.containsAll(ans.get(i))) {
						flag=false;
						break;
					}
				}
				if(flag)
					ans.add(cols);
			} else {
				int last = cols.get(cols.size()-1) ;
				for (int next=last+1;next < nCol; next++) {
					ArrayList<Integer> new_cols = new ArrayList<Integer>(cols);
					new_cols.add(next);
					queue.add(new_cols);
				}
			}
		}
		return ans.size();
	}

	public static boolean isUnique(String[][] relation, int nLow, int nCol, ArrayList<Integer> cols) {

		StringBuilder[] keys = new StringBuilder[nLow];
		for (int i = 0; i < nLow; i++)
			keys[i] = new StringBuilder("");
		for (int low = 0; low < nLow; low++) {
			for (int col = 0; col < nCol; col++) {
				if (cols.contains(col)) {
					keys[low].append(relation[low][col]);
					keys[low].append(" ");
				}
			}
		}
		for (int low = 0; low < nLow - 1; low++) {
			for (int nlow = low + 1; nlow < nLow; nlow++) {
				if ((keys[low].toString()).equals((keys[nlow].toString()))) {
					return false;
				}
			}
		}
		return true;
	}
}