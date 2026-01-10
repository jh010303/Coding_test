import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static HashMap<String,Integer> dic_cnt = new HashMap<>();
	static ArrayList<String> dic = new ArrayList<>();
	
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			String temp_dic = br.readLine();
			if(temp_dic.length()>=m) {
				if(dic_cnt.get(temp_dic)==null) {
					dic.add(temp_dic);
				}
				dic_cnt.put(temp_dic, dic_cnt.getOrDefault(temp_dic, 0)+1);
			}
		}
		Collections.sort(dic, (a,b)->{
			if(dic_cnt.get(b)!=dic_cnt.get(a)) {
				return dic_cnt.get(b)-dic_cnt.get(a);
			}
			else if(a.length()!=b.length()) {
				return b.length()-a.length();
			}
			else {
				return a.compareTo(b);
			}
		});
		for(String d:dic) {
			bw.write(d);
			bw.newLine();
		}
		bw.close();
	}
}
