import java.util.*;
import java.io.*;

class Solution {
	static int t, ans;
	static int[] cache = new int[100000];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			String n = br.readLine();
			ans = backTracking(n);
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static int backTracking(String n) {
		int num = Integer.parseInt(n), size = n.length();

		if (num < 10) {
			return 0;
		}
		
		if(cache[num]>0) {
			return cache[num];
		}

		for (int i = (1 << size - 1) - 1; i >= 1; i--) {
			int temp = 1, start = 0;
			for (int j = 0; j < size - 1; j++) {
				if ((i & (1 << j)) > 0) {
					temp *= Integer.parseInt(n.substring(start, j + 1));
					start = j + 1;
				}
			}
			temp *= Integer.parseInt(n.substring(start));
			cache[num] = Math.max(cache[num], backTracking(String.valueOf(temp))+1);
		}
		
		return cache[num];
	}
}