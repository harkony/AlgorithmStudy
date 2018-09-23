package LGCNS_2018;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_2 {
	public static void main(String[] args) {
		int N = 3;
		int house[][] = { { 0, 0 } ,{1,0}};

		System.out.println(solution(N,house));

	}

	public static int solution(int N, int[][] house) {
		int answer = 0;
		int nHouse=house.length;
		int dist[]=new int[201*201-nHouse];
		int index_dist=0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		//좌표값의 범위를 -100~+100에서 0~200으로 변환시킨다
		for(int i=0;i<nHouse;i++) {
			house[i][0]+=100;
			house[i][1]+=100;
			//(x좌표*1000+y좌표)값은 모든 좌표에 대한 유일한 값을 갖는다
			map.put(  (house[i][0]*1000+house[i][1]), 1);
		}
		
		for(int i=0;i<=200;i++) {
			for(int j=0;j<=200;j++) {
				int key=1000*i+j;
				//해당 위치에 집이 있는지 확인한다
				if(map.get(key)!=null)
					continue;
				else {
					int min=Integer.MAX_VALUE;
					//모든 집에 대해 가장 가까운 거리만을 저장한다
					for(int h=0;h<nHouse;h++) {
						int d= (house[h][0]-i)*(house[h][0]-i)+(house[h][1]-j)*(house[h][1]-j);
						if (d<min)
							min=d;
					}
					dist[index_dist++]=min;
				}
			}
		}
		Arrays.sort(dist);
		
		
		
		return dist[dist.length-N];
	}

}
