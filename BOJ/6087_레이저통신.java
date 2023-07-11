import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
 
public class Main {
 
    static int W, H;
    static char map[][];
    static int[][] dist;
    static node start, end;	
    static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
 
    static class node {
        int x, y;
 
        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];
      
        boolean isStart = false;
        
        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                
                if (map[i][j] == 'C') {
             
                    if (!isStart) {
                        start = new node(i, j);
                        isStart = true;
                    } else
                        end = new node(i, j);
                }
            }
        }
 
        cal();
        System.out.println(dist[end.x][end.y] - 1);
    }
 
    private static void cal() {
 
        Queue<node> q = new ArrayDeque<>();
        dist = new int[H][W];
        // 시작점부터 출발
        q.add(start);
 
        while (!q.isEmpty()) {
            node nd = q.poll();
            if(dist[end.x][end.y] != 0) return;
            // 4방 탐색
            for (int d = 0; d < 4; d++) {
                int nx = nd.x + dx[d];
                int ny = nd.y + dy[d];
               
                while (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] != '*') {
                    if (dist[nx][ny] == 0) {
                        dist[nx][ny] = dist[nd.x][nd.y] + 1;
                        q.add(new node(nx, ny));
                    }
                    nx += dx[d];
                    ny += dy[d];
                }
            }
        }
        
        return;
    }
}
