import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int n, m;
	static int[] arr;
	static boolean[] visited = new boolean[9];
	static boolean[][] visited2 = new boolean[9][10001];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int[] trace = new int[9];
		backTracking(trace, 0);
		System.out.print(sb);
	}

	static void backTracking(int[]trace, int depth) {
		if (depth == m) {
			for(int i=0; i<depth; i++) {
				sb.append(trace[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i] && !visited2[depth][arr[i]]) {
				visited[i] = true;
				visited2[depth][arr[i]] = true;
				trace[depth] = arr[i];
				backTracking(trace, depth + 1);
				visited[i] = false;
				Arrays.fill(visited2[depth+1], false);
			}

		}
	}
}
