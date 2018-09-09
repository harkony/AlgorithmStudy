//2018-8-27

package SWexpertAcademy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swAcademy_4411 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i=0;i<T;i++)
		{
			int N=sc.nextInt();
			Double K=sc.nextDouble();
			Queue<Integer> queue = new LinkedList<Integer>();
			for(int j=1;j<=N;j++)
				queue.add(j);
			while(queue.size()>1)
			{
				int new_k=(int) (K%N);
				System.out.println("N : "+N+"new_k : "+new_k);
				for(int loop=0;loop<new_k;loop++)
				{
					queue.add(queue.poll());
				}
				queue.poll();
				N--;
			}
			System.out.println(queue.poll());
		}
	}

}
