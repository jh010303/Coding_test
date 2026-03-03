import java.io.*;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Main {
	static class Cord{
		int y;
		int x;
		public Cord(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static boolean escaped = false;
	static int r,c,t=1;
	
	static char[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	static Queue<Cord> fire = new LinkedList<>();
	static Queue<Cord> person = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visited = new boolean[r][c];
		for(int i=0; i<r; i++) {
			String temp = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = temp.charAt(j);
				if(map[i][j]=='F') {
					fire.offer(new Cord(i,j));
				}
				else if(map[i][j]=='J') {
					person.offer(new Cord(i,j));
					visited[i][j] = true;
				}
			}
		}

		while(!person.isEmpty()) {
			
			int fireCnt = fire.size();
			for(int i=0; i<fireCnt; i++) {
				Cord curFire = fire.poll();
				for(int j=0; j<4; j++) {
					int nextY = curFire.y+dy[j];
					int nextX = curFire.x+dx[j];
					if(nextY<0 || nextX<0 || nextY>=r || nextX>=c) {
						continue;
					}
					if(map[nextY][nextX]=='.' || map[nextY][nextX]=='J') {
						map[nextY][nextX]='F';
						fire.offer(new Cord(nextY,nextX));
					}
				}
			}
			
			int personCnt = person.size();
			for(int i=0; i<personCnt; i++) {
				Cord curPerson = person.poll();
				for(int j=0; j<4; j++) {
					int nextY = curPerson.y+dy[j];
					int nextX = curPerson.x+dx[j];
					if(nextY<0 || nextX<0 || nextY>=r || nextX>=c) {
						escaped = true;
						break;
					}
					if(map[nextY][nextX]=='.' && !visited[nextY][nextX]) {
						map[nextY][nextX] = 'J';
						person.offer(new Cord(nextY,nextX));
						visited[nextY][nextX] = true;
					}
				}
				if(escaped)break;
			}
			if(escaped)break;

			t++;
		}
		
		if(escaped) {
			System.out.print(t);
		}
		else {
			System.out.print("IMPOSSIBLE");
		}
	}
}