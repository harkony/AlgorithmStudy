package SWexpertAcademy;

//2018-09-23
//체감난이도: 중하


import java.util.ArrayList;
import java.util.Scanner;

public class swAcademy_2383 {
	static int nP;
	static int Complete;
	static ArrayList<Person> people;
	static ArrayList<Stair> stairs;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int loop = 0; loop < T; loop++) {
			int n = sc.nextInt();
			int nCase = 1;
			int minTime = Integer.MAX_VALUE;
			people = new ArrayList<Person>();
			stairs = new ArrayList<Stair>();

			nP = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int num = sc.nextInt();
					if (num == 1) {
						people.add(new Person(i, j));

					} else if (num > 1) {
						stairs.add(new Stair(i, j, num));
					}
				}
			}

			nP = people.size();
			nCase <<= nP;

			for (int i = 0; i < nCase; i++) {
				Complete=0;
				int bit = i;
				for (int j = 0; j < nP; j++, bit >>= 1) {
					people.get(j).setDest(stairs.get(bit&1));
					//System.out.print(bit&1);
					//people.get(j).print();
				}
				//System.out.println();
				int time=0;
				while(Complete<nP) {
					//System.out.println(time);
					for(int k=0;k<people.size();k++)
						people.get(k).preAction();
					for(int k=0;k<people.size();k++)
						people.get(k).postAction();
					time++;
				}
				if(time<minTime)
					minTime=time;
				
			}			
			System.out.println("#" + (loop + 1) + " " + (minTime+1));
		}
	}

	public static class Stair {
		int x;
		int y;
		int len;
		ArrayList<Person> ing = new ArrayList<Person>();

		Stair(){
			
		}
		Stair(int x, int y, int len) {
			this.x = x;
			this.y = y;
			this.len = len;
		}
		
	}

	public static class Person {
		int x;
		int y;
		int dist;
		Stair dest=new Stair();

		Person(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void print() {
			System.out.println("dest: "+dest.len+" dist:"+dist);
		}
		public void setDest(Stair dest) {
			this.dest = dest;
			dist=Math.abs(dest.x-x)+Math.abs(dest.y-y);
		}

		
		public void preAction() {
			if(dist>0)
				dist--;
			else if(dist==0) {
				if(dest.ing.size()<3) {
					dest.ing.add(this);
					dist--;
				} 
			} else if(dist<0 && dist+dest.len>0) {
				dist--;
			}
			
		}
		
		public void postAction() {
			if(dist+dest.len==0) {
				dest.ing.remove(0);
				Complete++;
				dist--;
			}
			
		}

	}
}
