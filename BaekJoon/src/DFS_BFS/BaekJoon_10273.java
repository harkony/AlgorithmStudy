package DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//2018-09-11 
// IDEA :
// 1) DFS : Fail (runtime error) 
// 2) BFS+DP 
//     + route 저장: (string -> memory fail -> integer[] 로)
//     + 출력 : (string 이용 -> 시간 초과 -> stringBuilder -> pass)
// 체감 난이도: 사	
public class BaekJoon_10273 {
	static int N;
	static int E;
	static ArrayList<ArrayList<ArrayList<Integer>>> lists;
	static int[] treasure;
	static long[] dp;
	static int[] nNext;
	static int[] routes;
	static Queue<Integer> queue;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();

		for (int tcase = 0; tcase < T; tcase++) {
			ReadInput();
			Process();
			printResult();
		} // tcase loop end
	}

	public static void ReadInput() {
		lists = new ArrayList<ArrayList<ArrayList<Integer>>>();
		queue = new LinkedList<Integer>();
		N = sc.nextInt();
		E = sc.nextInt();
		nNext = new int[N + 1];
		dp = new long[N + 1];
		treasure = new int[N + 1];
		routes = new int[N+1];
		lists = new ArrayList<ArrayList<ArrayList<Integer>>>();

		for (int i = 0; i < N + 1; i++) {
			lists.add(new ArrayList<ArrayList<Integer>>());
		}
		for (int i = 1; i <= N; i++)
			treasure[i] = sc.nextInt();

		for (int i = 0; i < E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int cost = sc.nextInt();
			// list.get(0): 출발 동굴
			// list.get(1): 출발 동굴에서 도착 동굴로 갔을 때 추가로 얻을 수 있는 이익 (보물-비용)
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(start);
			list.add(treasure[end] - cost);
			// lists.get(i) : i로 갈 수 있는 출발지 list.
			// 동굴 끝에서부터 거꾸로 갈것 이므로 list(destination)에 source를 저장한다.
			lists.get(end).add(list);
			nNext[start] += 1;

		} // read edge end;
		dp[1] = 0;
	}

	public static void Process() {
		//idea
		//dp[i] : i 이후에 얻을 수 있는 이득의 최대값
		
		for (int i = 2; i <= N; i++) {
			if (nNext[i] == 0) // 더 이상 진행 할 수 없는 막다른 동굴, 동굴 끝에서 시작하므로 queue에 넣는다
			{
				dp[i] = 0;
				queue.add(i);
			} else
				dp[i] = Long.MIN_VALUE; // 방문하지 않은 값 초기화
		}
		while (!queue.isEmpty()) {
			int caveEnd = queue.poll();
			//list: caveEnd에 도달할 수 있는 caveStart, caveStart->caveEnd의 cost
			ArrayList<ArrayList<Integer>> list = lists.get(caveEnd);
			for (int i = 0; i < list.size(); i++) {
				int caveStart = list.get(i).get(0);
				int profit = list.get(i).get(1);
				long dpNext = dp[caveEnd] + profit;
				if (dp[caveStart] < dpNext) {  // 갱신한다
					if (dpNext > 0) {
						routes[caveStart]=caveEnd;
						dp[caveStart] = dp[caveEnd] + profit;
						queue.add(caveStart);
					} else {  // dp에 는 최대값을 저장하므로 음수값이면 0으로 저장한다.
						dp[caveStart] = 0;
						queue.add(caveStart);
					}
				}
			}
		}
	}

	public static void printResult() {
		StringBuilder route=new StringBuilder("1 ");
		int cave=1;
		int n=1;
		while(routes[cave]!=0)
		{
			route.append(routes[cave]+" ");
			cave=routes[cave];
			n++;
		}
		System.out.println(dp[1] + treasure[1] + " " + n);
		System.out.println(route);
	}
}
