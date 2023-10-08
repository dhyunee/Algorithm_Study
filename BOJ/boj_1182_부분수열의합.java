package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1182_부분수열의합 {

	static int n,s,answer;
	static int []arr;
	static int []comb;
	
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		s=Integer.parseInt(st.nextToken());
		
		arr=new int[n];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		answer=0;
		for(int i=1;i<n+1;i++) {
			comb=new int[i];
			cal(i,0,0,0);
		}
		
		
		System.out.println(answer);
	}
	
	static void cal(int k,int c,int a,int sum) {//k 부분수열에서 뽑을 갯수, c 봅을 인덱스, arr에서 인덱스
		//System.out.println(sum);
		if(c==k&&sum==s) {
			answer++;
			return;
		}
		if(c>=k)return ;
		//if(sum>s)return;
		if(a==n)return;
		
		for(int i=a;i<n;i++) {
			comb[c]=arr[i];
			cal(k,c+1,i+1,sum+arr[i]);
		}
	}
}
