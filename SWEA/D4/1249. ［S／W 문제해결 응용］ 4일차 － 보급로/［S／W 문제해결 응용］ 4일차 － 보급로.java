import java.util.*;
import java.io.*;

class Solution
{
	static class Cord{
		int y;
		int x;
		int w;
		
		public Cord(int y, int x, int w) {
			this.y = y;
			this.x = x;
			this.w = w;
		}
	}
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static int[][] arr;
	static int[][] cache;
	static PriorityQueue<Cord> pq = new PriorityQueue<>((a,b)->{
		return Integer.compare(a.w,b.w);
	});
	
	public static void main(String args[]) throws Exception
	{
        
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{

			int n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			cache = new int[n][n];
			
			for(int i=0; i<n; i++) {
				Arrays.fill(cache[i], Integer.MAX_VALUE);
			}
			
			for(int i=0; i<n; i++) {
				String s = br.readLine();
				for(int j=0; j<n; j++) {
					arr[i][j] = s.charAt(j)-'0';
				}
			}
			
			pq.offer(new Cord(0,0,arr[0][0]));
			
			while(!pq.isEmpty()) {
				Cord cur = pq.poll();
				int cy = cur.y, cx = cur.x, cw = cur.w;
				if(cache[cy][cx]<cw) {
					continue;
				}
				
				for(int i=0; i<4; i++) {
					int ny = cy+dy[i], nx = cx+dx[i];
					if(ny<0 || nx<0 || nx>=n || ny>=n){
						continue;
					}
					
					int nw = cw+arr[ny][nx];
					if(cache[ny][nx] <= nw) {
						continue;
					}
					pq.offer(new Cord(ny,nx,nw));
					cache[ny][nx] = nw;
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(cache[n-1][n-1]).append("\n");
		}
		
		System.out.print(sb);
	}
}