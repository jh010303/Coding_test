import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int n,m;
	static int[] arr;
	static boolean[][] visited = new boolean[10][10001];
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int[] trace = new int[m];
		backTracking(trace,0);
		System.out.print(sb);
	}
	
	static void backTracking(int[] trace, int depth) {
		if(depth==m) {
			for(int i=0; i<depth; i++) {
				sb.append(trace[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visited[depth][arr[i]]) {
				if(depth>0 && trace[depth-1] > arr[i]) continue;
				visited[depth][arr[i]] = true;
				trace[depth] = arr[i];
				backTracking(trace,depth+1);
				for(int j=0; j<10; j++) {
					Arrays.fill(visited[depth+1], false);
				}
				
			}
		}
	}
}
