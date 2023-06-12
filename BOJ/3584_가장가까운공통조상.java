package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1039_교환 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		int k = Integer.parseInt(st.nextToken());

		int len = str.length();
		int[] arr = new int[len];
		List<Integer> arrcpy = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			int x = str.charAt(i) - '0';
			arr[i] = x;
			arrcpy.add(x);
		}

		Collections.sort(arrcpy, Collections.reverseOrder());

		
		if (len == 1 || (len == 2 && (arr[0] == 0 || arr[1] == 0))) {
			System.out.println(-1);
			return;
		}

		for (int c = 0; c < k; c++) {
			boolean flag = true;
			int f = 0, l = 0;
			for (int i = 0; i < len; i++) {
				if (arr[i] != arrcpy.get(i)) {
					// System.out.println(arrcpy.get(i));
					f = i;
					flag = false;
					break;
				}
			}
			for (int j = len-1; j >=0; j--) {
				if (arr[j] == arrcpy.get(f)) {
					l = j;
					break;
				}
			}

			if (flag) {
				f = len - 2;
				l = len - 1;
			}
			int tmp = arr[f];
			arr[f] = arr[l];
			arr[l] = tmp;
		}

		for(int a:arr)System.out.print(a);
	}

}
