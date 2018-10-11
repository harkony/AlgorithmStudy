package SWexpertAcademy;

//2018-09-26
//ü�����̵�: ����

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class swAcademy_2382 {
	static int N; // cell�� ���� , 5~100
	static int M; // �ð�
	static int K; // �̻��� ������ ����
	static int DIR[][] = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static String DIR_C[]= {"x","^","v","<",">"};
	static ArrayList<MicroGroup> groups;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Map<Integer, ArrayList<MicroGroup>> map = new HashMap();
		for (int testcase = 1; testcase <= T; testcase++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			groups = new ArrayList<MicroGroup>();
			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int n = sc.nextInt();
				int dir = sc.nextInt();
				MicroGroup group = new MicroGroup(i, x, y, n, dir);
				groups.add(group);
			}
			for (int time =0; time < M; time++) {
				for(int g=0;g<groups.size();g++)
				//groups.get(g).print();
				//System.out.println();
				map.clear();
				ArrayList<Integer> keys = new ArrayList<Integer>();
				
				//��� �̻��� ������ ���Ͽ�
				for (int i = 0; i < groups.size(); i++) {
					//�̵� ���� ��ġ�� key������ �Ѵ�
					int key = groups.get(i).move();
					ArrayList<MicroGroup> list = map.get(key);
					//�ش� ��ġ�� �̵��� �Ϸ��� �׷��� ������ ArrayList�� �Ҵ��� �ʿ��ϴ�
					if (list == null) {
						list = new ArrayList<MicroGroup>();
						keys.add(key);
					}
					//�ش� ��ġ�� �̻����� �߰��Ѵ�
					list.add(groups.get(i));
					map.put(key, list);
				} // end individual move
				
				
				for (int i = 0; i < keys.size(); i++) {
					//assemble : �� ��ġ�� �� �ִ� �̻������� list
					ArrayList<MicroGroup> assembles = map.get(keys.get(i));
					int max = 0;
					int index_assembles = 0;
					for (int j = 0; j < assembles.size(); j++) {
						if (assembles.get(j).n > max) {
							//���� ������ ū �̻����� �Ը�� ������ �����س��´�.
							max = assembles.get(j).n;
							index_assembles = j;
						}
					}
					for (int j = 0; j < assembles.size(); j++) {
						//���� ū �Ը��� �̻��� ������ �ٸ� �̻��� ������ ���Խ�Ų��.
						if (j != index_assembles) {
							assembles.get(index_assembles).n += assembles.get(j).n;
							for (int k = 0; k < groups.size(); k++) {
								if (groups.get(k).index == assembles.get(j).index) {
									groups.remove(k);
									break;
								}
							}
						}
					}

				}
			} // for time end
			int alive=0;
			for(int i=0;i<groups.size();i++)
				alive+=groups.get(i).n;
			System.out.println("#" + testcase + " " + alive);
		}
	}

	public static class MicroGroup {
		int index;
		int x;
		int y;
		int n;
		int dir; // 1:up 2:down 3:left 4:right

		MicroGroup(int index, int x, int y, int n, int dir) {
			this.index = index;
			this.x = x;
			this.y = y;
			this.n = n;
			this.dir = dir;
		}

		public int move() {
			x += DIR[dir][0];
			y += DIR[dir][1];
			
			if (x == 0 || y == 0 || x == N - 1 || y == N - 1) // �������
			{
				if (dir % 2 == 0)
					dir -= 1;
				else
					dir += 1;

				n /= 2;
			}
			return (1000 * x + y);
		}
		public void print() {
			System.out.println("["+index+"]"+" ("+x+","+y+")"+DIR_C[dir]+"  : "+n);
		}
	}
		
}
