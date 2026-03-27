import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n];
		Arrays.fill(parent, -1);
		
		boolean success = false;
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(find(a)==find(b)) {
				System.out.print(i);
				success = true;
				break;
			}
			else {
				union(a,b);
			}
		}
		if(!success) {
			System.out.print(0);
		}
	}
	
	static int find(int n){
		if(parent[n] < 0) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}
	
	static void union(int a, int b) {
		int parentA = find(a); int parentB = find(b);
		parent[parentA]=parentB;
	}
}