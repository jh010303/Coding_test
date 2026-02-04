import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int t, win = 0;
	static final int total = 362880;
	static boolean[] visited = new boolean[9];
	static boolean[] visited2 = new boolean[19];

	static int[] cards1 = new int[9];
	static int[] cards2 = new int[9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();

		t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			init();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				cards1[i] = Integer.parseInt(st.nextToken());
				visited2[cards1[i]] = true;
			}

			int tempIndex = 0;
			for (int i = 0; i < 18; i++) {
				if (!visited2[i + 1]) {
					cards2[tempIndex++] = i + 1;
				}
			}

			backTracking(0, 0, 0);
			int lose = total - win;
			sb.append("#").append(test_case).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}

	static void backTracking(int score1, int score2, int depth) {
		if (depth >= 9) {
			if (score1 >= score2) {
				win++;
			}
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				if (cards1[depth] > cards2[i]) {
					visited[i] = true;
					backTracking(score1 + cards1[depth]+cards2[i], score2, depth + 1);
					visited[i] = false;
				} else if (cards1[depth] < cards2[i]) {
					visited[i] = true;
					backTracking(score1, score2 + cards1[depth]+cards2[i], depth + 1);
					visited[i] = false;
				} else {
					visited[i] = true;
					backTracking(score1, score2, depth + 1);
					visited[i] = false;
				}
			}
		}
		return;
	}

	static void init() {
		Arrays.fill(visited, false);
		Arrays.fill(visited2, false);
		win = 0;
	}
}
