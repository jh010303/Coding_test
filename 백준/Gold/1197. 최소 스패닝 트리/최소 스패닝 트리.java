import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V;//정점
	static int total;
	static boolean[] visited;
	static int E;//간선 
	static List<Node>[] list;
	static StringBuilder sb = new StringBuilder();

	static class Node implements Comparable<Node>{
		int b; //연결된 정점
		int c; //가중치
		
		Node(int b, int c){
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return this.c-o.c;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[V+1];
		visited = new boolean[V+1];
		
		for(int i=1;i<=V;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
		}
		select(1);
		System.out.println(total);

	}

	public static void select(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		total = 0;
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			int edge = tmp.b;
			int cost = tmp.c;
			
			if(!visited[edge]) {
				visited[edge] = true;
				
				total += cost;
				for(Node l : list[edge]) {
					if(!visited[l.b]) {
						pq.offer(new Node(l.b,l.c));
					}
				}
			}
		}

	}

}