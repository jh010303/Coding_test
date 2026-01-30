import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int t,n;
    static String[] card = new String[1001];
    static String[] answer = new String[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
            while(true){
                init();
                n = Integer.parseInt(br.readLine());
                if(n==0) break;
        	for(int i=0; i<n; i++) {
        		card[i] = br.readLine();
        	}
        	int first=0, second=n/2, answerIndex=0;
        	if(n%2!=0) {
        		second++;
        	}
        	for(int i=0; i<n/2; i++) {
        		answer[answerIndex++] = card[first++];
        		answer[answerIndex++] = card[second++];
        	}        		
        	
        	if(n%2!=0) {
        		answer[answerIndex] = card[first];
        	}
    
            for(int i=0; i<n; i++) {
            	sb.append(answer[i]).append("\n");
            }
            }
        
        System.out.println(sb.toString());
    }
    
    static void init() {
    	Arrays.fill(card, "");
    	Arrays.fill(answer, "");
    }
}
