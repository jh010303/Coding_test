import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int day = 0; // 결과
	static int N;// 세로
	static int M;// 가로
	static int H; // 높이
	static int[][][] tomato; // 토마토
	static Queue<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int flag = 1;
		tomato = new int[H][N][M];
		for (int z = 0; z < H; z++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					tomato[z][i][j] = Integer.parseInt(st.nextToken());
					if (tomato[z][i][j] == 1) {
						q.offer(new int[] { i, j, z });
					} else if (tomato[z][i][j] == 0) {
						flag = 0;
					}
				}
			}
		} // 입력 완료

		if (flag == 1) {
			day = 0;
		} else {
			flag = 0;
			grow();
			for (int z = 0; z < H; z++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (tomato[z][i][j] == 0) {
							flag = 1;
							break;
						}
					}
					if (flag == 1) {
						break;
					}
				}
			}
			if (flag == 1) {
				day = -1;
			}
			else {
				day-=1;
			}
		}
		System.out.println(day);

	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dh = { -1, 1 };

	public static void grow() {

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] tmp = q.poll();
				int x = tmp[0];
				int y = tmp[1];
				int h = tmp[2];
				for (int d = 0; d < 2; d++) {
					int nh = h + dh[d];
					if (nh >= 0 && nh < H && tomato[nh][x][y] == 0) {
						tomato[nh][x][y] = 1;
						q.offer(new int[] {x,y,nh});
					}
				}
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx >= 0 && ny >= 0 && nx < N && ny < M && tomato[h][nx][ny] == 0) {
						tomato[h][nx][ny] = 1;
						q.offer(new int[] {nx,ny,h});
					}
				}
			}
			day++;
		}

	}

}