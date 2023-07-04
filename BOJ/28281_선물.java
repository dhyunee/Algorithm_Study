package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_28281 {
	static int N,X;
	static int []arr;
	public static void main(String []args)throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		
		arr=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int min=arr[0]+arr[1];
		for(int i=1;i<N-1;i++) {
			min=Math.min(min, arr[i]+arr[i+1]);
		}
		
		min*=X;
		
		System.out.println(min);
	}

}
