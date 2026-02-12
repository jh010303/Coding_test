import java.io.*;
import java.util.*;

public class Solution {
	static class Room {
		int y;
		int x;
		int moveCnt;

		public Room(int y, int x, int moveCnt) {
			super();
			this.y = y;
			this.x = x;
			this.moveCnt = moveCnt;
		}
	}

	static int roomAns, cntAns, n;
	static int[][] rooms;
	static int[][] cache;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			init();
			sb.append("#").append(test_case).append(" ");
			n = Integer.parseInt(in.readLine());
			rooms = new int[n][n];
			cache = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < n; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (cache[i][j] > 0)
						continue;
					int cnt = backTracking(i, j);
					if (cnt > cntAns) {
						cntAns = cnt;
						roomAns = rooms[i][j];
					} else if (cnt == cntAns) {
						roomAns = Math.min(roomAns, rooms[i][j]);
					}
				}
			}

			sb.append(roomAns).append(" ").append(cntAns + 1).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int backTracking(int y, int x) {
		for (int r = 0; r < 4; r++) {
			int nextY = y + dy[r], nextX = x + dx[r];
			if (nextY < 0 || nextX < 0 || nextX >= n || nextY >= n)
				continue;
			int curRoomNum = rooms[y][x], nextRoomNum = rooms[nextY][nextX];
			if (nextRoomNum == curRoomNum + 1) {
				cache[y][x] = backTracking(nextY, nextX) + 1;
				break;
			}
		}
		return cache[y][x];
	}

	static void init() {
		roomAns = Integer.MAX_VALUE;
		cntAns = 0;
	}
}
