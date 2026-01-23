import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution
{
	static class Pair{
		int num;
		int depth;
		
		Pair(){
			
		}

		public Pair(int num, int depth) {
			this.num = num;
			this.depth = depth;
		}
	}
	
	static int t,n,m,ans=1;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited = new boolean[11];
	
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=t; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			init();
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				graph.get(y).add(x);
				graph.get(x).add(y);
			}
			
			for(int i=1; i<=n; i++) {
				if(graph.get(i).size()>0) {
					dfs(new Pair(i,1));
				}
			}	
			bw.write("#"+test_case+" "+ans);
			bw.newLine();
		}
		bw.flush();
	}
	
	static void dfs(Pair pair) {
		int cur_num = pair.num, cur_depth = pair.depth;
		visited[cur_num] = true;
		for(Integer i:graph.get(cur_num)) {
			if(!visited[i]) {
				dfs(new Pair(i,cur_depth+1));
			}
		}
		visited[cur_num] = false;
		ans = Math.max(ans, cur_depth);
	}
	
	static void init() {
		ans=1;
		graph.clear();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0; i<11; i++) {
			Arrays.fill(visited,false);
		}
	}
}