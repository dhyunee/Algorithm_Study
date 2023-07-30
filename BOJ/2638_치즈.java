package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2638_치즈 {

	static int R,C;
	static int [][] map;
	static boolean[][]out,visit;
	static List<node> list=new ArrayList<>();
	static int answer=0;
	static int [][]dir= {{0,1},{0,-1},{1,0},{-1,0}};
	
	static class node{
		int y,x;
		node(int y,int x){
			this.y=y;
			this.x=x;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		map=new int[R][C];
		out=new boolean[R][C];
		visit=new boolean[R][C];
		
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			Arrays.fill(out[i], false);
			for(int j=0;j<C;j++) {
				int a=Integer.parseInt(st.nextToken());
				map[i][j]=a;
				if(a==1) {
					list.add(new node(i,j));
				}
			}
		}
		
		//입력 완
		
		//치즈 안 구멍인지 치즈 밖 구멍인지
		bfs();
		
		cal();
		
		System.out.println(answer);
		
	}
	
	static void bfs() {
		Queue<node>q=new ArrayDeque<>();
		q.add(new node(0,0));
		out[0][0]=true;
		
		for(int i=0;i<R;i++)Arrays.fill(visit[i], false);
		
		visit[0][0]=true;
		
		while(!q.isEmpty()) {
			node nd=q.poll();

			for(int i=0;i<4;i++) {
				int ny=nd.y+dir[i][0];
				int nx=nd.x+dir[i][1];
				
				if(ny<0||ny>=R||nx<0||nx>=C||visit[ny][nx]||map[ny][nx]!=0)
					continue;
				q.add(new node(ny,nx));
				out[ny][nx]=true;
				visit[ny][nx]=true;
			}
			
		}
	}
	
	static void cal() {
		
		while(list.size()>0) {
			answer++; 
      
			for(int k=list.size()-1;k>=0;k--) {
				 int cnt=0;
				 node nd=list.get(k);
				 
        for(int i=0;i<4;i++) {
					int ny=nd.y+dir[i][0];
					int nx=nd.x+dir[i][1];
					
					if(out[ny][nx])cnt++;
				 }
				 if(cnt>=2) {
					 list.remove(k);
					 map[nd.y][nd.x]=0;
				 }
			 }
			 bfs();
		}
	}

}
