import java.util.*;
import java.io.*;

class Solution {
	static int[][] hambuk;
	static int ans = 0;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			init();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			hambuk = new int[n][2];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int t = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				hambuk[i][0] = t; hambuk[i][1] = k;
			}
			
			for(int i=0; i<(1<<n); i++) {
				int tasteSum = 0, calSum=0;
				for(int j=0; j<n; j++) {
					if((i & (1<<j))!=0) {
						tasteSum+=hambuk[j][0];
						calSum+=hambuk[j][1];
					}
				}
				if(calSum<l) {
					ans = Math.max(tasteSum, ans);
				}
			}
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
	
	static void init() {
		ans = 1;
	}
}