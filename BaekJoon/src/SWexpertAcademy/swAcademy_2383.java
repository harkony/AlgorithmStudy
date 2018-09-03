//2018-8-27

package SWexpertAcademy;

import java.util.ArrayList;
import java.util.Scanner;

public class swAcademy_2383 {
	static ArrayList<Person> personList=new ArrayList<Person>();
	static ArrayList<Stair> stairList=new ArrayList<Stair>();
	static int N;
	static int nP=0;
	static int nC=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		int nP=0;
		int nC=0;
		int nCase=1;
		int minTime=Integer.MAX_VALUE;
		
		for(int loop=0;loop<T;loop++)
		{
			int n=sc.nextInt();
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					int index=sc.nextInt();
					if(index==1)
					{
						personList.add(new Person(i,j,nP++));
					}else if(index>1){
						stairList.add(new Stair(i,j,nC++,index));
					}
				}
			}
			
			System.out.println("nP : "+nP+", nC : "+nC);
			for(int i=0;i<nP;i++)
				nCase*=2;
			
			for(int i=0;i<nCase;i++)
			{
				int time=Process();
				System.out.println("nCase : "+i+" , time: "+time);
				if(time<minTime) minTime=time;
				personList.get(personList.size()-1).nextPosition();
			}
		}
	}
	static class Person{	
		int xpos;
		int ypos;
		int personIndex;
		int destination;
		int distance2stair;
		Person(int xpos,int ypos,int personIndex)
		{
			this.xpos=xpos;
			this.ypos=ypos;
			this.personIndex=personIndex;
			destination=0;
		}
		void nextPosition() {
			destination= (destination+1)%2;
			distance2stair=(Math.abs(stairList.get(destination).xpos-xpos)+Math.abs(stairList.get(destination).ypos-ypos));
			personList.get(personIndex+1).nextPosition();
		}
		void move() {
			if(distance2stair>0) {
				distance2stair-=1;
			} else if(distance2stair==0){
				if(stairList.get(destination).available()) {
					stairList.get(destination).position.add(0);
					distance2stair--;
				}
			}
		}
		
	}
	static class Stair{
		int xpos;
		int ypos;
		int stairIndex;
		int len;
		int complete;
		ArrayList<Integer> position=new ArrayList<Integer>();
		Stair(int xpos,int ypos,int stairIndex,int len){
			this.xpos=xpos;
			this.ypos=ypos;
			this.stairIndex=stairIndex;
			this.len=len;
			this.complete=0;
		}
		boolean available() {
			if(position.size()<3) return true;
			else return false;
		}
		void move() {
			for(int i=0;i<position.size();i++)
			{
				int pos=position.get(i);
				if(pos<len)
					position.set(i,position.get(i)+1);
				else {
					position.remove(i);
					complete+=1;
				}
			}			
		}
		void reset()
		{
			complete=0;
		}
	}
	static int Process() {
		int time=0;
		for(int i=0;i<2;i++)
			stairList.get(i).reset();
		while(stairList.get(0).complete+stairList.get(1).complete<nP)
		{
			for(int i=0;i<nP;i++)
				personList.get(i).move();
			for(int i=0;i<nC;i++)
				stairList.get(i).move();
			time++;
		}
		
		return time;
	}
	
	static void Init() {
		for(int i=0;i<nP;i++)
		{
			Person p=personList.get(i);
			p.distance2stair=Math.abs(p.xpos- stairList.get(p.destination).xpos) +Math.abs(p.ypos- stairList.get(p.destination).ypos);
		}
	}
}
