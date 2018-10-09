package SWexpertAcademy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//2018-10-08
// idea: ���ڵ��� �浹�� ������ �־��� ������ ������ �Ͼ��(-1000<= x,y <= 1000)
// ���� ���� ���� ���ڴ� �����ص� �����ϴ�.
// ü�� ���̵�: ��
// �ùķ��̼��� �ƴ� �ٸ� ȿ������ ����� �ʿ��ϴ�.

public class swAcademy_5648 {
	static int DIR[][] = { {  0,  1 }, {  0,  -1 }, {  -1,  0 },
			{  1,  0 } };
	static double[][] REVERSE_HALF = { {  0,  (double) -0.5 }, {  0,  (double) 0.5 },
			{  (double) 0.5,  0 }, {  (double) -0.5,  0 } };
	static ArrayList<Atom> atoms;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {
			int ans = 0;
			int N = sc.nextInt();
			atoms = new ArrayList<Atom>();
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int dir = sc.nextInt();
				int e = sc.nextInt();
				atoms.add(new Atom(x+1000, y+1000, dir, e));
			}

			// ��ȿ�� ���ڵ��� ��� ������ �� ����
			while (atoms.size() > 0) {
				
				Map<Double, Boolean> isCollision = new HashMap();
				Map<Double, Integer> shadow = new HashMap();
				
				// ��� atom�� �����̱� ���� �ڽ��� ��ġ�� �׸��ڷ� �����.
				for (int i = 0; i < atoms.size(); i++) {
					shadow.put(atoms.get(i).getKey(), atoms.get(i).dir);
				}

				// ��� ���ڵ鿡 ���ؼ� �̵��Ѵ�.
				for (int i = 0; i < atoms.size(); i++) {
					Atom atom = atoms.get(i);	
					atom.move();

					// �������� ���ڵ鸸 �浹�� �����ϴ�.
					if (!atom.outOfBound()) {
						// key���� x��ǥ*10000+y��ǥ �̴�.
						// x,y���� �ȿ��� key���� �����ϴ�.
						double key = atom.getKey();

						// ���� atom�� �̵��Ϸ��� ��ġ�� �̹� �̵��� �Ϸ��� �ٸ� atom�� �ִ���
						Boolean value = isCollision.get(key);

						// �ڽŰ� �ݴ������ �׸��ڸ� ����ġ��
						if ((shadow.get(key) != null
								&& (shadow.get(key) + atom.dir == 1 || shadow.get(key) + atom.dir == 5))) {
							// �ٽ� �ݴ�� �� ĭ �̵��ϰ�
							atom.moveReverseHalf();
							// key���� �ٽ� ���Ͽ� �浹������ �߰��Ѵ�.
							key = atom.getKey();
							isCollision.put(key, true);
						} else if (value == null) {
							// �̵��Ϸ��� ��ġ�� �̵��� �� ��ģ �ٸ� atom�� ������
							isCollision.put(key, false);
						} else if (value != null) {
							// �̵��Ϸ��� ��ġ�� �̵��� �� ��ģ �ٸ� atom�� ������
							isCollision.put(key, true);
						}
					} else { // ���� ���� ���ڵ��� �浹 ���ɼ��� �����Ƿ� �����Ѵ�.
						atoms.remove(i);
						// list�� ������ �������Ƿ� i�� ������Ű�� �ʰ� �����Ѵ�.
						i--;
					}
				}

				// ��� atom�� ���ؼ� �浹������ �ִ� atom�� �������� �����ϰ� �����Ѵ�.
				for (int i = 0; i < atoms.size(); i++) {
					if (isCollision.get(atoms.get(i).getKey())) {
						ans += atoms.get(i).getEnergy();
						//System.out.println(atoms.get(i).getKey());
						atoms.remove(i);
						i--;
					}
				}

			} // time loop end
			System.out.println("#" + testcase + " " + ans);
		}
	}

	public static class Atom {
		double x;
		double y;
		int dir;
		int energy;

		public void move() {
			x += DIR[dir][0];
			y += DIR[dir][1];
		}

		public void moveReverseHalf() {
			x += REVERSE_HALF[dir][0];
			y += REVERSE_HALF[dir][1];
		}

		Atom(int x, int y, int dir, int energy) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.energy = energy;
		}

		public double getKey() {
			return (10000*x+y);
		}

		public int getEnergy() {
			return energy;
		}

		public boolean outOfBound() {
			if (x < 0 || y < 0 || x > 2000 || y > 2000)
				return true;

			else
				return false;
		}

	}
}
