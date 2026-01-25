import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static boolean[][] graph = new boolean[501][501];
	static int ans, t;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			init();
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a][b] = true;
			}
			for (int i = 1; i <= n; i++) {
				graph[i][i] = true;
			}
			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						graph[i][j] = graph[i][j] || (graph[i][k] && graph[k][j]);
					}
				}
			}
			for (int i = 1; i <= n; i++) {
				int cnt = 0;
				for (int j = 1; j <= n; j++) {
					if (graph[i][j]) {
						cnt++;
					}
					if (graph[j][i]) {
						cnt++;
					}
				}

				if (cnt == n + 1) {
					ans++;
				}

			}
			bw.write("#"+test_case+" "+ans);
			bw.newLine();
			bw.flush();
		}
	}

	static void init() {
		ans = 0;
		for (int i = 0; i < 501; i++) {
			for (int j = 0; j < 501; j++) {
				Arrays.fill(graph[i], false);
			}
		}
	}

}
