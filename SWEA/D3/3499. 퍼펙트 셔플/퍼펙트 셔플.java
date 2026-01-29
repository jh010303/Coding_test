import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	static int t,n;
    static String[] card = new String[1001];
    static String[] answer = new String[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        t = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= t; test_case++) {
        	init();
        	n = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i=0; i<n; i++) {
        		card[i] = st.nextToken();
        	}
        	int firstStart=0, firstEnd=n/2, answerIndex=0;
        	if(n%2==0) {
        		for(int i=0; i<n/2; i++) {
        			answer[answerIndex++] = card[firstStart++];
        			answer[answerIndex++] = card[firstEnd++];
        		}        		
        	}else {
        		firstEnd++;
        		for(int i=0; i<n/2; i++) {
           			answer[answerIndex++] = card[firstStart++];
        			answer[answerIndex++] = card[firstEnd++];
        		}        		
        		answer[answerIndex] = card[firstStart];
        	}
        	
            sb.append("#").append(test_case).append(" ");
            for(int i=0; i<n; i++) {
            	sb.append(answer[i]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
    
    static void init() {
    	Arrays.fill(card, "");
    	Arrays.fill(answer, "");
    }
}
