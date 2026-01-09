import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static HashMap<String, String> pwd = new HashMap<>();
	
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			pwd.put(st.nextToken(), st.nextToken());
		}
		
		
		for(int j=0; j<m; j++) {
			String id = br.readLine();
			System.out.println(pwd.get(id));
		}
	}
}
