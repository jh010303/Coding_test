import java.io.*;
import java.util.*;

public class Main {
	static class Cord {
		int y;
		int x;
		int d; // 이동한 거리 Cord에서만 씀

		public Cord() {

		}

		public Cord(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}

	static class Fish extends Cord implements Comparable<Fish> {
		int s; // fish 크기
		int d; // shark와 거리

		public Fish(int y, int x, int s, int d) {
			this.y = y;
			this.x = x;
			this.s = s;
			this.d = d;
		}

		@Override
		public int compareTo(Fish f) {
			// TODO Auto-generated method stub
			if (this.d != f.d) {
				return Integer.compare(this.d, f.d);
			} else if (this.y != f.y) {
				return Integer.compare(this.y, f.y);
			}
			return Integer.compare(this.x, f.x);
		}
	}

	static class Shark extends Cord {
		int s; // shark 크기
		int e; // 먹은 물고기 개수

		public Shark(int y, int x, int s, int e) {
			this.y = y;
			this.x = x;
			this.s = s;
			this.e = e;
		}

		public void eat() {
			e++;
			if (s == e) {
				s++;
				e = 0;
			}
		}

	}

	static int n, time;
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visited;
	static Queue<Cord> que = new LinkedList<>();
	static List<Fish> fishList = new ArrayList<>();
	static Shark shark;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				int temp = map[i][j];
				if (temp >= 1 && temp <= 6) { // 물고기
					fishList.add(new Fish(i, j, temp, 401));
				} else if (temp == 9) {
					map[i][j]=0;
					shark = new Shark(i, j, 2, 0);
				}
			}
		}

		boolean ate = false;
		do {
			ate = false;
			// 1. 상어와 물고기의 거리 구하기, 먹을 수 있는 물고기의 거리만 구함
			getFishSharkDistance();

			// 2. 우선순위에 따라 물고기 배열 정렬
			Collections.sort(fishList);

			// 3. 가장 우선순위가 높은 물고기 먹기, 지도에 반영
			for (int i = 0; i < fishList.size(); i++) {
				Fish ateFish = fishList.get(i);
				if (shark.s > ateFish.s && ateFish.d<401) {
					time += ateFish.d;
					int ateFishY = ateFish.y;
					int ateFishX = ateFish.x;
					shark.eat();
					map[ateFishY][ateFishX] = 0;
					shark.y = ateFishY;
					shark.x = ateFishX;
					fishList.remove(i);
					ate = true;
					break;
				}
			}

			// 4. 물고기와 shark의 거리를 무한대로 지정
			for (int i = 0; i < fishList.size(); i++) {
				fishList.get(i).d = 401;
			}
		} while (ate);

		System.out.print(time);
	}

	static void getFishSharkDistance() {
		for (int i = 0; i < fishList.size(); i++) {
			initVisited();
			Fish targetFish = fishList.get(i);
			int ty = targetFish.y;
			int tx = targetFish.x;
			if (map[ty][tx] < shark.s) {
				visited[shark.y][shark.x] = true;
				que.offer(new Cord(shark.y, shark.x, 0));
				while (!que.isEmpty()) {
					Cord cur = que.poll();
					int cy = cur.y;
					int cx = cur.x;
					int cd = cur.d;
					if (cy == ty && cx == tx) {
						targetFish.d = cd;
						que.clear();
						break;
					}
					for (int j = 0; j < 4; j++) {
						int ny = cy + dy[j];
						int nx = cx + dx[j];
						int nd = cd + 1;
						if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] || shark.s < map[ny][nx]) {
							continue;
						}
						visited[ny][nx] = true;
						que.offer(new Cord(ny, nx, nd));
					}
				}
			}
		}
	}

	static void initVisited() {
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], false);
		}
	}
}