import java.io.*;
import java.util.*;

public class Main {
	static class Cord implements Comparable<Cord>{
		int n;
		int t;
		
		public Cord(int n, int t) {
			this.n = n;
			this.t = t;
		}
		
		@Override
		public int compareTo(Cord c) {
			return Integer.compare(this.t, c.t);
		}
	}
	
	static int n,k,ans;
	static PriorityQueue<Cord> que = new PriorityQueue<Main.Cord>();
	static int[] minTable;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		minTable = new int[100001];
		Arrays.fill(minTable,100001);
		
		minTable[n] = 0;
		que.offer(new Cord(n,0));
		
		while(!que.isEmpty()) {
			Cord cur = que.poll();
			int curN = cur.n; int curT = cur.t;
			if(minTable[curN]<curT) {
				continue;
			}
			if(curN==k) {
				ans = curT;
				break;
			}
			for(int i=0; i<3; i++) {
				int nextN=0; int nextT=0; 
				if(i==0) {
					nextN = curN*2; nextT = curT; 
				}
				else if(i==1) {
					nextN = curN+1; nextT = curT+1; 
				}
				else {
					nextN = curN-1; nextT = curT+1; 
				}
				if(nextN>100000 || nextN<0 || minTable[nextN]<=nextT) {
					continue;
				}
				minTable[nextN] = nextT;
				que.offer(new Cord(nextN, nextT));
			}
		}
		System.out.print(ans);
	}
}