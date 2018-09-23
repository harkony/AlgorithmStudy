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
		
		//��ǥ���� ������ -100~+100���� 0~200���� ��ȯ��Ų��
		for(int i=0;i<nHouse;i++) {
			house[i][0]+=100;
			house[i][1]+=100;
			//(x��ǥ*1000+y��ǥ)���� ��� ��ǥ�� ���� ������ ���� ���´�
			map.put(  (house[i][0]*1000+house[i][1]), 1);
		}
		
		for(int i=0;i<=200;i++) {
			for(int j=0;j<=200;j++) {
				int key=1000*i+j;
				//�ش� ��ġ�� ���� �ִ��� Ȯ���Ѵ�
				if(map.get(key)!=null)
					continue;
				else {
					int min=Integer.MAX_VALUE;
					//��� ���� ���� ���� ����� �Ÿ����� �����Ѵ�
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
