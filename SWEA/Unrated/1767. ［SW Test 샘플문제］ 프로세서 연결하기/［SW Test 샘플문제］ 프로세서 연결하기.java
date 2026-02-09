import java.io.*;
import java.util.*;

public class Solution {
	static int t, n, ans, coreCordSize, maxCoreCnt;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] map;
	static int[][] coreCord = new int[12][2];
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			init();
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						visited[i][j] = true;
						if (i != 0 && j != 0 && i != n - 1 && j != n - 1) {
							coreCord[coreCordSize][0] = i;
							coreCord[coreCordSize++][1] = j;
						}
					}
				}
			}

			backTracking(0, 0, 0);
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);

	}

	static void backTracking(int depth, int coreCnt, int powerLength) {
		if (depth == coreCordSize) {
			if (coreCnt == maxCoreCnt) {
				ans = Math.min(ans, powerLength);
			}else if(coreCnt > maxCoreCnt) {
				maxCoreCnt = coreCnt;
				ans = powerLength;
			}
			return;
		}
		int curY = coreCord[depth][0], curX = coreCord[depth][1];
		for (int i = 0; i < 4; i++) {
			boolean pos = check(curY, curX, dy[i],dx[i]);
			if (pos) {
				int length = fillVisited(curY, curX, dy[i], dx[i], true);
				backTracking(depth + 1, coreCnt + 1, powerLength + length);
				fillVisited(curY, curX, dy[i], dx[i], false);
			}
		}
		backTracking(depth + 1, coreCnt, powerLength);
	}

	static int fillVisited(int curY, int curX, int dy, int dx, boolean fill) {
		int j=1;
		for (j = 1; j <= n; j++) {
			int nextY = curY + dy * j;
			int nextX = curX + dx * j;
			if (nextY < 0 || nextX < 0 || nextX >= n || nextY >= n) {
				break;
			}
			visited[nextY][nextX] = fill;
		}
		return j-1;
	}
	
	static boolean check(int curY, int curX, int dy, int dx) {
		for (int j = 1; j <= n; j++) {
			int nextY = curY + dy * j;
			int nextX = curX + dx * j;
			if (nextY < 0 || nextX < 0 || nextX >= n || nextY >= n) {
				break;
			}
			if (visited[nextY][nextX]) {
				return false;
			}
		}
		return true;
	}
	
	static void init() {
		ans = 169;
		coreCordSize = 0;
		maxCoreCnt = -1;
	}
}
