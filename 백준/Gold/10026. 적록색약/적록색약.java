import java.io.*;
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
	
	static int n,normalArea=0, disableArea=0;
	static char normalColor, disableColor;
	static char[][] normalRGB;
	static char[][] disableRGB;
	static boolean[][] normalVisited;
	static boolean[][] disableVisited;
	static int[] dx = {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static Queue<Cord> normalQue = new ArrayDeque<>();
	static Queue<Cord> normalNextQue = new ArrayDeque<>();
	static Queue<Cord> disableQue = new ArrayDeque<>();
	static Queue<Cord> disableNextQue = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		normalRGB = new char[n][n];
		disableRGB = new char[n][n];
		normalVisited = new boolean[n][n];
		disableVisited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String tempRGB = br.readLine();
			for(int j=0; j<n; j++) {
				char tempc = tempRGB.charAt(j);
				normalRGB[i][j] = tempc;
				disableRGB[i][j] = tempc == 'G' ? 'R':tempc;
			}
		}
		
		normalNextQue.offer(new Cord(0,0));
		disableNextQue.offer(new Cord(0,0));
		
		while(!normalNextQue.isEmpty()) {
			Cord normalStart = normalNextQue.poll();
			int normalStartY = normalStart.y, normalStartX = normalStart.x;
			if(normalVisited[normalStartY][normalStartX])continue;
			normalVisited[normalStartY][normalStartX]=true;
			normalColor = normalRGB[normalStartY][normalStartX];
			normalQue.offer(new Cord(normalStartY,normalStartX));
			
			while(!normalQue.isEmpty()) {
				Cord cur = normalQue.poll();
				int curY = cur.y, curX = cur.x;
				for(int i=0; i<4; i++) {
					int nextY = curY+dy[i], nextX = curX+dx[i];
					if(nextY<0 || nextY>=n || nextX<0 || nextX>=n ||
							normalVisited[nextY][nextX]) continue;
					if(normalRGB[nextY][nextX]!=normalColor) {
						normalNextQue.offer(new Cord(nextY,nextX));
						continue;
					}
					normalVisited[nextY][nextX] = true;
					normalQue.offer(new Cord(nextY,nextX));
				}
			}
			
			normalArea++;
		}
		
		while(!disableNextQue.isEmpty()) {
			Cord disableStart = disableNextQue.poll();
			int disableStartY = disableStart.y, disableStartX = disableStart.x;
			if(disableVisited[disableStartY][disableStartX])continue;
			disableVisited[disableStartY][disableStartX]=true;
			disableColor = disableRGB[disableStartY][disableStartX];
			disableQue.offer(new Cord(disableStartY,disableStartX));
			
			while(!disableQue.isEmpty()) {
				Cord cur = disableQue.poll();
				int curY = cur.y, curX = cur.x;
				for(int i=0; i<4; i++) {
					int nextY = curY+dy[i], nextX = curX+dx[i];
					if(nextY<0 || nextY>=n || nextX<0 || nextX>=n ||
							disableVisited[nextY][nextX]) continue;
					if(disableRGB[nextY][nextX]!=disableColor) {
						disableNextQue.offer(new Cord(nextY,nextX));
						continue;
					}
					disableVisited[nextY][nextX] = true;
					disableQue.offer(new Cord(nextY,nextX));
				}
			}
			
			disableArea++;
		}
		
		System.out.print(normalArea+" "+disableArea);
	}
}
