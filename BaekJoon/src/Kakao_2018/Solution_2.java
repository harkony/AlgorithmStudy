package Kakao_2018;
//2018-09-15
//idea
//그냥 계산문제로 풀이하였다

class Solution_2 {
	public static void main(String[] args) {
		int N[]= {5,4};
		int stages[][]= {{2, 1, 2, 6, 2, 4, 3, 3},{4,4,4,4,4}};
		int []ret;
		for(int i=0;i<2;i++)
			ret=solution(N[i],stages[i]);
	}
    public static int[] solution(int N, int[] stages) {
       int [] answer= {};
       // nStages[i]= i단계에 머무르고 있는 사람의 수
       int[] nStages=new int[N+1];
       int[] order=new int[N];
       // rate[i]= i단계의 성공률
       float[] rate=new float[N+1];
       
       for(int i=0;i<stages.length;i++)
       {
           nStages[stages[i]-1]+=1;
       }
       int total=stages.length;
       rate[0]=(float) nStages[0]/total;
       for(int i=1;i<N;i++)
       {
           order[i]=i;
           total-=nStages[i-1];
           rate[i]=(float) nStages[i] / total;
       }
     
       
       for(int i=0;i<N-1;i++)
       {
           for(int j=i+1;j<N;j++)
           {
               if(rate[i]<rate[j] ||(rate[i]==rate[j] && order[i] > order[j])){
                   float temp=rate[i];
                   rate[i]=rate[j];
                   rate[j]=temp;
                   
                   int tmp=order[i];
                   order[i]=order[j];
                   order[j]=tmp;
               }   
           }
       }
      
       
       
       for(int i=0;i<N;i++)
           order[i]++;
       
       
       return answer;
    }
}