import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution
{
	static int n,y,x;
	static String s;
	static ArrayList<String> cryptogram = new ArrayList<>();
	
	public static void main(String args[]) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int test_case=1; test_case<=10; test_case++) {
			cryptogram.clear(); 
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				cryptogram.add(st.nextToken());
			}
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				st.nextToken();
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				for(int j=x; j<x+y; j++) {
					cryptogram.add(j, st.nextToken());
				}
			}
			
			System.out.print("#"+test_case+" ");
			for(int i=0; i<cryptogram.size(); i++) {
				if(i<10) {
					System.out.print(cryptogram.get(i)+" ");
				}
				else break;
			}
			System.out.println();
		}
	}
}