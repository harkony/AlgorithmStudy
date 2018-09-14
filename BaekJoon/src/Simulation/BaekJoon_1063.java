package Simulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//2018-09-14
//체감 난이도: 하
public class BaekJoon_1063 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str=sc.nextLine();
		String splits[]=str.split(" ");
		King king=new King(splits[0]);
		Stone stone=new Stone(splits[1]);
		int nCMD=Integer.parseInt(splits[2]);
		
		for(int i=0;i<nCMD;i++) {
			String cmd=sc.nextLine();
			king.move(cmd, stone);
			
		}
		king.print();
		stone.print();
		
	}

	public static class Object {
		int x;
		int y;
		int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

		Object(String str) {
			x = str.charAt(0) - 'A'+1; 
			y = str.charAt(1) - '0';  
			//System.out.println(str+" is converted as "+x+","+y);
		}
		void print(){
			char xChar=(char) (x+'A'-1);
			System.out.println(xChar+""+y);
		}

	}

	public static class King extends Object {
		King(String str) {
			super(str);
			// TODO Auto-generated constructor stub
		}

		public void move(String cmd, Stone stone) {
			int nextX = 0;
			int nextY = 0;
			if (cmd.contentEquals("T")) {
				nextX = x + dir[0][0];
				nextY = y + dir[0][1];
			} else if (cmd.contentEquals("B")) {
				nextX = x + dir[1][0];
				nextY = y + dir[1][1];
			} else if (cmd.contentEquals("L")) {
				nextX = x + dir[2][0];
				nextY = y + dir[2][1];
			} else if (cmd.contentEquals("R")) {
				nextX = x + dir[3][0];
				nextY = y + dir[3][1];
			} else if (cmd.contentEquals("RT")) {
				nextX = x + dir[4][0];
				nextY = y + dir[4][1];
			} else if (cmd.contentEquals("RB")) {
				nextX = x + dir[5][0];
				nextY = y + dir[5][1];
			} else if (cmd.contentEquals("LT")) {
				nextX = x + dir[6][0];
				nextY = y + dir[6][1];
			} else if (cmd.contentEquals("LB")) {
				nextX = x + dir[7][0];
				nextY = y + dir[7][1];
			} else {
				System.out.println("Invalid CMD");
			}

			if (nextX == stone.x && nextY == stone.y) {
				//System.out.println("Stone is detected");
				if (stone.move(cmd)) {
					x = nextX;
					y = nextY;
				}
			} else if (nextX > 0 && nextY > 0 && nextX <= 8 && nextY <= 8) {
				x=nextX;
				y=nextY;
			} else {
				//System.out.println("OUT OF BOARD");
			}
		}
	}

	public static class Stone extends Object {

		Stone(String str) {
			super(str);
			// TODO Auto-generated constructor stub
		}

		public boolean move(String cmd) {
			int nextX = 0;
			int nextY = 0;
			if (cmd.contentEquals("T")) {
				nextX = x + dir[0][0];
				nextY = y + dir[0][1];
			} else if (cmd.contentEquals("B")) {
				nextX = x + dir[1][0];
				nextY = y + dir[1][1];
			} else if (cmd.contentEquals("L")) {
				nextX = x + dir[2][0];
				nextY = y + dir[2][1];
			} else if (cmd.contentEquals("R")) {
				nextX = x + dir[3][0];
				nextY = y + dir[3][1];
			} else if (cmd.contentEquals("RT")) {
				nextX = x + dir[4][0];
				nextY = y + dir[4][1];
			} else if (cmd.contentEquals("RB")) {
				nextX = x + dir[5][0];
				nextY = y + dir[5][1];
			} else if (cmd.contentEquals("LT")) {
				nextX = x + dir[6][0];
				nextY = y + dir[6][1];
			} else if (cmd.contentEquals("LB")) {
				nextX = x + dir[7][0];
				nextY = y + dir[7][1];
			} else {
				System.out.println("Invalid CMD");
			}
			if (nextX > 0 && nextY > 0 && nextX <= 8 && nextY <= 8) {
				x = nextX;
				y = nextY;
				return true;
			} else {
				//System.out.println("OUT OF BOARD");
				return false;
			}
		}
	}
}