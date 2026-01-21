import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static int n;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	for(int test_case=1; test_case<=10; test_case++) {
    		int start=0, end=start+1;
    		st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		StringBuilder pwd = new StringBuilder(st.nextToken());
    		while(start>=0 && end<pwd.length()) {
    			if(pwd.charAt(start)==pwd.charAt(end)) {
    				pwd.delete(start, end+1);
    				if(end==pwd.length()-1) {
    					start-=2;
    					end-=2;
    					continue;
    				}
    				else if(start==0) {
    					continue;
    				}
    				else {
    					start--;
    					end--;
    					continue;
    				}
    			}
    			start++; end++;
    		}
        	bw.write("#"+test_case+" "+pwd.toString());
        	bw.newLine();
    	}
		bw.flush();
    }
}
