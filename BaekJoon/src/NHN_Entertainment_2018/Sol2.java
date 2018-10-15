package NHN_Entertainment_2018;

import java.util.Scanner;

public class Sol2 {
	static int N;
	static int W;
	static String mat[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		N = Integer.parseInt(s.split(" ")[0]);
		W = Integer.parseInt(s.split(" ")[1]);
		mat = new String[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			String splits[] = str.split(" ");
			for (int j = 0; j < N; j++) {
				mat[i][j] = splits[j];
			}
		}
		//layer 바깥쪽에서 안으로 0,1,2,...
		for(int layer=0;layer<N/2;layer++){
			Rotate(layer);
			
		}
		print(mat);
	}

	static void print(String mat[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void Rotate(int layer){
		int n=N-2*layer;
		int w;
		int nP= 4*n-4;
		if(nP<4)
			return;
		if(layer%2==0){
			//정방향
			w= W%nP;
			
		} else{
			//반대방향
			w= (-W) % nP;
		}
		String arr[]=new String[nP];
		int arr_i=0;
		
		int l=layer;
		int h=N-1-layer;
		
		for(int col=l;col<=h;col++)
			arr[arr_i++]=mat[l][col];
		for(int low=l+1;low<=h;low++)
			arr[arr_i++]=mat[low][h];
		for(int col=h-1;col>=l;col--)
			arr[arr_i++]=mat[h][col];
		for(int low=h-1;low>l;low--)
			arr[arr_i++]=mat[low][l];
		
		String arr_new[]=new String[nP];
		for(int i=0;i<nP;i++)
			arr_new[ (i+nP+w)%nP]=arr[i];
	
		arr_i=0;
		for(int col=l;col<=h;col++)
			mat[l][col]=arr_new[arr_i++];
		for(int low=l+1;low<=h;low++)
			mat[low][h]=arr_new[arr_i++];
		for(int col=h-1;col>=l;col--)
			mat[h][col]=arr_new[arr_i++];
		for(int low=h-1;low>l;low--)
			mat[low][l]=arr_new[arr_i++];
		
		
	}
}
