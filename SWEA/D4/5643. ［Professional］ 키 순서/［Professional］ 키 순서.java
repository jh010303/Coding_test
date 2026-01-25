import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int t,n,m,ans;
	static ArrayList<ArrayList<Integer>> bigger = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> shorter = new ArrayList<ArrayList<Integer>>();
	static boolean biggerVisited[] = new boolean[501];
	static boolean shorterVisited[] = new boolean[501];
	static Set<Integer> wholeStudents = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=t; test_case++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			init();
			for(int i=0; i<m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				bigger.get(a).add(b);
				shorter.get(b).add(a);
			}
			
			for(int i=1; i<=n; i++) {
				biggerVisited[i] = true;
				biggerDfs(i,i);
				initVisited();
				shorterVisited[i] = true;
				shorterDfs(i,i);
				initVisited();
			}
			
			for(int i=1; i<=n; i++) {
				wholeStudents.add(i);
				for(Integer v: bigger.get(i)) {
					wholeStudents.add(v);
				}
				for(Integer v: shorter.get(i)) {
					wholeStudents.add(v);
				}
				if(wholeStudents.size()==n) {
					ans++;
				}
				wholeStudents.clear();
			}
			bw.write("#"+test_case+" "+ans);
			bw.newLine();
			bw.flush();
		}
	}
	
	static void biggerDfs(int start, int v) {
		int size = bigger.get(v).size();
		for(int i=0; i<size; i++) {
			int nextV = bigger.get(v).get(i);
			if(!biggerVisited[nextV]) {
				biggerVisited[nextV] = true;
				biggerDfs(start, nextV);
				bigger.get(start).add(nextV);
			}
		}
	}
	
	static void shorterDfs(int start, int v) {
		int size = shorter.get(v).size();
		for(int i=0; i<size; i++) {
			int nextV = shorter.get(v).get(i);
			if(!shorterVisited[nextV]) {
				shorterVisited[nextV] = true;
				shorterDfs(start, nextV);
				shorter.get(start).add(nextV);
			}
		}
	}
	
	static void init() {
		bigger.clear();
		shorter.clear();
		for(int i=0; i<=n; i++) {
			bigger.add(new ArrayList<Integer>());
			shorter.add(new ArrayList<Integer>());
		}
		initVisited();
		ans=0;
	}
	
	static void initVisited() {
		for(int i=0; i<501; i++) {
			Arrays.fill(shorterVisited, false);
			Arrays.fill(biggerVisited, false);
		}
	}

}
