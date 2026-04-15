import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	
	static int t,n;
	
	static TreeMap<Integer,Integer> mp = new TreeMap<>();
        
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		t = Integer.parseInt(br.readLine());
		for(int test_case=0; test_case<t; test_case++) {
			n = Integer.parseInt(br.readLine());
			mp.clear();
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken(); int num = Integer.parseInt(st.nextToken());
				if(cmd.equals("I")){
					addQ(num);
				}
				else if(cmd.equals("D") && num==1){
					deleteMax();
				}
				else{
					deleteMin();
				}				
			}
            
            if(!mp.isEmpty()){
            	sb.append(mp.lastEntry().getKey()).append(" ")
            	.append(mp.firstEntry().getKey()).append("\n");
            }
            else {
            	sb.append("EMPTY").append("\n");
            }
		}
		System.out.print(sb);
	}
	
    static void deleteMin(){
    	if(mp.isEmpty()) {
    		return;
    	}
    	
    	Entry<Integer, Integer> minE = mp.firstEntry();
    	if(minE.getValue()<=1) {
    		mp.remove(minE.getKey());
    	} 
    	else {
    		mp.put(minE.getKey(), minE.getValue()-1);
    	}
    }
    
    static void deleteMax(){
    	if(mp.isEmpty()) {
    		return;
    	}
    	
    	Entry<Integer, Integer> maxE = mp.lastEntry();
    	if(maxE.getValue()<=1) {
    		mp.remove(maxE.getKey());
    	} 
    	else {
    		mp.put(maxE.getKey(), maxE.getValue()-1);
    	}
    	
    }
    
    static void addQ(int num){
    	mp.put(num, mp.getOrDefault(num, 0)+1);
    }
}