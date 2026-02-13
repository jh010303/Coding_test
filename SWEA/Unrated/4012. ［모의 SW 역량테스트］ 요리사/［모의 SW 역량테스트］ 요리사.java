import java.io.*;
import java.util.*;

public class Solution {
	static int[][] ingredient;
	static int[] gred1;
	static int[] gred2;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			init();
			int n = Integer.parseInt(br.readLine());
			ingredient = new int[n][n];
			gred1 = new int[n/2];
			gred2 = new int[n/2];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					ingredient[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < (1 << n); i++) {
				if (Integer.bitCount(i) == n / 2) {
					int gredIndex1 = 0, gredIndex2 = 0;
					Arrays.fill(gred1, 0);
					Arrays.fill(gred2, 0);
					for (int j = 0; j < n; j++) {
						if ((i & (1 << j)) > 0) {
							gred1[gredIndex1++] = j;
						} else {
							gred2[gredIndex2++] = j;
						}
					}
					
					int taste1 = 0, taste2 = 0;
					for (int j = 0; j < n / 2; j++) {
						for (int r = 0; r < n / 2; r++) {
							if (j == r)
								continue;
							taste1 += ingredient[gred1[j]][gred1[r]];
						}
					}
					for (int j = 0; j < n / 2; j++) {
						for (int r = 0; r < n / 2; r++) {
							if (j == r)
								continue;
							taste2 += ingredient[gred2[j]][gred2[r]];
						}
					}
					ans = Math.min(ans, Math.abs(taste1-taste2));
				}
			}
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void init() {
		ans = Integer.MAX_VALUE;
	}

}
