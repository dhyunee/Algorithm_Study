package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11055 {

	 static class xy implements Comparable<xy>{
		int x,y;

		xy(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(xy nxy) {
			if(nxy.x>x) {
				return 1;
			}else if(nxy.x<x) {
				return -1;
			}else {
				if(nxy.y>y) {
					return 1;
				}else if(nxy.y<y) {
					return -1;
				}
				return 0;
			}
		}
	
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int n;
		n=Integer.parseInt(br.readLine());

		int[] arr=new int [n];
		int []dp=new int[n];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int a=Integer.parseInt(st.nextToken());
			dp[i]=a;
			arr[i]=a;
		}
		
		int ans=dp[0];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {
					dp[i]=Math.max(dp[j]+arr[i],dp[i]);
					ans=Math.max(ans, dp[i]);
				}
			}
		}
			
		System.out.println(ans);
		
	}

}
