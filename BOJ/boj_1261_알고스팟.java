package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1261_알고스팟 {

	static int M,N;
	static int map[][];
	static int cnt[][];
	static boolean v[][];
	static int ans=Integer.MAX_VALUE;
	static int [][]dir= {{0,1},{1,0},{-1,0},{0,-1}};
	
	static class node{
		int y,x,cnt;
		node(int y,int x,int cnt){
			this.y=y;
			this.x=x;
			this.cnt=cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		
		map=new int [N][M];
		cnt=new int [N][M];
		v=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			char[] str=br.readLine().toCharArray();
			Arrays.fill(cnt[i],Integer.MAX_VALUE);
			for(int j=0;j<M;j++) {
				map[i][j]=str[j]-'0';
			}
		}
		
		Dijkstra();
		
		System.out.println(cnt[N-1][M-1]);

	}
	
	static void Dijkstra() {
		
		PriorityQueue<node>pq=new PriorityQueue<>((p1,p2)->p1.cnt-p2.cnt);
		pq.offer(new node(0,0,0));
		v[0][0]=true;
		cnt[0][0]=0;
		
		while(!pq.isEmpty()) {
			node nd=pq.poll();
			
			for(int i=0;i<4;i++) {
				int ny=nd.y+dir[i][0];
				int nx=nd.x+dir[i][1];
				
				if(ny<0||nx<0||ny>=N||nx>=M) {
					continue;
				}
				
				if(cnt[ny][nx]<cnt[nd.y][nd.x])continue;
				
				if(map[ny][nx]==0) {
					if(cnt[ny][nx]>cnt[nd.y][nd.x]) {
						cnt[ny][nx]=cnt[nd.y][nd.x];
						pq.offer(new node(ny,nx,cnt[nd.y][nd.x]));
					}
				}else if(map[ny][nx]==1) {
					if(cnt[ny][nx]>cnt[nd.y][nd.x]+1) {
						cnt[ny][nx]=cnt[nd.y][nd.x]+1;
						pq.offer(new node(ny,nx,cnt[nd.y][nd.x]));
					}
				}
			}
			
		}
		
	}
}
