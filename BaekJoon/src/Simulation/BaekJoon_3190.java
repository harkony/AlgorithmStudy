package Simulation;

import java.util.ArrayList;
import java.util.Scanner;

//2018-09-14 
//체감 난이도: 	중
//% 연산이 항상 양수가 아님을 기억하자!!!!!
public class BaekJoon_3190 {
	static int[][] DIR = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };;
	static ArrayList<ArrayList<Integer>> apples = new ArrayList<ArrayList<Integer>>();
	static int N;
	static int K;
	static int L;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		for (int i = 0; i < K; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			ArrayList<Integer> apple = new ArrayList<Integer>();
			apple.add(x);
			apple.add(y);
			apples.add(apple);
		}
		//System.out.println("Apples at " + apples.toString());
		L = sc.nextInt();
		sc.nextLine();
		int time = 1;
		Snake snake = new Snake();
		for (int i = 0; i < L; i++) {
			String str = sc.nextLine();
			String[] splits = str.split(" ");
			int t = Integer.parseInt(splits[0]);
			char cmd = splits[1].charAt(0);
			while (time <= t) {
				//System.out.println("(time: " + time + ")");
				snake.move();
				//snake.print();
				if (!snake.isValid()) {
					System.out.println(time);
					return;
				}
				time++;
			}
			//System.out.println(cmd+"");
			snake.turn(cmd);
		}
		while (true) {
			snake.move();
			if (!snake.isValid()) {
				System.out.println(time);
				return;
			}
			time++;
		}
	}

	public static class Snake {
		ArrayList<Integer> head;
		ArrayList<ArrayList<Integer>> body = new ArrayList<ArrayList<Integer>>();
		int dir = 0;// 0: right 1:bottom 2:left 3:top

		Snake() {
			head = new ArrayList<Integer>();
			head.add(1);
			head.add(1);
		}

		void print() {
			System.out.print("Head : " + head.toString() + " Body: ");

			for (int i = 0; i < body.size(); i++)
				System.out.print(body.get(i).toString() + " ");
			System.out.println();
		}

		void turn(char turn) {
			//System.out.print(dir+" is changed to ");
			if (turn == 'L') {
				dir = (dir + 3 ) % 4;
			} else {
				dir = (dir + 1) % 4;
			}
			//System.out.println(dir);
		}

		boolean isValid() {
			if (head.get(0) < 1 || head.get(0) > N || head.get(1) < 1 || head.get(1) > N || body.contains(head))
				return false;
			return true;
		}

		boolean move() {
			int x = head.get(0);
			int y = head.get(1);
			head.set(0, head.get(0) + DIR[dir][0]);
			head.set(1, head.get(1) + DIR[dir][1]);
			if (!isValid())
				return false;

			if (apples.contains(head)) {
				for (int i = 0; i < apples.size(); i++) {
					if (apples.get(i).equals(head)) {
						apples.remove(i);
						break;
					}
				}
				ArrayList<Integer> add = new ArrayList<Integer>();
				add.add(x);
				add.add(y);
				body.add(0, add);
			} else {
				for (int i = body.size() - 1; i > 0; i--) {
					body.get(i).set(0, body.get(i - 1).get(0));
					body.get(i).set(1, body.get(i - 1).get(1));
				}
				if (body.size() > 0) {
					body.get(0).set(0, x);
					body.get(0).set(1, y);
				}
			}
			return true;
		}
	}
}