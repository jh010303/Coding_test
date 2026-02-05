import java.io.*;
import java.util.*;

public class Solution {
	static int[][] honey;
	static int[][] dp;
	static int ans, n, m, c;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			init();
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			honey = new int[n][n];
			dp = new int[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					honey[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= n - m; j++) {
					if(dp[i][j]==0) {
						int[] temp = new int[m];
						int tempIndex = 0;
						for (int r = j; r < j+m; r++) {
							temp[tempIndex++] = honey[i][r];
						}
						dp[i][j] = collectLimitHoney(temp, 0, 0, 0);
					}
					for (int p = i; p < n; p++) {
						for (int q = 0; q <= n - m; q++) {
							if (p == i && q < j + m)
								continue;
							if(dp[p][q]==0) {
								int[] temp = new int[m];
								int tempIndex = 0;
								for (int r = q; r < q+m; r++) {
									temp[tempIndex++] = honey[p][r];
								}
								dp[p][q] = collectLimitHoney(temp, 0, 0, 0);
							}
							ans = Math.max(ans, dp[i][j]+dp[p][q]);
						}
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static int collectLimitHoney(int[] arr, int depth, int sum, int sum2) {
		if (sum2 > c) {
			return 0;
		}

		if (depth == m) {
			return sum;
		}

		int ans = Math.max(collectLimitHoney(arr, depth+1, sum, sum2),
				collectLimitHoney(arr, depth+1, sum+(int)Math.pow(arr[depth], 2), sum2+arr[depth]));
		return ans;
	}
	
	static void init() {
		ans = 0;
	}
}
