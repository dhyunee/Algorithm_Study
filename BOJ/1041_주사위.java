package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1041_주사위 {
	static int N;
	static long answer;
	static int[] dice;
	static int[][] sec = { { 1, 2, 3, 4 }, { 0, 2, 3, 5 }, { 0, 1, 4, 5 }, { 0, 1, 4, 5 }, { 0, 2, 3, 5 },
			{ 1, 2, 3, 4 } };
	static node[][] thd = { { new node(1, 3), new node(1, 2), new node(2, 4), new node(3, 4) },
			{ new node(0, 2), new node(2, 5), new node(3, 5), new node(0, 3) },
			{ new node(0, 4), new node(4, 5), new node(1, 5), new node(0, 1) },
			{ new node(0, 4), new node(4, 5), new node(1, 5), new node(0, 1) },
			{ new node(0, 2), new node(2, 5), new node(3, 5), new node(0, 3) },
			{ new node(1, 3), new node(1, 2), new node(2, 4), new node(3, 4) } };

	static class node {
		int a;
		int b;

		node(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		dice=new int[6];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<6;i++) {
			dice[i]=Integer.parseInt(st.nextToken());
		}
		
		int aspect3=Integer.MAX_VALUE;
		int aspect2=Integer.MAX_VALUE;
		int aspect1=Integer.MAX_VALUE;
		int max=0;
		for(int i=0;i<6;i++) {
			aspect1=Math.min(aspect1, dice[i]);
			max=Math.max(max, dice[i]);
			for(int j=0;j<4;j++) {
				aspect2=Math.min(aspect2, dice[i]+dice[sec[i][j]]);
				aspect3=Math.min(aspect3, dice[i]+dice[thd[i][j].a]+dice[thd[i][j].b]);
			}
		}
		
		answer=0L;
		if(N==1) {
			for(int i=0;i<6;i++)answer+=dice[i];
			answer-=max;
		}else {
			answer+=aspect3*4L;
			answer+=aspect2*(4L*(long)(N-1)+4L*(long)(N-2));
			answer+=aspect1*((long)(N-2)*(long)(N-2)+4*(long)(N-2)*(N-1));
			
			//System.out.println(dice[0]+" "+dice[1]+" "+dice[2]);
		}
		System.out.println(answer);

		
	}

}
