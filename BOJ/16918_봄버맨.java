package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16918_봄버맨 {

	static int R, C, T;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<node> q=new ArrayDeque<>();

	static class node {
		int y, x;

		node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		boolean[][] visit = new boolean[R][C];
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			char[] arr = br.readLine().toCharArray();

			for (int j = 0; j < C; j++) {
				if (arr[j] == 'O') {
					map[i][j] = 1;
					// System.out.println(i+" "+j);
				}
			}
		}

		int cnt = 0;
		// 160000*200:32000000
		while (cnt++ < T) {

			if (cnt % 2 == 0) {
				q = new ArrayDeque<>();

				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						map[i][j]+=2;
						if (map[i][j] > 2) {
							q.add(new node(i, j));
						}
					}
					Arrays.fill(visit[i], false);
				}
			}

			else {
				while (!q.isEmpty()) {
					node nd = q.poll();

					int x = nd.x;
					int y = nd.y;

					map[y][x] = 0;
					visit[y][x] = true;

					for (int k = 0; k < 4; k++) {
						int ny = y + dy[k];
						int nx = x + dx[k];

						if (ny < 0 || nx < 0 || ny >= R || nx >= C || visit[ny][nx]) {
							continue;
						}

						map[ny][nx] = 0;
					}

				}
			}

			cnt++;

		}

		
		for (int i = 0; i < R; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0)
					sb.append('.');
				else
					sb.append('O');
			}
			System.out.println(sb);
		}

	}
}
