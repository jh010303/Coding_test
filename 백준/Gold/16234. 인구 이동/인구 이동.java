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
	
	static int n,l,r;
	static int[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	static Queue<Cord> que = new LinkedList<>();
	static Queue<Cord> unionQ = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		boolean move = false;
		
		do {
			move = false;
			init();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visited[i][j]) {
						visited[i][j] = true;
						Cord temp = new Cord(i,j);
						que.offer(temp);
						unionQ.offer(temp);
						int sum = map[i][j]; int cnt = 1;
						while(!que.isEmpty()) {
							Cord cur = que.poll();
							int cy = cur.y; int cx = cur.x; int cw = map[cy][cx];
							for(int t=0; t<4; t++) {
								int ny = cy+dy[t]; int nx = cx+dx[t];
								if(ny<0 || nx<0 || ny>=n || nx>=n || visited[ny][nx]) {
									continue;
								}
								int nw = map[ny][nx];
								if(l<=Math.abs(cw-nw) && Math.abs(cw-nw)<=r) {
									visited[ny][nx] = true;
									Cord next = new Cord(ny,nx);
									que.offer(next);
									unionQ.offer(next);
									sum+=map[ny][nx];
									cnt++;
								}
							}
						}
						if(cnt==1) { // 움직이지 않았다는 것
							unionQ.clear();
						}
						else {	// 움직였다는 것		
							
							int newP = sum/cnt;
							move = true;
							while(!unionQ.isEmpty()) {
								Cord cur = unionQ.poll();
								map[cur.y][cur.x] = newP;
							}
						}
					}
				}
			}
			if(move) {
				day++;
			}
		}
		while(move);

		System.out.print(day);
	}
	
	static void init() {
		for(int i=0; i<n; i++) {
			Arrays.fill(visited[i], false);
		}
	}
	
}