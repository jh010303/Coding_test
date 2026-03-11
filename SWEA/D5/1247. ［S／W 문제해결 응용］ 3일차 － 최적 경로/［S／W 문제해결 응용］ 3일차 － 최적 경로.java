import java.util.*;
import java.io.*;

public class Solution {
	static class Cord{
		int x;
		int y;
		public Cord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static Cord[] customers;
	static Cord company = new Cord(0,0);
	static Cord house = new Cord(0,0);
	static boolean[] visited;
	static int n,answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=t; test_case++) {
			n = Integer.parseInt(br.readLine());
			answer=Integer.MAX_VALUE;
			customers = new Cord[n];
			visited = new boolean[n];
			st = new StringTokenizer(br.readLine());
			company.x = Integer.parseInt(st.nextToken());
			company.y = Integer.parseInt(st.nextToken());
			house.x = Integer.parseInt(st.nextToken());
			house.y = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<n; i++) {
				customers[i] = new Cord(0,0);
				customers[i].x = Integer.parseInt(st.nextToken());
				customers[i].y = Integer.parseInt(st.nextToken());
			}
			
			
			backTracking(company, 0,0);
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
	
	static void backTracking(Cord cur, int distance, int cnt) {
		int curY = cur.y; int curX = cur.x;
		if(cnt==n) {
			distance+=(Math.abs(house.y-curY)+Math.abs(house.x-curX));
			answer = Math.min(answer,distance);
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i]=true;
				Cord next = customers[i];
				backTracking(next,distance+Math.abs(next.y-curY)+Math.abs(next.x-curX),cnt+1);
				visited[i]=false;
			}
		}
	}
}
