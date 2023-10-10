package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class boj_2494_스택 {
	static class node{
		int idx,val;
		
		node(int idx,int val) {
			this.idx=idx;
			this.val=val;
		}
		
	}
	
	public static void main(String []args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		Stack<node>stack=new Stack<node>();
		
		int n=Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=1;i<n+1;i++) {
			int cur=Integer.parseInt(st.nextToken());
		
			while(!stack.isEmpty()) {
				if(cur>stack.peek().val) {
					stack.pop();
				}else {
					break;
				}
			}
			
			if(stack.isEmpty())sb.append(0).append(' ');
			else sb.append(stack.peek().idx).append(' ');
			
			stack.push(new node(i,cur));
			
		}
		
		System.out.println(sb);
	
	}

}
