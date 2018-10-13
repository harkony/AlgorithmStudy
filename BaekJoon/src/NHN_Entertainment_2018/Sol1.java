package NHN_Entertainment_2018;

import java.util.ArrayList;
import java.util.Scanner;

public class Sol1 {
	static int C;
	static int N;
	static int P[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C=sc.nextInt();
		N=sc.nextInt();
		P=new int[N];
		 ArrayList<Integer> deck=new ArrayList<Integer>();
		for(int i=1;i<=C;i++)
			deck.add(i);
		for(int i=0;i<N;i++)
			P[i]=sc.nextInt();
		for(int i=0;i<N;i++)
			deck=shuffle(deck,P[i]);
		for(int i=0;i<5;i++){
			System.out.println(deck.get(i));
		}
		
		
	}
	public static ArrayList<Integer> shuffle(ArrayList<Integer> deck,int p){
		if(deck.size()>2*p){
			ArrayList<Integer> mid=new ArrayList<Integer>(deck.subList(p, deck.size()-p));
			ArrayList<Integer> end=new ArrayList<Integer>(deck.subList(0, p));
			end.addAll(deck.subList(deck.size()-p, deck.size()));			
			
			ArrayList<Integer> shuffled=shuffle(mid,p);
			shuffled.addAll(end);
			return shuffled;
		} else{
			return deck;
		}
	}

}
