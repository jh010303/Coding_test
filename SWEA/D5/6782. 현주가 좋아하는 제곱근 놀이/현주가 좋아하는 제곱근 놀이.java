import java.util.*;
import java.io.*;

class Solution {
    static long ans;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
            ans = 0;
			long n = Long.parseLong(br.readLine());
            while(n>2) {
            	long nextPow = (long)Math.pow(Math.ceil(Math.sqrt(n)),2);
            	ans+=(nextPow-n+1);
            	n = (long)Math.sqrt(nextPow);
            }
			
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
}