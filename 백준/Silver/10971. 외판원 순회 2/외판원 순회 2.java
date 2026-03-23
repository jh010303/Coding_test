import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] visited;
	static int[][] map;
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());// 입력된 숫자
		visited = new boolean[N];
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력완료
		visited[0] = true; // 시작 도시
		select(0, 0, 0);
		System.out.println(res);

	}

	public static void select(int idx, int cnt, int start) {
		if (idx == N - 1) {
			if (map[start][0] == 0) {
				return;
			}
			cnt += map[start][0];
			res = Math.min(res, cnt);
			return;
		}
		for (int j = 0; j < N; j++) {
			if (!visited[j] && map[start][j] != 0) {
				visited[j] = true;
				select(idx + 1, cnt + map[start][j], j);
				visited[j] = false;
			}
		}

	}

} 