//2018-9-4
//체감난이도: 중상
//50개중에 48개만 pass했다. 처음부터 다시 짜야한다.
package SWexpertAcademy;

import java.util.ArrayList;
import java.util.Scanner;

public class swAcademy_2383 {
	static ArrayList<Person> personList = new ArrayList<Person>();
	static ArrayList<Stair> stairList = new ArrayList<Stair>();
	static int nP;
	static int nC;
	static int Complete;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int loop = 0; loop < T; loop++) {
			int n = sc.nextInt();
			int nCase = 1;
			int minTime = Integer.MAX_VALUE;

			personList.removeAll(personList);
			stairList.removeAll(stairList);
			nP = 0;
			nC = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int index = sc.nextInt();
					if (index == 1) {
						personList.add(new Person(i, j, nP++));
					} else if (index > 1) {
						stairList.add(new Stair(i, j, nC++, index));
					}
				}
			}

			// System.out.println("nP : " + nP + ", nC : " + nC);
			for (int i = 0; i < nP; i++)
				nCase *= 2;

			for (int i = 0; i < nCase; i++) {
				Init();
				int time = Process();
				// System.out.println("\nnCase : " + i + " , time: " + time);
				if (time < minTime)
					minTime = time;
				personList.get(personList.size() - 1).nextPosition();
			}
			System.out.println("#" + (loop + 1) + " " + minTime);
		}
	}

	static class Person {
		int xpos;
		int ypos;
		int personIndex;
		int destination;
		int distance2stair;
		int distance2floor;

		Person(int xpos, int ypos, int personIndex) {
			this.xpos = xpos;
			this.ypos = ypos;
			this.personIndex = personIndex;
			destination = 0;

		}

		void nextPosition() {
			destination = (destination + 1) % 2;
			distance2floor = -stairList.get(destination).len;
			distance2stair = (Math.abs(stairList.get(destination).xpos - xpos)
					+ Math.abs(stairList.get(destination).ypos - ypos));
			if (personIndex > 0 && destination == 0)
				personList.get(personIndex - 1).nextPosition();
			if (personIndex > 0 && destination == 1) {
				personList.get(personIndex - 1).reset();
			}
		}

		void reset() {
			distance2floor = -stairList.get(destination).len;
			distance2stair = (Math.abs(stairList.get(destination).xpos - xpos)
					+ Math.abs(stairList.get(destination).ypos - ypos));
			if (personIndex > 0)
				personList.get(personIndex - 1).reset();

		}

		void move() {
			if (distance2stair < distance2floor)
				return;
			else if (distance2stair == 0) {
				if (stairList.get(destination).available()) {
					stairList.get(destination).nAction += 1;
					distance2stair--;
				}
			} else if (distance2stair == distance2floor) {
				Complete += 1;
				stairList.get(destination).nAction -= 1;
				distance2stair--;
			} else {
				distance2stair--;
			}
		}

	}

	static class Stair {
		int xpos;
		int ypos;
		int stairIndex;
		int len;
		int nAction;

		Stair(int xpos, int ypos, int stairIndex, int len) {
			this.xpos = xpos;
			this.ypos = ypos;
			this.stairIndex = stairIndex;
			this.len = len;
			this.nAction = 0;
		}

		boolean available() {
			if (nAction < 3)
				return true;
			else
				return false;
		}

		void reset() {
			nAction = 0;
		}

	}

	static int Process() {
		int time = 0;

		while (Complete < nP) {
			//System.out.println("Time :" + time);
			//for (int i = 0; i < nP; i++)
			//	System.out.print(personList.get(i).distance2stair + " ");
			//System.out.println("");
			for (int i = 0; i < nP; i++)
				personList.get(i).move();
			time++;
		}
		return time;
	}

	static void Init() {
		Complete = 0;
		for (int i = 0; i < nP; i++) {
			Person p = personList.get(i);
			p.distance2floor = -stairList.get(p.destination).len;
			p.distance2stair = Math.abs(p.xpos - stairList.get(p.destination).xpos)
					+ Math.abs(p.ypos - stairList.get(p.destination).ypos);
		}
		for (int i = 0; i < nC; i++) {
			stairList.get(i).reset();
		}
	}
}
