import java.io.*;
import java.util.*;

public class Solution {
	static class Cord {
		int y;
		int x;

		Cord(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int n, ans, tasteMin, tasteMax;
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] cheeseMap;
	static Queue<Cord> que = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			n = Integer.parseInt(br.readLine());
			init();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					tasteMin = Math.min(tasteMin, map[i][j]);
					tasteMax = Math.max(tasteMax, map[i][j]);
				}
			}
			
			for (int taste = tasteMin; taste <= tasteMax; taste++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (map[i][j] == taste) {
							cheeseMap[i][j] = true;
						}
					}
				}

				boolean[][] cheeseBFSMap = new boolean[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						cheeseBFSMap[i][j] = cheeseMap[i][j];
					}
				}

				int cnt = 0;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (cheeseBFSMap[i][j]) {
							continue;
						}
						que.offer(new Cord(i, j));
						cheeseBFSMap[i][j] = true;
						while (!que.isEmpty()) {
							Cord cur = que.poll();
							int curY = cur.y, curX = cur.x;
							for (int r = 0; r < 4; r++) {
								int nextY = curY + dy[r], nextX = curX + dx[r];
								if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || cheeseBFSMap[nextY][nextX]) {
									continue;
								}
								que.offer(new Cord(nextY, nextX));
								cheeseBFSMap[nextY][nextX] = true;
							}
						}
						cnt++;
					}
				}
				ans = Math.max(ans, cnt);
			}
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static void init() {
		map = new int[n][n];
		cheeseMap = new boolean[n][n];
		tasteMin = 101;
		tasteMax = 0;
		ans = 1;
	}
}
