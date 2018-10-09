package SWexpertAcademy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//2018-10-09
//ü�� ���̵�: ����

public class swAcademy_5650 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {
			int bestScore=0;
			int N;
			int map[][];
			Map<Integer, Integer> wormhole;
			N = sc.nextInt();
			map = new int[N][N];
			wormhole = new HashMap();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] > 5) {
						//ó�� map���� wormhole index�� key�� x,y���� value�� �ִ´�
						if (wormhole.get(map[i][j]) == null)
							wormhole.put(map[i][j], i * 1000 + j);
						else {
						//���� map���� wormhole index�� key�� ����� ��ǥ�� �����´�.
						//�׸��� �ٽ� map�� �ֹ��� ��Ȧ ��ǥ�� �ִ´�.
							int connected = wormhole.get(map[i][j]);
							int current = 1000 * i + j;
							wormhole.remove(map[i][j]);
							wormhole.put(current, connected);
							wormhole.put(connected, current);
						}
					}
				}
			}
			Game game = new Game(N, map, wormhole);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==0) {
						for(int dir=0;dir<4;dir++) {
							game.set(i, j, dir);
							int score=game.play();
							//System.out.println(i+","+j+","+dir+" : "+score);
							if(score>bestScore)
								bestScore=score;							
						}
					}
				}
			}
			

			System.out.println("#" + testcase + " " + bestScore);
		}
	}

	static class Game {
		// obstacle[i][j]= i�� osbtacle��  j�������� �����̴ٰ� �浹�� ��ȯ�� ����
		/* j=> 
		0:�� 
		1:�Ʒ� 
		2:���� 
		3:������
		*/
		// obstacle[i][j] 
		int obstacle[][] = {
				// 0�� ��ֹ�: ���
				{ 0, 0, 0, 0},
				// 1�� ��ֹ�
				{ 1, 3, 0, 2 },
				// 2�� ��ֹ�
				{ 3, 0, 1, 2 },
				// 3�� ��ֹ�
				{ 2, 0, 3, 1 },
				// 4�� ��ֹ�
				{ 1, 2, 3, 0 },
				// 5�� ��ֹ�
				{ 1, 0, 3, 2 }, };
		int DIR[][] ={
			{-1,0},
			{1,0},
			{0,-1},
			{0,1}
		};
		int N;
		int map[][];
		// 1000*x+y���� wormhole�� ������ ����� 1000*x+y���� ���� �� �ִ�.
		Map<Integer, Integer> wormhole;
		int startLow;
		int startCol;
		int curLow;
		int curCol;
		// dir 0: �� 1:�Ʒ�  2:�� 3: ����
		int dir;
		int score;

		public Game(int n, int[][] map, Map<Integer, Integer> wormhole) {
			super();
			N = n;
			this.map = map;
			this.wormhole = wormhole;
		}

		public void set(int low, int col, int dir) {
			startLow=low;
			startCol=col;
			this.curLow = low;
			this.curCol = col;
			this.dir = dir;
			score = 0;
		}
		
		public int play() {
			while(true) {
				//System.out.println(curLow+","+curCol);
				move();
				if(outOfBoundary()) {
					score++;
					reverseDir();
				} else if(map[curLow][curCol]==-1 || (curLow==startLow && curCol==startCol)) {
					return score; 
				} else if(map[curLow][curCol]>0 && map[curLow][curCol]<6) {
					dir=obstacle[map[curLow][curCol]][dir];
					score++;
				} else if(map[curLow][curCol]>5) {
					int value=wormhole.get(curLow*1000+curCol);
					curLow=value/1000;
					curCol=value%1000;
				}
				
			}			
		}
		public void move() {
			curLow+=DIR[dir][0];
			curCol+=DIR[dir][1];
		}
		
		public boolean outOfBoundary() {
			if(curLow<0 || curCol<0 || curLow>=N || curCol>=N)
				return true;
			else 
				return false;
		}
		public void reverseDir() {
			if(dir<2)
				dir=1-dir;
			else
				dir=5-dir;
		}

	}

}
