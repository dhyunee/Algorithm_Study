package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1189_컴백홈 {
	
	static int R,C,K;
	static char [][]map;
	static int []dx= {0,1,-1,0};
	static int []dy= {1,0,0,-1};
	static boolean [][]visit;
	static int answer=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		map=new char[R][C];
		visit=new boolean[R][C];
		
		for(int i=0;i<R;i++) {
			map[i]=br.readLine().toCharArray();
			Arrays.fill(visit[i], false);
			
		}
		visit[R-1][0]=true;
		cal(R-1,0,1);
		
		System.out.println(answer);
	}
	
	static void cal(int y,int x,int cnt) {
		if(y==0&&x==C-1) {
			if(cnt==K)answer++;
			return ;
		}
		
		if(cnt>K)return ;
		
		for(int i=0;i<4;i++) {
			int ny=y+dy[i];
			int nx=x+dx[i];
			
			if(ny<0||nx<0||ny>=R||nx>=C||map[ny][nx]=='T'||visit[ny][nx]) {
				continue;
			}
			
			visit[ny][nx]=true;
			cal(ny,nx,cnt+1);
			visit[ny][nx]=false;
		}
	}
}
