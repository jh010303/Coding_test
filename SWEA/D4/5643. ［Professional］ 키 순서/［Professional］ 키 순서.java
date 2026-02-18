import java.io.*;
import java.util.*;

public class Solution {
	static int n, m, ans;
	static boolean[][] students;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			students = new boolean[n+1][n+1];
			init();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				students[a][b] = true;
			}

			
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					for(int r=1; r<=n; r++) {
						if(j==r)continue;
						students[j][r] = (students[j][r] || (students[j][i] && students[i][r]));
					}
				}
			}

			for(int i=1; i<=n; i++) {
				boolean success = true;
				for(int j=1; j<=n; j++) {
					if(i==j)continue;
					if(students[i][j]==false && students[j][i] == false) {
						success = false;
						break;
					}
				}
				if(success) {
					ans++;
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static void init() {
		ans = 0;
		for(int i=0; i<n+1; i++) {
			Arrays.fill(students[i], false);
		}
	}
}
