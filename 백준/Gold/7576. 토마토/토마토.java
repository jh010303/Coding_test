import java.io.*;
import java.util.*;

public class Main {
	static class Cord {
		int y;
		int x;

		public Cord(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static int n, m, ans = 0;
	static short[][] tomatoes;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visited;
	static boolean alreadyRipe = true;
	
	static Queue<Cord> que = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		tomatoes = new short[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				tomatoes[i][j] = Short.parseShort(st.nextToken());
				if (tomatoes[i][j] == 1) {
					que.offer(new Cord(i, j));
				}
				if (tomatoes[i][j] == 0) {
					alreadyRipe = false;
				}
			}
		}

		if (alreadyRipe) {
			que.clear();
		}

		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				Cord cur = que.poll();
				int curY = cur.y, curX = cur.x;
				tomatoes[curY][curX] = 1;
				for (int j = 0; j < 4; j++) {
					int nextY = cur.y + dy[j];
					int nextX = cur.x + dx[j];
					if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m || tomatoes[nextY][nextX] != 0
				|| visited[nextY][nextX])
						continue;
					visited[nextY][nextX] = true;
					que.offer(new Cord(nextY, nextX));
				}
			}
			ans++;
		}

		if (alreadyRipe) {
			System.out.print(0);
		} else if (!isRipe()) {
			System.out.print(-1);
		} else {
			System.out.print(ans - 1);
		}
	}

	static boolean isRipe() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tomatoes[i][j] == 0)
					return false;
			}
		}
		return true;
	}
}
