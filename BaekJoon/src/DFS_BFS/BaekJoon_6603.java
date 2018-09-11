package DFS_BFS;

import java.util.ArrayList;
import java.util.Scanner;

//2018-09-11 
// 체감 난이도: 하
public class BaekJoon_6603 {
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = new String();

		while (true) {
			ArrayList<Integer> lists = new ArrayList<Integer>();
			int n=sc.nextInt();
			if(n==0) break;
			for(int i=0;i<n;i++)
				lists.add(sc.nextInt());
		
			Combination(new ArrayList<Integer>(),lists);
			System.out.println();
		}
	}

	public static void Combination(ArrayList<Integer> picked, ArrayList<Integer> last) {
		if (picked.size() < 6) {
			for (int i = 0; i < last.size(); i++) {
				ArrayList<Integer> newPicked = new ArrayList<Integer>(picked);
				ArrayList<Integer> newLast = new ArrayList<Integer>(last);
				newPicked.add(last.get(i));
				for(int j=0;j<=i;j++)
					newLast.remove(0);
				Combination(newPicked,newLast);
			}
		} else {
			for(int i=0;i<picked.size();i++)
				System.out.print(picked.get(i)+" ");
			System.out.println();
		}
	}

}
