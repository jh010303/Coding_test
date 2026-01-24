import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n,ans=1;
	static List<Integer> fruits = new ArrayList<>();
	static HashMap<Integer,Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n  = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			fruits.add(Integer.parseInt(st.nextToken()));
		}
		
		int s=0, e=s+1;
		map.put(fruits.get(s), 1);
		while(e<n) {
			int end_key = fruits.get(e);
			map.put(end_key, map.getOrDefault(end_key, 0)+1);
			while(map.size()>2) {
				int start_key = fruits.get(s);
				map.put(start_key, map.get(start_key)-1);
				if(map.get(start_key)<=0) {
					map.remove(start_key);
				}
				s++;
			}
			ans = Math.max(ans, e-s+1);
			e++;
		}
		bw.write(ans+"");
		bw.flush();
	}
}
