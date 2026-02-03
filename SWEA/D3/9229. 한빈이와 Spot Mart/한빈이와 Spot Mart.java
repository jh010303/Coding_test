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
	static int t,n,m,ans;
	static int[] snacks;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			ans=-1;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			snacks = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(snacks);
			int start = 0, end = n-1;
			while(start<end) {
				int weight = snacks[start]+snacks[end];
				if(weight==m) {
					ans = weight;
					break;
				}else if(weight>m) {
					end--;
				}else {
					ans = Math.max(ans, weight);
					start++;
				}
			}
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);
	}
}
