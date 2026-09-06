import java.util.*;
import java.io.*;

class Solution
{
	static int[] parent;
	static int[][] edge;
	static int count;
	
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parent = new int[n+1];
			edge = new int[m][3];
			count = 0;
			Arrays.fill(parent, -1);
			long answer = 0;
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				edge[i][0] = n1; edge[i][1] = n2; edge[i][2] = v;
			}
			
			Arrays.sort(edge,(a,b)->{
				return Integer.compare(a[2], b[2]);
			});
			
			for(int j=0; j<edge.length; j++) {
				if(count==n-1) {
					break;
				}
				int n1 = edge[j][0], n2 = edge[j][1], v = edge[j][2];
				answer+=union(n1,n2,v);
			}
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static int find(int n) {
		if(parent[n]<0){
			return n;
		}
		return parent[n] = find(parent[n]);
	}
	
	static int union(int n1, int n2, int v) {
		int p1 = find(n1), p2 = find(n2);
		if(p1==p2) {
			return 0;
		}
		parent[p1]+=parent[p2];
		parent[p2]=p1;
		count++;
		return v;
		
	}
}