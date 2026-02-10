import java.io.*;
import java.util.*;

public class Solution {
	static int t, n, ans = 0;
	static int[][] chess;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			init();
			n = Integer.parseInt(br.readLine());
			chess = new int[n][n];
			visited = new boolean[n];
			backTracking(0, 0);
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);

	}

	static void backTracking(int queenCnt, int depth) {
		if (depth == n) {
			if (queenCnt == n) {
				ans++;
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if (chess[depth][i]==0 && !visited[i]) {
				visited[i] = true;
				fillBoolean(depth, i, 1);
				backTracking(queenCnt + 1, depth + 1);
				fillBoolean(depth, i, -1);
				visited[i] = false;
			}
		}
	}

	static void fillBoolean(int y, int x, int fill) {
		for (int i = 1; i < n; i++) {
			int newY = y+i, newX = x-i;
			if(newY>=n || newX<0) {
				break;
			}
			chess[newY][newX]+=fill;		
		}
		
		for (int i = 1; i < n; i++) {
			int newY = y+i, newX = x+i;
			if(newY>=n || newX>=n) {
				break;
			}
			chess[newY][newX]+=fill;				
		}
	}

	static void init() {
		ans = 0;
	}
}
