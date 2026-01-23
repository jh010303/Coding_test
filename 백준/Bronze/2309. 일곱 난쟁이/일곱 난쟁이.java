import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int target,sum=0;
	static List<Integer> arr = new ArrayList<>();
	static final int TOTAL_SUM = 100;
	static boolean find = false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<9; i++) {
			int temp = Integer.parseInt(br.readLine());
			sum+=temp;
			arr.add(temp);
		}
		Collections.sort(arr);
		target = sum-TOTAL_SUM;
		
		for(int i=0; i<9; i++) {
			if(find)break;
			for(int j=i+1; j<9; j++) {
				if(arr.get(i)+arr.get(j)==target) {
					arr.remove(j);
					arr.remove(i);
					find = true;
					break;
				}
			}
		}
		
		for(Integer i:arr) {
			bw.write(i+"");
			bw.newLine();
		}
		bw.flush();
	}
}
