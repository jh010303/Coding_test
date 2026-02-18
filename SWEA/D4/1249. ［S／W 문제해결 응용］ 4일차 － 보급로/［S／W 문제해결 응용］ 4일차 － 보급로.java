import java.io.*;
import java.util.*;

public class Solution {
	static class Cord implements Comparable<Cord> {
		int y;
		int x;
		int t;

		public Cord(int y, int x, int t) {
			super();
			this.y = y;
			this.x = x;
			this.t = t;
		}

		@Override
		public int compareTo(Cord o) {
			return this.t - o.t;
		}
	}

	static int n, ans;
	static int[][] map;
	static int[][] timeTable;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static PriorityQueue<Cord> que = new PriorityQueue<>();

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			init();
			int end = n - 1;
			for (int i = 0; i < n; i++) {
				String temp = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = temp.charAt(j) - '0';
				}
			}

			que.offer(new Cord(0, 0, 0));
			while (!que.isEmpty()) {
				Cord cur = que.poll();
				int curY = cur.y, curX = cur.x, curT = cur.t;
				if (timeTable[curY][curX] <= curT) {
					continue;
				}
				timeTable[curY][curX] = curT;

				for (int i = 0; i < 4; i++) {
					int nextY = curY + dy[i], nextX = curX + dx[i];
					if (nextY < 0 || nextX < 0 || nextX >= n || nextY >= n) {
						continue;
					}
					int nextT = curT + map[nextY][nextX];
					if (nextT >= timeTable[nextY][nextX])
						continue;
					que.offer(new Cord(nextY, nextX, nextT));
				}
			}

			ans = timeTable[end][end];
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static void init() {
		map = new int[n][n];
		timeTable = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(timeTable[i], Integer.MAX_VALUE);
		}
	}
}
