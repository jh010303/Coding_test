import java.io.*;
import java.util.*;

public class Solution {
	static int n, ans, ascCnt, bef, cur;
	static boolean desc;
	static int[] mountains;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			init();
			n = sc.nextInt();
			mountains = new int[n];
			for (int i = 0; i < n; i++) {
				mountains[i] = sc.nextInt();
			}
			bef = mountains[0];
			for (int i = 1; i < n; i++) {
				cur = mountains[i];
				if (bef < cur) { 
					if(desc) {
						ascCnt=0;
						desc = false;
					}
					ascCnt++;
				} else if (bef > cur) { 
					ans += ascCnt;
					desc =  true;
				}
				bef = mountains[i];
			}
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void init() {
		ans = 0;
		ascCnt = 0;
		desc = true;
		bef = 0;
		cur = 0;
	}
}
