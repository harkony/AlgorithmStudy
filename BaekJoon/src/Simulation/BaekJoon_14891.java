package Simulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//2018-09-27
//체감 난이도: 하
public class BaekJoon_14891 {
	public static GearWheel[] gears = new GearWheel[4];
	public static String SN[] = { "N", "S" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			String str = sc.nextLine();
			gears[i] = new GearWheel(i, str);
		}
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int index = sc.nextInt();
			int dir = sc.nextInt();
			gears[index - 1].RotateAllSide(dir, 0);
		}

		int score = 0;
		int weight=1;
		for (int i = 0; i < 4; i++) {
			score+=gears[i].getTop()*(weight);
			weight*=2;
		}
		System.out.println(score);
	}

	public static class GearWheel {
		int index;
		int top = 0;
		int arr[] = new int[8];

		GearWheel(int index, String str) {
			this.index = index;
			for (int i = 0; i < 8; i++)
				arr[i] = str.charAt(i) - '0';
		}

		public void RotateAllSide(int dir, int side) {
			// dir 1: clock -1: reverse clock
			// side 0: BothSide 1:RightSide 2:LeftSide

			if (side != 2)
				this.RotateRightSide(dir);

			if (side != 1)
				this.RotateLeftSide(dir);
			top = (top + 8 - dir) % 8;
		}

		public void RotateRightSide(int dir) {
			if (index < 3 && this.getRight() != gears[index + 1].getLeft()) {
				gears[index + 1].RotateAllSide((dir * -1), 1);
			}
		}

		public void RotateLeftSide(int dir) {

			if (index > 0 && this.getLeft() != gears[index - 1].getRight()) {
				gears[index - 1].RotateAllSide((dir * -1), 2);
			}
		}

		public int getRight() {
			return arr[(top + 2) % 8];
		}

		public int getLeft() {
			return arr[(top + 6) % 8];
		}

		public int getTop() {
			return arr[top];
		}

		public void print() {
			System.out.println(SN[this.getLeft()] + " " + SN[this.getTop()] + " " + SN[this.getRight()]);
		}
	}
}