import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int t, n, k, ans = 0;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			init();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) { // depth
				for (int j = 0; j < n; j++) { // 각 요소 반복
					backTracking(arr[j], j, 1, i);
				}
			}

			sb.append("#").append(test_case).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);
	}

	static void backTracking(int num, int index, int depth, int depthLimit) {
		if (depth >= depthLimit || num>k) {
			if (num == k) {
				ans++;
			}
			return;
		}
		for (int j = 0; j < n; j++) {
			if (j > index) {
				backTracking(num + arr[j], j, depth + 1, depthLimit);
			}
		}
	}

	static void init() {
		arr = new int[n];
		ans = 0;
	}
}
