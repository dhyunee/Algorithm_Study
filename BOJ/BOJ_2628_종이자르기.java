import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static int C,R,N;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		C=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		
		N=Integer.parseInt(br.readLine());
		
		List<Integer>listR=new ArrayList<>();
		List<Integer>listC=new ArrayList<>();
		
		listR.add(0);
		listR.add(R);
		listC.add(0);
		listC.add(C);
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int d=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			
			switch(d) {
			case 1: 
				listC.add(x);
				break;
			case 0: 
				listR.add(x);
				break;
			}
			
		}
		
		Collections.sort(listC);
		Collections.sort(listR);
		
		int cSize=listC.size()-1;
		int rSize=listR.size()-1;
		
		int []cArr = new int[cSize];
		int []rArr = new int[rSize];
		
		for(int i=1;i<=rSize;i++) {
			rArr[i-1]=listR.get(i)-listR.get(i-1);
		}
		
		for(int i=1;i<=cSize;i++) {
			cArr[i-1]=listC.get(i)-listC.get(i-1);
		}
		
		
		int max=0;
		for(int i=0;i<rSize;i++) {
			for(int j=0;j<cSize;j++) {
				max=Math.max(max, rArr[i]*cArr[j]);
			}
		}
		
		System.out.println(max);
	}

}
