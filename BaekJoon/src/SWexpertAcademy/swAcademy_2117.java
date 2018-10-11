package SWexpertAcademy;

//2018-09-26

//ü�����̵�: ����
//�ٸ� ����� �����Ű�����..


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swAcademy_2117 {
	static int N;
	static int M;
	static int map[][];
	static int[][] DIR = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];
			for (int low = 0; low < N; low++) {
				for (int col = 0; col < N; col++) {
					map[low][col] = sc.nextInt();
				}
			}
			
			//kPossible : �ش� N*N�� ��� Ŀ�������� �ּ�  kũ�� 
			int kPossible=2*N-1;
			
			//maxHouses[k]: k�� �� ���� ������ ���� �ִ밪  
			int maxHouses[]=new int[kPossible+1];
			
			for (int low = 0; low < N; low++) {
				for (int col = 0; col < N; col++) {
					boolean visit[][]=new boolean[N][N];
					int houses[]=new int[kPossible+1];
					
					Queue<Integer> queue=new LinkedList<Integer>();
					
					queue.add(low);
					queue.add(col);
					queue.add(1);
					
					
					while(!queue.isEmpty()) {
						int l=queue.poll();
						int c=queue.poll();
						int dist=queue.poll();
						
						if(visit[l][c] || dist>kPossible)
							continue;
						visit[l][c]=true;
						//System.out.println(l+","+c);
						if(map[l][c]==1) {
							for(int i=dist;i<=kPossible;i++)
								houses[i]++;
						}
						for(int dir=0;dir<4;dir++) {
							int nl=l+DIR[dir][0];
							int nc=c+DIR[dir][1];
							if(nl<0 || nc<0 || nl>=N || nc>=N || visit[nl][nc])
								continue;
							queue.add(nl);
							queue.add(nc);
							queue.add(dist+1);
						}
					} //while end
					for(int i=1;i<=kPossible;i++){
						if(maxHouses[i]<houses[i])
							maxHouses[i]=houses[i];
					}
					
				}// for col end
			}// for low end
			for(int i=1;i<=kPossible;i++){
				//System.out.print(maxHouses[i]+" ");
			}
			//System.out.println();
			int ans=0;
			
			//��� ������ k�� ���ؼ� ����� ����Ͽ� �ִ밪 ���Ѵ�.
			for(int i=kPossible;i>0;i--) {
				if(maxHouses[i]*M - i*i -(i-1)*(i-1) >=0) {
					if(ans<maxHouses[i])
					 ans=maxHouses[i];
				}
			}
			System.out.println("#"+testcase+" "+ans);
		} //for testcase end

	}

}
