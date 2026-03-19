import java.io.*;
import java.util.*;

public class Main {
	static class Cord{
		int y;
		int x;
		int t;
		boolean c;
		
		public Cord(int y, int x, int t, boolean c) {
			this.y = y;
			this.x = x;
			this.t = t;
			this.c = c;
		}
	}

	static int n, m, ans = 1000001;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static char[][] map;
	static boolean[][][] visited;
	static Queue<Cord> que = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m][2];
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
		visited[0][0][0] = true;
		que.offer(new Cord(0,0,1,false));
		
		while(!que.isEmpty()) {
			Cord cur = que.poll();
			int cy = cur.y; int cx = cur.x; int ct = cur.t; boolean c = cur.c;
			int crushed = c==false?0:1;
			if(cy==n-1 && cx==m-1) {
				ans = Math.min(ans,ct);
				continue;
			}
			for(int i=0; i<4; i++) {
				int ny = cur.y+dy[i]; int nx = cur.x+dx[i];
				if(nx<0 || ny<0 || nx>=m || ny>=n || visited[ny][nx][crushed]) {
					continue;
				}
				visited[ny][nx][crushed]=true;
				if(map[ny][nx]=='0') {
					que.offer(new Cord(ny,nx,cur.t+1,c));
				}
				else if(c==false && map[ny][nx]=='1') {
					que.offer(new Cord(ny,nx,cur.t+1,true));
				}
			}
		}
		ans = ans==1000001?-1:ans;
		System.out.println(ans);
	}
}