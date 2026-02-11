import java.io.*;
import java.util.*;

public class Solution {
	static int n,b,ans;
	static int[] height;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			height = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<(1<<n); i++) {
				int sum = 0;
				for(int j=0; j<n; j++) {
					if((i & (1<<j))!=0) {
						sum+=height[j];
					}
				}
				if(sum>=b) {
					ans = Math.min(ans,sum-b);
				}
			}
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
