import java.io.*;
import java.util.*;

public class Main {
	static class Cord{
		int y;
		int x;
		public Cord(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int n,ans = 1;
	static int[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static Queue<Cord> que = new LinkedList<Main.Cord>();
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		int minH = Integer.MAX_VALUE; int maxH = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				minH = Math.min(minH, map[i][j]);
				maxH = Math.max(maxH,map[i][j]);
			}
		}
		
		for(int h=minH; h<=maxH; h++) {
			for(int i=0; i<n; i++) {
				Arrays.fill(visited[i], false);
			}
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visited[i][j] && map[i][j]>h) {
						que.offer(new Cord(i,j));
						visited[i][j] = true;
						while(!que.isEmpty()) {
							Cord cur = que.poll();
							int cy = cur.y; int cx = cur.x;
							for(int r=0; r<4; r++) {
								int ny = cy+dy[r]; int nx = cx+dx[r];
								if(ny<0 || nx<0 || ny>=n || nx>=n || 
										visited[ny][nx] || map[ny][nx]<=h) {
									continue;
								}
								que.offer(new Cord(ny,nx));
								visited[ny][nx] = true;
							}
						}
						cnt++;
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.print(ans);
	}
}