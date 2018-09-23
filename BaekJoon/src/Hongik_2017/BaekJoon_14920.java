package Hongik_2017;
import java.util.Arrays;
import java.util.Scanner;

//2018-08-31 
//체감 난이도: 하
public class BaekJoon_14920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long cn=sc.nextInt();
		int n=1;
		while(cn!=1)
		{
			if(cn%2==0)
				cn=cn/2;
			else
				cn=3*cn+1;
			n++;
			
		}
		System.out.println(n);
	}

}
