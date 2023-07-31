package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11054_가장긴바이토닉부분 {

	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		int []right=new int[n];
		int []left=new int[n];
		
		int []arr=new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}


		for(int i=0;i<n;i++) {
			left[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]&&left[i]<=left[j]) {
					left[i]=left[j]+1;
				}
			}
		}
		
		for(int i=n-1;i>=0;i--) {
			right[i]=1;
			for(int j=n-1;j>i;j--) {
				if(arr[j]<arr[i]&&right[i]<=right[j]) {
					right[i]=right[j]+1;
				}
			}
		}
		
		int max=0;
		for(int i=0;i<n;i++) {
			max=Math.max(max, left[i]+right[i]-1);//본인+왼+오
		}
		
		System.out.println(max);
	}

}
