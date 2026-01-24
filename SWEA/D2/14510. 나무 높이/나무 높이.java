import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	static int t,n,target,day,growth=1;
	static ArrayList<Integer> trees = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=t; test_case++) {
			init();
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				trees.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(trees);
			target = trees.get(n-1);
			for(int i=n-1; i>=0; i--) {
				if(trees.get(i)==target) {
					trees.remove(i);
				}
			}
			while(!trees.isEmpty()) {				
				day++;
				if(day%2==0) {
					growth=2;
				}
				else {
					growth=1;
				}
				for(int i=trees.size()-1; i>=0; i--) {
					if(target-trees.get(i)==2 && growth==2) {
						trees.remove(i);
						break;
					}
					else if(target-trees.get(i)==1 && growth==1) {
						trees.remove(i);
						break;
					}
					else if(target-trees.get(i)>2){
						trees.set(i, trees.get(i)+growth);
						break;
					}
				}

			}
			bw.write("#"+test_case+" "+day);
			bw.newLine();
			bw.flush();
		}
	}
	
	static void init() {
		day=0;
		trees.clear();
		
	}
}
