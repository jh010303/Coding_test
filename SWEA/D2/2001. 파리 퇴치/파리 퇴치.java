import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {	
	static int t,n,m,ans;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			ans = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<=n-m; i++) {
				for(int j=0; j<=n-m; j++) {
					int sum = 0;
					for(int r=i; r<i+m; r++) {
						for(int k=j; k<j+m; k++) {
							sum+=map[r][k];
						}
					}
					ans = Math.max(ans, sum);
				}
			}
			sb.append("#").append(test_case).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);
	}

}
