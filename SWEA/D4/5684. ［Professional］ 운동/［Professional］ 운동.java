import java.util.*;
import java.io.*;

class Solution
{
	static int[][] dist;
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			dist = new int[n+1][n+1];
			for(int i=0; i<n+1; i++) {
				Arrays.fill(dist[i],40000001);
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				dist[s][e] = c;
			}
			
			for(int k=1; k<n+1; k++) {
				for(int i=1; i<n+1; i++) {
					for(int j=1; j<n+1; j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}
			
			int answer = 40000001;
			for(int i=1; i<n+1; i++) {
				answer = Math.min(answer, dist[i][i]);
			}
			
			if(answer==40000001) {
				answer=-1;
			}
			
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb);
	}
}