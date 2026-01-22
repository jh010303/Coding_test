import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static List<Integer> arr = new ArrayList<>();
	static HashMap<Integer, Integer> mp = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		List<Integer> temp = new ArrayList<>(arr);
		Collections.sort(arr);
		for(int i=0; i<arr.size(); i++) {
			int t = arr.get(i);
			if(i==0) {
				mp.put(t, 0);
			}
			else {
				if(mp.get(t)==null) {
					mp.put(t, mp.get(arr.get(i-1))+1);
				}
				else {
					mp.put(t, mp.get(arr.get(i-1)));
				}	
			}
		}
		for(int i=0; i<temp.size(); i++) {
			bw.write(mp.get(temp.get(i))+" ");
		}
		bw.flush();
	}
}
