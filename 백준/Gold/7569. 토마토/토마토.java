import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Cord {
		int h;
		int y;
		int x;

		public Cord(int h, int y, int x) {
			super();
			this.h = h;
			this.y = y;
			this.x = x;
		}
	}

	static int m, n, h, day = 0;
	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static int[][][] tomatoes;
	static Queue<Cord> saveCords = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		tomatoes = new int[h][n][m];
		boolean rip = false;
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
					if (tomatoes[i][j][k] == 1) {
						saveCords.offer(new Cord(i, j, k));
					}
					else if(tomatoes[i][j][k] == 0) {
						rip = true;
					}
				}
			}
		}

		if(!rip) {
			day=1;
			saveCords.clear();
		}
		
		while (!saveCords.isEmpty()) {
			int size = saveCords.size();
			for(int i=0; i<size; i++) {
				Cord cur = saveCords.poll();
				for (int j = 0; j< 6; j++) {
					int nextH = cur.h + dh[j];
					int nextY = cur.y + dy[j];
					int nextX = cur.x + dx[j];
					if (nextH < 0 || nextY < 0 || nextX < 0 || nextH >= h || nextY >= n || nextX >= m) {
						continue;
					}
					if (tomatoes[nextH][nextY][nextX] == 0) {
						tomatoes[nextH][nextY][nextX] = 1;
						saveCords.offer(new Cord(nextH,nextY,nextX));
					}
				}
			}
			day++;
		}

		if(isRipe()) {
			System.out.print(day-1);
		}
		else {
			System.out.print(-1);
		}
	}

	static boolean isRipe() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (tomatoes[i][j][k] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
