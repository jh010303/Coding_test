import java.io.*;
import java.util.*;

public class Main {
	static class Cord {
		int y;
		int x;
		int m;
		public Cord(int y, int x, int m) {
			this.y = y;
			this.x = x;
			this.m = m;
		}
	}

	static int r, c,ans;
	static char[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			String temp = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
		boolean[] visited = new boolean[26];
		visited[map[0][0]-'A'] = true;
		backTracking(0,0,1,visited);
		
		System.out.print(ans);
	}
	
	static void backTracking(int y, int x, int cnt, boolean[] visited) {
		ans = Math.max(ans, cnt);
		for(int i=0; i<4; i++) {
			int ny = y+dy[i]; int nx = x+dx[i];
			if(ny<0 || nx<0 || ny>=r || nx>=c || visited[map[ny][nx]-'A']) {
				continue;
			}
			visited[map[ny][nx]-'A'] = true;
			backTracking(ny,nx,cnt+1,visited);
			visited[map[ny][nx]-'A'] = false;
		}
	}
	
}