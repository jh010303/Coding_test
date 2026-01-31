import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
    	ArrayList<Integer> trace = new ArrayList<>();
    	boolean[] visited = new boolean[10001];
    	backTracking(trace, visited, 0, 0);
        System.out.println(sb.toString());
    }
	
	static void backTracking(ArrayList<Integer> trace,boolean[] visited, int n, int depth) {
		if(depth==m) {
			for(int i=0; i<trace.size(); i++) {
				sb.append(trace.get(i)+" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!visited[arr[i]]) {
				trace.add(arr[i]);
				visited[arr[i]] = true;
				backTracking(trace, visited, arr[i], depth+1);
				trace.remove(trace.size()-1);
				visited[arr[i]] = false;
			}
		}
	}
}
