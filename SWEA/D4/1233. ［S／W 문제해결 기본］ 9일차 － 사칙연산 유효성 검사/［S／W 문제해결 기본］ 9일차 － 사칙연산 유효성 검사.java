import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static boolean child=false, success = true;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		for (int test_case = 1; test_case <= 10; test_case++) {
			n = Integer.parseInt(br.readLine());
			child = false; success = true;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				String alpha = st.nextToken();
				if(child && (st.hasMoreTokens() || (alpha.equals("+") || alpha.equals("-") ||
						alpha.equals("*") || alpha.equals("/")))) {
					if(st.hasMoreTokens()) {
						while(st.hasMoreTokens())
							st.nextToken(); 
					}
					success = false;
					continue;
				}
				if(st.hasMoreTokens() && !(alpha.equals("+") || alpha.equals("-") ||
						alpha.equals("*") || alpha.equals("/"))) {
					while(st.hasMoreTokens())
						st.nextToken(); 
					
					success = false;
					continue;
				}
				if(!st.hasMoreTokens() && !(alpha.equals("+") || alpha.equals("-") ||
						alpha.equals("*") || alpha.equals("/"))) {
					child = true;
				}
			}
			if(success) {
				sb.append("#").append(test_case).append(" ").append("1").append("\n");
			}
			else {
				sb.append("#").append(test_case).append(" ").append("0").append("\n");
			}
		}

		System.out.println(sb);
	}
}
