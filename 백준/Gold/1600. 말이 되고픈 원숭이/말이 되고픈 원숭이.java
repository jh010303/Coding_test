import java.io.*;
import java.util.*;

public class Main {
	static class Cord{
		int y;
		int x;
		int m; // 움직임 횟수
		int a; // 특별 동작 횟수
		public Cord(int y, int x, int m, int a) {
			super();
			this.y = y;
			this.x = x;
			this.m = m;
			this.a = a;
		}
	}
	static int k,w,h,ans = Integer.MAX_VALUE;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[] sdx = {1,2,2,1,-1,-2,-2,-1};
	static int[] sdy = {-2,-1,1,2,2,1,-1,-2};
	static int[][] map;
	static boolean[][][] visited;
	static Queue<Cord> que = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		visited = new boolean[h][w][k+1];
		
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		que.offer(new Cord(0,0,0,0));
		while(!que.isEmpty()) {
			Cord cur = que.poll();
			int cy = cur.y; int cx = cur.x; int cm = cur.m; int ca = cur.a;
			if(cy==h-1 && cx==w-1) {
				ans = Math.min(ans, cm);
			}
			// 특별 움직임
			if(ca<k) {
				for(int i=0; i<8; i++) {
					int ny = cy+sdy[i]; int nx = cx+sdx[i]; int nm = cm+1; int na=ca+1;
					if(ny<0 || nx<0 || ny>=h || nx>=w || 
							visited[ny][nx][na] || map[ny][nx]==1) {
						continue;
					}
					que.offer(new Cord(ny,nx,nm,na));
					visited[ny][nx][na] = true;
				}
			}
		
			// 일반 움직임
			for(int i=0; i<4; i++) {
				int ny = cy+dy[i]; int nx = cx+dx[i]; int nm = cm+1;
				if(ny<0 || nx<0 || ny>=h || nx>=w || 
						visited[ny][nx][ca] || map[ny][nx]==1) {
					continue;
				}
				que.offer(new Cord(ny,nx,nm,ca));
				visited[ny][nx][ca] = true;
			}			
		}
		
		ans = ans==Integer.MAX_VALUE?-1:ans;
		System.out.print(ans);
	}
}