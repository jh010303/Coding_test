import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static Set<String> set = new HashSet<>();
	static String[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
	
		for(int i=0; i<n; i++) {
			set.add(br.readLine());
		}
		
		list = set.toArray(new String[0]);
		
		Arrays.sort(list,(a,b)->{
			if(a.length()!=b.length()) {
				return a.length()-b.length();
			}
			return a.compareTo(b);
		});
		
		for(int i=0; i<list.length; i++) {
			System.out.println(list[i]);
		}
	}
}