import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution
{

	static int t,n;
	
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String find,str;
		int ans=0,t;
		for(int test_case=1; test_case<=10; test_case++) {
			ans = 0;
			br.readLine();
			find = br.readLine(); str = br.readLine();
			for(int i=0; i<=str.length()-find.length(); i++) {
				if(find.equals(str.substring(i, i+find.length()))) {
					ans++;
				}
			}
			System.out.println("#"+test_case+" "+ans);
		}
	}
}