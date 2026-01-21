import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Cord{
		int y;
		int x;
		
		Cord(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	static int n,m,ans=0;
	static char[][] mp = new char[601][601];
	static Queue<Cord> que = new LinkedList<>();
	static boolean[][] visited = new boolean[601][601];
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) {
			String temp = br.readLine();
			for(int j=0; j<m; j++) {
				mp[i][j] = temp.charAt(j);
				if(mp[i][j] == 'I') {
					que.offer(new Cord(i,j));
					visited[i][j] = true;
				}
			}	
		}
		while(!que.isEmpty()) {
			Cord temp = que.poll();
			int cur_y = temp.y, cur_x = temp.x;
			if(mp[cur_y][cur_x]=='P') {
				ans++;
			}
			for(int i=0; i<4; i++) {
				int next_y = cur_y+dy[i], next_x = cur_x+dx[i];
				if(next_y<0 || next_x<0 || next_y>=n || next_x>=m || visited[next_y][next_x] || mp[next_y][next_x]=='X') {
					continue;
				}
				que.offer(new Cord(next_y,next_x));
				visited[next_y][next_x] = true;
			}
		}
		
		if(ans==0) {
			bw.write("TT");
		}
		else {
			bw.write(ans+"");
		}
		bw.flush();
	}
}
