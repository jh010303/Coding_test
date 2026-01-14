import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution
{
	static class Pair{
		int y;
		int x;
		int time;
		
		Pair(){
			
		}
		
		Pair(int y, int x, int time){
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}
	
	static int t,n,min=Integer.MAX_VALUE;
	static Queue<Pair> que = new LinkedList<>();
	static int[][] mp = new int[101][101];
	static int[][] visited = new int[101][101];
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			n = Integer.parseInt(br.readLine());
			init();
			for(int i=0; i<n; i++) {
				String temp = br.readLine();
				for(int j=0; j<n; j++) {
					mp[i][j] = temp.charAt(j)-'0';
				}
			}
			
			que.offer(new Pair(0,0,mp[0][0]));
			visited[0][0] = 0;
			while(!que.isEmpty()) {
				Pair cur = que.poll();
				if(cur.y==n-1 && cur.x==n-1) {
					min = Integer.min(cur.time,min);
				}
				for(int i=0; i<4; i++) {
					int next_y = cur.y+dy[i], next_x = cur.x+dx[i];
					if(next_y<0 || next_x<0 || next_y>=n || next_x>=n) {
						continue;
					}
					int next_time = cur.time+mp[next_y][next_x];
					if(next_time<visited[next_y][next_x]) {
						que.offer(new Pair(next_y,next_x,next_time));
						visited[next_y][next_x] = next_time;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+min);
		}
	}
	
	static void init() {
		min = Integer.MAX_VALUE;
		que.clear();
		for(int i=0; i<100; i++) {
			Arrays.fill(visited[i], min);
		}
	}
}