import java.io.*;
import java.util.*;

public class Main {
	static class Cord {
		int y;
		int x;

		public Cord(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int n, m, ans;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] map;
	static boolean[][] visited;
	static Queue<Cord> que = new LinkedList<>();
	static List<Cord> virus = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					Cord curVirus = new Cord(i,j);
					virus.add(curVirus);
					que.offer(curVirus);
					visited[curVirus.y][curVirus.x] = true;
				}
			}
		}

		backTracking(0);

		System.out.println(ans);
	}

	static void backTracking(int depth) {
		if (depth == 3) {
			while (!que.isEmpty()) {
				Cord curVirus = que.poll();
				for (int i = 0; i < 4; i++) {
					int nextY = curVirus.y + dy[i];
					int nextX = curVirus.x + dx[i];
					if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m || visited[nextY][nextX]
							|| map[nextY][nextX] != 0) {
						continue;
					}
					map[nextY][nextX] = 2;
					que.offer(new Cord(nextY, nextX));
					visited[nextY][nextX] = true;
				}
			}
			updateAns();
			initVirus();
		} else { // 3개의 벽 설치
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 0) { // 벽 설치는 무조건 빈 공간에 설치
						map[i][j] = 1;
						backTracking(depth + 1);
						map[i][j] = 0;
					}
				}
			}
		}
	}

	static void updateAns() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					cnt++;
				}
			}
		}
		ans = Math.max(ans, cnt);
	}

	static void initVirus() {
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], false);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]==2) {
					map[i][j] = 0;					
				}
			}
		}
		for (int i = 0; i < virus.size(); i++) {
			Cord curVirus = virus.get(i);
			que.offer(curVirus);
			visited[curVirus.y][curVirus.x] = true;
			map[curVirus.y][curVirus.x] = 2;
		}
	}
}