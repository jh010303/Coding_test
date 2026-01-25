import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, ans, min = Integer.MAX_VALUE;
	static int[][] friends = new int[101][101];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				friends[i][j] = 5001;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a][b] = 1;
			friends[b][a] = 1;
		}

		for (int i = 1; i <= n; i++) {
			friends[i][i] = 1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					friends[i][j] = Integer.min(friends[i][j], friends[i][k] + friends[k][j]);
					friends[j][i] = friends[i][j];
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			int sum = -1;
			for (int j = 1; j <= n; j++) {
				sum += friends[i][j];
			}
			if (sum < min) {
				min = sum;
				ans = i;
			}
		}

		bw.write(ans + "");
		bw.flush();

	}
}
