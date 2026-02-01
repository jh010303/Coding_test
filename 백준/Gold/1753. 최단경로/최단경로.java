import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int num;
		int weight;
		
		public Node(int num, int weight) {
			super();
			this.num = num;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static ArrayList<Node>[] graph;
	static PriorityQueue<Node> que = new PriorityQueue<>();
	static int[] dist;
	static int v,e,k;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        
        init();
        
        for(int i=0; i<e; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	graph[u].add(new Node(v,e));
        }
        
        djikstra(k);    
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=v; i++) {
        	if(dist[i]==INF) {
        		sb.append("INF");
        	}
        	else {
        		sb.append(dist[i]);
        	}
        	sb.append('\n');
        }
        System.out.print(sb);
    }
	
	static void djikstra(int start) {
		dist[start] = 0;
		que.offer(new Node(start,0));
		
		while(!que.isEmpty()) {
			Node cur = que.poll();
			int cur_num = cur.num, cur_weight = cur.weight;
			
			if(dist[cur_num]<cur_weight)continue;
			dist[cur_num] = cur_weight;
			
			for(int i=0; i<graph[cur_num].size(); i++) {
				Node temp = graph[cur_num].get(i);
				int next_weight = temp.weight+cur_weight;
				if(next_weight<dist[temp.num]) {
					que.offer(new Node(temp.num,next_weight));
				}
			}
		}
	}
	
	static void init() {
		graph = new ArrayList[v+1];
		for(int i=1; i<=v; i++) {
			graph[i] = new ArrayList<>();
		}
		dist = new int[v+1];
		Arrays.fill(dist, INF);
	}
}
