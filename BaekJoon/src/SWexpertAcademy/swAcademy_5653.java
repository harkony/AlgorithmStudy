package SWexpertAcademy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//2018-10-09
//체감난이도: 중

public class swAcademy_5653 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {

			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();

			BioLab lab = new BioLab(N, M);

			for (int low = 0; low < N; low++) {
				for (int col = 0; col < M; col++) {
					int vitality = sc.nextInt();
					if (vitality > 0) {
						lab.setCell(low, col, vitality);
					}
				}
			}

			int alive = lab.getAliveAfter(K);
			System.out.println("#" + testcase + " " + alive);
		}
	}

	static class BioLab {
		int LIMIT = 300;
		Vessel vessels[][];
		ArrayList<Integer> validVessels = new ArrayList<Integer>();
		int DIR[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		String[] status_str = { "inActive", "Active", "Dead" };

		BioLab(int n, int m) {
			vessels = new Vessel[50 + LIMIT + LIMIT][50 + LIMIT + LIMIT];
			for (int low = 0; low < n + LIMIT + LIMIT; low++) {
				for (int col = 0; col < n + LIMIT + LIMIT; col++)
					vessels[low][col] = new Vessel();
			}
		}

		void showVessels() {
			for (int i = 0; i < validVessels.size(); i += 2) {
				int low = validVessels.get(i);
				int col = validVessels.get(i + 1);
				System.out.println((low - 300) + "," + (col - 300) + " " + vessels[low][col].vitality + " "
						+ status_str[vessels[low][col].getStatus()]);
			}
			System.out.println();
		}

		void setFixed() {
			for (int i = 0; i < validVessels.size(); i += 2)
				vessels[validVessels.get(i)][validVessels.get(i + 1)].isFixed = true;
		}

		void setCell(int low, int col, int vitality) {
			vessels[LIMIT + low][LIMIT + col].vitality = vitality;
			vessels[LIMIT + low][LIMIT + col].age = 0;
			vessels[LIMIT + low][LIMIT + col].isFixed = true;
			validVessels.add(LIMIT + low);
			validVessels.add(LIMIT + col);
		}

		public int getAliveAfter(int time) {
			// showVessels();
			for (int i = 1; i <= time; i++) {
				simulate();
				setFixed();
			}
			
			return validVessels.size() / 2;
		}

		public void simulate() {
			int nValid = validVessels.size();
			for (int i = 0; i < nValid; i += 2) {
				int low = validVessels.get(i);
				int col = validVessels.get(i + 1);
				Vessel v = vessels[low][col];
				v.isFixed = true;
				if (v.getStatus() == 1) {
					for (int dir = 0; dir < 4; dir++) {
						int nl = low + DIR[dir][0];
						int nc = col + DIR[dir][1];
						Vessel nv = vessels[nl][nc];

						// 해당 vessel이 비어있거나 더 낮은 vitality로 증식중이면
						if (nv.vitality < v.vitality && !nv.isFixed) {
							nv.vitality = v.vitality;
							validVessels.add(nl);
							validVessels.add(nc);
						}
					}
				}
				v.aging();

				// dead 상태의 세포는 삭제한다.
				if (v.isDead()) {
					validVessels.remove(i);
					validVessels.remove(i);
					i -= 2;
					nValid -= 2;
				}

			}

		}
	}

	static class Vessel {
		int vitality;
		int age;
		boolean isFixed;

		Vessel() {
			vitality = 0;
			age = 0;
			isFixed = false;
		}

		public void aging() {
			age++;
		}

		public boolean isDead() {
			return (age / vitality) >= 2;
		}

		public int getStatus() {
			if ((age / vitality) > 2)
				return 2;
			return age / vitality;
		}
	}

}
