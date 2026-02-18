import java.io.*;
import java.util.*;

public class Solution {
	static int n, k, ans, maxH;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			init();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxH = Math.max(map[i][j], maxH);
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == maxH) {
						visited[i][j] = true;
						backTracking(i, j, false, 0);
						visited[i][j] = false;
					}
				}
			}

			sb.append("#").append(test_case).append(" ").append(ans+1).append("\n");
		}
		System.out.print(sb);
	}

	static void backTracking(int y, int x, boolean cut, int depth) {
		int curH = map[y][x];
		for (int i = 0; i < 4; i++) {
			int nextY = y + dy[i], nextX = x + dx[i];
			if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n || visited[nextY][nextX]) {
				continue;
			}
			int nextH = map[nextY][nextX];
			visited[nextY][nextX] = true;
			if (curH > nextH) {				
				backTracking(nextY, nextX, cut, depth + 1);
			} else {
				if (cut == false) {
					for (int j = 1; j <= k; j++) {
						if (nextH - j < curH) {
							map[nextY][nextX] -= j;
							backTracking(nextY, nextX, true, depth + 1);
							map[nextY][nextX] += j;
							break;
						}
					}
				}
			}
			visited[nextY][nextX] = false;
		}
		ans = Math.max(ans, depth);
	}

	static void init() {
		map = new int[n][n];
		visited = new boolean[n][n];
		ans = -1;
		maxH = -1;
	}
}
