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
	static String a,b;
	static int t;
	static int[] aList = new int[101];
	static int[] bList = new int[101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			init();
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = st.nextToken(); b= st.nextToken();
			int maxLength = Math.max(a.length(), b.length());
			int aIndex = a.length()-1, bIndex = b.length()-1;
			
			for(int i=maxLength; i>0; i--) {
				if(aIndex<0)break;
				aList[i] = a.charAt(aIndex--)-'0';
			}
			for(int i=maxLength; i>0; i--) {
				if(bIndex<0)break;
				bList[i] = b.charAt(bIndex--)-'0';
			}
			
			for(int i=maxLength; i>0; i--) {
				int temp = aList[i]+bList[i];
				if(a.length()>=b.length()) {
					aList[i] = temp%10;
					if(temp>=10) {
						aList[i-1]++;
					}
				}else {
					bList[i] = temp%10;
					if(temp>=10) {
						bList[i-1]++;
					}
				}
			}
			
			sb.append("#").append(test_case).append(" ");
			for(int i=0; i<=maxLength; i++) {
				if(a.length()>=b.length()) {
					if(i==0 && aList[i]==0)continue;
					sb.append(aList[i]);
				}else {
					if(i==0 && aList[i]==0)continue;
					sb.append(bList[i]);
				}
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	
	static void init() {
		Arrays.fill(aList, 0);
		Arrays.fill(bList, 0);
	}
}
