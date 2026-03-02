import java.io.*;
import java.util.*;

public class Solution {
	static int v,e;
	static int[] entryList;
	static List<Integer> ans = new ArrayList<>();
	static List<List<Integer>> graph = new ArrayList<>();
	static Queue<Integer> que = new LinkedList<>();
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			init();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<e; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				graph.get(s).add(e);
				entryList[e]++;
			}
			
			for(int i=1; i<=v; i++) {
				if(entryList[i]==0) {
					que.offer(i);
					ans.add(i);
				}
			}
			
			while(!que.isEmpty()) {
				int cur = que.poll();
				for(int i=0; i<graph.get(cur).size(); i++) {
					int next = graph.get(cur).get(i);
					entryList[next]--;
					if(entryList[next]==0) {
						que.offer(next);
						ans.add(next);
					}
				}
			}
			
			sb.append("#").append(test_case).append(" ");
			for(int i=0; i<ans.size(); i++) {
				sb.append(ans.get(i)).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void init() {
		entryList = new int[v+1];
		ans.clear();
		graph.clear();
		for(int i=0; i<=v; i++) {
			graph.add(new ArrayList<>());
		}
	}
}